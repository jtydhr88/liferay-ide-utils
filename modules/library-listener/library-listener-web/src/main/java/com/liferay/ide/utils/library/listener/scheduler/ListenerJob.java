package com.liferay.ide.utils.library.listener.scheduler;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.liferay.ide.utils.library.listener.configuration.LibraryListenerConfiguration;
import com.liferay.ide.utils.library.listener.model.Library;
import com.liferay.ide.utils.library.listener.model.Repository;
import com.liferay.ide.utils.library.listener.service.LibraryLocalService;
import com.liferay.ide.utils.library.listener.service.RepositoryLocalService;
import com.liferay.ide.utils.library.listener.utils.HttpUtils;
import com.liferay.ide.utils.library.listener.utils.SaxService;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;

/**
 * @author Carson Li
 * @author Terry Jia
 */
public class ListenerJob implements Job {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		RepositoryLocalService repositoryLocalService =
			(RepositoryLocalService) jobExecutionContext.getJobDetail().getJobDataMap().get("repositoryLocalService");
		LibraryLocalService libraryLocalService =
			(LibraryLocalService) jobExecutionContext.getJobDetail().getJobDataMap().get("libraryLocalService");
		MailService mailService =
				(MailService) jobExecutionContext.getJobDetail().getJobDataMap().get("mailService");
		LibraryListenerConfiguration libraryListenerConfiguration =
			(LibraryListenerConfiguration) jobExecutionContext.getJobDetail().getJobDataMap().get(
				"libraryListenerConfiguration");

		List<Repository> repositories = repositoryLocalService.getRepositories(-1, -1);

		for (Repository repository : repositories) {
			long repositoryId = repository.getRepositoryId();

			String rootUrl = repository.getRepositoryRootUrl();

			List<Library> libraries = libraryLocalService.getLibrariesByRepositoryId(repositoryId);

			for (Library library : libraries) {
				if (library.getEnableListener()) {
					try {
						String groupId = library.getLibraryGroupId();
						String artifactId = library.getLibraryArtifactId();

						StringBuilder sb = new StringBuilder();

						sb.append(rootUrl);

						String[] groupPaths = groupId.split("\\.");

						for (String groupPath : groupPaths) {
							sb.append(groupPath);
							sb.append("/");
						}

						sb.append(artifactId);
						sb.append("/");

						sb.append("maven-metadata.xml");

						InputStream inputStream = HttpUtils.getXML(sb.toString());

						List<HashMap<String, String>> latestMap = SaxService.readXML(inputStream, "latest");
						String latest = latestMap.get(0).get("latest");

						StringBuilder messageSb = new StringBuilder();

						messageSb.append("The library ");
						messageSb.append(library.getLibraryGroupId());
						messageSb.append(":");
						messageSb.append(library.getLibraryArtifactId());
						messageSb.append(" in repository ");
						messageSb.append(repository.getRepositoryRootUrl());
						messageSb.append(" has been updated: \nthe latest version is ");
						messageSb.append(latest);
						messageSb.append("\n");

						if (!library.getLatestVersion().equals(latest)) {
							libraryLocalService.updateLibraryLatestVersion(library.getLibraryId(), latest);
						}

						if (!library.getCurrentVersion().equals(library.getLatestVersion())) {
							messageSb.append("You current using ");
							messageSb.append(library.getCurrentVersion());
							messageSb.append("\nthe following resource are using this library:\n");
							messageSb.append(library.getResources());
						}

						String sender = libraryListenerConfiguration.emailSender();

						String[] emailList = libraryListenerConfiguration.notifyEmailList();

						for (String email : emailList) {
							MailMessage msg = new MailMessage(new InternetAddress(sender), new InternetAddress(email),
									library.getLibraryArtifactId() + "  Has Update", messageSb.toString(), true);

							mailService.sendEmail(msg);
						}
					}
					catch (Exception e) {
						e.printStackTrace();

						System.out.println("Unable to fetch library " + library.getLibraryGroupId() + ":"
								+ library.getLibraryArtifactId());
					}
				}
			}
		}
	}

}

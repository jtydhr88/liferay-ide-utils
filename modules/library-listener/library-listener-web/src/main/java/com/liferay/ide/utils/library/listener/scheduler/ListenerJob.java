package com.liferay.ide.utils.library.listener.scheduler;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.liferay.ide.utils.library.listener.model.Library;
import com.liferay.ide.utils.library.listener.model.Repository;
import com.liferay.ide.utils.library.listener.service.LibraryLocalService;
import com.liferay.ide.utils.library.listener.service.RepositoryLocalService;
import com.liferay.ide.utils.library.listener.utils.LibraryUtil;

/**
 * @author Carson Li
 * @author Terry Jia
 */
public class ListenerJob implements Job {

	// private static Map<String,String> noticedMap = new HashMap<>();

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		RepositoryLocalService repositoryLocalService = (RepositoryLocalService) jobExecutionContext.getJobDetail()
				.getJobDataMap().get("repositoryLocalService");
		LibraryLocalService libraryLocalService = (LibraryLocalService) jobExecutionContext.getJobDetail()
				.getJobDataMap().get("libraryLocalService");
		// MailService mailService =
		// (MailService)
		// jobExecutionContext.getJobDetail().getJobDataMap().get("mailService");
		// LibraryListenerConfiguration libraryListenerConfiguration =
		// (LibraryListenerConfiguration)
		// jobExecutionContext.getJobDetail().getJobDataMap().get(
		// "libraryListenerConfiguration");

		List<Repository> repositories = repositoryLocalService.getRepositories(-1, -1);

		// StringBuilder wholeMessage = new StringBuilder();

		for (Repository repository : repositories) {
			long repositoryId = repository.getRepositoryId();

			String rootUrl = repository.getRepositoryRootUrl();

			List<Library> libraries = libraryLocalService.getLibrariesByRepositoryId(repositoryId);

			for (Library library : libraries) {
				if (library.getEnableListener()) {
					try {
						String groupId = library.getLibraryGroupId();
						String artifactId = library.getLibraryArtifactId();

						String latestVersion = LibraryUtil.getLatestVersion(rootUrl, groupId, artifactId);

						// StringBuilder messageSb = new StringBuilder();

						if (!library.getLatestVersion().equals(latestVersion) && latestVersion != null
						// &&
						// (noticedMap.get(String.valueOf(library.getLibraryId()))
						// == null
						// ||
						// !noticedMap.get(String.valueOf(library.getLibraryId())).equals(latestVersion))
						) {

							libraryLocalService.updateLibraryLatestVersion(library.getLibraryId(), latestVersion);

							// messageSb.append("The library ");
							// messageSb.append(library.getLibraryGroupId());
							// messageSb.append(":");
							// messageSb.append(library.getLibraryArtifactId());
							// messageSb.append(" in repository ");
							// messageSb.append(repository.getRepositoryRootUrl());
							// messageSb.append(" has been updated: the latest
							// version is ");
							// messageSb.append(latestVersion);
							// messageSb.append("<br />");
							//
							// if
							// (!library.getCurrentVersion().equals(library.getLatestVersion()))
							// {
							// messageSb.append("You current using ");
							// messageSb.append("<b>");
							// messageSb.append(library.getCurrentVersion());
							// messageSb.append("<b />");
							// messageSb.append("<br />");
							// messageSb.append("the following resource are
							// using this library:");
							// messageSb.append("<br />");
							//
							// String[] resources =
							// library.getResources().split("\\n");
							//
							// for (String resource : resources) {
							// messageSb.append(resource);
							// messageSb.append("<br />");
							// }
							// }
							//
							// wholeMessage.append(messageSb.toString());
							// wholeMessage.append("<br />");

							// noticedMap.put(String.valueOf(library.getLibraryId()),
							// library.getLatestVersion());
						}
					} catch (Exception e) {
						e.printStackTrace();

						System.out.println("Unable to fetch library " + library.getLibraryGroupId() + ":"
								+ library.getLibraryArtifactId());
					}
				}
			}
		}

		// if (!wholeMessage.toString().equals("")) {
		// String sender = libraryListenerConfiguration.emailSender();
		//
		// String[] emailList = libraryListenerConfiguration.notifyEmailList();
		//
		// for (String email : emailList) {
		// try {
		// MailMessage msg = new MailMessage(new InternetAddress(sender), new
		// InternetAddress(email),
		// "The libraries Has Update", wholeMessage.toString(), true);
		// mailService.sendEmail(msg);
		// }
		// catch (AddressException e) {
		// e.printStackTrace();
		// }
		//
		// }
		// }
	}

}

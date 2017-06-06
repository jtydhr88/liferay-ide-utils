package com.liferay.ide.utils.library.listener.scheduler;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Reference;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.liferay.ide.utils.library.listener.utils.HttpUtils;
import com.liferay.ide.utils.library.listener.utils.SaxService;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.kernel.model.User;

/**
 * @author Carson Li
 */
@SuppressWarnings("unchecked")
public class ListenerJob implements Job {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		List<String> paths = (List<String>) jobExecutionContext.getJobDetail().getJobDataMap().get("paths");
		List<String> curs = (List<String>) jobExecutionContext.getJobDetail().getJobDataMap().get("curs");
		List<String> repoNames = (List<String>) jobExecutionContext.getJobDetail().getJobDataMap().get("repoNames");

		User user = (User) jobExecutionContext.getJobDetail().getJobDataMap().get("user");

		for (int i = 0; i < paths.size(); i++) {
			InputStream inputStream = HttpUtils.getXML(paths.get(i));
			try {
				List<HashMap<String, String>> list = SaxService.readXML(inputStream, "latest");
				String latest = list.get(0).get("latest");
				if (!curs.get(i).equals(latest)) {
					MailMessage msg = new MailMessage(new InternetAddress("just_domyself@126.com"),
							new InternetAddress(user.getEmailAddress()), "Liferay Repository Has Update",
							"Your concerned " + repoNames.get(i)
									+ " repository has a update version . The latest version is  " + latest,
							true);
					mailService.sendEmail(msg);
				}
			}
			catch (Exception e) {
			}
		}

	}

	@Reference
	MailService mailService;
}

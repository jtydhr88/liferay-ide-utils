package com.liferay.ide.utils.library.listener.scheduler;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.liferay.ide.utils.library.listener.configuration.LibraryListenerConfiguration;
import com.liferay.ide.utils.library.listener.service.LibraryLocalService;
import com.liferay.ide.utils.library.listener.service.RepositoryLocalService;
import com.liferay.mail.kernel.service.MailService;

/**
 * @author Carson Li
 */
public class ListenerScheduler {

	private static Scheduler scheduler;

	public static void start(RepositoryLocalService repositoryLocalService, LibraryLocalService libraryLocalService,
			MailService mailService, LibraryListenerConfiguration libraryListenerConfiguration) {

		if (!libraryListenerConfiguration.enableListener()) {
			return;
		}

		try {
			if (scheduler == null) {
				SchedulerFactory schedulerFactory = new StdSchedulerFactory();

				scheduler = schedulerFactory.getScheduler();
			}

			int hours = 24;

			if (libraryListenerConfiguration.hours() > 0){
				hours = libraryListenerConfiguration.hours();
			}

			SimpleScheduleBuilder schedBuilder =
				SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(hours).repeatForever();

			Date triggerDate = new Date();

			TriggerBuilder<Trigger> triggerBuilder =
				TriggerBuilder.newTrigger().withIdentity("myTrigger", "triggerGroup");
			Trigger trigger = triggerBuilder.startAt(triggerDate).withSchedule(schedBuilder).build();

			JobDetail jobDetail = JobBuilder.newJob(ListenerJob.class).withIdentity("myJob", "jobGroup").build();

			jobDetail.getJobDataMap().put("repositoryLocalService", repositoryLocalService);
			jobDetail.getJobDataMap().put("libraryLocalService", libraryLocalService);
			jobDetail.getJobDataMap().put("libraryListenerConfiguration", libraryListenerConfiguration);
			jobDetail.getJobDataMap().put("mailService", mailService);

			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();

			System.out.println("scheduler started");
		}
		catch (SchedulerException e) {
			System.out.println("with some exception, scheduler stoped");
		}
	}

	public static void stop() {
		if (scheduler != null) {
			try {
				scheduler.shutdown();

				System.out.println("scheduler stoped");
			}
			catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
	}

}
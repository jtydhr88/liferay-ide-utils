package library.listener.web.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.liferay.ide.utils.library.listener.model.ListenerModel;
import com.liferay.portal.kernel.model.User;

/**
 * @author Carson Li
 */
public class ListenerScheduler {

	public static void start(List<ListenerModel> list, User user) {

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();
			SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(24)
					.repeatForever();
			// SimpleScheduleBuilder schedBuilder =
			// SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();

			Date triggerDate = new Date();
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger().withIdentity("myTrigger",
					"triggerGroup" );
			Trigger trigger = triggerBuilder.startAt(triggerDate).withSchedule(schedBuilder).build();

			JobDetail jobDetail = JobBuilder.newJob(ListenerJob.class).withIdentity("myJob", "jobGroup")
					.build();

			List<String> paths = new ArrayList<>();
			List<String> curs = new ArrayList<>();
			List<String> repoNames = new ArrayList<>();

			for (int i = 0; i < list.size(); i++) {
				String[] arr = list.get(i).getGroupId().split("\\.");

				StringBuilder sb = new StringBuilder("https://repository.liferay.com/nexus/content/groups/public");
				for (int j = 0; j < arr.length; j++) {
					sb.append("/" + arr[j]);
				}
				sb.append("/" + list.get(i).getArtifactId() + "/" + "maven-metadata.xml");

				paths.add(sb.toString());
				curs.add(list.get(i).getCurVersion());
				repoNames.add(list.get(i).getRepositoryName());
			}
			
			jobDetail.getJobDataMap().put("paths", paths);
			jobDetail.getJobDataMap().put("curs", curs);
			jobDetail.getJobDataMap().put("repoNames", repoNames);
			jobDetail.getJobDataMap().put("user", user);

			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();

		} catch (SchedulerException e) {
			
		}

	}
}

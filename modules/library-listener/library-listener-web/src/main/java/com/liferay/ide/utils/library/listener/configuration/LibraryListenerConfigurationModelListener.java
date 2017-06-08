package com.liferay.ide.utils.library.listener.configuration;

import java.io.IOException;

import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ConfigurationEvent;
import org.osgi.service.cm.ConfigurationListener;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.ide.utils.library.listener.scheduler.ListenerScheduler;
import com.liferay.ide.utils.library.listener.service.LibraryLocalService;
import com.liferay.ide.utils.library.listener.service.RepositoryLocalService;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

@Component (
	immediate = true,
	service = ConfigurationListener.class
)
public class LibraryListenerConfigurationModelListener implements ConfigurationListener {

	@Override
	public void configurationEvent(ConfigurationEvent event) {
		if (event.getPid().equals(
			"com.liferay.ide.utils.library.listener.configuration.LibraryListenerConfiguration")) {

			try {
				LibraryListenerConfiguration configuration = ConfigurableUtil.createConfigurable(
						LibraryListenerConfiguration.class, configAdmin.getConfiguration(event.getPid()).getProperties());

				ListenerScheduler.restart(_repositoryLocalService, _libraryLocalService, _mailService, configuration);
			}
			catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@Reference
	ConfigurationAdmin configAdmin;

	@Reference
	private volatile RepositoryLocalService _repositoryLocalService;

	@Reference
	private volatile LibraryLocalService _libraryLocalService;

	@Reference
	private volatile MailService _mailService;

}

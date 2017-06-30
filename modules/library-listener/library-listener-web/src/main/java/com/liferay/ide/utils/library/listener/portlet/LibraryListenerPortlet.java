package com.liferay.ide.utils.library.listener.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.ide.utils.library.listener.configuration.LibraryListenerConfiguration;
import com.liferay.ide.utils.library.listener.model.Library;
import com.liferay.ide.utils.library.listener.model.Repository;
import com.liferay.ide.utils.library.listener.scheduler.ListenerScheduler;
import com.liferay.ide.utils.library.listener.service.LibraryLocalService;
import com.liferay.ide.utils.library.listener.service.RepositoryLocalService;
import com.liferay.ide.utils.library.listener.utils.LibraryUtil;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author terry
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=library-listener-web Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.portlet-name=library-listener-portlet", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.css-class-wrapper=libraray-listener" }, configurationPid = "com.liferay.ide.utils.library.listener.configuration.LibraryListenerConfiguration", service = Portlet.class)
public class LibraryListenerPortlet extends MVCPortlet {

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		String repositoryId = resourceRequest.getParameter("repositoryId");
		String libraryGroupId = resourceRequest.getParameter("libraryGroupId");
		String artifactId = resourceRequest.getParameter("artifactId");
		String repoRootUrl = null;
		String latestVersion = null;

		try {
			Repository repository = _repositoryLocalService.getRepository(Long.parseLong(repositoryId));
			repoRootUrl = repository.getRepositoryRootUrl();

			try {
				latestVersion = LibraryUtil.getLatestVersion(repoRootUrl, libraryGroupId, artifactId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (PortalException e1) {
			e1.printStackTrace();
		}

		resourceResponse.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;

		try {
			out = resourceResponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(latestVersion != null ? latestVersion : "can't get latest version");
		out.flush();
		out.close();

		super.serveResource(resourceRequest, resourceResponse);
	}

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		request.setAttribute("repositoryLocalService", getRepositoryLocalService());
		request.setAttribute("libraryLocalService", getLibraryLocalService());
		request.setAttribute("libraryListenerConfiguration", getLibraryListenerConfiguration());

		super.render(request, response);
	}

	public void checkAll(ActionRequest req, ActionResponse resp) throws SystemException, PortalException {
		List<Repository> repositories = _repositoryLocalService.getRepositories(-1, -1);

		for (Repository repository : repositories) {
			long repositoryId = repository.getRepositoryId();

			String rootUrl = repository.getRepositoryRootUrl();

			List<Library> libraries = _libraryLocalService.getLibrariesByRepositoryId(repositoryId);

			for (Library library : libraries) {
				if (library.getEnableListener()) {
					try {
						String groupId = library.getLibraryGroupId();
						String artifactId = library.getLibraryArtifactId();

						String latestVersion = LibraryUtil.getLatestVersion(rootUrl, groupId, artifactId);

						if (!library.getLatestVersion().equals(latestVersion) && latestVersion != null) {
							_libraryLocalService.updateLibraryLatestVersion(library.getLibraryId(), latestVersion);
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

	public void editRepository(ActionRequest req, ActionResponse resp) throws SystemException, PortalException {
		String repositoryName = ParamUtil.getString(req, "repositoryName");
		String repositoryRootUrl = ParamUtil.getString(req, "repositoryRootUrl");
		String repositoryUserName = ParamUtil.getString(req, "repositoryUserName");
		String repositoryPassword = ParamUtil.getString(req, "repositoryPassword");

		long repositoryId = ParamUtil.getLong(req, "repositoryId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Repository.class.getName(), req);

		if (repositoryId > 0) {
			_repositoryLocalService.updateRepository(repositoryId, repositoryName, repositoryRootUrl,
					repositoryUserName, repositoryPassword, serviceContext);
		} else {
			_repositoryLocalService.addRepository(repositoryName, repositoryRootUrl, repositoryUserName,
					repositoryPassword, serviceContext);
		}
	}

	public void editLibrary(ActionRequest req, ActionResponse resp) throws SystemException, PortalException {
		long repositoryId = ParamUtil.getLong(req, "repositoryId");
		String libraryArtifactId = ParamUtil.getString(req, "libraryArtifactId");
		String libraryGroupId = ParamUtil.getString(req, "libraryGroupId");
		String latestVersion = ParamUtil.getString(req, "latestVersion");
		String lastUpdated = ParamUtil.getString(req, "lastUpdated");
		String currentVersion = ParamUtil.getString(req, "currentVersion");
		String resources = ParamUtil.getString(req, "resources");
		boolean enableListener = ParamUtil.getBoolean(req, "enableListener");

		long libraryId = ParamUtil.getLong(req, "libraryId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Library.class.getName(), req);

		if (libraryId > 0) {
			_libraryLocalService.updateLibrary(libraryId, repositoryId, libraryGroupId, libraryArtifactId,
					latestVersion, lastUpdated, currentVersion, resources, enableListener, serviceContext);
		} else {
			_libraryLocalService.addLibrary(repositoryId, libraryGroupId, libraryArtifactId, latestVersion, lastUpdated,
					currentVersion, resources, enableListener, serviceContext);
		}
	}

	public void deleteRepository(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException {
		long repositoryId = ParamUtil.getLong(actionRequest, "repositoryId");

		_repositoryLocalService.deleteRepository(repositoryId);
	}

	public void deleteLibrary(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException {
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");

		_libraryLocalService.deleteLibrary(libraryId);
	}

	public void updateToLatest(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException {
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");

		_libraryLocalService.updateToLatest(libraryId);
	}

	public RepositoryLocalService getRepositoryLocalService() {
		return _repositoryLocalService;
	}

	public LibraryLocalService getLibraryLocalService() {
		return _libraryLocalService;
	}

	public LibraryListenerConfiguration getLibraryListenerConfiguration() {
		return _libraryListenerConfiguration;
	}

	@Reference
	private volatile RepositoryLocalService _repositoryLocalService;

	@Reference
	private volatile LibraryLocalService _libraryLocalService;

	@Reference
	private volatile MailService _mailService;

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_libraryListenerConfiguration = ConfigurableUtil.createConfigurable(LibraryListenerConfiguration.class,
				properties);

		ListenerScheduler.start(_repositoryLocalService, _libraryLocalService, _mailService,
				_libraryListenerConfiguration);
	}

	@Deactivate
	protected void deactivate(Map<Object, Object> properties) {
		ListenerScheduler.stop();
	}

	private volatile LibraryListenerConfiguration _libraryListenerConfiguration;

}
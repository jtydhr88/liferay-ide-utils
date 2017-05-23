package library.listener.web.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.ide.utils.library.listener.model.Library;
import com.liferay.ide.utils.library.listener.model.Repository;
import com.liferay.ide.utils.library.listener.service.LibraryLocalService;
import com.liferay.ide.utils.library.listener.service.RepositoryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author terry
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=library-listener-web Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LibraryListenerWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		request.setAttribute("repositoryLocalService", getRepositoryLocalService());
		request.setAttribute("libraryLocalService", getLibraryLocalService());

		super.render(request, response);
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
		boolean enableListener = ParamUtil.getBoolean(req, "enableListener");

		long libraryId = ParamUtil.getLong(req, "libraryId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Library.class.getName(), req);

		if (libraryId > 0) {
			_libraryLocalService.updateLibrary(libraryId, repositoryId, libraryGroupId, libraryArtifactId,
					latestVersion, lastUpdated, currentVersion, enableListener, serviceContext);
		} else {
			_libraryLocalService.addLibrary(repositoryId, libraryGroupId, libraryArtifactId, latestVersion, lastUpdated,
					currentVersion, enableListener, serviceContext);
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

	public RepositoryLocalService getRepositoryLocalService() {
		return _repositoryLocalService;
	}

	public LibraryLocalService getLibraryLocalService() {
		return _libraryLocalService;
	}

	@Reference
	private volatile RepositoryLocalService _repositoryLocalService;

	@Reference
	private volatile LibraryLocalService _libraryLocalService;

}
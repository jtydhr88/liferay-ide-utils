package com.liferay.ide.utils.quality.track.portlet;

import quality.track.web.constants.QualityTrackWebPortletKeys;

import com.liferay.ide.utils.quality.track.service.TestCaseLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

/**
 * @author jtydhr88
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TestCase Portlet",
		"javax.portlet.init-param.template-path=/testcase/",
		"javax.portlet.init-param.view-template=/testcase/view.jsp",
		"javax.portlet.name=" + QualityTrackWebPortletKeys.TestCasePortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TestCasePortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		request.setAttribute("testCaseLocalService", getTestCaseLocalService());

		super.render(request, response);
	}

	public TestCaseLocalService getTestCaseLocalService() {
		return _testCaseLocalService;
	}

	@Reference
	private volatile TestCaseLocalService _testCaseLocalService;

	@ProcessAction(name = "editTestCase")
	public void editTestCase(ActionRequest actionRequest, ActionResponse actionResponse) {
	}

}
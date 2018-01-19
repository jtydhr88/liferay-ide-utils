<%@page import="com.liferay.ide.utils.quality.track.model.TestCase"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/testcase/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
long testCaseId = ParamUtil.getLong(request, "testCaseId");

TestCase testCase = null;

if (testCaseId > 0 ){
	testCase = testCaseLocalService.getTestCase(testCaseId);
}
%>

<portlet:actionURL name="editTestCase" var="editTestCaseUrl" />

<aui:form action="<%= editTestCaseUrl %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="testCaseId" type="hidden" value="<%= testCaseId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title='<%= (testCase != null) ? testCase.getTestCaseName() : "new-testcase" %>'
	/>

	<aui:model-context bean="<%= testCase %>" model="<%= TestCase.class %>" />

	<aui:fieldset>
		<aui:input name="testCaseName" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>
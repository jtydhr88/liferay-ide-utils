<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
long repositoryId = ParamUtil.getLong(request, "repositoryId");

Repository repository = null;
if (repositoryId > 0 ){
	repository = repositoryLocalService.getRepository(repositoryId);
}
%>

<portlet:actionURL name="editRepository" var="editRepositoryUrl" />

<aui:form action="<%= editRepositoryUrl %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="repositoryId" type="hidden" value="<%= repositoryId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title='<%= (repository != null) ? repository.getRepositoryName() : "new-repository" %>'
	/>
	
	<aui:model-context bean="<%= repository %>" model="<%= Repository.class %>" />
		<aui:fieldset>
		<aui:input name="repositoryName" />

		<aui:input name="repositoryRootUrl" />

		<aui:input name="repositoryUserName" />

		<aui:input name="repositoryPassword" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>
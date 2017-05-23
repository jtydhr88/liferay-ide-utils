<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
long libraryId = ParamUtil.getLong(request, "libraryId");

Library library = null;
if (libraryId > 0 ){
	library = libraryLocalService.getLibrary(libraryId);
}

List<Repository> repositories = repositoryLocalService.getRepositories(-1, -1);
%>

<portlet:actionURL name="editLibrary" var="editLibraryUrl" />

<aui:form action="<%= editLibraryUrl %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="libraryId" type="hidden" value="<%= libraryId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title='<%= (library != null) ? library.getLibraryArtifactId() : "new-library" %>'
	/>
	
	<aui:model-context bean="<%= library %>" model="<%= Library.class %>" />

	<aui:fieldset>
		<aui:select name="repositoryId" >
			<%
			for (Repository repository : repositories) {
			%>
				<aui:option label="<%= repository.getRepositoryName() %>"  value="<%= repository.getRepositoryId() %>" />
			<%
			}
			%>
		</aui:select>

		<aui:input name="libraryGroupId" />

		<aui:input name="libraryArtifactId" />

		<aui:input name="latestVersion" />

		<aui:input name="lastUpdated" />

		<aui:input name="currentVersion" />

		<aui:input name="enableListener" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>
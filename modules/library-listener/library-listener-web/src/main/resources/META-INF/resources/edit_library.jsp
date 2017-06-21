<%@ include file="/init.jsp" %>

<portlet:resourceURL var="ajaxUrl"/>

<script>
function fetchLatestVersion(){

	var repositoryIdMyValue = $("#<portlet:namespace />repositoryId").val();
	var libraryGroupIdMyValue = $("#<portlet:namespace />libraryGroupId").val();
	var libraryArtifactIdMyValue = $("#<portlet:namespace />libraryArtifactId").val();

	if( repositoryIdMyValue.trim() == "" ||  libraryGroupIdMyValue.trim() == "" || libraryArtifactIdMyValue.trim() == "")
	{
		return;
	}

	$("#<portlet:namespace />latestVersion").val("fetching latest verison...");

	$.post('<%=ajaxUrl%>',
		{
		 <portlet:namespace/>repositoryId:repositoryIdMyValue,
		 <portlet:namespace/>libraryGroupId:libraryGroupIdMyValue,
		 <portlet:namespace/>artifactId:libraryArtifactIdMyValue,
		},function(data){
		$("#<portlet:namespace />latestVersion").val(data);
	 })
}
</script>

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
		<aui:select name="repositoryId"  onChange="fetchLatestVersion()" >
			<%
			for (Repository repository : repositories) {
			%>
				<aui:option label="<%= repository.getRepositoryName() %>"  value="<%= repository.getRepositoryId() %>" />
			<%
			}
			%>
		</aui:select>

		<aui:input name="libraryGroupId" onChange="fetchLatestVersion()" type="text">
			<aui:validator name="required"/>
		</aui:input>

		<aui:input name="libraryArtifactId" onChange="fetchLatestVersion()" type="text">
			<aui:validator name="required"/>
		</aui:input>

		<aui:input name="latestVersion" readonly="readonly" type="text" />

		<aui:input name="lastUpdated" />

		<aui:input name="currentVersion" />

		<aui:input name="resources" />

		<aui:input name="enableListener" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>
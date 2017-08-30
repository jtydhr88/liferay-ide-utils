<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Library library = null;
if (row != null) {
	library = (Library)row.getObject();
}
%>

<liferay-ui:icon-menu showExpanded="<%= row == null %>" showWhenSingleIcon="<%= row == null %>">
	<portlet:actionURL var="deleteURL" name="deleteLibrary">
		<portlet:param name="libraryId" value="<%= String.valueOf(library.getLibraryId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL %>" />

	<%
	String artifactId = library.getLibraryArtifactId();
	String groupId = library.getLibraryGroupId();
	Repository repo = repositoryLocalService.getRepository(library.getRepositoryId());
	String url = repo.getRepositoryRootUrl();
	StringBuilder sb = new StringBuilder();

	sb.append( url );

    if( !url.endsWith( "/" ) )
    {
        sb.append( "/" );
    }

    String[] groupPaths = groupId.split( "\\." );

    for( String groupPath : groupPaths )
    {
        sb.append( groupPath );
        sb.append( "/" );
    }

    sb.append( artifactId );
    sb.append( "/" );
	%>

	<liferay-ui:icon url="<%= sb.toString() %>" target="blank" message="go-the-liberay-link" />
</liferay-ui:icon-menu>
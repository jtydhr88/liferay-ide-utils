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
</liferay-ui:icon-menu>
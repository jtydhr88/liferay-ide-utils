<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Repository repository = null;
if (row != null) {
	repository = (Repository)row.getObject();
}
%>

<liferay-ui:icon-menu showExpanded="<%= row == null %>" showWhenSingleIcon="<%= row == null %>">
	<portlet:actionURL var="deleteURL" name="deleteRepository">
		<portlet:param name="repositoryId" value="<%= String.valueOf(repository.getRepositoryId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL %>" />
</liferay-ui:icon-menu>
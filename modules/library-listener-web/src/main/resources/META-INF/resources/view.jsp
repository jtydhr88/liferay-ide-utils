<%@ include file="/init.jsp" %>

<aui:button-row>
	<portlet:renderURL var="editRepositoryURL">
		<portlet:param name="mvcPath" value="/edit_repository.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<portlet:renderURL var="editLibraryURL">
		<portlet:param name="mvcPath" value="/edit_library.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<aui:button href="<%= editRepositoryURL %>" value="add-repository" />
	<aui:button href="<%= editLibraryURL %>" value="add-library" />
</aui:button-row>

<liferay-ui:search-container
	emptyResultsMessage="there-are-no-repository"
>
	<liferay-ui:search-container-results>
	<%
	searchContainer.setTotal(repositoryLocalService.getRepositoriesCount());
	searchContainer.setResults(repositoryLocalService.getRepositories(searchContainer.getStart(), searchContainer.getEnd()));
	%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row
		className="com.liferay.ide.utils.library.listener.model.Repository"
		keyProperty="primaryKeyObj"
		modelVar="repository"
	>
		<portlet:renderURL var="viewRepositoryUrl">
			<portlet:param name="repositoryId" value="<%= String.valueOf(repository.getRepositoryId())  %>"/>
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="mvcPath" value="/edit_repository.jsp" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			name="name"
			value="<%= repository.getRepositoryName() %>"
			href="<%= viewRepositoryUrl %>"
		/>
		<liferay-ui:search-container-column-text
			name="author"
			value="<%= repository.getRepositoryRootUrl() %>"
			href="<%= viewRepositoryUrl %>"
		/>
		<liferay-ui:search-container-column-jsp
			path="/action_repository.jsp"
			valign="top"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
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
			name="root-url"
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

<liferay-ui:search-container
	emptyResultsMessage="there-are-no-libraries"
>
	<liferay-ui:search-container-results>
	<%
	searchContainer.setTotal(libraryLocalService.getLibrariesCount());
	searchContainer.setResults(libraryLocalService.getLibraries(searchContainer.getStart(), searchContainer.getEnd()));
	%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row
		className="com.liferay.ide.utils.library.listener.model.Library"
		keyProperty="primaryKeyObj"
		modelVar="library"
	>
		<portlet:renderURL var="viewLibraryUrl">
			<portlet:param name="libraryId" value="<%= String.valueOf(library.getLibraryId())  %>"/>
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="mvcPath" value="/edit_library.jsp" />
		</portlet:renderURL>

		<%
		String CurrentVersionCssClass = "current-version-equals";

		if (!library.getCurrentVersion().equals(library.getLatestVersion())) {
			CurrentVersionCssClass = "current-version-not-equals";
		}
		%>

		<liferay-ui:search-container-column-text
			name="repo-name"
			value="<%= 	repositoryLocalService.getRepository(library.getRepositoryId()).getRepositoryName() %>"
			href="<%= viewLibraryUrl %>"
		/>
		<liferay-ui:search-container-column-text
			name="group-id"
			value="<%= library.getLibraryGroupId() %>"
			href="<%= viewLibraryUrl %>"
		/>
		<liferay-ui:search-container-column-text
			name="artifact-id"
			value="<%= library.getLibraryArtifactId() %>"
			href="<%= viewLibraryUrl %>"
		/>
		<liferay-ui:search-container-column-text
			name="latest-version"
			value="<%= library.getLatestVersion() %>"
			href="<%= viewLibraryUrl %>"
		/>
		<liferay-ui:search-container-column-text
			name="current-version"
		>
			<div class="<%= CurrentVersionCssClass %>"><%= library.getCurrentVersion() %></div>
			<c:if test="<%= !library.getCurrentVersion().equals(library.getLatestVersion()) %>">
				<portlet:actionURL name="updateToLatest" var="updateToLatestUrl">
					<portlet:param name="libraryId" value="<%= String.valueOf(library.getLibraryId()) %>" />
				</portlet:actionURL>

				<aui:a href="<%= updateToLatestUrl %>">Have updated all resources to latest?</aui:a>
			</c:if>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="enable-listener"
			value="<%= String.valueOf(library.getEnableListener()) %>"
			href="<%= viewLibraryUrl %>"
		/>
		<liferay-ui:search-container-column-jsp
			path="/action_library.jsp"
			valign="top"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
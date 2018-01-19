<%@ include file="/testcase/init.jsp" %>

<aui:button-row>
	<portlet:renderURL var="editTestCaseURL">
		<portlet:param name="mvcPath" value="/testcase/edit_testcase.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<aui:button href="<%= editTestCaseURL %>" value="add-testcase" />
</aui:button-row>

<liferay-ui:search-container
	emptyResultsMessage="there-are-no-testcases"
>
	<liferay-ui:search-container-results>
	<%
	searchContainer.setTotal(testCaseLocalService.getTestCasesCount());
	searchContainer.setResults(testCaseLocalService.getTestCases(searchContainer.getStart(), searchContainer.getEnd()));
	%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.ide.utils.quality.track.model.TestCase"
		keyProperty="primaryKeyObj"
		modelVar="testCase"
	>
		<portlet:renderURL var="viewTestCaseUrl">
			<portlet:param name="testCaseId" value="<%= String.valueOf(testCase.getTestCaseId()) %>"/>
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="mvcPath" value="/testcase/edit_testcase.jsp" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			name="testcase-name"
			value="<%= testCase.getTestCaseName() %>"
			href="<%= viewTestCaseUrl %>"
		/>

		<liferay-ui:search-container-column-jsp
			path="/testcase/action_testcase.jsp"
			valign="top"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
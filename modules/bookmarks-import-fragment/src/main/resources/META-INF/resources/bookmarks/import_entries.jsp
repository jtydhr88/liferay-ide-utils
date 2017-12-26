<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>
<%@ include file="/bookmarks/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

BookmarksFolder folder = (BookmarksFolder) request.getAttribute(BookmarksWebKeys.BOOKMARKS_FOLDER);

long folderId = BeanParamUtil.getLong(folder, request, "folderId");

boolean portletTitleBasedNavigation =
GetterUtil.getBoolean(portletConfig.getInitParameter("portlet-title-based-navigation"));

if (portletTitleBasedNavigation) {
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(redirect);
	renderResponse.setTitle("import-bookmarks");
}
%>

<div <%=portletTitleBasedNavigation ? "class=\"container-fluid-1280\"" : StringPool.BLANK%>>
	<portlet:actionURL name="/bookmarks/import_entries" var="importURL">
		<portlet:param name="mvcRenderCommandName" value="/bookmarks/import_entries" />
	</portlet:actionURL>

	<aui:form action="<%=importURL%>" method="post" enctype="multipart/form-data">
		<aui:input name="folderId" type="hidden" value="<%=folderId%>" />
		<aui:input type="file" name="bookmarks_file" />
		<aui:button-row>
			<aui:button cssClass="btn-lg" type="submit" />
			<aui:button cssClass="btn-lg" href="<%=redirect%>" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>
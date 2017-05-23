<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.ide.utils.library.listener.service.LibraryLocalService"%><%@
page import="com.liferay.ide.utils.library.listener.service.RepositoryLocalService"%><%@
page import="javax.portlet.PortletURL"%><%@
page import="com.liferay.portal.kernel.util.ParamUtil"%><%@
page import="com.liferay.ide.utils.library.listener.model.Repository"%><%@
page import="com.liferay.portal.kernel.util.WebKeys"%><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow"%><%@
page import="com.liferay.ide.utils.library.listener.model.Library"%><%@
page import="java.util.List"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
RepositoryLocalService repositoryLocalService = (RepositoryLocalService)request.getAttribute("repositoryLocalService");
LibraryLocalService libraryLocalService = (LibraryLocalService)request.getAttribute("libraryLocalService");

PortletURL portletURL = renderResponse.createRenderURL();
String currentURL = portletURL.toString();
%>
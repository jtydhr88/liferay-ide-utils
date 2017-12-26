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

package com.liferay.bookmarks.web.internal.portlet.action;

import com.liferay.bookmarks.constants.BookmarksPortletKeys;
import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.bookmarks.model.BookmarksFolder;
import com.liferay.bookmarks.service.BookmarksEntryService;
import com.liferay.bookmarks.service.BookmarksFolderService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Charles Wu
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS,
		"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS_ADMIN,
		"mvc.command.name=/bookmarks/import_entries"
	},
	service = MVCActionCommand.class
)
public class ImportEntriesMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String content = null;

		try (InputStream inputStream = uploadPortletRequest.getFileAsStream("bookmarks_file")) {

			byte[] data = FileUtil.getBytes(inputStream);

			content = new String(data);

			if (!"".equals(content) && content != null) {
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

				long groupId = themeDisplay.getScopeGroupId();
				long folderId = ParamUtil.getLong(actionRequest, "folderId");

				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(BookmarksEntry.class.getName(), actionRequest);

				Document doc = Jsoup.parse(content);

				Elements elements = doc.select("body > dl > dt > dl");

				recurFolder(elements, serviceContext, groupId, folderId);

				actionResponse.sendRedirect(themeDisplay.getPortalURL());

			}
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	private void recurFolder(Elements folder, ServiceContext serviceContext, long groupId, long folderId)
		throws PortalException {

		for (int i = 0; i < folder.size(); i++) {
			Elements urls = folder.get(i).select("> dt > a");

			for (Element e : urls) {
				_bookmarksEntryService.addEntry(groupId, folderId, e.text(), e.attr("href"), "", serviceContext);
			}

			Elements titles = folder.get(i).select("> dt > h3");
			Elements subFolders = folder.get(i).select("> dt > dl");

			for (int j = 0; j < titles.size(); j++) {

				Elements elements = subFolders.get(j).getAllElements();

				BookmarksFolder subNewFolder =
					_bookmarksFolderService.addFolder(folderId, titles.get(j).text(), "", serviceContext);

				recurFolder(elements, serviceContext, groupId, subNewFolder.getFolderId());
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(ImportEntriesMVCActionCommand.class);

	@Reference(unbind = "-")
	protected void setBookmarksEntryService(BookmarksEntryService bookmarksEntryService) {
		_bookmarksEntryService = bookmarksEntryService;
	}

	@Reference(unbind = "-")
	protected void setBookmarksFolderService(
		BookmarksFolderService bookmarksFolderService) {
		_bookmarksFolderService = bookmarksFolderService;
	}
	
	private BookmarksEntryService _bookmarksEntryService;
	private BookmarksFolderService _bookmarksFolderService;

	@Reference
	private Http _http;

	@Reference
	private Portal _portal;

}

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
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Haoyi Sun
 */
@Component(immediate = true, property = { "javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS,
		"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS_ADMIN,
		"mvc.command.name=/bookmarks/get_title" }, service = MVCActionCommand.class)
public class GetTitleMVCActionCommand extends BaseMVCActionCommand {

	private static final String _REGEX_HEAD = "(?i)<head>" + ".*" + "(?i)</head>";
	private static final String _REGEX_TITLE = "(?i)<title>" + ".*" + "(?i)</title>";
	private static final String _REGEX_CHARSET = "(?i)charset=";
	private static final String _UTF_8 = "utf-8";
	private static final String _GBK = "gbk";
	private static final String _GB_2312 = "gb2312";
	private static final String _ISO_8859_1 = "iso-8859-1";

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);

		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

		String url = originalRequest.getParameter("requestPage");

		StringBuffer pageToTitle = _getHtmlHead(url, _UTF_8);

		if (pageToTitle != null) {
			String charset = _htmlCharsetFilter(pageToTitle);

			if (charset == _ISO_8859_1) {
				pageToTitle = _getHtmlHead(url, _ISO_8859_1);
			} else if (charset == _GB_2312) {
				pageToTitle = _getHtmlHead(url, _GB_2312);
			} else if (charset == _GBK) {
				pageToTitle = _getHtmlHead(url, _GBK);
			}

			String title = _htmlTitleFilter(pageToTitle);

			if (title != null && charset != _ISO_8859_1) {

				actionResponse.addProperty("TitleValue", URLEncoder.encode(title, _UTF_8));
			} else if (title != null) {
				actionResponse.addProperty("TitleValue", title);
			}
		} else {
			actionResponse.addProperty("TitleValue", "null");
		}

	}

	private StringBuffer _getHtmlHead(String url, String encoding) {
		URL page = null;
		HttpURLConnection httpUrlConn = null;
		try {
			page = new URL(url);

			httpUrlConn = (HttpURLConnection) page.openConnection();

			httpUrlConn.setDoInput(true);

			httpUrlConn.setRequestMethod("GET");

			httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		} catch (IOException e1) {
			return null;
		}

		StringBuffer pageContext = new StringBuffer();

		try (InputStream pageStream = httpUrlConn.getInputStream();

				InputStreamReader reader = new InputStreamReader(pageStream, encoding);

				BufferedReader bufferedReader = new BufferedReader(reader);

		) {

			String str = null;

			while ((str = bufferedReader.readLine()) != null) {
				pageContext.append(str);

				if (_cutoffHtml(pageContext, _REGEX_HEAD).find()) {
					break;
				}
			}

		} catch (IOException e) {
			return null;
		}

		return pageContext;
	}

	private Matcher _cutoffHtml(StringBuffer html, String regex) {

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(html);

		return matcher;
	}

	private String _htmlTitleFilter(StringBuffer htmlHead) {
		Matcher matcher = _cutoffHtml(htmlHead, _REGEX_TITLE);

		if (matcher.find()) {
			return (htmlHead.substring(matcher.start() + "<title>".length(), matcher.end() - "</title>".length()));
		}

		return null;
	}

	private String _htmlCharsetFilter(StringBuffer htmlHead) {
		Matcher matcher = _cutoffHtml(htmlHead, _REGEX_CHARSET);

		if (matcher.find()) {
			String charset = htmlHead.substring(matcher.start() + "charset=".length());

			String subCharset = charset.substring(0, 10);

			if ((subCharset.indexOf(_UTF_8) != -1) || (subCharset.indexOf(_UTF_8.toUpperCase()) != -1)) {
				return _UTF_8;
			} else if (subCharset.indexOf(_GBK) != -1 || (subCharset.indexOf(_GBK.toUpperCase()) != -1)) {
				return _GBK;
			} else if (subCharset.indexOf(_GB_2312) != -1 || (subCharset.indexOf(_GB_2312.toUpperCase()) != -1)) {
				return _GB_2312;
			} else {
				return _ISO_8859_1;
			}
		}

		return _ISO_8859_1;
	}
}

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

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

/**
 * @author Haoyi Sun
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS,
				"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS_ADMIN,
				"mvc.command.name=/bookmarks/get_title"
		},
		service = MVCActionCommand.class
)
public class GetTitleMVCActionCommand extends BaseMVCActionCommand {

	private final String _REGEX_TITLE = "<title>(.*?)</title>";
	private final String _REGEX_CHARSET = "<meta.*charset\\s*=([^\\s'\"]+).*>";

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);

		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

		String url = originalRequest.getParameter("requestPage");

		String title = _getTitleFromHtml(url);

		if (title != null) {
			title = title.replaceAll("&#8211;", "-");

			String encodeTitle = URLEncoder.encode(title, "utf-8");

			encodeTitle = encodeTitle.replaceAll("\\+", "%20");

			actionResponse.addProperty("Title", encodeTitle);
		}
	}

	private String _getTitleFromHtml(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet(url);

		Builder requestBuidler = RequestConfig.custom();

		Builder connectionTimeoutSet = requestBuidler.setConnectTimeout(5000);

		Builder requestTimeoutSet = connectionTimeoutSet.setConnectionRequestTimeout(3000);

		RequestConfig timeoutSet = requestTimeoutSet.setSocketTimeout(5000).build();

		httpGet.addHeader("Accept", "text/html");
		httpGet.addHeader("Accept-Charset", "utf-8");
		httpGet.addHeader("Accept-Encoding", "gzip");
		httpGet.addHeader("User-Agent",
				"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");
		httpGet.setConfig(timeoutSet);

		String title = null;

		byte[] html = null;

		String charsetName = null;

		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);

			HttpEntity entity = response.getEntity();

			ContentType contentType = ContentType.getOrDefault(entity);

			Charset charset = contentType.getCharset();

			html = EntityUtils.toByteArray(entity);

			byte[] partOfHtml = new byte[20000];

			System.arraycopy(html, 0, partOfHtml, 0, 20000);

			if (charset != null) {
				charsetName = contentType.getCharset().toString();
			}
			else {
				charsetName = getInfoFromHtml(partOfHtml, _REGEX_CHARSET, "UTF-8");
			}

			title = getInfoFromHtml(partOfHtml, _REGEX_TITLE, charsetName);

		} catch (IOException e) {
			return null;
		}

		return title;
	}

	private String getInfoFromHtml(byte[] partOfHtml, String regex, String charsetName) {
		String matchData = null;

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		String htmlEntity = StringUtils.newString(partOfHtml, charsetName);

		Matcher matcher = pattern.matcher(htmlEntity);

		if (matcher.find()) {
			matchData = matcher.group(1);
		}
		else {
			if (regex == _REGEX_CHARSET) {
				matchData = "iso-8859-1";
			}
		}

		return matchData.trim();
	}
}

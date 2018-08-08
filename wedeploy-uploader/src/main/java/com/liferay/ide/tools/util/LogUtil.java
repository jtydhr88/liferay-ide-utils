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

package com.liferay.ide.tools.util;

import com.liferay.ide.tools.LogConstants;
import com.liferay.ide.tools.checker.Checker;
import com.liferay.ide.tools.checker.IntegrationJobsChecker;
import com.liferay.ide.tools.checker.SingleJobChecker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.regex.Matcher;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Haoyi Sun
 */
public class LogUtil {

	public static void deleteChecker(String checkerName, File htmlFolder) {
		File checkerFolder = new File(htmlFolder, checkerName);

		FileUtil.deleteFolder(checkerFolder);

		File checkerLogHtml = new File(htmlFolder, LogConstants.HOME_FILE_NAME);

		try {
			Document document = Jsoup.parse(checkerLogHtml, LogConstants.UTF_8);

			HtmlUtil.deleteElementById(document, checkerName + LogConstants.NAV_ID_SUFFIX);

			HtmlUtil.deleteElementById(document, checkerName);

			FileUtil.writeFile(checkerLogHtml, document);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static String getBuildErrorType(String buildHtml) {
		String errorType = "";

		Matcher matchErrorType = LogConstants.errorTypePattern.matcher(buildHtml);

		if (matchErrorType.find()) {
			errorType = matchErrorType.group(1);
		}

		return errorType;
	}

	public static Checker getChecker(String type) {
		Checker checker = new SingleJobChecker();

		if (type.equals(LogConstants.INTEGRATION)) {
			checker = new IntegrationJobsChecker();
		}

		return checker;
	}

	public static Optional<String> getHtmlFromWeb(String url) {
		HttpGet request = new HttpGet(url);

		HttpClient client = HttpClientBuilder.create().build();

		Optional<String> log = Optional.empty();

		try {
			HttpResponse response = client.execute(request);

			StatusLine statusLine = response.getStatusLine();

			if (statusLine.getStatusCode() != 200) {
				System.out.println("Response status is not 200!");

				return log;
			}

			HttpEntity entity = response.getEntity();

			String entityContent = EntityUtils.toString(entity, LogConstants.UTF_8);

			log = Optional.of(entityContent);
		}
		catch (Exception e) {
			System.out.println("Unable to get log from server!");

			e.printStackTrace();
		}

		return log;
	}

	//	public static void renameChecker(String oldName, String newName, File htmlFolder) {
	//		File checkerFolder = new File(htmlFolder, oldName);
	//
	//		File checkerLogHtml = new File(htmlFolder, LogConstants.HOME_FILE_NAME);

	//
	//		String content = FileUtil.readFile(checkerLogHtml);

	//
	//		content.replaceAll(oldName, newName);
	//
	//
	//	}

	public static String getPropertyFromProperties(String key) {
		File file = new File(LogConstants.RESOURCE_HOME_PROPERTIES);

		Path path = file.toPath();

		String homePath = null;

		try (InputStream inputStream = Files.newInputStream(path)) {
			Properties logHomePathProperties = new Properties();

			logHomePathProperties.load(inputStream);

			homePath = logHomePathProperties.getProperty(key);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return homePath;
	}

	public static void processArgs(String[] args, Map<String, String> map, String homePath) {
		File homeFolder = new File(homePath);

		File contentFolder = new File(homeFolder, "content");

		File htmlFolder = new File(contentFolder, "html");

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals(LogConstants.BUILD_NUMBER)) {
				String buildNumber = args[i + 1];

				map.put(LogConstants.BUILD_NUMBER, buildNumber);
			}
			else if (args[i].equals(LogConstants.CHECKER_NAME)) {
				String checkerName = args[i + 1];

				map.put(LogConstants.CHECKER_NAME, checkerName);
			}
			else if (args[i].equals(LogConstants.CHECKER_TYPE)) {
				String checkerType = args[i + 1];

				map.put(LogConstants.CHECKER_TYPE, checkerType);
			}
			else if (args[i].equals(LogConstants.DELETE)) {
				String deleteChecker = args[i + 1];

				deleteChecker(deleteChecker, htmlFolder);
			}
			//			else if (args[i].equals(LogConstants.RENAME)) {
			//				String oldName = args[i+1];
			//
			//				String newName = args[i+2];

			//
			//				LogUtil.renameChecker(oldName, newName, htmlFolder);
			//			}
		}
	}

}
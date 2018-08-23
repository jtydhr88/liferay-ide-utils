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

package com.liferay.ide.tools;

import com.liferay.ide.tools.checker.Checker;
import com.liferay.ide.tools.util.FileUtil;
import com.liferay.ide.tools.util.LogUtil;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Terry Jia
 * @author Haoyi Sun
 */
public class LogGenerator {

	public static void main(String[] args) {
		String homePath = LogUtil.getPropertyFromProperties(LogConstants.LOG_HOME_PATH_KEY);

		_copyResourceIfNotExists(homePath);

		_init(args, homePath);

		File ideLogFolder = new File(homePath);

		File contentFolder = new File(ideLogFolder, "content");

		File destLogFolder = _checker.createLogFolder(contentFolder);

		_checker.createLogFiles(destLogFolder);

		File htmlFolder = new File(contentFolder, "html");

		File deletedFolder = _checker.updateHomeHtml(htmlFolder);

		FileUtil.deleteFolder(deletedFolder);
	}

	private static void _copyResourceIfNotExists(String homePath) {
		File home = new File(homePath);

		File content = new File(home, "content");

		if (!FileUtil.fileExist(content)) {
			content.mkdir();
		}

		File json = new File(home, "wedeploy.json");

		if (!FileUtil.fileExist(json)) {
			File jsonSrc = new File(LogConstants.RESOURCE_WEDEPLOY);

			FileUtil.copyFile(jsonSrc, home, null);
		}

		File js = new File(content, "js");

		if (!FileUtil.fileExist(js)) {
			js.mkdir();

			File jsSrc = new File(LogConstants.RESOURCE_LOGGER_JS);

			FileUtil.copyFile(jsSrc, js, null);
		}

		File css = new File(content, "css");

		if (!FileUtil.fileExist(css)) {
			css.mkdir();

			File checkerCssSrc = new File(LogConstants.RESOURCE_LOGGER_CSS);

			FileUtil.copyFile(checkerCssSrc, css, null);

			File logCssSrc = new File(LogConstants.RESOURCE_LOG_CSS);

			FileUtil.copyFile(logCssSrc, css, null);
		}

		File html = new File(content, "html");

		if (!FileUtil.fileExist(html)) {
			html.mkdir();

			File htmlSrc = new File(LogConstants.RESOURCE_CHECKER_LOGGER_HTML);

			FileUtil.copyFile(htmlSrc, html, null);
		}
	}

	private static void _init(String[] args, String homePath) {
		Map<String, String> map = new HashMap<>();

		LogUtil.processArgs(args, map, homePath);

		String buildNumber = map.get(LogConstants.BUILD_NUMBER);

		String checkerName = map.get(LogConstants.CHECKER_NAME);

		String type = map.get(LogConstants.CHECKER_TYPE);

		_checker = LogUtil.getChecker(type);

		_checker.init(buildNumber, checkerName);
	}

	private static Checker _checker = null;

}
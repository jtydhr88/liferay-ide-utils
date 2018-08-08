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

import java.util.regex.Pattern;

/**
 * @author Haoyi Sun
 */
public interface LogConstants {

	public static final String BUILD_NUMBER = "buildNumber";

	public static final String CHECKER_NAME = "checkerName";

	public static final String CHECKER_TYPE = "checkerType";

	public static final String COMPLETE_LOG_FILE_SUFFIX = "-complete.html";

	public static final String CONSOLE_TEXT = "consoleText";

	public static final String DELETE = "delete";

	public static final String ERROR_MESSAGE = "Error Message";

	public static final String FAILED = "Failed";

	public static final String FAILED_TESTS = "Failed Tests";

	public static final String HOME_FILE_NAME = "checker-logger.html";

	public static final String INTEGRATION = "integration";

	public static final String ITEM_ID_SUFFIX = "-item";

	public static final String JOB = "job";

	public static final int LOG_COUNT_MAX = 20;

	public static final String LOG_HOME_PATH_KEY = "log.home.path";

	public static final String MODULE_BUILDS = "Module Builds";

	public static final String NAV_ID_SUFFIX = "-nav";

	public static final String REGRESSION = "Regression";

	public static final String RENAME = "rename";

	public static final String RESOURCE_CHECKER_LOGGER_HTML = "src/main/resource/checker-logger.html";

	public static final String RESOURCE_HOME_PROPERTIES = "src/main/resource/config.properties";

	public static final String RESOURCE_LOG_CSS = "src/main/resource/log.css";

	public static final String RESOURCE_LOGGER_CSS = "src/main/resource/checker-logger.css";

	public static final String RESOURCE_LOGGER_JS = "src/main/resource/checker-logger.js";

	public static final String RESOURCE_SIMPLE_LOG = "src/main/resource/simple-log.html";

	public static final String RESOURCE_WEDEPLOY = "src/main/resource/wedeploy.json";

	public static final String SERVER_IP_KEY = "server.ip";

	public static final String SIMPLE_LOG_FILE_SUFFIX = "-simple.html";

	public static final String STACK_TRACE = "Stacktrace";

	public static final String TEST_REPORT = "testReport";

	public static final String UNSTABLE = "Unstable";

	public static final String UTF_8 = "utf-8";

	public static final Pattern errorJobPattern = Pattern.compile(
		"Finished Build : #(\\d*) of Job : (.*) with status : (UNSTABLE|FAILURE)");
	public static final Pattern errorTypePattern = Pattern.compile(
		"<img src=.* alt=\"(\\w*)\" tooltip=\"\\w*\" style=\"\\w*: \\w*; \\w*: \\w*;" +
			" \" class=\"\\w*-\\w* \\w*-\\w*\" />");

}
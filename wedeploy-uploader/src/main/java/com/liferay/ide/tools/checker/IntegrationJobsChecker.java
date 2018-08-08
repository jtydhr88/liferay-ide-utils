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

package com.liferay.ide.tools.checker;

import com.liferay.ide.tools.LogConstants;
import com.liferay.ide.tools.build.Type.Build;
import com.liferay.ide.tools.util.FileUtil;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * @author Haoyi Sun
 */
public class IntegrationJobsChecker extends BaseChecker {

	@Override
	public void createLogFiles(File logFolder) {
		File srcFile = new File(LogConstants.RESOURCE_SIMPLE_LOG);

		File simpleLogFile = FileUtil.copyFile(
			srcFile, logFolder, checkerName + buildNumber + LogConstants.SIMPLE_LOG_FILE_SUFFIX);

		if (_checkers.isEmpty()) {
			File completeLogFile = new File(
				logFolder, checkerName + buildNumber + LogConstants.COMPLETE_LOG_FILE_SUFFIX);

			try {
				completeLogFile.createNewFile();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}

			if (buildHtml.isPresent()) {
				String html = buildHtml.get();

				logProcess.createLogToLogFiles(simpleLogFile, completeLogFile, html);
			}
		}
		else {
			_checkers.forEach(
				(subCheckerName, subChecker) -> {
					subChecker.setSubJob(true);

					subChecker.setParentChecker(this);

					subChecker.createLogFiles(logFolder);
				});
		}
	}

	@Override
	public void init(String number, String checkerName) {
		buildNumber = number;

		this.checkerName = checkerName;

		setCheckerUrl();

		setBuildLog();

		resolveBuildType();

		initLogProcess();

		_fillTestCheckers();
	}

	private void _fillSubCheckersInfo() {
		Build build = logProcess.getBuild();

		String consoleText = build.getConsoleText();

		String[] buildLogLines = consoleText.split("\\n");

		List<String> logLines = new ArrayList();

		Collections.addAll(logLines, buildLogLines);

		logLines.forEach(
			logLine -> {
				Matcher matcher = LogConstants.errorJobPattern.matcher(logLine);

				if (matcher.find()) {
					_subCheckersInfo.put(matcher.group(2), matcher.group(1));
				}
			});
	}

	private void _fillTestCheckers() {
		_fillSubCheckersInfo();

		_subCheckersInfo.forEach((subCheckerName, subCheckerBuildNumber) -> {
			SingleJobChecker subChecker = new SingleJobChecker();

			subChecker.init(subCheckerBuildNumber, subCheckerName);

			_checkers.put(subCheckerName, subChecker);
		});
	}

	private Map<String, SingleJobChecker> _checkers = new HashMap<>();
	private Map<String, String> _subCheckersInfo = new HashMap<>();

}

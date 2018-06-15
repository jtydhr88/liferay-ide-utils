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

import com.liferay.ide.tools.build.process.FailedLogProcess;
import com.liferay.ide.tools.build.process.LogProcess;
import com.liferay.ide.tools.build.process.UnstableLogProcess;

import java.io.File;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;

/**
 * @author Terry Jia
 */
public class LogGenerator {

	public static void main(String[] args) {
		_buildNumber = LogUtil.getBuildNumber(args);
		_buildName = LogUtil.getBuildName(args);

		if (_buildNumber.equals("-1") || _buildName.equals("-1")) {
			return;
		}

		File parentFolder = new File(Log.PARENT);

		File uiTestingReportsFolder = new File(parentFolder, "ui-testing-reports");

		File newBuildLogFolder = new File(uiTestingReportsFolder, _buildNumber);

		_createLogFolder(newBuildLogFolder);

		_getErrorTypeToLogProcess();

		_logProcess.initBuild(_buildName);

		_updateUiTestingReports(uiTestingReportsFolder);

		boolean success = _logProcess.createLogFiles(newBuildLogFolder);

		if (!success) {
			System.out.println("Create log files failure!");

			return;
		}

		_uploadLogToWeDeploy(parentFolder);
	}

	private static void _createLogFolder(File folder) {
		LogUtil.deleteFolder(folder);

		folder.mkdir();
	}

	private static String _getErrorType() {
		StringBuilder buildUrl = new StringBuilder();

		buildUrl.append(Log.SERVER_IP);
		buildUrl.append("/job/");
		buildUrl.append(_buildName);
		buildUrl.append("/");
		buildUrl.append(_buildNumber);
		buildUrl.append("/");

		Optional<String> log = LogUtil.getLogFromWeb(buildUrl.toString());

		String errorType = "";

		if (log.isPresent()) {
			String buildLog = log.get();

			Matcher matchErrorType = Log.errorTypePattern.matcher(buildLog);

			if (matchErrorType.find()) {
				errorType = matchErrorType.group(1);
			}
		}

		return errorType;
}

	private static void _getErrorTypeToLogProcess() {
		String errorType = _getErrorType();

		if (errorType.equals("Unstable")) {
			_logProcess = new UnstableLogProcess(_buildNumber);
		}
		else if (errorType.equals("Failed")) {
			_logProcess = new FailedLogProcess(_buildNumber);
		}
	}

	private static void _updateUiTestingReports(File reportFolder) {
		File recordFolder = new File(reportFolder, "record");

		String deleteFolderName = _logProcess.updateItemsHtml(recordFolder);

		if (LogUtil.isNotEmpty(deleteFolderName)){
			File deleteObsoleteLogFolder = new File(reportFolder, deleteFolderName);

			LogUtil.deleteFolder(deleteObsoleteLogFolder);
		}
	}

	private static void _uploadLogToWeDeploy(File parent) {
		try {
			Runtime runtime = Runtime.getRuntime();

			Process upload = runtime.exec(Log.WE_DEPLOY_PROJECT, null, parent);

			LogUtil.waitForUpload(upload, 120 * 1000);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static String _buildNumber;
	private static LogProcess _logProcess;
	private static String _buildName;

}

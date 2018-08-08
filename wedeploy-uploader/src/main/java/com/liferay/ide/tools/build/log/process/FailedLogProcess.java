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

package com.liferay.ide.tools.build.log.process;

import com.liferay.ide.tools.LogConstants;
import com.liferay.ide.tools.build.Type.Build;
import com.liferay.ide.tools.build.Type.FailedBuild;
import com.liferay.ide.tools.util.FileUtil;
import com.liferay.ide.tools.util.HtmlUtil;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Haoyi Sun
 */
public class FailedLogProcess implements LogProcess {

	public FailedLogProcess(String buildUrl, String buildNumber, String buildName) {
		_failedBuild = new FailedBuild(buildUrl, buildNumber, buildName);
	}

	@Override
	public void createLogToLogFiles(File simpleFile, File completeFile, String buildHtml) {
		String completeFileName = completeFile.getName();

		String commitMessage = _getCommitMessage(buildHtml);

		if (commitMessage == null) {
			commitMessage = _getModuleBuilds(buildHtml);
		}

		_createSimpleLogToFile(simpleFile, completeFileName, commitMessage);

		_createCompleteLogToFile(completeFile);
	}

	@Override
	public Build getBuild() {
		return _failedBuild;
	}

	@Override
	public void initBuild(String checkerUrl) {
		_failedBuild.setConsoleTextFromWeb();
	}

	@Override
	public File updateHomeHtml(File htmlFolder, String checkerName, String buildNumber) {
		File homeFile = new File(htmlFolder, LogConstants.HOME_FILE_NAME);

		File checkerFolder = new File(htmlFolder, checkerName);

		File deletedFolder = null;

		try {
			Document document = Jsoup.parse(homeFile, LogConstants.UTF_8);

			String number = HtmlUtil.updateHomeContent(document, checkerName, buildNumber);

			FileUtil.writeFile(homeFile, document);

			if (number != null) {
				deletedFolder = new File(checkerFolder, number);
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return deletedFolder;
	}

	private void _createCompleteLogToFile(File completeLogFile) {
		try {
			Document completeLogHtml = Jsoup.parse(completeLogFile, LogConstants.UTF_8);

			String consoleText = _failedBuild.getConsoleText();

			HtmlUtil.createCompleteLog(completeLogHtml, consoleText);

			FileUtil.writeFile(completeLogFile, completeLogHtml);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void _createSimpleLogToFile(File simpleLogFile, String completeFileName, String commitMessage) {
		try {
			Document simpleLogHtml = Jsoup.parse(simpleLogFile, LogConstants.UTF_8);

			String buildName = _failedBuild.getBuildName();

			String buildNumber = _failedBuild.getBuildNumber();

			String consoleText = _failedBuild.getConsoleText();

			HtmlUtil.createSimpleLogToFailedBuild(
				simpleLogHtml, buildName, buildName + buildNumber, completeFileName, commitMessage, consoleText);

			FileUtil.writeFile(simpleLogFile, simpleLogHtml);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private String _getCommitMessage(String html) {
		return HtmlUtil.getCommitMessageFromHtml(html);
	}

	private String _getModuleBuilds(String html) {
		return HtmlUtil.getModuleBuildsFromHtml(html);
	}

	private FailedBuild _failedBuild = null;

}
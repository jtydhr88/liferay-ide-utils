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
import com.liferay.ide.tools.build.Result.FailureTestResult;
import com.liferay.ide.tools.build.Type.Build;
import com.liferay.ide.tools.build.Type.UnstableBuild;
import com.liferay.ide.tools.util.FileUtil;
import com.liferay.ide.tools.util.HtmlUtil;

import java.io.File;
import java.io.IOException;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Haoyi Sun
 */
public class UnstableLogProcess implements LogProcess {

	public UnstableLogProcess(String buildUrl, String buildNumber, String buildName) {
		_unstableBuild = new UnstableBuild(buildUrl, buildNumber, buildName);
	}

	@Override
	public void createLogToLogFiles(File simpleFile, File completeFile, String buildHtml) {
		String completeFileName = completeFile.getName();

		_createSimpleLogToFile(simpleFile, completeFileName);

		_createCompleteLogToFile(completeFile);
	}

	@Override
	public Build getBuild() {
		return _unstableBuild;
	}

	@Override
	public void initBuild(String checkerUrl) {
		_unstableBuild.setConsoleTextFromWeb();
		_unstableBuild.setFailedTestNameFromWeb();
		_unstableBuild.fillFailureTests();
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

			String consoleText = _unstableBuild.getConsoleText();

			HtmlUtil.createCompleteLog(completeLogHtml, consoleText);

			FileUtil.writeFile(completeLogFile, completeLogHtml);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void _createSimpleLogToFile(File simpleLogFile, String completeFileName) {
		try {
			Document simpleLogHtml = Jsoup.parse(simpleLogFile, LogConstants.UTF_8);

			List<FailureTestResult> failureTestResults = _unstableBuild.getFailureTests();

			String buildName = _unstableBuild.getBuildName();

			String failedTestName = _unstableBuild.getFailedTestName();

			HtmlUtil.createSimpleLogToUnstableBuild(
				simpleLogHtml, failureTestResults, buildName, failedTestName, completeFileName);

			FileUtil.writeFile(simpleLogFile, simpleLogHtml);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private UnstableBuild _unstableBuild = null;

}
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
import com.liferay.ide.tools.util.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author Haoyi Sun
 */
public class SingleJobChecker extends BaseChecker {

	@Override
	public void createLogFiles(File logFolder) {
		File completeLogFile = new File(logFolder, checkerName + buildNumber + LogConstants.COMPLETE_LOG_FILE_SUFFIX);

		try {
			completeLogFile.createNewFile();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		String html = null;

		if (buildHtml.isPresent()) {
			html = buildHtml.get();
		}

		File simpleLogFile = null;

		if (_subJob && (html != null)) {
			simpleLogFile = new File(
				logFolder,
				_parentChecker.checkerName + _parentChecker.buildNumber + LogConstants.SIMPLE_LOG_FILE_SUFFIX);

			logProcess.createLogToLogFiles(simpleLogFile, completeLogFile, html);
		}
		else {
			File srcFile = new File(LogConstants.RESOURCE_SIMPLE_LOG);

			simpleLogFile = FileUtil.copyFile(
				srcFile, logFolder, checkerName + buildNumber + LogConstants.SIMPLE_LOG_FILE_SUFFIX);

			logProcess.createLogToLogFiles(simpleLogFile, completeLogFile, html);
		}
	}

	@Override
	public void init(String number, String checkerName) {
		this.checkerName = checkerName;

		buildNumber = number;

		setCheckerUrl();

		setBuildLog();

		resolveBuildType();

		initLogProcess();
	}

	public boolean isSubJob() {
		return _subJob;
	}

	public void setParentChecker(IntegrationJobsChecker parentChecker) {
		_parentChecker = parentChecker;
	}

	public void setSubJob(boolean subJob) {
		_subJob = subJob;
	}

	private IntegrationJobsChecker _parentChecker = null;
	private boolean _subJob = false;

}

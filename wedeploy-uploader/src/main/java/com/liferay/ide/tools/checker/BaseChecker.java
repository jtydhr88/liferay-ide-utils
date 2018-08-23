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
import com.liferay.ide.tools.build.log.process.FailedLogProcess;
import com.liferay.ide.tools.build.log.process.LogProcess;
import com.liferay.ide.tools.build.log.process.UnstableLogProcess;
import com.liferay.ide.tools.util.FileUtil;
import com.liferay.ide.tools.util.LogUtil;

import java.io.File;

import java.util.Optional;

/**
 * @author Haoyi Sun
 */
public abstract class BaseChecker implements Checker {

	@Override
	public File createLogFolder(File contentFolder) {
		File logFolder = FileUtil.createLogFolder(contentFolder, checkerName, buildNumber);

		return logFolder;
	}

	public void setBuildLog() {
		buildHtml = LogUtil.getHtmlFromWeb(checkerUrl.toString());
	}

	public void setCheckerUrl() {
		String serverIp = LogUtil.getPropertyFromProperties(LogConstants.SERVER_IP_KEY);

		checkerUrl.append(serverIp);

		checkerUrl.append("/");
		checkerUrl.append(LogConstants.JOB);
		checkerUrl.append("/");
		checkerUrl.append(checkerName);
		checkerUrl.append("/");
		checkerUrl.append(buildNumber);
		checkerUrl.append("/");
	}

	@Override
	public File updateHomeHtml(File htmlFolder) {
		File deletedFolderName = logProcess.updateHomeHtml(htmlFolder, checkerName, buildNumber);

		return deletedFolderName;
	}

	protected void initLogProcess() {
		logProcess.initBuild(checkerUrl.toString());
	}

	protected void resolveBuildType() {
		if (buildHtml.isPresent()) {
			buildType = LogUtil.getBuildErrorType(buildHtml.get());

			if (buildType.equals(LogConstants.UNSTABLE)) {
				logProcess = new UnstableLogProcess(checkerUrl.toString(), buildNumber, checkerName);
			}
			else if (buildType.equals(LogConstants.FAILED)) {
				logProcess = new FailedLogProcess(checkerUrl.toString(), buildNumber, checkerName);
			}
		}
	}

	protected Optional<String> buildHtml = null;
	protected String buildNumber = null;
	protected String buildType = null;
	protected String checkerName = null;
	protected StringBuilder checkerUrl = new StringBuilder();
	protected LogProcess logProcess = null;

}
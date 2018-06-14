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

package com.liferay.ide.tools.build.process;

import com.liferay.ide.tools.LogUtil;
import com.liferay.ide.tools.build.Build;
import com.liferay.ide.tools.build.FailedBuild;

import java.io.File;

/**
 * @author Haoyi Sun
 */
public class FailedLogProcess implements LogProcess {

	public FailedLogProcess(String buildNumber) {
		_buildNumber = buildNumber;

		_failedBuild = new FailedBuild(buildNumber);
	}

	@Override
	public boolean createLogFiles(File folder) {
		String buildLog = _failedBuild.getBuildLog();

		String commitMessage = _failedBuild.getCommitMessage();

		boolean createSuccess = LogUtil.createHtml(buildLog, folder, commitMessage);

		return createSuccess;
	}

	@Override
	public void initBuild() {
		_failedBuild.setBuildLogFromWeb();
		_failedBuild.matcher();
	}

	@Override
	public String updateItemsHtml(File folder) {
		File itemsFile = new File(folder, "items.html");

		String commitMessage = _failedBuild.getCommitMessage();

		String deleteFolderName = LogUtil.updateItems(itemsFile, commitMessage, _buildNumber);

		return deleteFolderName;
	}

	private String _buildNumber = null;
	private Build _failedBuild = null;

}

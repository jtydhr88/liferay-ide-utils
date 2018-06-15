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
import com.liferay.ide.tools.build.UnstableBuild;

import java.io.File;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Haoyi Sun
 */
public class UnstableLogProcess implements LogProcess {

	public UnstableLogProcess(String buildNumber) {
		_buildNumber = buildNumber;

		_unstableBuild = new UnstableBuild(buildNumber);
	}

	@Override
	public boolean createLogFiles(File folder) {
		Map<String, String> jobLogs = _unstableBuild.getJobLogs();

		AtomicBoolean allSuccess = new AtomicBoolean(true);

		jobLogs.forEach(
			(jobName, jobLog) -> {
				boolean createSuccess = LogUtil.createHtml(jobLog, folder, jobName);

				if (createSuccess == false) {
					allSuccess.set(false);

					return;
				}
			});

		return allSuccess.get();
	}

	@Override
	public void initBuild(String buildName) {
		_unstableBuild.setBuildLogFromWeb(buildName);
		_unstableBuild.matcher();
		_unstableBuild.setJoblogsFromWeb();
	}

	@Override
	public String updateItemsHtml(File folder) {
		File itemsFile = new File(folder, "items.html");

		Map<String, String> jobs = _unstableBuild.getJobs();

		String deleteFolderName = LogUtil.updateItems(itemsFile, jobs, _buildNumber);

		return deleteFolderName;
	}

	private String _buildNumber = null;
	private Build _unstableBuild = null;

}

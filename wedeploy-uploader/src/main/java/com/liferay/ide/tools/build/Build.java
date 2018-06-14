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

package com.liferay.ide.tools.build;

import com.liferay.ide.tools.Log;
import com.liferay.ide.tools.LogUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;

/**
 * @author Haoyi Sun
 */
public abstract class Build {

	public String getBuildLog() {
		return buildLog;
	}

	public String getCommitMessage() {
		return commitMessage;
	}

	public Map<String, String> getJobLogs() {
		return jobLogs;
	}

	public Map<String, String> getJobs() {
		return jobs;
	}

	public void matcher() {
		String[] buildLogLines = buildLog.split("\\n");

		List<String> logLines = new ArrayList<>();

		Collections.addAll(logLines, buildLogLines);

		logLines.forEach(
			logLine -> {
				Matcher matcher = Log.commitMessagePattern.matcher(logLine);

				if (matcher.find()) {
					commitMessage = matcher.group(1);

					return;
				}
			});
	}

	public void setBuildLogFromWeb() {
		StringBuilder buildLogUrl = new StringBuilder();

		buildLogUrl.append(Log.SERVER_IP);
		buildLogUrl.append("/job/Multiple-Job-Test/");
		buildLogUrl.append(buildNumber);
		buildLogUrl.append("/consoleText");

		Optional<String> log = LogUtil.getLogFromWeb(buildLogUrl.toString());

		if (log.isPresent()) {
			buildLog = log.get();
		}
	}

	public abstract void setJoblogsFromWeb();

	protected String buildLog = null;
	protected String buildNumber = null;
	protected String commitMessage = null;
	protected Map<String, String> jobLogs = new HashMap<>();
	protected Map<String, String> jobs = new HashMap<>();

}
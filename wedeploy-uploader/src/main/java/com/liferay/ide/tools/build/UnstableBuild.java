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
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;

/**
 * @author Haoyi Sun
 */
public class UnstableBuild extends Build {

	public UnstableBuild(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	@Override
	public void matcher() {
		String[] buildLogLines = buildLog.split("\\n");

		List<String> logLines = new ArrayList();

		Collections.addAll(logLines, buildLogLines);

		logLines.forEach(
			logLine -> {
				Matcher matcher = Log.unstableJobPattern.matcher(logLine);

				if (matcher.find()) {
					jobs.put(matcher.group(2), matcher.group(1));
				}
			});
	}

	public void setJoblogsFromWeb() {
		jobs.forEach(
			(jobName, jobNumber) -> {
				StringBuilder jobLogUrl = new StringBuilder();

				jobLogUrl.append(Log.SERVER_IP);
				jobLogUrl.append("job/");
				jobLogUrl.append(jobName);
				jobLogUrl.append("/");
				jobLogUrl.append(jobNumber);
				jobLogUrl.append("/consoleText");

				Optional<String> log = LogUtil.getLogFromWeb(jobLogUrl.toString());

				if (log.isPresent()) {
					jobLogs.put(jobName, log.get());
				}
			});
	}

}
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

package com.liferay.ide.tools.build.Type;

import com.liferay.ide.tools.LogConstants;
import com.liferay.ide.tools.util.LogUtil;

import java.util.Optional;

/**
 * @author Haoyi Sun
 */
public class Build {

	public Build() {
	}

	public Build(String buildUrl, String buildNumber, String buildName) {
		this.buildUrl = buildUrl;
		this.buildNumber = buildNumber;
		this.buildName = buildName;
	}

	public String getBuildName() {
		return buildName;
	}

	public String getBuildNumber() {
		return buildNumber;
	}

	public String getBuildUrl() {
		return buildUrl;
	}

	public String getConsoleText() {
		return consoleText;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	public void setBuildUrl(String buildUrl) {
		this.buildUrl = buildUrl;
	}

	public void setConsoleText(String consoleText) {
		this.consoleText = consoleText;
	}

	public void setConsoleTextFromWeb() {
		String consoleTextUrl = buildUrl + LogConstants.CONSOLE_TEXT;

		Optional<String> optional = LogUtil.getHtmlFromWeb(consoleTextUrl);

		if (optional.isPresent()) {
			consoleText = optional.get();
		}
	}

	protected String buildName = null;
	protected String buildNumber = null;
	protected String buildUrl = null;
	protected String consoleText = null;

}
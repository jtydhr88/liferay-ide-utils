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
import com.liferay.ide.tools.build.Result.FailureTestResult;
import com.liferay.ide.tools.util.HtmlUtil;
import com.liferay.ide.tools.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Haoyi Sun
 */
public class UnstableBuild extends Build {

	public UnstableBuild() {
	}

	public UnstableBuild(String buildUrl, String buildNumber, String buildName) {
		super(buildUrl, buildNumber, buildName);
	}

	public void fillFailureTests() {
		List<String> failedTestUrls = HtmlUtil.getFailedTestUrlsFromWeb(buildUrl, buildName);

		failedTestUrls.forEach(
			failedTestUrl -> {
				FailureTestResult result = HtmlUtil.getFailureTestInfoFromWeb(failedTestUrl);

				_failureTests.add(result);
			});
	}

	public String getFailedTestName() {
		return _failedTestName;
	}

	public List<FailureTestResult> getFailureTests() {
		return _failureTests;
	}

	public void setFailedTestNameFromWeb() {
		String consoleTextUrl = buildUrl + LogConstants.TEST_REPORT;

		Optional<String> optional = LogUtil.getHtmlFromWeb(consoleTextUrl);

		if (optional.isPresent()) {
			String testReport = optional.get();

			_failedTestName = HtmlUtil.getFailedTestNameFromHtml(testReport);
		}
	}

	public void setFailureTests(List<FailureTestResult> failureTests) {
		_failureTests = failureTests;
	}

	private String _failedTestName = null;
	private List<FailureTestResult> _failureTests = new ArrayList<>();

}
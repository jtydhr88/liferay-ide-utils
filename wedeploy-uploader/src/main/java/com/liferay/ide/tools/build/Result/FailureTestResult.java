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

package com.liferay.ide.tools.build.Result;

/**
 * @author Haoyi Sun
 */
public class FailureTestResult {

	public String getErrorMessage() {
		return _errorMessage;
	}

	public String getRegression() {
		return _regression;
	}

	public String getStackTrace() {
		return _stackTrace;
	}

	public void setErrorMessage(String errorMessage) {
		_errorMessage = errorMessage;
	}

	public void setRegression(String regression) {
		_regression = regression;
	}

	public void setStackTrace(String stackTrace) {
		_stackTrace = stackTrace;
	}

	private String _errorMessage = null;
	private String _regression = null;
	private String _stackTrace = null;

}
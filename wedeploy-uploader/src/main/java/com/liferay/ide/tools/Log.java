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

package com.liferay.ide.tools;

import java.util.regex.Pattern;

/**
 * @author Haoyi Sun
 */
public interface Log {

	public static final int MAX = 20;

	public static final String PARENT = "/home/build/wedeploy/liferayide/";

	public static final String SERVER_IP = "http://192.168.130.85:9090/";

	public static final String WE_DEPLOY_PROJECT = "we deploy -p liferayide";

	public static final Pattern commitMessagePattern = Pattern.compile("Commit message: \"(.*)\"");
	public static final Pattern errorTypePattern = Pattern.compile(
		"<img src=.* alt=\"(\\w*)\" tooltip=\"\\w*\" style=\"\\w*: \\w*; \\w*: \\w*;" +
			" \" class=\"\\w*-\\w* \\w*-\\w*\" />");
	public static final Pattern unstableJobPattern = Pattern.compile(
		"Finished Build : #(\\d*) of Job : (.*Tester) with status : UNSTABLE");

}

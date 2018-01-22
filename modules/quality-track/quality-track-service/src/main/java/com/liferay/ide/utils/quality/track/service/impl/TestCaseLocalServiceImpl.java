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

package com.liferay.ide.utils.quality.track.service.impl;

import com.liferay.ide.utils.quality.track.model.TestCase;
import com.liferay.ide.utils.quality.track.service.base.TestCaseLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the test case local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.ide.utils.quality.track.service.TestCaseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Terry Jia
 * @see TestCaseLocalServiceBaseImpl
 * @see com.liferay.ide.utils.quality.track.service.TestCaseLocalServiceUtil
 */
@ProviderType
public class TestCaseLocalServiceImpl extends TestCaseLocalServiceBaseImpl {

	public TestCase addTestCase(
			String testCaseName, String environment, long beforeTestCaseId, long afterTestCaseId,
			boolean automatic, String steps, long categroyId, String expectedResults, String developer,
			long developerId, String comments, ServiceContext serviceContext)
		throws PortalException {

		long testCaseId = counterLocalService.increment();

		TestCase testCase = testCasePersistence.create(testCaseId);

		testCase.setGroupId(serviceContext.getScopeGroupId());
		testCase.setCompanyId(serviceContext.getCompanyId());
		testCase.setUserId(serviceContext.getUserId());
		testCase.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		testCase.setTestCaseName(testCaseName);
		testCase.setEnvironment(environment);
		testCase.setBeforeTestCaseId(beforeTestCaseId);
		testCase.setAfterTestCaseId(afterTestCaseId);
		testCase.setAutomatic(automatic);
		testCase.setSteps(steps);
		testCase.setCategroyId(categroyId);
		testCase.setExpectedResults(expectedResults);
		testCase.setDeveloper(developer);
		testCase.setDeveloperId(developerId);
		testCase.setComments(comments);

		testCase.setCreateDate(serviceContext.getCreateDate(null));

		testCasePersistence.update(testCase);

		return testCase;
	}

	public TestCase updateTestCase(
			long testCaseId, String testCaseName, String environment, long beforeTestCaseId, long afterTestCaseId,
			boolean automatic, String steps, long categroyId, String expectedResults, String developer,
			long developerId, String comments, ServiceContext serviceContext)
		throws PortalException {

		TestCase testCase = testCasePersistence.fetchByPrimaryKey(testCaseId);

		testCase.setUserId(serviceContext.getUserId());
		testCase.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		testCase.setTestCaseName(testCaseName);
		testCase.setEnvironment(environment);
		testCase.setBeforeTestCaseId(beforeTestCaseId);
		testCase.setAfterTestCaseId(afterTestCaseId);
		testCase.setAutomatic(automatic);
		testCase.setSteps(steps);
		testCase.setCategroyId(categroyId);
		testCase.setExpectedResults(expectedResults);
		testCase.setDeveloper(developer);
		testCase.setDeveloperId(developerId);
		testCase.setComments(comments);

		testCase.setModifiedDate(serviceContext.getModifiedDate());

		testCasePersistence.update(testCase);

		return testCase;
	}

}
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

import aQute.bnd.annotation.ProviderType;

import java.util.Date;

import com.liferay.ide.utils.quality.track.model.Test;
import com.liferay.ide.utils.quality.track.service.base.TestLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the test local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.ide.utils.quality.track.service.TestLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Terry Jia
 * @see TestLocalServiceBaseImpl
 * @see com.liferay.ide.utils.quality.track.service.TestLocalServiceUtil
 */
@ProviderType
public class TestLocalServiceImpl extends TestLocalServiceBaseImpl {

	public Test addTest(String testName, long releaseId, long testCaseId, String actualResults, String jiraLink,
			Date time, int status, long statusByUserId, String statusByUserName, Date statusDate, String comments,
			ServiceContext serviceContext)
		throws PortalException {

		long testId = counterLocalService.increment();

		Test test = testPersistence.create(testId);

		test.setGroupId(serviceContext.getScopeGroupId());
		test.setCompanyId(serviceContext.getCompanyId());
		test.setUserId(serviceContext.getUserId());
		test.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		test.setActualResults(actualResults);
		test.setJiraLink(jiraLink);
		test.setComments(comments);
		test.setReleaseId(releaseId);
		test.setCreateDate(serviceContext.getCreateDate(null));

		testPersistence.update(test);

		return test;
	}

	public Test updateTest(long testId, String testName, long releaseId, long testCaseId, String actualResults,
			String jiraLink, Date time, int status, long statusByUserId, String statusByUserName, Date statusDate, String comments,
			ServiceContext serviceContext)
		throws PortalException {

		Test test = testPersistence.fetchByPrimaryKey(testId);

		test.setUserId(serviceContext.getUserId());
		test.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());
		
		test.setActualResults(actualResults);
		test.setJiraLink(jiraLink);
		test.setComments(comments);

		test.setModifiedDate(serviceContext.getModifiedDate());

		testPersistence.update(test);

		return test;
	}
}
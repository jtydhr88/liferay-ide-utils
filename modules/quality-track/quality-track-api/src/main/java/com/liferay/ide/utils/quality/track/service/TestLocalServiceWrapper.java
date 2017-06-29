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

package com.liferay.ide.utils.quality.track.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TestLocalService}.
 *
 * @author Terry Jia
 * @see TestLocalService
 * @generated
 */
@ProviderType
public class TestLocalServiceWrapper implements TestLocalService,
	ServiceWrapper<TestLocalService> {
	public TestLocalServiceWrapper(TestLocalService testLocalService) {
		_testLocalService = testLocalService;
	}

	/**
	* Adds the test to the database. Also notifies the appropriate model listeners.
	*
	* @param test the test
	* @return the test that was added
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Test addTest(
		com.liferay.ide.utils.quality.track.model.Test test) {
		return _testLocalService.addTest(test);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.Test addTest(
		java.lang.String testName, long releaseId, long testCaseId,
		java.lang.String actualResults, java.lang.String jiraLink,
		java.util.Date time, int status, long statusByUserId,
		java.lang.String statusByUserName, java.util.Date statusDate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testLocalService.addTest(testName, releaseId, testCaseId,
			actualResults, jiraLink, time, status, statusByUserId,
			statusByUserName, statusDate, serviceContext);
	}

	/**
	* Creates a new test with the primary key. Does not add the test to the database.
	*
	* @param testId the primary key for the new test
	* @return the new test
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Test createTest(
		long testId) {
		return _testLocalService.createTest(testId);
	}

	/**
	* Deletes the test from the database. Also notifies the appropriate model listeners.
	*
	* @param test the test
	* @return the test that was removed
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Test deleteTest(
		com.liferay.ide.utils.quality.track.model.Test test) {
		return _testLocalService.deleteTest(test);
	}

	/**
	* Deletes the test with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testId the primary key of the test
	* @return the test that was removed
	* @throws PortalException if a test with the primary key could not be found
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Test deleteTest(
		long testId) throws com.liferay.portal.kernel.exception.PortalException {
		return _testLocalService.deleteTest(testId);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.Test fetchTest(long testId) {
		return _testLocalService.fetchTest(testId);
	}

	/**
	* Returns the test with the primary key.
	*
	* @param testId the primary key of the test
	* @return the test
	* @throws PortalException if a test with the primary key could not be found
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Test getTest(long testId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testLocalService.getTest(testId);
	}

	/**
	* Updates the test in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param test the test
	* @return the test that was updated
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Test updateTest(
		com.liferay.ide.utils.quality.track.model.Test test) {
		return _testLocalService.updateTest(test);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.Test updateTest(
		long testId, java.lang.String testName, long releaseId,
		long testCaseId, java.lang.String actualResults,
		java.lang.String jiraLink, java.util.Date time, int status,
		long statusByUserId, java.lang.String statusByUserName,
		java.util.Date statusDate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testLocalService.updateTest(testId, testName, releaseId,
			testCaseId, actualResults, jiraLink, time, status, statusByUserId,
			statusByUserName, statusDate, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _testLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _testLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of tests.
	*
	* @return the number of tests
	*/
	@Override
	public int getTestsCount() {
		return _testLocalService.getTestsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _testLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _testLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.TestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _testLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.TestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _testLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the tests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.TestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tests
	* @param end the upper bound of the range of tests (not inclusive)
	* @return the range of tests
	*/
	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.Test> getTests(
		int start, int end) {
		return _testLocalService.getTests(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _testLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _testLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public TestLocalService getWrappedService() {
		return _testLocalService;
	}

	@Override
	public void setWrappedService(TestLocalService testLocalService) {
		_testLocalService = testLocalService;
	}

	private TestLocalService _testLocalService;
}
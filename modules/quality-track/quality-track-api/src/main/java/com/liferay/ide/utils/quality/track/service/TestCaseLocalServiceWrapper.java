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
 * Provides a wrapper for {@link TestCaseLocalService}.
 *
 * @author Terry Jia
 * @see TestCaseLocalService
 * @generated
 */
@ProviderType
public class TestCaseLocalServiceWrapper implements TestCaseLocalService,
	ServiceWrapper<TestCaseLocalService> {
	public TestCaseLocalServiceWrapper(
		TestCaseLocalService testCaseLocalService) {
		_testCaseLocalService = testCaseLocalService;
	}

	@Override
	public boolean hasReleaseTestCase(long releaseId, long testCaseId) {
		return _testCaseLocalService.hasReleaseTestCase(releaseId, testCaseId);
	}

	@Override
	public boolean hasReleaseTestCases(long releaseId) {
		return _testCaseLocalService.hasReleaseTestCases(releaseId);
	}

	/**
	* Adds the test case to the database. Also notifies the appropriate model listeners.
	*
	* @param testCase the test case
	* @return the test case that was added
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase addTestCase(
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		return _testCaseLocalService.addTestCase(testCase);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase addTestCase(
		java.lang.String testCaseName, java.lang.String environment,
		long beforeTestCaseId, long afterTestCaseId, boolean automatic,
		java.lang.String steps, long categroyId,
		java.lang.String expectedResults, java.lang.String developer,
		long developerId, java.lang.String comments,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testCaseLocalService.addTestCase(testCaseName, environment,
			beforeTestCaseId, afterTestCaseId, automatic, steps, categroyId,
			expectedResults, developer, developerId, comments, serviceContext);
	}

	/**
	* Creates a new test case with the primary key. Does not add the test case to the database.
	*
	* @param testCaseId the primary key for the new test case
	* @return the new test case
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase createTestCase(
		long testCaseId) {
		return _testCaseLocalService.createTestCase(testCaseId);
	}

	/**
	* Deletes the test case from the database. Also notifies the appropriate model listeners.
	*
	* @param testCase the test case
	* @return the test case that was removed
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase deleteTestCase(
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		return _testCaseLocalService.deleteTestCase(testCase);
	}

	/**
	* Deletes the test case with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testCaseId the primary key of the test case
	* @return the test case that was removed
	* @throws PortalException if a test case with the primary key could not be found
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase deleteTestCase(
		long testCaseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testCaseLocalService.deleteTestCase(testCaseId);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase fetchTestCase(
		long testCaseId) {
		return _testCaseLocalService.fetchTestCase(testCaseId);
	}

	/**
	* Returns the test case with the primary key.
	*
	* @param testCaseId the primary key of the test case
	* @return the test case
	* @throws PortalException if a test case with the primary key could not be found
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase getTestCase(
		long testCaseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testCaseLocalService.getTestCase(testCaseId);
	}

	/**
	* Updates the test case in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testCase the test case
	* @return the test case that was updated
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase updateTestCase(
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		return _testCaseLocalService.updateTestCase(testCase);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.TestCase updateTestCase(
		long testCaseId, java.lang.String testCaseName,
		java.lang.String environment, long beforeTestCaseId,
		long afterTestCaseId, boolean automatic, java.lang.String steps,
		long categroyId, java.lang.String expectedResults,
		java.lang.String developer, long developerId,
		java.lang.String comments,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testCaseLocalService.updateTestCase(testCaseId, testCaseName,
			environment, beforeTestCaseId, afterTestCaseId, automatic, steps,
			categroyId, expectedResults, developer, developerId, comments,
			serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _testCaseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testCaseLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _testCaseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testCaseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testCaseLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getReleaseTestCasesCount(long releaseId) {
		return _testCaseLocalService.getReleaseTestCasesCount(releaseId);
	}

	/**
	* Returns the number of test cases.
	*
	* @return the number of test cases
	*/
	@Override
	public int getTestCasesCount() {
		return _testCaseLocalService.getTestCasesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _testCaseLocalService.getOSGiServiceIdentifier();
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
		return _testCaseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.TestCaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testCaseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.TestCaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _testCaseLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> getReleaseTestCases(
		long releaseId) {
		return _testCaseLocalService.getReleaseTestCases(releaseId);
	}

	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> getReleaseTestCases(
		long releaseId, int start, int end) {
		return _testCaseLocalService.getReleaseTestCases(releaseId, start, end);
	}

	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> getReleaseTestCases(
		long releaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.ide.utils.quality.track.model.TestCase> orderByComparator) {
		return _testCaseLocalService.getReleaseTestCases(releaseId, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the test cases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.TestCaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of test cases
	* @param end the upper bound of the range of test cases (not inclusive)
	* @return the range of test cases
	*/
	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> getTestCases(
		int start, int end) {
		return _testCaseLocalService.getTestCases(start, end);
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
		return _testCaseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _testCaseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Returns the releaseIds of the releases associated with the test case.
	*
	* @param testCaseId the testCaseId of the test case
	* @return long[] the releaseIds of releases associated with the test case
	*/
	@Override
	public long[] getReleasePrimaryKeys(long testCaseId) {
		return _testCaseLocalService.getReleasePrimaryKeys(testCaseId);
	}

	@Override
	public void addReleaseTestCase(long releaseId,
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		_testCaseLocalService.addReleaseTestCase(releaseId, testCase);
	}

	@Override
	public void addReleaseTestCase(long releaseId, long testCaseId) {
		_testCaseLocalService.addReleaseTestCase(releaseId, testCaseId);
	}

	@Override
	public void addReleaseTestCases(long releaseId,
		java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> testCases) {
		_testCaseLocalService.addReleaseTestCases(releaseId, testCases);
	}

	@Override
	public void addReleaseTestCases(long releaseId, long[] testCaseIds) {
		_testCaseLocalService.addReleaseTestCases(releaseId, testCaseIds);
	}

	@Override
	public void clearReleaseTestCases(long releaseId) {
		_testCaseLocalService.clearReleaseTestCases(releaseId);
	}

	@Override
	public void deleteReleaseTestCase(long releaseId,
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		_testCaseLocalService.deleteReleaseTestCase(releaseId, testCase);
	}

	@Override
	public void deleteReleaseTestCase(long releaseId, long testCaseId) {
		_testCaseLocalService.deleteReleaseTestCase(releaseId, testCaseId);
	}

	@Override
	public void deleteReleaseTestCases(long releaseId,
		java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> testCases) {
		_testCaseLocalService.deleteReleaseTestCases(releaseId, testCases);
	}

	@Override
	public void deleteReleaseTestCases(long releaseId, long[] testCaseIds) {
		_testCaseLocalService.deleteReleaseTestCases(releaseId, testCaseIds);
	}

	@Override
	public void setReleaseTestCases(long releaseId, long[] testCaseIds) {
		_testCaseLocalService.setReleaseTestCases(releaseId, testCaseIds);
	}

	@Override
	public TestCaseLocalService getWrappedService() {
		return _testCaseLocalService;
	}

	@Override
	public void setWrappedService(TestCaseLocalService testCaseLocalService) {
		_testCaseLocalService = testCaseLocalService;
	}

	private TestCaseLocalService _testCaseLocalService;
}
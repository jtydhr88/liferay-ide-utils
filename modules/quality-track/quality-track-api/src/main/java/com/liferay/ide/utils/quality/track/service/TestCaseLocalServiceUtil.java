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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TestCase. This utility wraps
 * {@link com.liferay.ide.utils.quality.track.service.impl.TestCaseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Terry Jia
 * @see TestCaseLocalService
 * @see com.liferay.ide.utils.quality.track.service.base.TestCaseLocalServiceBaseImpl
 * @see com.liferay.ide.utils.quality.track.service.impl.TestCaseLocalServiceImpl
 * @generated
 */
@ProviderType
public class TestCaseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.ide.utils.quality.track.service.impl.TestCaseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean hasReleaseTestCase(long releaseId, long testCaseId) {
		return getService().hasReleaseTestCase(releaseId, testCaseId);
	}

	public static boolean hasReleaseTestCases(long releaseId) {
		return getService().hasReleaseTestCases(releaseId);
	}

	/**
	* Adds the test case to the database. Also notifies the appropriate model listeners.
	*
	* @param testCase the test case
	* @return the test case that was added
	*/
	public static com.liferay.ide.utils.quality.track.model.TestCase addTestCase(
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		return getService().addTestCase(testCase);
	}

	public static com.liferay.ide.utils.quality.track.model.TestCase addTestCase(
		java.lang.String testCaseName, java.lang.String environment,
		long beforeTestCaseId, long afterTestCaseId, boolean automatic,
		java.lang.String steps, long categroyId,
		java.lang.String expectedResults, java.lang.String developer,
		long developerId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTestCase(testCaseName, environment, beforeTestCaseId,
			afterTestCaseId, automatic, steps, categroyId, expectedResults,
			developer, developerId, serviceContext);
	}

	/**
	* Creates a new test case with the primary key. Does not add the test case to the database.
	*
	* @param testCaseId the primary key for the new test case
	* @return the new test case
	*/
	public static com.liferay.ide.utils.quality.track.model.TestCase createTestCase(
		long testCaseId) {
		return getService().createTestCase(testCaseId);
	}

	/**
	* Deletes the test case from the database. Also notifies the appropriate model listeners.
	*
	* @param testCase the test case
	* @return the test case that was removed
	*/
	public static com.liferay.ide.utils.quality.track.model.TestCase deleteTestCase(
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		return getService().deleteTestCase(testCase);
	}

	/**
	* Deletes the test case with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testCaseId the primary key of the test case
	* @return the test case that was removed
	* @throws PortalException if a test case with the primary key could not be found
	*/
	public static com.liferay.ide.utils.quality.track.model.TestCase deleteTestCase(
		long testCaseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTestCase(testCaseId);
	}

	public static com.liferay.ide.utils.quality.track.model.TestCase fetchTestCase(
		long testCaseId) {
		return getService().fetchTestCase(testCaseId);
	}

	/**
	* Returns the test case with the primary key.
	*
	* @param testCaseId the primary key of the test case
	* @return the test case
	* @throws PortalException if a test case with the primary key could not be found
	*/
	public static com.liferay.ide.utils.quality.track.model.TestCase getTestCase(
		long testCaseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTestCase(testCaseId);
	}

	/**
	* Updates the test case in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testCase the test case
	* @return the test case that was updated
	*/
	public static com.liferay.ide.utils.quality.track.model.TestCase updateTestCase(
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		return getService().updateTestCase(testCase);
	}

	public static com.liferay.ide.utils.quality.track.model.TestCase updateTestCase(
		long testCaseId, java.lang.String testCaseName,
		java.lang.String environment, long beforeTestCaseId,
		long afterTestCaseId, boolean automatic, java.lang.String steps,
		long categroyId, java.lang.String expectedResults,
		java.lang.String developer, long developerId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateTestCase(testCaseId, testCaseName, environment,
			beforeTestCaseId, afterTestCaseId, automatic, steps, categroyId,
			expectedResults, developer, developerId, serviceContext);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int getReleaseTestCasesCount(long releaseId) {
		return getService().getReleaseTestCasesCount(releaseId);
	}

	/**
	* Returns the number of test cases.
	*
	* @return the number of test cases
	*/
	public static int getTestCasesCount() {
		return getService().getTestCasesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> getReleaseTestCases(
		long releaseId) {
		return getService().getReleaseTestCases(releaseId);
	}

	public static java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> getReleaseTestCases(
		long releaseId, int start, int end) {
		return getService().getReleaseTestCases(releaseId, start, end);
	}

	public static java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> getReleaseTestCases(
		long releaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.ide.utils.quality.track.model.TestCase> orderByComparator) {
		return getService()
				   .getReleaseTestCases(releaseId, start, end, orderByComparator);
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
	public static java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> getTestCases(
		int start, int end) {
		return getService().getTestCases(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Returns the releaseIds of the releases associated with the test case.
	*
	* @param testCaseId the testCaseId of the test case
	* @return long[] the releaseIds of releases associated with the test case
	*/
	public static long[] getReleasePrimaryKeys(long testCaseId) {
		return getService().getReleasePrimaryKeys(testCaseId);
	}

	public static void addReleaseTestCase(long releaseId,
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		getService().addReleaseTestCase(releaseId, testCase);
	}

	public static void addReleaseTestCase(long releaseId, long testCaseId) {
		getService().addReleaseTestCase(releaseId, testCaseId);
	}

	public static void addReleaseTestCases(long releaseId,
		java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> testCases) {
		getService().addReleaseTestCases(releaseId, testCases);
	}

	public static void addReleaseTestCases(long releaseId, long[] testCaseIds) {
		getService().addReleaseTestCases(releaseId, testCaseIds);
	}

	public static void clearReleaseTestCases(long releaseId) {
		getService().clearReleaseTestCases(releaseId);
	}

	public static void deleteReleaseTestCase(long releaseId,
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		getService().deleteReleaseTestCase(releaseId, testCase);
	}

	public static void deleteReleaseTestCase(long releaseId, long testCaseId) {
		getService().deleteReleaseTestCase(releaseId, testCaseId);
	}

	public static void deleteReleaseTestCases(long releaseId,
		java.util.List<com.liferay.ide.utils.quality.track.model.TestCase> testCases) {
		getService().deleteReleaseTestCases(releaseId, testCases);
	}

	public static void deleteReleaseTestCases(long releaseId, long[] testCaseIds) {
		getService().deleteReleaseTestCases(releaseId, testCaseIds);
	}

	public static void setReleaseTestCases(long releaseId, long[] testCaseIds) {
		getService().setReleaseTestCases(releaseId, testCaseIds);
	}

	public static TestCaseLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TestCaseLocalService, TestCaseLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TestCaseLocalService.class);
}
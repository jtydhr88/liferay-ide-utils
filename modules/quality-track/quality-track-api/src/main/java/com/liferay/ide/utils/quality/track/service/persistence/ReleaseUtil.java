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

package com.liferay.ide.utils.quality.track.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.ide.utils.quality.track.model.Release;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the release service. This utility wraps {@link com.liferay.ide.utils.quality.track.service.persistence.impl.ReleasePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Terry Jia
 * @see ReleasePersistence
 * @see com.liferay.ide.utils.quality.track.service.persistence.impl.ReleasePersistenceImpl
 * @generated
 */
@ProviderType
public class ReleaseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Release release) {
		getPersistence().clearCache(release);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Release> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Release> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Release> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Release> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Release update(Release release) {
		return getPersistence().update(release);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Release update(Release release, ServiceContext serviceContext) {
		return getPersistence().update(release, serviceContext);
	}

	/**
	* Caches the release in the entity cache if it is enabled.
	*
	* @param release the release
	*/
	public static void cacheResult(Release release) {
		getPersistence().cacheResult(release);
	}

	/**
	* Caches the releases in the entity cache if it is enabled.
	*
	* @param releases the releases
	*/
	public static void cacheResult(List<Release> releases) {
		getPersistence().cacheResult(releases);
	}

	/**
	* Creates a new release with the primary key. Does not add the release to the database.
	*
	* @param releaseId the primary key for the new release
	* @return the new release
	*/
	public static Release create(long releaseId) {
		return getPersistence().create(releaseId);
	}

	/**
	* Removes the release with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param releaseId the primary key of the release
	* @return the release that was removed
	* @throws NoSuchReleaseException if a release with the primary key could not be found
	*/
	public static Release remove(long releaseId)
		throws com.liferay.ide.utils.quality.track.exception.NoSuchReleaseException {
		return getPersistence().remove(releaseId);
	}

	public static Release updateImpl(Release release) {
		return getPersistence().updateImpl(release);
	}

	/**
	* Returns the release with the primary key or throws a {@link NoSuchReleaseException} if it could not be found.
	*
	* @param releaseId the primary key of the release
	* @return the release
	* @throws NoSuchReleaseException if a release with the primary key could not be found
	*/
	public static Release findByPrimaryKey(long releaseId)
		throws com.liferay.ide.utils.quality.track.exception.NoSuchReleaseException {
		return getPersistence().findByPrimaryKey(releaseId);
	}

	/**
	* Returns the release with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param releaseId the primary key of the release
	* @return the release, or <code>null</code> if a release with the primary key could not be found
	*/
	public static Release fetchByPrimaryKey(long releaseId) {
		return getPersistence().fetchByPrimaryKey(releaseId);
	}

	public static java.util.Map<java.io.Serializable, Release> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the releases.
	*
	* @return the releases
	*/
	public static List<Release> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the releases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReleaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of releases
	* @param end the upper bound of the range of releases (not inclusive)
	* @return the range of releases
	*/
	public static List<Release> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the releases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReleaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of releases
	* @param end the upper bound of the range of releases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of releases
	*/
	public static List<Release> findAll(int start, int end,
		OrderByComparator<Release> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the releases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReleaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of releases
	* @param end the upper bound of the range of releases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of releases
	*/
	public static List<Release> findAll(int start, int end,
		OrderByComparator<Release> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the releases from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of releases.
	*
	* @return the number of releases
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of test cases associated with the release.
	*
	* @param pk the primary key of the release
	* @return long[] of the primaryKeys of test cases associated with the release
	*/
	public static long[] getTestCasePrimaryKeys(long pk) {
		return getPersistence().getTestCasePrimaryKeys(pk);
	}

	/**
	* Returns all the test cases associated with the release.
	*
	* @param pk the primary key of the release
	* @return the test cases associated with the release
	*/
	public static List<com.liferay.ide.utils.quality.track.model.TestCase> getTestCases(
		long pk) {
		return getPersistence().getTestCases(pk);
	}

	/**
	* Returns a range of all the test cases associated with the release.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReleaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the release
	* @param start the lower bound of the range of releases
	* @param end the upper bound of the range of releases (not inclusive)
	* @return the range of test cases associated with the release
	*/
	public static List<com.liferay.ide.utils.quality.track.model.TestCase> getTestCases(
		long pk, int start, int end) {
		return getPersistence().getTestCases(pk, start, end);
	}

	/**
	* Returns an ordered range of all the test cases associated with the release.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReleaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the release
	* @param start the lower bound of the range of releases
	* @param end the upper bound of the range of releases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of test cases associated with the release
	*/
	public static List<com.liferay.ide.utils.quality.track.model.TestCase> getTestCases(
		long pk, int start, int end,
		OrderByComparator<com.liferay.ide.utils.quality.track.model.TestCase> orderByComparator) {
		return getPersistence().getTestCases(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of test cases associated with the release.
	*
	* @param pk the primary key of the release
	* @return the number of test cases associated with the release
	*/
	public static int getTestCasesSize(long pk) {
		return getPersistence().getTestCasesSize(pk);
	}

	/**
	* Returns <code>true</code> if the test case is associated with the release.
	*
	* @param pk the primary key of the release
	* @param testCasePK the primary key of the test case
	* @return <code>true</code> if the test case is associated with the release; <code>false</code> otherwise
	*/
	public static boolean containsTestCase(long pk, long testCasePK) {
		return getPersistence().containsTestCase(pk, testCasePK);
	}

	/**
	* Returns <code>true</code> if the release has any test cases associated with it.
	*
	* @param pk the primary key of the release to check for associations with test cases
	* @return <code>true</code> if the release has any test cases associated with it; <code>false</code> otherwise
	*/
	public static boolean containsTestCases(long pk) {
		return getPersistence().containsTestCases(pk);
	}

	/**
	* Adds an association between the release and the test case. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCasePK the primary key of the test case
	*/
	public static void addTestCase(long pk, long testCasePK) {
		getPersistence().addTestCase(pk, testCasePK);
	}

	/**
	* Adds an association between the release and the test case. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCase the test case
	*/
	public static void addTestCase(long pk,
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		getPersistence().addTestCase(pk, testCase);
	}

	/**
	* Adds an association between the release and the test cases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCasePKs the primary keys of the test cases
	*/
	public static void addTestCases(long pk, long[] testCasePKs) {
		getPersistence().addTestCases(pk, testCasePKs);
	}

	/**
	* Adds an association between the release and the test cases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCases the test cases
	*/
	public static void addTestCases(long pk,
		List<com.liferay.ide.utils.quality.track.model.TestCase> testCases) {
		getPersistence().addTestCases(pk, testCases);
	}

	/**
	* Clears all associations between the release and its test cases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release to clear the associated test cases from
	*/
	public static void clearTestCases(long pk) {
		getPersistence().clearTestCases(pk);
	}

	/**
	* Removes the association between the release and the test case. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCasePK the primary key of the test case
	*/
	public static void removeTestCase(long pk, long testCasePK) {
		getPersistence().removeTestCase(pk, testCasePK);
	}

	/**
	* Removes the association between the release and the test case. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCase the test case
	*/
	public static void removeTestCase(long pk,
		com.liferay.ide.utils.quality.track.model.TestCase testCase) {
		getPersistence().removeTestCase(pk, testCase);
	}

	/**
	* Removes the association between the release and the test cases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCasePKs the primary keys of the test cases
	*/
	public static void removeTestCases(long pk, long[] testCasePKs) {
		getPersistence().removeTestCases(pk, testCasePKs);
	}

	/**
	* Removes the association between the release and the test cases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCases the test cases
	*/
	public static void removeTestCases(long pk,
		List<com.liferay.ide.utils.quality.track.model.TestCase> testCases) {
		getPersistence().removeTestCases(pk, testCases);
	}

	/**
	* Sets the test cases associated with the release, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCasePKs the primary keys of the test cases to be associated with the release
	*/
	public static void setTestCases(long pk, long[] testCasePKs) {
		getPersistence().setTestCases(pk, testCasePKs);
	}

	/**
	* Sets the test cases associated with the release, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the release
	* @param testCases the test cases to be associated with the release
	*/
	public static void setTestCases(long pk,
		List<com.liferay.ide.utils.quality.track.model.TestCase> testCases) {
		getPersistence().setTestCases(pk, testCases);
	}

	public static ReleasePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReleasePersistence, ReleasePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ReleasePersistence.class);
}
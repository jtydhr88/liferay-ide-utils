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

import com.liferay.ide.utils.quality.track.exception.NoSuchTestCaseException;
import com.liferay.ide.utils.quality.track.model.TestCase;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the test case service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Terry Jia
 * @see com.liferay.ide.utils.quality.track.service.persistence.impl.TestCasePersistenceImpl
 * @see TestCaseUtil
 * @generated
 */
@ProviderType
public interface TestCasePersistence extends BasePersistence<TestCase> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TestCaseUtil} to access the test case persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the test case in the entity cache if it is enabled.
	*
	* @param testCase the test case
	*/
	public void cacheResult(TestCase testCase);

	/**
	* Caches the test cases in the entity cache if it is enabled.
	*
	* @param testCases the test cases
	*/
	public void cacheResult(java.util.List<TestCase> testCases);

	/**
	* Creates a new test case with the primary key. Does not add the test case to the database.
	*
	* @param testCaseId the primary key for the new test case
	* @return the new test case
	*/
	public TestCase create(long testCaseId);

	/**
	* Removes the test case with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testCaseId the primary key of the test case
	* @return the test case that was removed
	* @throws NoSuchTestCaseException if a test case with the primary key could not be found
	*/
	public TestCase remove(long testCaseId) throws NoSuchTestCaseException;

	public TestCase updateImpl(TestCase testCase);

	/**
	* Returns the test case with the primary key or throws a {@link NoSuchTestCaseException} if it could not be found.
	*
	* @param testCaseId the primary key of the test case
	* @return the test case
	* @throws NoSuchTestCaseException if a test case with the primary key could not be found
	*/
	public TestCase findByPrimaryKey(long testCaseId)
		throws NoSuchTestCaseException;

	/**
	* Returns the test case with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param testCaseId the primary key of the test case
	* @return the test case, or <code>null</code> if a test case with the primary key could not be found
	*/
	public TestCase fetchByPrimaryKey(long testCaseId);

	@Override
	public java.util.Map<java.io.Serializable, TestCase> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the test cases.
	*
	* @return the test cases
	*/
	public java.util.List<TestCase> findAll();

	/**
	* Returns a range of all the test cases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestCaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of test cases
	* @param end the upper bound of the range of test cases (not inclusive)
	* @return the range of test cases
	*/
	public java.util.List<TestCase> findAll(int start, int end);

	/**
	* Returns an ordered range of all the test cases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestCaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of test cases
	* @param end the upper bound of the range of test cases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of test cases
	*/
	public java.util.List<TestCase> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TestCase> orderByComparator);

	/**
	* Returns an ordered range of all the test cases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestCaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of test cases
	* @param end the upper bound of the range of test cases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of test cases
	*/
	public java.util.List<TestCase> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TestCase> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the test cases from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of test cases.
	*
	* @return the number of test cases
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of releases associated with the test case.
	*
	* @param pk the primary key of the test case
	* @return long[] of the primaryKeys of releases associated with the test case
	*/
	public long[] getReleasePrimaryKeys(long pk);

	/**
	* Returns all the releases associated with the test case.
	*
	* @param pk the primary key of the test case
	* @return the releases associated with the test case
	*/
	public java.util.List<com.liferay.ide.utils.quality.track.model.Release> getReleases(
		long pk);

	/**
	* Returns a range of all the releases associated with the test case.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestCaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the test case
	* @param start the lower bound of the range of test cases
	* @param end the upper bound of the range of test cases (not inclusive)
	* @return the range of releases associated with the test case
	*/
	public java.util.List<com.liferay.ide.utils.quality.track.model.Release> getReleases(
		long pk, int start, int end);

	/**
	* Returns an ordered range of all the releases associated with the test case.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestCaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the test case
	* @param start the lower bound of the range of test cases
	* @param end the upper bound of the range of test cases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of releases associated with the test case
	*/
	public java.util.List<com.liferay.ide.utils.quality.track.model.Release> getReleases(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.ide.utils.quality.track.model.Release> orderByComparator);

	/**
	* Returns the number of releases associated with the test case.
	*
	* @param pk the primary key of the test case
	* @return the number of releases associated with the test case
	*/
	public int getReleasesSize(long pk);

	/**
	* Returns <code>true</code> if the release is associated with the test case.
	*
	* @param pk the primary key of the test case
	* @param releasePK the primary key of the release
	* @return <code>true</code> if the release is associated with the test case; <code>false</code> otherwise
	*/
	public boolean containsRelease(long pk, long releasePK);

	/**
	* Returns <code>true</code> if the test case has any releases associated with it.
	*
	* @param pk the primary key of the test case to check for associations with releases
	* @return <code>true</code> if the test case has any releases associated with it; <code>false</code> otherwise
	*/
	public boolean containsReleases(long pk);

	/**
	* Adds an association between the test case and the release. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param releasePK the primary key of the release
	*/
	public void addRelease(long pk, long releasePK);

	/**
	* Adds an association between the test case and the release. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param release the release
	*/
	public void addRelease(long pk,
		com.liferay.ide.utils.quality.track.model.Release release);

	/**
	* Adds an association between the test case and the releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param releasePKs the primary keys of the releases
	*/
	public void addReleases(long pk, long[] releasePKs);

	/**
	* Adds an association between the test case and the releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param releases the releases
	*/
	public void addReleases(long pk,
		java.util.List<com.liferay.ide.utils.quality.track.model.Release> releases);

	/**
	* Clears all associations between the test case and its releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case to clear the associated releases from
	*/
	public void clearReleases(long pk);

	/**
	* Removes the association between the test case and the release. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param releasePK the primary key of the release
	*/
	public void removeRelease(long pk, long releasePK);

	/**
	* Removes the association between the test case and the release. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param release the release
	*/
	public void removeRelease(long pk,
		com.liferay.ide.utils.quality.track.model.Release release);

	/**
	* Removes the association between the test case and the releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param releasePKs the primary keys of the releases
	*/
	public void removeReleases(long pk, long[] releasePKs);

	/**
	* Removes the association between the test case and the releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param releases the releases
	*/
	public void removeReleases(long pk,
		java.util.List<com.liferay.ide.utils.quality.track.model.Release> releases);

	/**
	* Sets the releases associated with the test case, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param releasePKs the primary keys of the releases to be associated with the test case
	*/
	public void setReleases(long pk, long[] releasePKs);

	/**
	* Sets the releases associated with the test case, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the test case
	* @param releases the releases to be associated with the test case
	*/
	public void setReleases(long pk,
		java.util.List<com.liferay.ide.utils.quality.track.model.Release> releases);
}
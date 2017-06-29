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

import com.liferay.ide.utils.quality.track.exception.NoSuchTestException;
import com.liferay.ide.utils.quality.track.model.Test;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the test service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Terry Jia
 * @see com.liferay.ide.utils.quality.track.service.persistence.impl.TestPersistenceImpl
 * @see TestUtil
 * @generated
 */
@ProviderType
public interface TestPersistence extends BasePersistence<Test> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TestUtil} to access the test persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the test in the entity cache if it is enabled.
	*
	* @param test the test
	*/
	public void cacheResult(Test test);

	/**
	* Caches the tests in the entity cache if it is enabled.
	*
	* @param tests the tests
	*/
	public void cacheResult(java.util.List<Test> tests);

	/**
	* Creates a new test with the primary key. Does not add the test to the database.
	*
	* @param testId the primary key for the new test
	* @return the new test
	*/
	public Test create(long testId);

	/**
	* Removes the test with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param testId the primary key of the test
	* @return the test that was removed
	* @throws NoSuchTestException if a test with the primary key could not be found
	*/
	public Test remove(long testId) throws NoSuchTestException;

	public Test updateImpl(Test test);

	/**
	* Returns the test with the primary key or throws a {@link NoSuchTestException} if it could not be found.
	*
	* @param testId the primary key of the test
	* @return the test
	* @throws NoSuchTestException if a test with the primary key could not be found
	*/
	public Test findByPrimaryKey(long testId) throws NoSuchTestException;

	/**
	* Returns the test with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param testId the primary key of the test
	* @return the test, or <code>null</code> if a test with the primary key could not be found
	*/
	public Test fetchByPrimaryKey(long testId);

	@Override
	public java.util.Map<java.io.Serializable, Test> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tests.
	*
	* @return the tests
	*/
	public java.util.List<Test> findAll();

	/**
	* Returns a range of all the tests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tests
	* @param end the upper bound of the range of tests (not inclusive)
	* @return the range of tests
	*/
	public java.util.List<Test> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tests
	* @param end the upper bound of the range of tests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tests
	*/
	public java.util.List<Test> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Test> orderByComparator);

	/**
	* Returns an ordered range of all the tests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tests
	* @param end the upper bound of the range of tests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tests
	*/
	public java.util.List<Test> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Test> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tests from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tests.
	*
	* @return the number of tests
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}
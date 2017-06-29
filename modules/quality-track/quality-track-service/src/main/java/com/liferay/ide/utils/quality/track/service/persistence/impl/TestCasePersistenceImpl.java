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

package com.liferay.ide.utils.quality.track.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.ide.utils.quality.track.exception.NoSuchTestCaseException;
import com.liferay.ide.utils.quality.track.model.TestCase;
import com.liferay.ide.utils.quality.track.model.impl.TestCaseImpl;
import com.liferay.ide.utils.quality.track.model.impl.TestCaseModelImpl;
import com.liferay.ide.utils.quality.track.service.persistence.ReleasePersistence;
import com.liferay.ide.utils.quality.track.service.persistence.TestCasePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the test case service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Terry Jia
 * @see TestCasePersistence
 * @see com.liferay.ide.utils.quality.track.service.persistence.TestCaseUtil
 * @generated
 */
@ProviderType
public class TestCasePersistenceImpl extends BasePersistenceImpl<TestCase>
	implements TestCasePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TestCaseUtil} to access the test case persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TestCaseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
			TestCaseModelImpl.FINDER_CACHE_ENABLED, TestCaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
			TestCaseModelImpl.FINDER_CACHE_ENABLED, TestCaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
			TestCaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TestCasePersistenceImpl() {
		setModelClass(TestCase.class);
	}

	/**
	 * Caches the test case in the entity cache if it is enabled.
	 *
	 * @param testCase the test case
	 */
	@Override
	public void cacheResult(TestCase testCase) {
		entityCache.putResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
			TestCaseImpl.class, testCase.getPrimaryKey(), testCase);

		testCase.resetOriginalValues();
	}

	/**
	 * Caches the test cases in the entity cache if it is enabled.
	 *
	 * @param testCases the test cases
	 */
	@Override
	public void cacheResult(List<TestCase> testCases) {
		for (TestCase testCase : testCases) {
			if (entityCache.getResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
						TestCaseImpl.class, testCase.getPrimaryKey()) == null) {
				cacheResult(testCase);
			}
			else {
				testCase.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all test cases.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TestCaseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the test case.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TestCase testCase) {
		entityCache.removeResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
			TestCaseImpl.class, testCase.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TestCase> testCases) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TestCase testCase : testCases) {
			entityCache.removeResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
				TestCaseImpl.class, testCase.getPrimaryKey());
		}
	}

	/**
	 * Creates a new test case with the primary key. Does not add the test case to the database.
	 *
	 * @param testCaseId the primary key for the new test case
	 * @return the new test case
	 */
	@Override
	public TestCase create(long testCaseId) {
		TestCase testCase = new TestCaseImpl();

		testCase.setNew(true);
		testCase.setPrimaryKey(testCaseId);

		testCase.setCompanyId(companyProvider.getCompanyId());

		return testCase;
	}

	/**
	 * Removes the test case with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param testCaseId the primary key of the test case
	 * @return the test case that was removed
	 * @throws NoSuchTestCaseException if a test case with the primary key could not be found
	 */
	@Override
	public TestCase remove(long testCaseId) throws NoSuchTestCaseException {
		return remove((Serializable)testCaseId);
	}

	/**
	 * Removes the test case with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the test case
	 * @return the test case that was removed
	 * @throws NoSuchTestCaseException if a test case with the primary key could not be found
	 */
	@Override
	public TestCase remove(Serializable primaryKey)
		throws NoSuchTestCaseException {
		Session session = null;

		try {
			session = openSession();

			TestCase testCase = (TestCase)session.get(TestCaseImpl.class,
					primaryKey);

			if (testCase == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTestCaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(testCase);
		}
		catch (NoSuchTestCaseException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TestCase removeImpl(TestCase testCase) {
		testCase = toUnwrappedModel(testCase);

		testCaseToReleaseTableMapper.deleteLeftPrimaryKeyTableMappings(testCase.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(testCase)) {
				testCase = (TestCase)session.get(TestCaseImpl.class,
						testCase.getPrimaryKeyObj());
			}

			if (testCase != null) {
				session.delete(testCase);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (testCase != null) {
			clearCache(testCase);
		}

		return testCase;
	}

	@Override
	public TestCase updateImpl(TestCase testCase) {
		testCase = toUnwrappedModel(testCase);

		boolean isNew = testCase.isNew();

		TestCaseModelImpl testCaseModelImpl = (TestCaseModelImpl)testCase;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (testCase.getCreateDate() == null)) {
			if (serviceContext == null) {
				testCase.setCreateDate(now);
			}
			else {
				testCase.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!testCaseModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				testCase.setModifiedDate(now);
			}
			else {
				testCase.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (testCase.isNew()) {
				session.save(testCase);

				testCase.setNew(false);
			}
			else {
				testCase = (TestCase)session.merge(testCase);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
			TestCaseImpl.class, testCase.getPrimaryKey(), testCase, false);

		testCase.resetOriginalValues();

		return testCase;
	}

	protected TestCase toUnwrappedModel(TestCase testCase) {
		if (testCase instanceof TestCaseImpl) {
			return testCase;
		}

		TestCaseImpl testCaseImpl = new TestCaseImpl();

		testCaseImpl.setNew(testCase.isNew());
		testCaseImpl.setPrimaryKey(testCase.getPrimaryKey());

		testCaseImpl.setTestCaseId(testCase.getTestCaseId());
		testCaseImpl.setGroupId(testCase.getGroupId());
		testCaseImpl.setCompanyId(testCase.getCompanyId());
		testCaseImpl.setUserId(testCase.getUserId());
		testCaseImpl.setUserName(testCase.getUserName());
		testCaseImpl.setCreateDate(testCase.getCreateDate());
		testCaseImpl.setModifiedDate(testCase.getModifiedDate());
		testCaseImpl.setEnvironment(testCase.getEnvironment());
		testCaseImpl.setTestCaseName(testCase.getTestCaseName());
		testCaseImpl.setBeforeTestCaseId(testCase.getBeforeTestCaseId());
		testCaseImpl.setAutomatic(testCase.isAutomatic());
		testCaseImpl.setAfterTestCaseId(testCase.getAfterTestCaseId());
		testCaseImpl.setSteps(testCase.getSteps());
		testCaseImpl.setCategroyId(testCase.getCategroyId());
		testCaseImpl.setExpectedResults(testCase.getExpectedResults());
		testCaseImpl.setDeveloper(testCase.getDeveloper());
		testCaseImpl.setDeveloperId(testCase.getDeveloperId());

		return testCaseImpl;
	}

	/**
	 * Returns the test case with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the test case
	 * @return the test case
	 * @throws NoSuchTestCaseException if a test case with the primary key could not be found
	 */
	@Override
	public TestCase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTestCaseException {
		TestCase testCase = fetchByPrimaryKey(primaryKey);

		if (testCase == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTestCaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return testCase;
	}

	/**
	 * Returns the test case with the primary key or throws a {@link NoSuchTestCaseException} if it could not be found.
	 *
	 * @param testCaseId the primary key of the test case
	 * @return the test case
	 * @throws NoSuchTestCaseException if a test case with the primary key could not be found
	 */
	@Override
	public TestCase findByPrimaryKey(long testCaseId)
		throws NoSuchTestCaseException {
		return findByPrimaryKey((Serializable)testCaseId);
	}

	/**
	 * Returns the test case with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the test case
	 * @return the test case, or <code>null</code> if a test case with the primary key could not be found
	 */
	@Override
	public TestCase fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
				TestCaseImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TestCase testCase = (TestCase)serializable;

		if (testCase == null) {
			Session session = null;

			try {
				session = openSession();

				testCase = (TestCase)session.get(TestCaseImpl.class, primaryKey);

				if (testCase != null) {
					cacheResult(testCase);
				}
				else {
					entityCache.putResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
						TestCaseImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
					TestCaseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return testCase;
	}

	/**
	 * Returns the test case with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param testCaseId the primary key of the test case
	 * @return the test case, or <code>null</code> if a test case with the primary key could not be found
	 */
	@Override
	public TestCase fetchByPrimaryKey(long testCaseId) {
		return fetchByPrimaryKey((Serializable)testCaseId);
	}

	@Override
	public Map<Serializable, TestCase> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TestCase> map = new HashMap<Serializable, TestCase>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TestCase testCase = fetchByPrimaryKey(primaryKey);

			if (testCase != null) {
				map.put(primaryKey, testCase);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
					TestCaseImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TestCase)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TESTCASE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TestCase testCase : (List<TestCase>)q.list()) {
				map.put(testCase.getPrimaryKeyObj(), testCase);

				cacheResult(testCase);

				uncachedPrimaryKeys.remove(testCase.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TestCaseModelImpl.ENTITY_CACHE_ENABLED,
					TestCaseImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the test cases.
	 *
	 * @return the test cases
	 */
	@Override
	public List<TestCase> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TestCase> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<TestCase> findAll(int start, int end,
		OrderByComparator<TestCase> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<TestCase> findAll(int start, int end,
		OrderByComparator<TestCase> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TestCase> list = null;

		if (retrieveFromCache) {
			list = (List<TestCase>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TESTCASE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTCASE;

				if (pagination) {
					sql = sql.concat(TestCaseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TestCase>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TestCase>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the test cases from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TestCase testCase : findAll()) {
			remove(testCase);
		}
	}

	/**
	 * Returns the number of test cases.
	 *
	 * @return the number of test cases
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TESTCASE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of releases associated with the test case.
	 *
	 * @param pk the primary key of the test case
	 * @return long[] of the primaryKeys of releases associated with the test case
	 */
	@Override
	public long[] getReleasePrimaryKeys(long pk) {
		long[] pks = testCaseToReleaseTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the releases associated with the test case.
	 *
	 * @param pk the primary key of the test case
	 * @return the releases associated with the test case
	 */
	@Override
	public List<com.liferay.ide.utils.quality.track.model.Release> getReleases(
		long pk) {
		return getReleases(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<com.liferay.ide.utils.quality.track.model.Release> getReleases(
		long pk, int start, int end) {
		return getReleases(pk, start, end, null);
	}

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
	@Override
	public List<com.liferay.ide.utils.quality.track.model.Release> getReleases(
		long pk, int start, int end,
		OrderByComparator<com.liferay.ide.utils.quality.track.model.Release> orderByComparator) {
		return testCaseToReleaseTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of releases associated with the test case.
	 *
	 * @param pk the primary key of the test case
	 * @return the number of releases associated with the test case
	 */
	@Override
	public int getReleasesSize(long pk) {
		long[] pks = testCaseToReleaseTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the release is associated with the test case.
	 *
	 * @param pk the primary key of the test case
	 * @param releasePK the primary key of the release
	 * @return <code>true</code> if the release is associated with the test case; <code>false</code> otherwise
	 */
	@Override
	public boolean containsRelease(long pk, long releasePK) {
		return testCaseToReleaseTableMapper.containsTableMapping(pk, releasePK);
	}

	/**
	 * Returns <code>true</code> if the test case has any releases associated with it.
	 *
	 * @param pk the primary key of the test case to check for associations with releases
	 * @return <code>true</code> if the test case has any releases associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsReleases(long pk) {
		if (getReleasesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the test case and the release. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param releasePK the primary key of the release
	 */
	@Override
	public void addRelease(long pk, long releasePK) {
		TestCase testCase = fetchByPrimaryKey(pk);

		if (testCase == null) {
			testCaseToReleaseTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, releasePK);
		}
		else {
			testCaseToReleaseTableMapper.addTableMapping(testCase.getCompanyId(),
				pk, releasePK);
		}
	}

	/**
	 * Adds an association between the test case and the release. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param release the release
	 */
	@Override
	public void addRelease(long pk,
		com.liferay.ide.utils.quality.track.model.Release release) {
		TestCase testCase = fetchByPrimaryKey(pk);

		if (testCase == null) {
			testCaseToReleaseTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, release.getPrimaryKey());
		}
		else {
			testCaseToReleaseTableMapper.addTableMapping(testCase.getCompanyId(),
				pk, release.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the test case and the releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param releasePKs the primary keys of the releases
	 */
	@Override
	public void addReleases(long pk, long[] releasePKs) {
		long companyId = 0;

		TestCase testCase = fetchByPrimaryKey(pk);

		if (testCase == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = testCase.getCompanyId();
		}

		testCaseToReleaseTableMapper.addTableMappings(companyId, pk, releasePKs);
	}

	/**
	 * Adds an association between the test case and the releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param releases the releases
	 */
	@Override
	public void addReleases(long pk,
		List<com.liferay.ide.utils.quality.track.model.Release> releases) {
		addReleases(pk,
			ListUtil.toLongArray(releases,
				com.liferay.ide.utils.quality.track.model.Release.RELEASE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the test case and its releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case to clear the associated releases from
	 */
	@Override
	public void clearReleases(long pk) {
		testCaseToReleaseTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the test case and the release. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param releasePK the primary key of the release
	 */
	@Override
	public void removeRelease(long pk, long releasePK) {
		testCaseToReleaseTableMapper.deleteTableMapping(pk, releasePK);
	}

	/**
	 * Removes the association between the test case and the release. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param release the release
	 */
	@Override
	public void removeRelease(long pk,
		com.liferay.ide.utils.quality.track.model.Release release) {
		testCaseToReleaseTableMapper.deleteTableMapping(pk,
			release.getPrimaryKey());
	}

	/**
	 * Removes the association between the test case and the releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param releasePKs the primary keys of the releases
	 */
	@Override
	public void removeReleases(long pk, long[] releasePKs) {
		testCaseToReleaseTableMapper.deleteTableMappings(pk, releasePKs);
	}

	/**
	 * Removes the association between the test case and the releases. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param releases the releases
	 */
	@Override
	public void removeReleases(long pk,
		List<com.liferay.ide.utils.quality.track.model.Release> releases) {
		removeReleases(pk,
			ListUtil.toLongArray(releases,
				com.liferay.ide.utils.quality.track.model.Release.RELEASE_ID_ACCESSOR));
	}

	/**
	 * Sets the releases associated with the test case, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param releasePKs the primary keys of the releases to be associated with the test case
	 */
	@Override
	public void setReleases(long pk, long[] releasePKs) {
		Set<Long> newReleasePKsSet = SetUtil.fromArray(releasePKs);
		Set<Long> oldReleasePKsSet = SetUtil.fromArray(testCaseToReleaseTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeReleasePKsSet = new HashSet<Long>(oldReleasePKsSet);

		removeReleasePKsSet.removeAll(newReleasePKsSet);

		testCaseToReleaseTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeReleasePKsSet));

		newReleasePKsSet.removeAll(oldReleasePKsSet);

		long companyId = 0;

		TestCase testCase = fetchByPrimaryKey(pk);

		if (testCase == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = testCase.getCompanyId();
		}

		testCaseToReleaseTableMapper.addTableMappings(companyId, pk,
			ArrayUtil.toLongArray(newReleasePKsSet));
	}

	/**
	 * Sets the releases associated with the test case, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the test case
	 * @param releases the releases to be associated with the test case
	 */
	@Override
	public void setReleases(long pk,
		List<com.liferay.ide.utils.quality.track.model.Release> releases) {
		try {
			long[] releasePKs = new long[releases.size()];

			for (int i = 0; i < releases.size(); i++) {
				com.liferay.ide.utils.quality.track.model.Release release = releases.get(i);

				releasePKs[i] = release.getPrimaryKey();
			}

			setReleases(pk, releasePKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TestCaseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the test case persistence.
	 */
	public void afterPropertiesSet() {
		testCaseToReleaseTableMapper = TableMapperFactory.getTableMapper("qualitytrack_TestCases_Releases",
				"companyId", "testCaseId", "releaseId", this, releasePersistence);
	}

	public void destroy() {
		entityCache.removeCache(TestCaseImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("qualitytrack_TestCases_Releases");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = ReleasePersistence.class)
	protected ReleasePersistence releasePersistence;
	protected TableMapper<TestCase, com.liferay.ide.utils.quality.track.model.Release> testCaseToReleaseTableMapper;
	private static final String _SQL_SELECT_TESTCASE = "SELECT testCase FROM TestCase testCase";
	private static final String _SQL_SELECT_TESTCASE_WHERE_PKS_IN = "SELECT testCase FROM TestCase testCase WHERE testCaseId IN (";
	private static final String _SQL_COUNT_TESTCASE = "SELECT COUNT(testCase) FROM TestCase testCase";
	private static final String _ORDER_BY_ENTITY_ALIAS = "testCase.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TestCase exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TestCasePersistenceImpl.class);
}
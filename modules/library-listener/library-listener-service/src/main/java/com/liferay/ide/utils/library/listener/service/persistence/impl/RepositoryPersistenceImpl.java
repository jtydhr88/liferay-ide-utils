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

package com.liferay.ide.utils.library.listener.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.ide.utils.library.listener.exception.NoSuchRepositoryException;
import com.liferay.ide.utils.library.listener.model.Repository;
import com.liferay.ide.utils.library.listener.model.impl.RepositoryImpl;
import com.liferay.ide.utils.library.listener.model.impl.RepositoryModelImpl;
import com.liferay.ide.utils.library.listener.service.persistence.RepositoryPersistence;

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
import com.liferay.portal.kernel.util.OrderByComparator;
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
 * The persistence implementation for the repository service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RepositoryPersistence
 * @see com.liferay.ide.utils.library.listener.service.persistence.RepositoryUtil
 * @generated
 */
@ProviderType
public class RepositoryPersistenceImpl extends BasePersistenceImpl<Repository>
	implements RepositoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RepositoryUtil} to access the repository persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RepositoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
			RepositoryModelImpl.FINDER_CACHE_ENABLED, RepositoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
			RepositoryModelImpl.FINDER_CACHE_ENABLED, RepositoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
			RepositoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RepositoryPersistenceImpl() {
		setModelClass(Repository.class);
	}

	/**
	 * Caches the repository in the entity cache if it is enabled.
	 *
	 * @param repository the repository
	 */
	@Override
	public void cacheResult(Repository repository) {
		entityCache.putResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
			RepositoryImpl.class, repository.getPrimaryKey(), repository);

		repository.resetOriginalValues();
	}

	/**
	 * Caches the repositories in the entity cache if it is enabled.
	 *
	 * @param repositories the repositories
	 */
	@Override
	public void cacheResult(List<Repository> repositories) {
		for (Repository repository : repositories) {
			if (entityCache.getResult(
						RepositoryModelImpl.ENTITY_CACHE_ENABLED,
						RepositoryImpl.class, repository.getPrimaryKey()) == null) {
				cacheResult(repository);
			}
			else {
				repository.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all repositories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RepositoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the repository.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Repository repository) {
		entityCache.removeResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
			RepositoryImpl.class, repository.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Repository> repositories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Repository repository : repositories) {
			entityCache.removeResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
				RepositoryImpl.class, repository.getPrimaryKey());
		}
	}

	/**
	 * Creates a new repository with the primary key. Does not add the repository to the database.
	 *
	 * @param repositoryId the primary key for the new repository
	 * @return the new repository
	 */
	@Override
	public Repository create(long repositoryId) {
		Repository repository = new RepositoryImpl();

		repository.setNew(true);
		repository.setPrimaryKey(repositoryId);

		repository.setCompanyId(companyProvider.getCompanyId());

		return repository;
	}

	/**
	 * Removes the repository with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param repositoryId the primary key of the repository
	 * @return the repository that was removed
	 * @throws NoSuchRepositoryException if a repository with the primary key could not be found
	 */
	@Override
	public Repository remove(long repositoryId)
		throws NoSuchRepositoryException {
		return remove((Serializable)repositoryId);
	}

	/**
	 * Removes the repository with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the repository
	 * @return the repository that was removed
	 * @throws NoSuchRepositoryException if a repository with the primary key could not be found
	 */
	@Override
	public Repository remove(Serializable primaryKey)
		throws NoSuchRepositoryException {
		Session session = null;

		try {
			session = openSession();

			Repository repository = (Repository)session.get(RepositoryImpl.class,
					primaryKey);

			if (repository == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRepositoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(repository);
		}
		catch (NoSuchRepositoryException nsee) {
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
	protected Repository removeImpl(Repository repository) {
		repository = toUnwrappedModel(repository);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(repository)) {
				repository = (Repository)session.get(RepositoryImpl.class,
						repository.getPrimaryKeyObj());
			}

			if (repository != null) {
				session.delete(repository);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (repository != null) {
			clearCache(repository);
		}

		return repository;
	}

	@Override
	public Repository updateImpl(Repository repository) {
		repository = toUnwrappedModel(repository);

		boolean isNew = repository.isNew();

		RepositoryModelImpl repositoryModelImpl = (RepositoryModelImpl)repository;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (repository.getCreateDate() == null)) {
			if (serviceContext == null) {
				repository.setCreateDate(now);
			}
			else {
				repository.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!repositoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				repository.setModifiedDate(now);
			}
			else {
				repository.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (repository.isNew()) {
				session.save(repository);

				repository.setNew(false);
			}
			else {
				repository = (Repository)session.merge(repository);
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

		entityCache.putResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
			RepositoryImpl.class, repository.getPrimaryKey(), repository, false);

		repository.resetOriginalValues();

		return repository;
	}

	protected Repository toUnwrappedModel(Repository repository) {
		if (repository instanceof RepositoryImpl) {
			return repository;
		}

		RepositoryImpl repositoryImpl = new RepositoryImpl();

		repositoryImpl.setNew(repository.isNew());
		repositoryImpl.setPrimaryKey(repository.getPrimaryKey());

		repositoryImpl.setRepositoryId(repository.getRepositoryId());
		repositoryImpl.setGroupId(repository.getGroupId());
		repositoryImpl.setCompanyId(repository.getCompanyId());
		repositoryImpl.setUserId(repository.getUserId());
		repositoryImpl.setUserName(repository.getUserName());
		repositoryImpl.setCreateDate(repository.getCreateDate());
		repositoryImpl.setModifiedDate(repository.getModifiedDate());
		repositoryImpl.setRepositoryName(repository.getRepositoryName());
		repositoryImpl.setRepositoryRootUrl(repository.getRepositoryRootUrl());
		repositoryImpl.setRepositoryUserName(repository.getRepositoryUserName());
		repositoryImpl.setRepositoryPassword(repository.getRepositoryPassword());

		return repositoryImpl;
	}

	/**
	 * Returns the repository with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the repository
	 * @return the repository
	 * @throws NoSuchRepositoryException if a repository with the primary key could not be found
	 */
	@Override
	public Repository findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRepositoryException {
		Repository repository = fetchByPrimaryKey(primaryKey);

		if (repository == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRepositoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return repository;
	}

	/**
	 * Returns the repository with the primary key or throws a {@link NoSuchRepositoryException} if it could not be found.
	 *
	 * @param repositoryId the primary key of the repository
	 * @return the repository
	 * @throws NoSuchRepositoryException if a repository with the primary key could not be found
	 */
	@Override
	public Repository findByPrimaryKey(long repositoryId)
		throws NoSuchRepositoryException {
		return findByPrimaryKey((Serializable)repositoryId);
	}

	/**
	 * Returns the repository with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the repository
	 * @return the repository, or <code>null</code> if a repository with the primary key could not be found
	 */
	@Override
	public Repository fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
				RepositoryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Repository repository = (Repository)serializable;

		if (repository == null) {
			Session session = null;

			try {
				session = openSession();

				repository = (Repository)session.get(RepositoryImpl.class,
						primaryKey);

				if (repository != null) {
					cacheResult(repository);
				}
				else {
					entityCache.putResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
						RepositoryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
					RepositoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return repository;
	}

	/**
	 * Returns the repository with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param repositoryId the primary key of the repository
	 * @return the repository, or <code>null</code> if a repository with the primary key could not be found
	 */
	@Override
	public Repository fetchByPrimaryKey(long repositoryId) {
		return fetchByPrimaryKey((Serializable)repositoryId);
	}

	@Override
	public Map<Serializable, Repository> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Repository> map = new HashMap<Serializable, Repository>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Repository repository = fetchByPrimaryKey(primaryKey);

			if (repository != null) {
				map.put(primaryKey, repository);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
					RepositoryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Repository)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_REPOSITORY_WHERE_PKS_IN);

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

			for (Repository repository : (List<Repository>)q.list()) {
				map.put(repository.getPrimaryKeyObj(), repository);

				cacheResult(repository);

				uncachedPrimaryKeys.remove(repository.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RepositoryModelImpl.ENTITY_CACHE_ENABLED,
					RepositoryImpl.class, primaryKey, nullModel);
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
	 * Returns all the repositories.
	 *
	 * @return the repositories
	 */
	@Override
	public List<Repository> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the repositories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of repositories
	 * @param end the upper bound of the range of repositories (not inclusive)
	 * @return the range of repositories
	 */
	@Override
	public List<Repository> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the repositories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of repositories
	 * @param end the upper bound of the range of repositories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of repositories
	 */
	@Override
	public List<Repository> findAll(int start, int end,
		OrderByComparator<Repository> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the repositories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of repositories
	 * @param end the upper bound of the range of repositories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of repositories
	 */
	@Override
	public List<Repository> findAll(int start, int end,
		OrderByComparator<Repository> orderByComparator,
		boolean retrieveFromCache) {
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

		List<Repository> list = null;

		if (retrieveFromCache) {
			list = (List<Repository>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_REPOSITORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REPOSITORY;

				if (pagination) {
					sql = sql.concat(RepositoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Repository>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Repository>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the repositories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Repository repository : findAll()) {
			remove(repository);
		}
	}

	/**
	 * Returns the number of repositories.
	 *
	 * @return the number of repositories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REPOSITORY);

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

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RepositoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the repository persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RepositoryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_REPOSITORY = "SELECT repository FROM Repository repository";
	private static final String _SQL_SELECT_REPOSITORY_WHERE_PKS_IN = "SELECT repository FROM Repository repository WHERE repositoryId IN (";
	private static final String _SQL_COUNT_REPOSITORY = "SELECT COUNT(repository) FROM Repository repository";
	private static final String _ORDER_BY_ENTITY_ALIAS = "repository.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Repository exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(RepositoryPersistenceImpl.class);
}
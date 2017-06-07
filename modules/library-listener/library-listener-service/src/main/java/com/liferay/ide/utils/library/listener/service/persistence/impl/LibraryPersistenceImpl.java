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

import com.liferay.ide.utils.library.listener.exception.NoSuchLibraryException;
import com.liferay.ide.utils.library.listener.model.Library;
import com.liferay.ide.utils.library.listener.model.impl.LibraryImpl;
import com.liferay.ide.utils.library.listener.model.impl.LibraryModelImpl;
import com.liferay.ide.utils.library.listener.service.persistence.LibraryPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
 * The persistence implementation for the library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryPersistence
 * @see com.liferay.ide.utils.library.listener.service.persistence.LibraryUtil
 * @generated
 */
@ProviderType
public class LibraryPersistenceImpl extends BasePersistenceImpl<Library>
	implements LibraryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LibraryUtil} to access the library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LibraryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPOSITORYID =
		new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRepositoryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPOSITORYID =
		new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRepositoryId",
			new String[] { Long.class.getName() },
			LibraryModelImpl.REPOSITORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPOSITORYID = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRepositoryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the libraries where repositoryId = &#63;.
	 *
	 * @param repositoryId the repository ID
	 * @return the matching libraries
	 */
	@Override
	public List<Library> findByRepositoryId(long repositoryId) {
		return findByRepositoryId(repositoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the libraries where repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of matching libraries
	 */
	@Override
	public List<Library> findByRepositoryId(long repositoryId, int start,
		int end) {
		return findByRepositoryId(repositoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the libraries where repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching libraries
	 */
	@Override
	public List<Library> findByRepositoryId(long repositoryId, int start,
		int end, OrderByComparator<Library> orderByComparator) {
		return findByRepositoryId(repositoryId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the libraries where repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching libraries
	 */
	@Override
	public List<Library> findByRepositoryId(long repositoryId, int start,
		int end, OrderByComparator<Library> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPOSITORYID;
			finderArgs = new Object[] { repositoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPOSITORYID;
			finderArgs = new Object[] {
					repositoryId,
					
					start, end, orderByComparator
				};
		}

		List<Library> list = null;

		if (retrieveFromCache) {
			list = (List<Library>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Library library : list) {
					if ((repositoryId != library.getRepositoryId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LIBRARY_WHERE);

			query.append(_FINDER_COLUMN_REPOSITORYID_REPOSITORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LibraryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(repositoryId);

				if (!pagination) {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first library in the ordered set where repositoryId = &#63;.
	 *
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByRepositoryId_First(long repositoryId,
		OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {
		Library library = fetchByRepositoryId_First(repositoryId,
				orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("repositoryId=");
		msg.append(repositoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLibraryException(msg.toString());
	}

	/**
	 * Returns the first library in the ordered set where repositoryId = &#63;.
	 *
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByRepositoryId_First(long repositoryId,
		OrderByComparator<Library> orderByComparator) {
		List<Library> list = findByRepositoryId(repositoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last library in the ordered set where repositoryId = &#63;.
	 *
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByRepositoryId_Last(long repositoryId,
		OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {
		Library library = fetchByRepositoryId_Last(repositoryId,
				orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("repositoryId=");
		msg.append(repositoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLibraryException(msg.toString());
	}

	/**
	 * Returns the last library in the ordered set where repositoryId = &#63;.
	 *
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByRepositoryId_Last(long repositoryId,
		OrderByComparator<Library> orderByComparator) {
		int count = countByRepositoryId(repositoryId);

		if (count == 0) {
			return null;
		}

		List<Library> list = findByRepositoryId(repositoryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where repositoryId = &#63;.
	 *
	 * @param libraryId the primary key of the current library
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library[] findByRepositoryId_PrevAndNext(long libraryId,
		long repositoryId, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {
		Library library = findByPrimaryKey(libraryId);

		Session session = null;

		try {
			session = openSession();

			Library[] array = new LibraryImpl[3];

			array[0] = getByRepositoryId_PrevAndNext(session, library,
					repositoryId, orderByComparator, true);

			array[1] = library;

			array[2] = getByRepositoryId_PrevAndNext(session, library,
					repositoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Library getByRepositoryId_PrevAndNext(Session session,
		Library library, long repositoryId,
		OrderByComparator<Library> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LIBRARY_WHERE);

		query.append(_FINDER_COLUMN_REPOSITORYID_REPOSITORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(repositoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(library);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Library> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the libraries where repositoryId = &#63; from the database.
	 *
	 * @param repositoryId the repository ID
	 */
	@Override
	public void removeByRepositoryId(long repositoryId) {
		for (Library library : findByRepositoryId(repositoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(library);
		}
	}

	/**
	 * Returns the number of libraries where repositoryId = &#63;.
	 *
	 * @param repositoryId the repository ID
	 * @return the number of matching libraries
	 */
	@Override
	public int countByRepositoryId(long repositoryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPOSITORYID;

		Object[] finderArgs = new Object[] { repositoryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LIBRARY_WHERE);

			query.append(_FINDER_COLUMN_REPOSITORYID_REPOSITORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(repositoryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REPOSITORYID_REPOSITORYID_2 = "library.repositoryId = ?";

	public LibraryPersistenceImpl() {
		setModelClass(Library.class);
	}

	/**
	 * Caches the library in the entity cache if it is enabled.
	 *
	 * @param library the library
	 */
	@Override
	public void cacheResult(Library library) {
		entityCache.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey(), library);

		library.resetOriginalValues();
	}

	/**
	 * Caches the libraries in the entity cache if it is enabled.
	 *
	 * @param libraries the libraries
	 */
	@Override
	public void cacheResult(List<Library> libraries) {
		for (Library library : libraries) {
			if (entityCache.getResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
						LibraryImpl.class, library.getPrimaryKey()) == null) {
				cacheResult(library);
			}
			else {
				library.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all libraries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LibraryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the library.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Library library) {
		entityCache.removeResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Library> libraries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Library library : libraries) {
			entityCache.removeResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
				LibraryImpl.class, library.getPrimaryKey());
		}
	}

	/**
	 * Creates a new library with the primary key. Does not add the library to the database.
	 *
	 * @param libraryId the primary key for the new library
	 * @return the new library
	 */
	@Override
	public Library create(long libraryId) {
		Library library = new LibraryImpl();

		library.setNew(true);
		library.setPrimaryKey(libraryId);

		library.setCompanyId(companyProvider.getCompanyId());

		return library;
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library that was removed
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library remove(long libraryId) throws NoSuchLibraryException {
		return remove((Serializable)libraryId);
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library that was removed
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library remove(Serializable primaryKey)
		throws NoSuchLibraryException {
		Session session = null;

		try {
			session = openSession();

			Library library = (Library)session.get(LibraryImpl.class, primaryKey);

			if (library == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(library);
		}
		catch (NoSuchLibraryException nsee) {
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
	protected Library removeImpl(Library library) {
		library = toUnwrappedModel(library);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(library)) {
				library = (Library)session.get(LibraryImpl.class,
						library.getPrimaryKeyObj());
			}

			if (library != null) {
				session.delete(library);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (library != null) {
			clearCache(library);
		}

		return library;
	}

	@Override
	public Library updateImpl(Library library) {
		library = toUnwrappedModel(library);

		boolean isNew = library.isNew();

		LibraryModelImpl libraryModelImpl = (LibraryModelImpl)library;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (library.getCreateDate() == null)) {
			if (serviceContext == null) {
				library.setCreateDate(now);
			}
			else {
				library.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!libraryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				library.setModifiedDate(now);
			}
			else {
				library.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (library.isNew()) {
				session.save(library);

				library.setNew(false);
			}
			else {
				library = (Library)session.merge(library);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LibraryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((libraryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPOSITORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						libraryModelImpl.getOriginalRepositoryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPOSITORYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPOSITORYID,
					args);

				args = new Object[] { libraryModelImpl.getRepositoryId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPOSITORYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPOSITORYID,
					args);
			}
		}

		entityCache.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey(), library, false);

		library.resetOriginalValues();

		return library;
	}

	protected Library toUnwrappedModel(Library library) {
		if (library instanceof LibraryImpl) {
			return library;
		}

		LibraryImpl libraryImpl = new LibraryImpl();

		libraryImpl.setNew(library.isNew());
		libraryImpl.setPrimaryKey(library.getPrimaryKey());

		libraryImpl.setLibraryId(library.getLibraryId());
		libraryImpl.setGroupId(library.getGroupId());
		libraryImpl.setCompanyId(library.getCompanyId());
		libraryImpl.setUserId(library.getUserId());
		libraryImpl.setUserName(library.getUserName());
		libraryImpl.setCreateDate(library.getCreateDate());
		libraryImpl.setModifiedDate(library.getModifiedDate());
		libraryImpl.setRepositoryId(library.getRepositoryId());
		libraryImpl.setLibraryGroupId(library.getLibraryGroupId());
		libraryImpl.setLibraryArtifactId(library.getLibraryArtifactId());
		libraryImpl.setLatestVersion(library.getLatestVersion());
		libraryImpl.setLastUpdated(library.getLastUpdated());
		libraryImpl.setCurrentVersion(library.getCurrentVersion());
		libraryImpl.setResources(library.getResources());
		libraryImpl.setEnableListener(library.isEnableListener());

		return libraryImpl;
	}

	/**
	 * Returns the library with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLibraryException {
		Library library = fetchByPrimaryKey(primaryKey);

		if (library == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return library;
	}

	/**
	 * Returns the library with the primary key or throws a {@link NoSuchLibraryException} if it could not be found.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library findByPrimaryKey(long libraryId)
		throws NoSuchLibraryException {
		return findByPrimaryKey((Serializable)libraryId);
	}

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 */
	@Override
	public Library fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
				LibraryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Library library = (Library)serializable;

		if (library == null) {
			Session session = null;

			try {
				session = openSession();

				library = (Library)session.get(LibraryImpl.class, primaryKey);

				if (library != null) {
					cacheResult(library);
				}
				else {
					entityCache.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
						LibraryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
					LibraryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return library;
	}

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 */
	@Override
	public Library fetchByPrimaryKey(long libraryId) {
		return fetchByPrimaryKey((Serializable)libraryId);
	}

	@Override
	public Map<Serializable, Library> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Library> map = new HashMap<Serializable, Library>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Library library = fetchByPrimaryKey(primaryKey);

			if (library != null) {
				map.put(primaryKey, library);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
					LibraryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Library)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LIBRARY_WHERE_PKS_IN);

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

			for (Library library : (List<Library>)q.list()) {
				map.put(library.getPrimaryKeyObj(), library);

				cacheResult(library);

				uncachedPrimaryKeys.remove(library.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
					LibraryImpl.class, primaryKey, nullModel);
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
	 * Returns all the libraries.
	 *
	 * @return the libraries
	 */
	@Override
	public List<Library> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of libraries
	 */
	@Override
	public List<Library> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of libraries
	 */
	@Override
	public List<Library> findAll(int start, int end,
		OrderByComparator<Library> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of libraries
	 */
	@Override
	public List<Library> findAll(int start, int end,
		OrderByComparator<Library> orderByComparator, boolean retrieveFromCache) {
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

		List<Library> list = null;

		if (retrieveFromCache) {
			list = (List<Library>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LIBRARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LIBRARY;

				if (pagination) {
					sql = sql.concat(LibraryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the libraries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Library library : findAll()) {
			remove(library);
		}
	}

	/**
	 * Returns the number of libraries.
	 *
	 * @return the number of libraries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LIBRARY);

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
		return LibraryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the library persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LibraryImpl.class.getName());
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
	private static final String _SQL_SELECT_LIBRARY = "SELECT library FROM Library library";
	private static final String _SQL_SELECT_LIBRARY_WHERE_PKS_IN = "SELECT library FROM Library library WHERE libraryId IN (";
	private static final String _SQL_SELECT_LIBRARY_WHERE = "SELECT library FROM Library library WHERE ";
	private static final String _SQL_COUNT_LIBRARY = "SELECT COUNT(library) FROM Library library";
	private static final String _SQL_COUNT_LIBRARY_WHERE = "SELECT COUNT(library) FROM Library library WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "library.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Library exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Library exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LibraryPersistenceImpl.class);
}
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

package com.liferay.ide.utils.library.listener.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.ide.utils.library.listener.exception.NoSuchLibraryException;
import com.liferay.ide.utils.library.listener.model.Library;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.ide.utils.library.listener.service.persistence.impl.LibraryPersistenceImpl
 * @see LibraryUtil
 * @generated
 */
@ProviderType
public interface LibraryPersistence extends BasePersistence<Library> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LibraryUtil} to access the library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the libraries where repositoryId = &#63;.
	*
	* @param repositoryId the repository ID
	* @return the matching libraries
	*/
	public java.util.List<Library> findByRepositoryId(long repositoryId);

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
	public java.util.List<Library> findByRepositoryId(long repositoryId,
		int start, int end);

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
	public java.util.List<Library> findByRepositoryId(long repositoryId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator);

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
	public java.util.List<Library> findByRepositoryId(long repositoryId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first library in the ordered set where repositoryId = &#63;.
	*
	* @param repositoryId the repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching library
	* @throws NoSuchLibraryException if a matching library could not be found
	*/
	public Library findByRepositoryId_First(long repositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException;

	/**
	* Returns the first library in the ordered set where repositoryId = &#63;.
	*
	* @param repositoryId the repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching library, or <code>null</code> if a matching library could not be found
	*/
	public Library fetchByRepositoryId_First(long repositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator);

	/**
	* Returns the last library in the ordered set where repositoryId = &#63;.
	*
	* @param repositoryId the repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching library
	* @throws NoSuchLibraryException if a matching library could not be found
	*/
	public Library findByRepositoryId_Last(long repositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException;

	/**
	* Returns the last library in the ordered set where repositoryId = &#63;.
	*
	* @param repositoryId the repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching library, or <code>null</code> if a matching library could not be found
	*/
	public Library fetchByRepositoryId_Last(long repositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator);

	/**
	* Returns the libraries before and after the current library in the ordered set where repositoryId = &#63;.
	*
	* @param libraryId the primary key of the current library
	* @param repositoryId the repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next library
	* @throws NoSuchLibraryException if a library with the primary key could not be found
	*/
	public Library[] findByRepositoryId_PrevAndNext(long libraryId,
		long repositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException;

	/**
	* Removes all the libraries where repositoryId = &#63; from the database.
	*
	* @param repositoryId the repository ID
	*/
	public void removeByRepositoryId(long repositoryId);

	/**
	* Returns the number of libraries where repositoryId = &#63;.
	*
	* @param repositoryId the repository ID
	* @return the number of matching libraries
	*/
	public int countByRepositoryId(long repositoryId);

	/**
	* Caches the library in the entity cache if it is enabled.
	*
	* @param library the library
	*/
	public void cacheResult(Library library);

	/**
	* Caches the libraries in the entity cache if it is enabled.
	*
	* @param libraries the libraries
	*/
	public void cacheResult(java.util.List<Library> libraries);

	/**
	* Creates a new library with the primary key. Does not add the library to the database.
	*
	* @param libraryId the primary key for the new library
	* @return the new library
	*/
	public Library create(long libraryId);

	/**
	* Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryId the primary key of the library
	* @return the library that was removed
	* @throws NoSuchLibraryException if a library with the primary key could not be found
	*/
	public Library remove(long libraryId) throws NoSuchLibraryException;

	public Library updateImpl(Library library);

	/**
	* Returns the library with the primary key or throws a {@link NoSuchLibraryException} if it could not be found.
	*
	* @param libraryId the primary key of the library
	* @return the library
	* @throws NoSuchLibraryException if a library with the primary key could not be found
	*/
	public Library findByPrimaryKey(long libraryId)
		throws NoSuchLibraryException;

	/**
	* Returns the library with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param libraryId the primary key of the library
	* @return the library, or <code>null</code> if a library with the primary key could not be found
	*/
	public Library fetchByPrimaryKey(long libraryId);

	@Override
	public java.util.Map<java.io.Serializable, Library> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the libraries.
	*
	* @return the libraries
	*/
	public java.util.List<Library> findAll();

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
	public java.util.List<Library> findAll(int start, int end);

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
	public java.util.List<Library> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator);

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
	public java.util.List<Library> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the libraries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of libraries.
	*
	* @return the number of libraries
	*/
	public int countAll();
}
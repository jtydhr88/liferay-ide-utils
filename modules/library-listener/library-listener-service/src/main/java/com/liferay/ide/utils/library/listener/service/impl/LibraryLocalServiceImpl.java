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

package com.liferay.ide.utils.library.listener.service.impl;

import com.liferay.ide.utils.library.listener.model.Library;
import com.liferay.ide.utils.library.listener.service.base.LibraryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the library local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.ide.utils.library.listener.service.LibraryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryLocalServiceBaseImpl
 * @see com.liferay.ide.utils.library.listener.service.LibraryLocalServiceUtil
 */
@ProviderType
public class LibraryLocalServiceImpl extends LibraryLocalServiceBaseImpl {
	public Library addLibrary(
			long repositoryId, String libraryGroupId, String libraryArtifactId, String latestVersion,
			String lastUpdated, String currentVersion, boolean enableListener, ServiceContext serviceContext)
		throws PortalException {

		long libraryId = counterLocalService.increment();

		Library library = libraryPersistence.create(libraryId);

		library.setGroupId(serviceContext.getScopeGroupId());
		library.setCompanyId(serviceContext.getCompanyId());
		library.setUserId(serviceContext.getUserId());
		library.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		library.setRepositoryId(repositoryId);
		library.setLibraryGroupId(libraryGroupId);
		library.setLibraryArtifactId(libraryArtifactId);
		library.setLatestVersion(latestVersion);
		library.setLastUpdated(lastUpdated);
		library.setCurrentVersion(currentVersion);
		library.setEnableListener(enableListener);

		library.setCreateDate(serviceContext.getCreateDate(null));

		libraryPersistence.update(library);

		return library;
	}

	public Library updateLibrary(
			long libraryId, long repositoryId, String libraryGroupId, String libraryArtifactId, String latestVersion,
			String lastUpdated, String currentVersion, boolean enableListener, ServiceContext serviceContext)
		throws PortalException {

		Library library = libraryPersistence.fetchByPrimaryKey(libraryId);

		library.setUserId(serviceContext.getUserId());
		library.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		library.setRepositoryId(repositoryId);
		library.setLibraryGroupId(libraryGroupId);
		library.setLibraryArtifactId(libraryArtifactId);
		library.setLatestVersion(latestVersion);
		library.setLastUpdated(lastUpdated);
		library.setCurrentVersion(currentVersion);
		library.setEnableListener(enableListener);

		library.setModifiedDate(serviceContext.getModifiedDate());

		libraryPersistence.update(library);

		return library;
	}

}
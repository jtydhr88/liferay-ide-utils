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

import aQute.bnd.annotation.ProviderType;

import com.liferay.ide.utils.library.listener.model.Repository;
import com.liferay.ide.utils.library.listener.service.base.RepositoryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the repository local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.ide.utils.library.listener.service.RepositoryLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RepositoryLocalServiceBaseImpl
 * @see com.liferay.ide.utils.library.listener.service.RepositoryLocalServiceUtil
 */
@ProviderType
public class RepositoryLocalServiceImpl extends RepositoryLocalServiceBaseImpl {

	public Repository addRepository(
			String repositoryName, String repositoryRootUrl, String repositoryUserName,
			String repositoryPassword, ServiceContext serviceContext) throws PortalException {

		long repositoryId = counterLocalService.increment();

		Repository repository = repositoryPersistence.create(repositoryId);

		repository.setGroupId(serviceContext.getScopeGroupId());
		repository.setCompanyId(serviceContext.getCompanyId());
		repository.setUserId(serviceContext.getUserId());
		repository.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		repository.setRepositoryName(repositoryName);
		repository.setRepositoryRootUrl(repositoryRootUrl);
		repository.setRepositoryUserName(repositoryUserName);
		repository.setRepositoryPassword(repositoryPassword);

		repository.setCreateDate(serviceContext.getCreateDate(null));

		repositoryPersistence.update(repository);

		return repository;
	}

	public Repository updateRepository(
			long repositoryId, String repositoryName, String repositoryRootUrl, String repositoryUserName,
			String repositoryPassword, ServiceContext serviceContext) throws PortalException {

		Repository repository = repositoryPersistence.fetchByPrimaryKey(repositoryId);

		repository.setUserId(serviceContext.getUserId());
		repository.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		repository.setRepositoryName(repositoryName);
		repository.setRepositoryRootUrl(repositoryRootUrl);
		repository.setRepositoryUserName(repositoryUserName);
		repository.setRepositoryPassword(repositoryPassword);

		repository.setModifiedDate(serviceContext.getModifiedDate());

		repositoryPersistence.update(repository);

		return repository;
	}

}
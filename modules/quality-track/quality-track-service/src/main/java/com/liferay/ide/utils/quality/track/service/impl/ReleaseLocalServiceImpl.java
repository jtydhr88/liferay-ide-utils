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

package com.liferay.ide.utils.quality.track.service.impl;

import java.util.Date;

import com.liferay.ide.utils.quality.track.model.Release;
import com.liferay.ide.utils.quality.track.service.base.ReleaseLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the release local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.ide.utils.quality.track.service.ReleaseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Terry Jia
 * @see ReleaseLocalServiceBaseImpl
 * @see com.liferay.ide.utils.quality.track.service.ReleaseLocalServiceUtil
 */
@ProviderType
public class ReleaseLocalServiceImpl extends ReleaseLocalServiceBaseImpl {

	public Release addRelease(
			String releaseName, Date releaseDate, long[] testCaseIds, boolean isDefault, int status, String comments, ServiceContext serviceContext)
		throws PortalException {

		long releaseId = counterLocalService.increment();

		Release release = releasePersistence.create(releaseId);

		release.setGroupId(serviceContext.getScopeGroupId());
		release.setCompanyId(serviceContext.getCompanyId());
		release.setUserId(serviceContext.getUserId());
		release.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		release.setReleaseName(releaseName);
		release.setReleaseDate(releaseDate);

		releasePersistence.setTestCases(releaseId, testCaseIds);

		release.setCreateDate(serviceContext.getCreateDate(null));
		release.setStatus(status);
		release.setComments(comments);

		releasePersistence.update(release);

		return release;
	}

	public Release updateRelease(
			long releaseId, String releaseName, Date releaseDate, long[] testCaseIds, boolean isDefault, int status, String comments,
			ServiceContext serviceContext)
		throws PortalException {

		Release release = releasePersistence.fetchByPrimaryKey(releaseId);

		release.setUserId(serviceContext.getUserId());
		release.setUserName(userLocalService.getUser(serviceContext.getUserId()).getFullName());

		release.setReleaseName(releaseName);
		release.setReleaseDate(releaseDate);

		releasePersistence.setTestCases(releaseId, testCaseIds);
		release.setStatus(status);
		release.setComments(comments);

		release.setModifiedDate(serviceContext.getModifiedDate());

		releasePersistence.update(release);

		return release;
	}

}
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

package com.liferay.ide.utils.quality.track.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReleaseLocalService}.
 *
 * @author Terry Jia
 * @see ReleaseLocalService
 * @generated
 */
@ProviderType
public class ReleaseLocalServiceWrapper implements ReleaseLocalService,
	ServiceWrapper<ReleaseLocalService> {
	public ReleaseLocalServiceWrapper(ReleaseLocalService releaseLocalService) {
		_releaseLocalService = releaseLocalService;
	}

	@Override
	public boolean hasTestCaseRelease(long testCaseId, long releaseId) {
		return _releaseLocalService.hasTestCaseRelease(testCaseId, releaseId);
	}

	@Override
	public boolean hasTestCaseReleases(long testCaseId) {
		return _releaseLocalService.hasTestCaseReleases(testCaseId);
	}

	/**
	* Adds the release to the database. Also notifies the appropriate model listeners.
	*
	* @param release the release
	* @return the release that was added
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Release addRelease(
		com.liferay.ide.utils.quality.track.model.Release release) {
		return _releaseLocalService.addRelease(release);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.Release addRelease(
		java.lang.String releaseName, java.util.Date releaseDate,
		long[] testCaseIds, boolean isDefault, int status,
		java.lang.String comments,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _releaseLocalService.addRelease(releaseName, releaseDate,
			testCaseIds, isDefault, status, comments, serviceContext);
	}

	/**
	* Creates a new release with the primary key. Does not add the release to the database.
	*
	* @param releaseId the primary key for the new release
	* @return the new release
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Release createRelease(
		long releaseId) {
		return _releaseLocalService.createRelease(releaseId);
	}

	/**
	* Deletes the release from the database. Also notifies the appropriate model listeners.
	*
	* @param release the release
	* @return the release that was removed
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Release deleteRelease(
		com.liferay.ide.utils.quality.track.model.Release release) {
		return _releaseLocalService.deleteRelease(release);
	}

	/**
	* Deletes the release with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param releaseId the primary key of the release
	* @return the release that was removed
	* @throws PortalException if a release with the primary key could not be found
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Release deleteRelease(
		long releaseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _releaseLocalService.deleteRelease(releaseId);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.Release fetchRelease(
		long releaseId) {
		return _releaseLocalService.fetchRelease(releaseId);
	}

	/**
	* Returns the release with the primary key.
	*
	* @param releaseId the primary key of the release
	* @return the release
	* @throws PortalException if a release with the primary key could not be found
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Release getRelease(
		long releaseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _releaseLocalService.getRelease(releaseId);
	}

	/**
	* Updates the release in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param release the release
	* @return the release that was updated
	*/
	@Override
	public com.liferay.ide.utils.quality.track.model.Release updateRelease(
		com.liferay.ide.utils.quality.track.model.Release release) {
		return _releaseLocalService.updateRelease(release);
	}

	@Override
	public com.liferay.ide.utils.quality.track.model.Release updateRelease(
		long releaseId, java.lang.String releaseName,
		java.util.Date releaseDate, long[] testCaseIds, boolean isDefault,
		int status, java.lang.String comments,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _releaseLocalService.updateRelease(releaseId, releaseName,
			releaseDate, testCaseIds, isDefault, status, comments,
			serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _releaseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _releaseLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _releaseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _releaseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _releaseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of releases.
	*
	* @return the number of releases
	*/
	@Override
	public int getReleasesCount() {
		return _releaseLocalService.getReleasesCount();
	}

	@Override
	public int getTestCaseReleasesCount(long testCaseId) {
		return _releaseLocalService.getTestCaseReleasesCount(testCaseId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _releaseLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _releaseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.ReleaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _releaseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.ReleaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _releaseLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the releases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.ide.utils.quality.track.model.impl.ReleaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of releases
	* @param end the upper bound of the range of releases (not inclusive)
	* @return the range of releases
	*/
	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.Release> getReleases(
		int start, int end) {
		return _releaseLocalService.getReleases(start, end);
	}

	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.Release> getTestCaseReleases(
		long testCaseId) {
		return _releaseLocalService.getTestCaseReleases(testCaseId);
	}

	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.Release> getTestCaseReleases(
		long testCaseId, int start, int end) {
		return _releaseLocalService.getTestCaseReleases(testCaseId, start, end);
	}

	@Override
	public java.util.List<com.liferay.ide.utils.quality.track.model.Release> getTestCaseReleases(
		long testCaseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.ide.utils.quality.track.model.Release> orderByComparator) {
		return _releaseLocalService.getTestCaseReleases(testCaseId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _releaseLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _releaseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Returns the testCaseIds of the test cases associated with the release.
	*
	* @param releaseId the releaseId of the release
	* @return long[] the testCaseIds of test cases associated with the release
	*/
	@Override
	public long[] getTestCasePrimaryKeys(long releaseId) {
		return _releaseLocalService.getTestCasePrimaryKeys(releaseId);
	}

	@Override
	public void addTestCaseRelease(long testCaseId,
		com.liferay.ide.utils.quality.track.model.Release release) {
		_releaseLocalService.addTestCaseRelease(testCaseId, release);
	}

	@Override
	public void addTestCaseRelease(long testCaseId, long releaseId) {
		_releaseLocalService.addTestCaseRelease(testCaseId, releaseId);
	}

	@Override
	public void addTestCaseReleases(long testCaseId,
		java.util.List<com.liferay.ide.utils.quality.track.model.Release> releases) {
		_releaseLocalService.addTestCaseReleases(testCaseId, releases);
	}

	@Override
	public void addTestCaseReleases(long testCaseId, long[] releaseIds) {
		_releaseLocalService.addTestCaseReleases(testCaseId, releaseIds);
	}

	@Override
	public void clearTestCaseReleases(long testCaseId) {
		_releaseLocalService.clearTestCaseReleases(testCaseId);
	}

	@Override
	public void deleteTestCaseRelease(long testCaseId,
		com.liferay.ide.utils.quality.track.model.Release release) {
		_releaseLocalService.deleteTestCaseRelease(testCaseId, release);
	}

	@Override
	public void deleteTestCaseRelease(long testCaseId, long releaseId) {
		_releaseLocalService.deleteTestCaseRelease(testCaseId, releaseId);
	}

	@Override
	public void deleteTestCaseReleases(long testCaseId,
		java.util.List<com.liferay.ide.utils.quality.track.model.Release> releases) {
		_releaseLocalService.deleteTestCaseReleases(testCaseId, releases);
	}

	@Override
	public void deleteTestCaseReleases(long testCaseId, long[] releaseIds) {
		_releaseLocalService.deleteTestCaseReleases(testCaseId, releaseIds);
	}

	@Override
	public void setTestCaseReleases(long testCaseId, long[] releaseIds) {
		_releaseLocalService.setTestCaseReleases(testCaseId, releaseIds);
	}

	@Override
	public ReleaseLocalService getWrappedService() {
		return _releaseLocalService;
	}

	@Override
	public void setWrappedService(ReleaseLocalService releaseLocalService) {
		_releaseLocalService = releaseLocalService;
	}

	private ReleaseLocalService _releaseLocalService;
}
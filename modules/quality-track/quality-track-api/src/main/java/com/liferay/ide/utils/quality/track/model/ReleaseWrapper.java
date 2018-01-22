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

package com.liferay.ide.utils.quality.track.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Release}.
 * </p>
 *
 * @author Terry Jia
 * @see Release
 * @generated
 */
@ProviderType
public class ReleaseWrapper implements Release, ModelWrapper<Release> {
	public ReleaseWrapper(Release release) {
		_release = release;
	}

	@Override
	public Class<?> getModelClass() {
		return Release.class;
	}

	@Override
	public String getModelClassName() {
		return Release.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("releaseId", getReleaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("releaseName", getReleaseName());
		attributes.put("releaseDate", getReleaseDate());
		attributes.put("isDefault", getIsDefault());
		attributes.put("status", getStatus());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long releaseId = (Long)attributes.get("releaseId");

		if (releaseId != null) {
			setReleaseId(releaseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String releaseName = (String)attributes.get("releaseName");

		if (releaseName != null) {
			setReleaseName(releaseName);
		}

		Date releaseDate = (Date)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}

		Boolean isDefault = (Boolean)attributes.get("isDefault");

		if (isDefault != null) {
			setIsDefault(isDefault);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public Release toEscapedModel() {
		return new ReleaseWrapper(_release.toEscapedModel());
	}

	@Override
	public Release toUnescapedModel() {
		return new ReleaseWrapper(_release.toUnescapedModel());
	}

	/**
	* Returns the is default of this release.
	*
	* @return the is default of this release
	*/
	@Override
	public boolean getIsDefault() {
		return _release.getIsDefault();
	}

	@Override
	public boolean isCachedModel() {
		return _release.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _release.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this release is is default.
	*
	* @return <code>true</code> if this release is is default; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsDefault() {
		return _release.isIsDefault();
	}

	@Override
	public boolean isNew() {
		return _release.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _release.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Release> toCacheModel() {
		return _release.toCacheModel();
	}

	@Override
	public int compareTo(Release release) {
		return _release.compareTo(release);
	}

	/**
	* Returns the status of this release.
	*
	* @return the status of this release
	*/
	@Override
	public int getStatus() {
		return _release.getStatus();
	}

	@Override
	public int hashCode() {
		return _release.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _release.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ReleaseWrapper((Release)_release.clone());
	}

	/**
	* Returns the comments of this release.
	*
	* @return the comments of this release
	*/
	@Override
	public java.lang.String getComments() {
		return _release.getComments();
	}

	/**
	* Returns the release name of this release.
	*
	* @return the release name of this release
	*/
	@Override
	public java.lang.String getReleaseName() {
		return _release.getReleaseName();
	}

	/**
	* Returns the user name of this release.
	*
	* @return the user name of this release
	*/
	@Override
	public java.lang.String getUserName() {
		return _release.getUserName();
	}

	/**
	* Returns the user uuid of this release.
	*
	* @return the user uuid of this release
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _release.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _release.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _release.toXmlString();
	}

	/**
	* Returns the create date of this release.
	*
	* @return the create date of this release
	*/
	@Override
	public Date getCreateDate() {
		return _release.getCreateDate();
	}

	/**
	* Returns the modified date of this release.
	*
	* @return the modified date of this release
	*/
	@Override
	public Date getModifiedDate() {
		return _release.getModifiedDate();
	}

	/**
	* Returns the release date of this release.
	*
	* @return the release date of this release
	*/
	@Override
	public Date getReleaseDate() {
		return _release.getReleaseDate();
	}

	/**
	* Returns the company ID of this release.
	*
	* @return the company ID of this release
	*/
	@Override
	public long getCompanyId() {
		return _release.getCompanyId();
	}

	/**
	* Returns the group ID of this release.
	*
	* @return the group ID of this release
	*/
	@Override
	public long getGroupId() {
		return _release.getGroupId();
	}

	/**
	* Returns the primary key of this release.
	*
	* @return the primary key of this release
	*/
	@Override
	public long getPrimaryKey() {
		return _release.getPrimaryKey();
	}

	/**
	* Returns the release ID of this release.
	*
	* @return the release ID of this release
	*/
	@Override
	public long getReleaseId() {
		return _release.getReleaseId();
	}

	/**
	* Returns the user ID of this release.
	*
	* @return the user ID of this release
	*/
	@Override
	public long getUserId() {
		return _release.getUserId();
	}

	@Override
	public void persist() {
		_release.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_release.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this release.
	*
	* @param comments the comments of this release
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_release.setComments(comments);
	}

	/**
	* Sets the company ID of this release.
	*
	* @param companyId the company ID of this release
	*/
	@Override
	public void setCompanyId(long companyId) {
		_release.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this release.
	*
	* @param createDate the create date of this release
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_release.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_release.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_release.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_release.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this release.
	*
	* @param groupId the group ID of this release
	*/
	@Override
	public void setGroupId(long groupId) {
		_release.setGroupId(groupId);
	}

	/**
	* Sets whether this release is is default.
	*
	* @param isDefault the is default of this release
	*/
	@Override
	public void setIsDefault(boolean isDefault) {
		_release.setIsDefault(isDefault);
	}

	/**
	* Sets the modified date of this release.
	*
	* @param modifiedDate the modified date of this release
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_release.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_release.setNew(n);
	}

	/**
	* Sets the primary key of this release.
	*
	* @param primaryKey the primary key of this release
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_release.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_release.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the release date of this release.
	*
	* @param releaseDate the release date of this release
	*/
	@Override
	public void setReleaseDate(Date releaseDate) {
		_release.setReleaseDate(releaseDate);
	}

	/**
	* Sets the release ID of this release.
	*
	* @param releaseId the release ID of this release
	*/
	@Override
	public void setReleaseId(long releaseId) {
		_release.setReleaseId(releaseId);
	}

	/**
	* Sets the release name of this release.
	*
	* @param releaseName the release name of this release
	*/
	@Override
	public void setReleaseName(java.lang.String releaseName) {
		_release.setReleaseName(releaseName);
	}

	/**
	* Sets the status of this release.
	*
	* @param status the status of this release
	*/
	@Override
	public void setStatus(int status) {
		_release.setStatus(status);
	}

	/**
	* Sets the user ID of this release.
	*
	* @param userId the user ID of this release
	*/
	@Override
	public void setUserId(long userId) {
		_release.setUserId(userId);
	}

	/**
	* Sets the user name of this release.
	*
	* @param userName the user name of this release
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_release.setUserName(userName);
	}

	/**
	* Sets the user uuid of this release.
	*
	* @param userUuid the user uuid of this release
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_release.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReleaseWrapper)) {
			return false;
		}

		ReleaseWrapper releaseWrapper = (ReleaseWrapper)obj;

		if (Objects.equals(_release, releaseWrapper._release)) {
			return true;
		}

		return false;
	}

	@Override
	public Release getWrappedModel() {
		return _release;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _release.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _release.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_release.resetOriginalValues();
	}

	private final Release _release;
}
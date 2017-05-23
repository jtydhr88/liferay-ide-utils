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

package com.liferay.ide.utils.library.listener.model;

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
 * This class is a wrapper for {@link Library}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Library
 * @generated
 */
@ProviderType
public class LibraryWrapper implements Library, ModelWrapper<Library> {
	public LibraryWrapper(Library library) {
		_library = library;
	}

	@Override
	public Class<?> getModelClass() {
		return Library.class;
	}

	@Override
	public String getModelClassName() {
		return Library.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libraryId", getLibraryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("repositoryId", getRepositoryId());
		attributes.put("libraryGroupId", getLibraryGroupId());
		attributes.put("libraryArtifactId", getLibraryArtifactId());
		attributes.put("latestVersion", getLatestVersion());
		attributes.put("lastUpdated", getLastUpdated());
		attributes.put("currentVersion", getCurrentVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
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

		Long repositoryId = (Long)attributes.get("repositoryId");

		if (repositoryId != null) {
			setRepositoryId(repositoryId);
		}

		String libraryGroupId = (String)attributes.get("libraryGroupId");

		if (libraryGroupId != null) {
			setLibraryGroupId(libraryGroupId);
		}

		String libraryArtifactId = (String)attributes.get("libraryArtifactId");

		if (libraryArtifactId != null) {
			setLibraryArtifactId(libraryArtifactId);
		}

		String latestVersion = (String)attributes.get("latestVersion");

		if (latestVersion != null) {
			setLatestVersion(latestVersion);
		}

		String lastUpdated = (String)attributes.get("lastUpdated");

		if (lastUpdated != null) {
			setLastUpdated(lastUpdated);
		}

		String currentVersion = (String)attributes.get("currentVersion");

		if (currentVersion != null) {
			setCurrentVersion(currentVersion);
		}
	}

	@Override
	public Library toEscapedModel() {
		return new LibraryWrapper(_library.toEscapedModel());
	}

	@Override
	public Library toUnescapedModel() {
		return new LibraryWrapper(_library.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _library.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _library.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _library.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _library.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Library> toCacheModel() {
		return _library.toCacheModel();
	}

	@Override
	public int compareTo(Library library) {
		return _library.compareTo(library);
	}

	@Override
	public int hashCode() {
		return _library.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _library.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LibraryWrapper((Library)_library.clone());
	}

	/**
	* Returns the current version of this library.
	*
	* @return the current version of this library
	*/
	@Override
	public java.lang.String getCurrentVersion() {
		return _library.getCurrentVersion();
	}

	/**
	* Returns the last updated of this library.
	*
	* @return the last updated of this library
	*/
	@Override
	public java.lang.String getLastUpdated() {
		return _library.getLastUpdated();
	}

	/**
	* Returns the latest version of this library.
	*
	* @return the latest version of this library
	*/
	@Override
	public java.lang.String getLatestVersion() {
		return _library.getLatestVersion();
	}

	/**
	* Returns the library artifact ID of this library.
	*
	* @return the library artifact ID of this library
	*/
	@Override
	public java.lang.String getLibraryArtifactId() {
		return _library.getLibraryArtifactId();
	}

	/**
	* Returns the library group ID of this library.
	*
	* @return the library group ID of this library
	*/
	@Override
	public java.lang.String getLibraryGroupId() {
		return _library.getLibraryGroupId();
	}

	/**
	* Returns the user name of this library.
	*
	* @return the user name of this library
	*/
	@Override
	public java.lang.String getUserName() {
		return _library.getUserName();
	}

	/**
	* Returns the user uuid of this library.
	*
	* @return the user uuid of this library
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _library.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _library.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _library.toXmlString();
	}

	/**
	* Returns the create date of this library.
	*
	* @return the create date of this library
	*/
	@Override
	public Date getCreateDate() {
		return _library.getCreateDate();
	}

	/**
	* Returns the modified date of this library.
	*
	* @return the modified date of this library
	*/
	@Override
	public Date getModifiedDate() {
		return _library.getModifiedDate();
	}

	/**
	* Returns the company ID of this library.
	*
	* @return the company ID of this library
	*/
	@Override
	public long getCompanyId() {
		return _library.getCompanyId();
	}

	/**
	* Returns the group ID of this library.
	*
	* @return the group ID of this library
	*/
	@Override
	public long getGroupId() {
		return _library.getGroupId();
	}

	/**
	* Returns the library ID of this library.
	*
	* @return the library ID of this library
	*/
	@Override
	public long getLibraryId() {
		return _library.getLibraryId();
	}

	/**
	* Returns the primary key of this library.
	*
	* @return the primary key of this library
	*/
	@Override
	public long getPrimaryKey() {
		return _library.getPrimaryKey();
	}

	/**
	* Returns the repository ID of this library.
	*
	* @return the repository ID of this library
	*/
	@Override
	public long getRepositoryId() {
		return _library.getRepositoryId();
	}

	/**
	* Returns the user ID of this library.
	*
	* @return the user ID of this library
	*/
	@Override
	public long getUserId() {
		return _library.getUserId();
	}

	@Override
	public void persist() {
		_library.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_library.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this library.
	*
	* @param companyId the company ID of this library
	*/
	@Override
	public void setCompanyId(long companyId) {
		_library.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this library.
	*
	* @param createDate the create date of this library
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_library.setCreateDate(createDate);
	}

	/**
	* Sets the current version of this library.
	*
	* @param currentVersion the current version of this library
	*/
	@Override
	public void setCurrentVersion(java.lang.String currentVersion) {
		_library.setCurrentVersion(currentVersion);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_library.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_library.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_library.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this library.
	*
	* @param groupId the group ID of this library
	*/
	@Override
	public void setGroupId(long groupId) {
		_library.setGroupId(groupId);
	}

	/**
	* Sets the last updated of this library.
	*
	* @param lastUpdated the last updated of this library
	*/
	@Override
	public void setLastUpdated(java.lang.String lastUpdated) {
		_library.setLastUpdated(lastUpdated);
	}

	/**
	* Sets the latest version of this library.
	*
	* @param latestVersion the latest version of this library
	*/
	@Override
	public void setLatestVersion(java.lang.String latestVersion) {
		_library.setLatestVersion(latestVersion);
	}

	/**
	* Sets the library artifact ID of this library.
	*
	* @param libraryArtifactId the library artifact ID of this library
	*/
	@Override
	public void setLibraryArtifactId(java.lang.String libraryArtifactId) {
		_library.setLibraryArtifactId(libraryArtifactId);
	}

	/**
	* Sets the library group ID of this library.
	*
	* @param libraryGroupId the library group ID of this library
	*/
	@Override
	public void setLibraryGroupId(java.lang.String libraryGroupId) {
		_library.setLibraryGroupId(libraryGroupId);
	}

	/**
	* Sets the library ID of this library.
	*
	* @param libraryId the library ID of this library
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_library.setLibraryId(libraryId);
	}

	/**
	* Sets the modified date of this library.
	*
	* @param modifiedDate the modified date of this library
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_library.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_library.setNew(n);
	}

	/**
	* Sets the primary key of this library.
	*
	* @param primaryKey the primary key of this library
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_library.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_library.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the repository ID of this library.
	*
	* @param repositoryId the repository ID of this library
	*/
	@Override
	public void setRepositoryId(long repositoryId) {
		_library.setRepositoryId(repositoryId);
	}

	/**
	* Sets the user ID of this library.
	*
	* @param userId the user ID of this library
	*/
	@Override
	public void setUserId(long userId) {
		_library.setUserId(userId);
	}

	/**
	* Sets the user name of this library.
	*
	* @param userName the user name of this library
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_library.setUserName(userName);
	}

	/**
	* Sets the user uuid of this library.
	*
	* @param userUuid the user uuid of this library
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_library.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LibraryWrapper)) {
			return false;
		}

		LibraryWrapper libraryWrapper = (LibraryWrapper)obj;

		if (Objects.equals(_library, libraryWrapper._library)) {
			return true;
		}

		return false;
	}

	@Override
	public Library getWrappedModel() {
		return _library;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _library.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _library.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_library.resetOriginalValues();
	}

	private final Library _library;
}
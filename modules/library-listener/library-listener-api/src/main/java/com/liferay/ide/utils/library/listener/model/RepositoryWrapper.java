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
 * This class is a wrapper for {@link Repository}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Repository
 * @generated
 */
@ProviderType
public class RepositoryWrapper implements Repository, ModelWrapper<Repository> {
	public RepositoryWrapper(Repository repository) {
		_repository = repository;
	}

	@Override
	public Class<?> getModelClass() {
		return Repository.class;
	}

	@Override
	public String getModelClassName() {
		return Repository.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("repositoryId", getRepositoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("repositoryName", getRepositoryName());
		attributes.put("repositoryRootUrl", getRepositoryRootUrl());
		attributes.put("repositoryUserName", getRepositoryUserName());
		attributes.put("repositoryPassword", getRepositoryPassword());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long repositoryId = (Long)attributes.get("repositoryId");

		if (repositoryId != null) {
			setRepositoryId(repositoryId);
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

		String repositoryName = (String)attributes.get("repositoryName");

		if (repositoryName != null) {
			setRepositoryName(repositoryName);
		}

		String repositoryRootUrl = (String)attributes.get("repositoryRootUrl");

		if (repositoryRootUrl != null) {
			setRepositoryRootUrl(repositoryRootUrl);
		}

		String repositoryUserName = (String)attributes.get("repositoryUserName");

		if (repositoryUserName != null) {
			setRepositoryUserName(repositoryUserName);
		}

		String repositoryPassword = (String)attributes.get("repositoryPassword");

		if (repositoryPassword != null) {
			setRepositoryPassword(repositoryPassword);
		}
	}

	@Override
	public Repository toEscapedModel() {
		return new RepositoryWrapper(_repository.toEscapedModel());
	}

	@Override
	public Repository toUnescapedModel() {
		return new RepositoryWrapper(_repository.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _repository.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _repository.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _repository.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _repository.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Repository> toCacheModel() {
		return _repository.toCacheModel();
	}

	@Override
	public int compareTo(Repository repository) {
		return _repository.compareTo(repository);
	}

	@Override
	public int hashCode() {
		return _repository.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _repository.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RepositoryWrapper((Repository)_repository.clone());
	}

	/**
	* Returns the repository name of this repository.
	*
	* @return the repository name of this repository
	*/
	@Override
	public java.lang.String getRepositoryName() {
		return _repository.getRepositoryName();
	}

	/**
	* Returns the repository password of this repository.
	*
	* @return the repository password of this repository
	*/
	@Override
	public java.lang.String getRepositoryPassword() {
		return _repository.getRepositoryPassword();
	}

	/**
	* Returns the repository root url of this repository.
	*
	* @return the repository root url of this repository
	*/
	@Override
	public java.lang.String getRepositoryRootUrl() {
		return _repository.getRepositoryRootUrl();
	}

	/**
	* Returns the repository user name of this repository.
	*
	* @return the repository user name of this repository
	*/
	@Override
	public java.lang.String getRepositoryUserName() {
		return _repository.getRepositoryUserName();
	}

	/**
	* Returns the user name of this repository.
	*
	* @return the user name of this repository
	*/
	@Override
	public java.lang.String getUserName() {
		return _repository.getUserName();
	}

	/**
	* Returns the user uuid of this repository.
	*
	* @return the user uuid of this repository
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _repository.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _repository.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _repository.toXmlString();
	}

	/**
	* Returns the create date of this repository.
	*
	* @return the create date of this repository
	*/
	@Override
	public Date getCreateDate() {
		return _repository.getCreateDate();
	}

	/**
	* Returns the modified date of this repository.
	*
	* @return the modified date of this repository
	*/
	@Override
	public Date getModifiedDate() {
		return _repository.getModifiedDate();
	}

	/**
	* Returns the company ID of this repository.
	*
	* @return the company ID of this repository
	*/
	@Override
	public long getCompanyId() {
		return _repository.getCompanyId();
	}

	/**
	* Returns the group ID of this repository.
	*
	* @return the group ID of this repository
	*/
	@Override
	public long getGroupId() {
		return _repository.getGroupId();
	}

	/**
	* Returns the primary key of this repository.
	*
	* @return the primary key of this repository
	*/
	@Override
	public long getPrimaryKey() {
		return _repository.getPrimaryKey();
	}

	/**
	* Returns the repository ID of this repository.
	*
	* @return the repository ID of this repository
	*/
	@Override
	public long getRepositoryId() {
		return _repository.getRepositoryId();
	}

	/**
	* Returns the user ID of this repository.
	*
	* @return the user ID of this repository
	*/
	@Override
	public long getUserId() {
		return _repository.getUserId();
	}

	@Override
	public void persist() {
		_repository.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_repository.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this repository.
	*
	* @param companyId the company ID of this repository
	*/
	@Override
	public void setCompanyId(long companyId) {
		_repository.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this repository.
	*
	* @param createDate the create date of this repository
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_repository.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_repository.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_repository.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_repository.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this repository.
	*
	* @param groupId the group ID of this repository
	*/
	@Override
	public void setGroupId(long groupId) {
		_repository.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this repository.
	*
	* @param modifiedDate the modified date of this repository
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_repository.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_repository.setNew(n);
	}

	/**
	* Sets the primary key of this repository.
	*
	* @param primaryKey the primary key of this repository
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_repository.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_repository.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the repository ID of this repository.
	*
	* @param repositoryId the repository ID of this repository
	*/
	@Override
	public void setRepositoryId(long repositoryId) {
		_repository.setRepositoryId(repositoryId);
	}

	/**
	* Sets the repository name of this repository.
	*
	* @param repositoryName the repository name of this repository
	*/
	@Override
	public void setRepositoryName(java.lang.String repositoryName) {
		_repository.setRepositoryName(repositoryName);
	}

	/**
	* Sets the repository password of this repository.
	*
	* @param repositoryPassword the repository password of this repository
	*/
	@Override
	public void setRepositoryPassword(java.lang.String repositoryPassword) {
		_repository.setRepositoryPassword(repositoryPassword);
	}

	/**
	* Sets the repository root url of this repository.
	*
	* @param repositoryRootUrl the repository root url of this repository
	*/
	@Override
	public void setRepositoryRootUrl(java.lang.String repositoryRootUrl) {
		_repository.setRepositoryRootUrl(repositoryRootUrl);
	}

	/**
	* Sets the repository user name of this repository.
	*
	* @param repositoryUserName the repository user name of this repository
	*/
	@Override
	public void setRepositoryUserName(java.lang.String repositoryUserName) {
		_repository.setRepositoryUserName(repositoryUserName);
	}

	/**
	* Sets the user ID of this repository.
	*
	* @param userId the user ID of this repository
	*/
	@Override
	public void setUserId(long userId) {
		_repository.setUserId(userId);
	}

	/**
	* Sets the user name of this repository.
	*
	* @param userName the user name of this repository
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_repository.setUserName(userName);
	}

	/**
	* Sets the user uuid of this repository.
	*
	* @param userUuid the user uuid of this repository
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_repository.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RepositoryWrapper)) {
			return false;
		}

		RepositoryWrapper repositoryWrapper = (RepositoryWrapper)obj;

		if (Objects.equals(_repository, repositoryWrapper._repository)) {
			return true;
		}

		return false;
	}

	@Override
	public Repository getWrappedModel() {
		return _repository;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _repository.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _repository.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_repository.resetOriginalValues();
	}

	private final Repository _repository;
}
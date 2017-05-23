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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RepositorySoap implements Serializable {
	public static RepositorySoap toSoapModel(Repository model) {
		RepositorySoap soapModel = new RepositorySoap();

		soapModel.setRepositoryId(model.getRepositoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRepositoryName(model.getRepositoryName());
		soapModel.setRepositoryRootUrl(model.getRepositoryRootUrl());
		soapModel.setRepositoryUserName(model.getRepositoryUserName());
		soapModel.setRepositoryPassword(model.getRepositoryPassword());

		return soapModel;
	}

	public static RepositorySoap[] toSoapModels(Repository[] models) {
		RepositorySoap[] soapModels = new RepositorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RepositorySoap[][] toSoapModels(Repository[][] models) {
		RepositorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RepositorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new RepositorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RepositorySoap[] toSoapModels(List<Repository> models) {
		List<RepositorySoap> soapModels = new ArrayList<RepositorySoap>(models.size());

		for (Repository model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RepositorySoap[soapModels.size()]);
	}

	public RepositorySoap() {
	}

	public long getPrimaryKey() {
		return _repositoryId;
	}

	public void setPrimaryKey(long pk) {
		setRepositoryId(pk);
	}

	public long getRepositoryId() {
		return _repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		_repositoryId = repositoryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getRepositoryName() {
		return _repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		_repositoryName = repositoryName;
	}

	public String getRepositoryRootUrl() {
		return _repositoryRootUrl;
	}

	public void setRepositoryRootUrl(String repositoryRootUrl) {
		_repositoryRootUrl = repositoryRootUrl;
	}

	public String getRepositoryUserName() {
		return _repositoryUserName;
	}

	public void setRepositoryUserName(String repositoryUserName) {
		_repositoryUserName = repositoryUserName;
	}

	public String getRepositoryPassword() {
		return _repositoryPassword;
	}

	public void setRepositoryPassword(String repositoryPassword) {
		_repositoryPassword = repositoryPassword;
	}

	private long _repositoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _repositoryName;
	private String _repositoryRootUrl;
	private String _repositoryUserName;
	private String _repositoryPassword;
}
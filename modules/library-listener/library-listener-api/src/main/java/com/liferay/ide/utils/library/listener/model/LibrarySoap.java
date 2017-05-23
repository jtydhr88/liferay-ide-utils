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
public class LibrarySoap implements Serializable {
	public static LibrarySoap toSoapModel(Library model) {
		LibrarySoap soapModel = new LibrarySoap();

		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRepositoryId(model.getRepositoryId());
		soapModel.setLibraryGroupId(model.getLibraryGroupId());
		soapModel.setLibraryArtifactId(model.getLibraryArtifactId());
		soapModel.setLatestVersion(model.getLatestVersion());
		soapModel.setLastUpdated(model.getLastUpdated());
		soapModel.setCurrentVersion(model.getCurrentVersion());

		return soapModel;
	}

	public static LibrarySoap[] toSoapModels(Library[] models) {
		LibrarySoap[] soapModels = new LibrarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LibrarySoap[][] toSoapModels(Library[][] models) {
		LibrarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LibrarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LibrarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LibrarySoap[] toSoapModels(List<Library> models) {
		List<LibrarySoap> soapModels = new ArrayList<LibrarySoap>(models.size());

		for (Library model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LibrarySoap[soapModels.size()]);
	}

	public LibrarySoap() {
	}

	public long getPrimaryKey() {
		return _libraryId;
	}

	public void setPrimaryKey(long pk) {
		setLibraryId(pk);
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
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

	public long getRepositoryId() {
		return _repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		_repositoryId = repositoryId;
	}

	public String getLibraryGroupId() {
		return _libraryGroupId;
	}

	public void setLibraryGroupId(String libraryGroupId) {
		_libraryGroupId = libraryGroupId;
	}

	public String getLibraryArtifactId() {
		return _libraryArtifactId;
	}

	public void setLibraryArtifactId(String libraryArtifactId) {
		_libraryArtifactId = libraryArtifactId;
	}

	public String getLatestVersion() {
		return _latestVersion;
	}

	public void setLatestVersion(String latestVersion) {
		_latestVersion = latestVersion;
	}

	public String getLastUpdated() {
		return _lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		_lastUpdated = lastUpdated;
	}

	public String getCurrentVersion() {
		return _currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		_currentVersion = currentVersion;
	}

	private long _libraryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _repositoryId;
	private String _libraryGroupId;
	private String _libraryArtifactId;
	private String _latestVersion;
	private String _lastUpdated;
	private String _currentVersion;
}
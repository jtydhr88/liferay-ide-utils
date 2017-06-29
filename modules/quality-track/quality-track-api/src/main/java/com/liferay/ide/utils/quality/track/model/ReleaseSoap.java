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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Terry Jia
 * @generated
 */
@ProviderType
public class ReleaseSoap implements Serializable {
	public static ReleaseSoap toSoapModel(Release model) {
		ReleaseSoap soapModel = new ReleaseSoap();

		soapModel.setReleaseId(model.getReleaseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setReleaseName(model.getReleaseName());
		soapModel.setReleaseDate(model.getReleaseDate());
		soapModel.setIsDefault(model.getIsDefault());

		return soapModel;
	}

	public static ReleaseSoap[] toSoapModels(Release[] models) {
		ReleaseSoap[] soapModels = new ReleaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReleaseSoap[][] toSoapModels(Release[][] models) {
		ReleaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReleaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReleaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReleaseSoap[] toSoapModels(List<Release> models) {
		List<ReleaseSoap> soapModels = new ArrayList<ReleaseSoap>(models.size());

		for (Release model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReleaseSoap[soapModels.size()]);
	}

	public ReleaseSoap() {
	}

	public long getPrimaryKey() {
		return _releaseId;
	}

	public void setPrimaryKey(long pk) {
		setReleaseId(pk);
	}

	public long getReleaseId() {
		return _releaseId;
	}

	public void setReleaseId(long releaseId) {
		_releaseId = releaseId;
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

	public String getReleaseName() {
		return _releaseName;
	}

	public void setReleaseName(String releaseName) {
		_releaseName = releaseName;
	}

	public Date getReleaseDate() {
		return _releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		_releaseDate = releaseDate;
	}

	public boolean getIsDefault() {
		return _isDefault;
	}

	public boolean isIsDefault() {
		return _isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		_isDefault = isDefault;
	}

	private long _releaseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _releaseName;
	private Date _releaseDate;
	private boolean _isDefault;
}
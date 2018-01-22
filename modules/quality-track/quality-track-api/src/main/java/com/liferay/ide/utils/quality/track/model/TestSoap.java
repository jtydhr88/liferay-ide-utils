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
public class TestSoap implements Serializable {
	public static TestSoap toSoapModel(Test model) {
		TestSoap soapModel = new TestSoap();

		soapModel.setTestId(model.getTestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setReleaseId(model.getReleaseId());
		soapModel.setTestCaseId(model.getTestCaseId());
		soapModel.setActualResults(model.getActualResults());
		soapModel.setJiraLink(model.getJiraLink());
		soapModel.setTime(model.getTime());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static TestSoap[] toSoapModels(Test[] models) {
		TestSoap[] soapModels = new TestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TestSoap[][] toSoapModels(Test[][] models) {
		TestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TestSoap[] toSoapModels(List<Test> models) {
		List<TestSoap> soapModels = new ArrayList<TestSoap>(models.size());

		for (Test model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TestSoap[soapModels.size()]);
	}

	public TestSoap() {
	}

	public long getPrimaryKey() {
		return _testId;
	}

	public void setPrimaryKey(long pk) {
		setTestId(pk);
	}

	public long getTestId() {
		return _testId;
	}

	public void setTestId(long testId) {
		_testId = testId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getReleaseId() {
		return _releaseId;
	}

	public void setReleaseId(long releaseId) {
		_releaseId = releaseId;
	}

	public long getTestCaseId() {
		return _testCaseId;
	}

	public void setTestCaseId(long testCaseId) {
		_testCaseId = testCaseId;
	}

	public String getActualResults() {
		return _actualResults;
	}

	public void setActualResults(String actualResults) {
		_actualResults = actualResults;
	}

	public String getJiraLink() {
		return _jiraLink;
	}

	public void setJiraLink(String jiraLink) {
		_jiraLink = jiraLink;
	}

	public long getTime() {
		return _time;
	}

	public void setTime(long time) {
		_time = time;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private long _testId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _releaseId;
	private long _testCaseId;
	private String _actualResults;
	private String _jiraLink;
	private long _time;
	private String _comments;
}
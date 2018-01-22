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
public class TestCaseSoap implements Serializable {
	public static TestCaseSoap toSoapModel(TestCase model) {
		TestCaseSoap soapModel = new TestCaseSoap();

		soapModel.setTestCaseId(model.getTestCaseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEnvironment(model.getEnvironment());
		soapModel.setTestCaseName(model.getTestCaseName());
		soapModel.setBeforeTestCaseId(model.getBeforeTestCaseId());
		soapModel.setAutomatic(model.getAutomatic());
		soapModel.setAfterTestCaseId(model.getAfterTestCaseId());
		soapModel.setSteps(model.getSteps());
		soapModel.setCategroyId(model.getCategroyId());
		soapModel.setExpectedResults(model.getExpectedResults());
		soapModel.setComments(model.getComments());
		soapModel.setDeveloper(model.getDeveloper());
		soapModel.setDeveloperId(model.getDeveloperId());

		return soapModel;
	}

	public static TestCaseSoap[] toSoapModels(TestCase[] models) {
		TestCaseSoap[] soapModels = new TestCaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TestCaseSoap[][] toSoapModels(TestCase[][] models) {
		TestCaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TestCaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TestCaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TestCaseSoap[] toSoapModels(List<TestCase> models) {
		List<TestCaseSoap> soapModels = new ArrayList<TestCaseSoap>(models.size());

		for (TestCase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TestCaseSoap[soapModels.size()]);
	}

	public TestCaseSoap() {
	}

	public long getPrimaryKey() {
		return _testCaseId;
	}

	public void setPrimaryKey(long pk) {
		setTestCaseId(pk);
	}

	public long getTestCaseId() {
		return _testCaseId;
	}

	public void setTestCaseId(long testCaseId) {
		_testCaseId = testCaseId;
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

	public String getEnvironment() {
		return _environment;
	}

	public void setEnvironment(String environment) {
		_environment = environment;
	}

	public String getTestCaseName() {
		return _testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		_testCaseName = testCaseName;
	}

	public long getBeforeTestCaseId() {
		return _beforeTestCaseId;
	}

	public void setBeforeTestCaseId(long beforeTestCaseId) {
		_beforeTestCaseId = beforeTestCaseId;
	}

	public boolean getAutomatic() {
		return _automatic;
	}

	public boolean isAutomatic() {
		return _automatic;
	}

	public void setAutomatic(boolean automatic) {
		_automatic = automatic;
	}

	public long getAfterTestCaseId() {
		return _afterTestCaseId;
	}

	public void setAfterTestCaseId(long afterTestCaseId) {
		_afterTestCaseId = afterTestCaseId;
	}

	public String getSteps() {
		return _steps;
	}

	public void setSteps(String steps) {
		_steps = steps;
	}

	public long getCategroyId() {
		return _categroyId;
	}

	public void setCategroyId(long categroyId) {
		_categroyId = categroyId;
	}

	public String getExpectedResults() {
		return _expectedResults;
	}

	public void setExpectedResults(String expectedResults) {
		_expectedResults = expectedResults;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getDeveloper() {
		return _developer;
	}

	public void setDeveloper(String developer) {
		_developer = developer;
	}

	public long getDeveloperId() {
		return _developerId;
	}

	public void setDeveloperId(long developerId) {
		_developerId = developerId;
	}

	private long _testCaseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _environment;
	private String _testCaseName;
	private long _beforeTestCaseId;
	private boolean _automatic;
	private long _afterTestCaseId;
	private String _steps;
	private long _categroyId;
	private String _expectedResults;
	private String _comments;
	private String _developer;
	private long _developerId;
}
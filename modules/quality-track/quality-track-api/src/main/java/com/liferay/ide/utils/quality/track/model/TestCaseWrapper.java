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
 * This class is a wrapper for {@link TestCase}.
 * </p>
 *
 * @author Terry Jia
 * @see TestCase
 * @generated
 */
@ProviderType
public class TestCaseWrapper implements TestCase, ModelWrapper<TestCase> {
	public TestCaseWrapper(TestCase testCase) {
		_testCase = testCase;
	}

	@Override
	public Class<?> getModelClass() {
		return TestCase.class;
	}

	@Override
	public String getModelClassName() {
		return TestCase.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("testCaseId", getTestCaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("environment", getEnvironment());
		attributes.put("testCaseName", getTestCaseName());
		attributes.put("beforeTestCaseId", getBeforeTestCaseId());
		attributes.put("automatic", getAutomatic());
		attributes.put("afterTestCaseId", getAfterTestCaseId());
		attributes.put("steps", getSteps());
		attributes.put("categroyId", getCategroyId());
		attributes.put("expectedResults", getExpectedResults());
		attributes.put("developer", getDeveloper());
		attributes.put("developerId", getDeveloperId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long testCaseId = (Long)attributes.get("testCaseId");

		if (testCaseId != null) {
			setTestCaseId(testCaseId);
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

		String environment = (String)attributes.get("environment");

		if (environment != null) {
			setEnvironment(environment);
		}

		String testCaseName = (String)attributes.get("testCaseName");

		if (testCaseName != null) {
			setTestCaseName(testCaseName);
		}

		Long beforeTestCaseId = (Long)attributes.get("beforeTestCaseId");

		if (beforeTestCaseId != null) {
			setBeforeTestCaseId(beforeTestCaseId);
		}

		Boolean automatic = (Boolean)attributes.get("automatic");

		if (automatic != null) {
			setAutomatic(automatic);
		}

		Long afterTestCaseId = (Long)attributes.get("afterTestCaseId");

		if (afterTestCaseId != null) {
			setAfterTestCaseId(afterTestCaseId);
		}

		String steps = (String)attributes.get("steps");

		if (steps != null) {
			setSteps(steps);
		}

		Long categroyId = (Long)attributes.get("categroyId");

		if (categroyId != null) {
			setCategroyId(categroyId);
		}

		String expectedResults = (String)attributes.get("expectedResults");

		if (expectedResults != null) {
			setExpectedResults(expectedResults);
		}

		String developer = (String)attributes.get("developer");

		if (developer != null) {
			setDeveloper(developer);
		}

		Long developerId = (Long)attributes.get("developerId");

		if (developerId != null) {
			setDeveloperId(developerId);
		}
	}

	@Override
	public TestCase toEscapedModel() {
		return new TestCaseWrapper(_testCase.toEscapedModel());
	}

	@Override
	public TestCase toUnescapedModel() {
		return new TestCaseWrapper(_testCase.toUnescapedModel());
	}

	/**
	* Returns the automatic of this test case.
	*
	* @return the automatic of this test case
	*/
	@Override
	public boolean getAutomatic() {
		return _testCase.getAutomatic();
	}

	/**
	* Returns <code>true</code> if this test case is automatic.
	*
	* @return <code>true</code> if this test case is automatic; <code>false</code> otherwise
	*/
	@Override
	public boolean isAutomatic() {
		return _testCase.isAutomatic();
	}

	@Override
	public boolean isCachedModel() {
		return _testCase.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _testCase.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _testCase.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _testCase.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TestCase> toCacheModel() {
		return _testCase.toCacheModel();
	}

	@Override
	public int compareTo(TestCase testCase) {
		return _testCase.compareTo(testCase);
	}

	@Override
	public int hashCode() {
		return _testCase.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _testCase.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TestCaseWrapper((TestCase)_testCase.clone());
	}

	/**
	* Returns the developer of this test case.
	*
	* @return the developer of this test case
	*/
	@Override
	public java.lang.String getDeveloper() {
		return _testCase.getDeveloper();
	}

	/**
	* Returns the environment of this test case.
	*
	* @return the environment of this test case
	*/
	@Override
	public java.lang.String getEnvironment() {
		return _testCase.getEnvironment();
	}

	/**
	* Returns the expected results of this test case.
	*
	* @return the expected results of this test case
	*/
	@Override
	public java.lang.String getExpectedResults() {
		return _testCase.getExpectedResults();
	}

	/**
	* Returns the steps of this test case.
	*
	* @return the steps of this test case
	*/
	@Override
	public java.lang.String getSteps() {
		return _testCase.getSteps();
	}

	/**
	* Returns the test case name of this test case.
	*
	* @return the test case name of this test case
	*/
	@Override
	public java.lang.String getTestCaseName() {
		return _testCase.getTestCaseName();
	}

	/**
	* Returns the user name of this test case.
	*
	* @return the user name of this test case
	*/
	@Override
	public java.lang.String getUserName() {
		return _testCase.getUserName();
	}

	/**
	* Returns the user uuid of this test case.
	*
	* @return the user uuid of this test case
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _testCase.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _testCase.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _testCase.toXmlString();
	}

	/**
	* Returns the create date of this test case.
	*
	* @return the create date of this test case
	*/
	@Override
	public Date getCreateDate() {
		return _testCase.getCreateDate();
	}

	/**
	* Returns the modified date of this test case.
	*
	* @return the modified date of this test case
	*/
	@Override
	public Date getModifiedDate() {
		return _testCase.getModifiedDate();
	}

	/**
	* Returns the after test case ID of this test case.
	*
	* @return the after test case ID of this test case
	*/
	@Override
	public long getAfterTestCaseId() {
		return _testCase.getAfterTestCaseId();
	}

	/**
	* Returns the before test case ID of this test case.
	*
	* @return the before test case ID of this test case
	*/
	@Override
	public long getBeforeTestCaseId() {
		return _testCase.getBeforeTestCaseId();
	}

	/**
	* Returns the categroy ID of this test case.
	*
	* @return the categroy ID of this test case
	*/
	@Override
	public long getCategroyId() {
		return _testCase.getCategroyId();
	}

	/**
	* Returns the company ID of this test case.
	*
	* @return the company ID of this test case
	*/
	@Override
	public long getCompanyId() {
		return _testCase.getCompanyId();
	}

	/**
	* Returns the developer ID of this test case.
	*
	* @return the developer ID of this test case
	*/
	@Override
	public long getDeveloperId() {
		return _testCase.getDeveloperId();
	}

	/**
	* Returns the group ID of this test case.
	*
	* @return the group ID of this test case
	*/
	@Override
	public long getGroupId() {
		return _testCase.getGroupId();
	}

	/**
	* Returns the primary key of this test case.
	*
	* @return the primary key of this test case
	*/
	@Override
	public long getPrimaryKey() {
		return _testCase.getPrimaryKey();
	}

	/**
	* Returns the test case ID of this test case.
	*
	* @return the test case ID of this test case
	*/
	@Override
	public long getTestCaseId() {
		return _testCase.getTestCaseId();
	}

	/**
	* Returns the user ID of this test case.
	*
	* @return the user ID of this test case
	*/
	@Override
	public long getUserId() {
		return _testCase.getUserId();
	}

	@Override
	public void persist() {
		_testCase.persist();
	}

	/**
	* Sets the after test case ID of this test case.
	*
	* @param afterTestCaseId the after test case ID of this test case
	*/
	@Override
	public void setAfterTestCaseId(long afterTestCaseId) {
		_testCase.setAfterTestCaseId(afterTestCaseId);
	}

	/**
	* Sets whether this test case is automatic.
	*
	* @param automatic the automatic of this test case
	*/
	@Override
	public void setAutomatic(boolean automatic) {
		_testCase.setAutomatic(automatic);
	}

	/**
	* Sets the before test case ID of this test case.
	*
	* @param beforeTestCaseId the before test case ID of this test case
	*/
	@Override
	public void setBeforeTestCaseId(long beforeTestCaseId) {
		_testCase.setBeforeTestCaseId(beforeTestCaseId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_testCase.setCachedModel(cachedModel);
	}

	/**
	* Sets the categroy ID of this test case.
	*
	* @param categroyId the categroy ID of this test case
	*/
	@Override
	public void setCategroyId(long categroyId) {
		_testCase.setCategroyId(categroyId);
	}

	/**
	* Sets the company ID of this test case.
	*
	* @param companyId the company ID of this test case
	*/
	@Override
	public void setCompanyId(long companyId) {
		_testCase.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this test case.
	*
	* @param createDate the create date of this test case
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_testCase.setCreateDate(createDate);
	}

	/**
	* Sets the developer of this test case.
	*
	* @param developer the developer of this test case
	*/
	@Override
	public void setDeveloper(java.lang.String developer) {
		_testCase.setDeveloper(developer);
	}

	/**
	* Sets the developer ID of this test case.
	*
	* @param developerId the developer ID of this test case
	*/
	@Override
	public void setDeveloperId(long developerId) {
		_testCase.setDeveloperId(developerId);
	}

	/**
	* Sets the environment of this test case.
	*
	* @param environment the environment of this test case
	*/
	@Override
	public void setEnvironment(java.lang.String environment) {
		_testCase.setEnvironment(environment);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_testCase.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_testCase.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_testCase.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the expected results of this test case.
	*
	* @param expectedResults the expected results of this test case
	*/
	@Override
	public void setExpectedResults(java.lang.String expectedResults) {
		_testCase.setExpectedResults(expectedResults);
	}

	/**
	* Sets the group ID of this test case.
	*
	* @param groupId the group ID of this test case
	*/
	@Override
	public void setGroupId(long groupId) {
		_testCase.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this test case.
	*
	* @param modifiedDate the modified date of this test case
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_testCase.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_testCase.setNew(n);
	}

	/**
	* Sets the primary key of this test case.
	*
	* @param primaryKey the primary key of this test case
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_testCase.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_testCase.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the steps of this test case.
	*
	* @param steps the steps of this test case
	*/
	@Override
	public void setSteps(java.lang.String steps) {
		_testCase.setSteps(steps);
	}

	/**
	* Sets the test case ID of this test case.
	*
	* @param testCaseId the test case ID of this test case
	*/
	@Override
	public void setTestCaseId(long testCaseId) {
		_testCase.setTestCaseId(testCaseId);
	}

	/**
	* Sets the test case name of this test case.
	*
	* @param testCaseName the test case name of this test case
	*/
	@Override
	public void setTestCaseName(java.lang.String testCaseName) {
		_testCase.setTestCaseName(testCaseName);
	}

	/**
	* Sets the user ID of this test case.
	*
	* @param userId the user ID of this test case
	*/
	@Override
	public void setUserId(long userId) {
		_testCase.setUserId(userId);
	}

	/**
	* Sets the user name of this test case.
	*
	* @param userName the user name of this test case
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_testCase.setUserName(userName);
	}

	/**
	* Sets the user uuid of this test case.
	*
	* @param userUuid the user uuid of this test case
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_testCase.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestCaseWrapper)) {
			return false;
		}

		TestCaseWrapper testCaseWrapper = (TestCaseWrapper)obj;

		if (Objects.equals(_testCase, testCaseWrapper._testCase)) {
			return true;
		}

		return false;
	}

	@Override
	public TestCase getWrappedModel() {
		return _testCase;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _testCase.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _testCase.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_testCase.resetOriginalValues();
	}

	private final TestCase _testCase;
}
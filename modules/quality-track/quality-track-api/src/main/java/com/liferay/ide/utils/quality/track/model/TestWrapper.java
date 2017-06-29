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
 * This class is a wrapper for {@link Test}.
 * </p>
 *
 * @author Terry Jia
 * @see Test
 * @generated
 */
@ProviderType
public class TestWrapper implements Test, ModelWrapper<Test> {
	public TestWrapper(Test test) {
		_test = test;
	}

	@Override
	public Class<?> getModelClass() {
		return Test.class;
	}

	@Override
	public String getModelClassName() {
		return Test.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("testId", getTestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("releaseId", getReleaseId());
		attributes.put("testCaseId", getTestCaseId());
		attributes.put("actualResults", getActualResults());
		attributes.put("jiraLink", getJiraLink());
		attributes.put("time", getTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long testId = (Long)attributes.get("testId");

		if (testId != null) {
			setTestId(testId);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long releaseId = (Long)attributes.get("releaseId");

		if (releaseId != null) {
			setReleaseId(releaseId);
		}

		Long testCaseId = (Long)attributes.get("testCaseId");

		if (testCaseId != null) {
			setTestCaseId(testCaseId);
		}

		String actualResults = (String)attributes.get("actualResults");

		if (actualResults != null) {
			setActualResults(actualResults);
		}

		String jiraLink = (String)attributes.get("jiraLink");

		if (jiraLink != null) {
			setJiraLink(jiraLink);
		}

		Long time = (Long)attributes.get("time");

		if (time != null) {
			setTime(time);
		}
	}

	@Override
	public Test toEscapedModel() {
		return new TestWrapper(_test.toEscapedModel());
	}

	@Override
	public Test toUnescapedModel() {
		return new TestWrapper(_test.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this test is approved.
	*
	* @return <code>true</code> if this test is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _test.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _test.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this test is denied.
	*
	* @return <code>true</code> if this test is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _test.isDenied();
	}

	/**
	* Returns <code>true</code> if this test is a draft.
	*
	* @return <code>true</code> if this test is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _test.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _test.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this test is expired.
	*
	* @return <code>true</code> if this test is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _test.isExpired();
	}

	/**
	* Returns <code>true</code> if this test is inactive.
	*
	* @return <code>true</code> if this test is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _test.isInactive();
	}

	/**
	* Returns <code>true</code> if this test is incomplete.
	*
	* @return <code>true</code> if this test is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _test.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _test.isNew();
	}

	/**
	* Returns <code>true</code> if this test is pending.
	*
	* @return <code>true</code> if this test is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _test.isPending();
	}

	/**
	* Returns <code>true</code> if this test is scheduled.
	*
	* @return <code>true</code> if this test is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _test.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _test.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Test> toCacheModel() {
		return _test.toCacheModel();
	}

	@Override
	public int compareTo(Test test) {
		return _test.compareTo(test);
	}

	/**
	* Returns the status of this test.
	*
	* @return the status of this test
	*/
	@Override
	public int getStatus() {
		return _test.getStatus();
	}

	@Override
	public int hashCode() {
		return _test.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _test.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TestWrapper((Test)_test.clone());
	}

	/**
	* Returns the actual results of this test.
	*
	* @return the actual results of this test
	*/
	@Override
	public java.lang.String getActualResults() {
		return _test.getActualResults();
	}

	/**
	* Returns the jira link of this test.
	*
	* @return the jira link of this test
	*/
	@Override
	public java.lang.String getJiraLink() {
		return _test.getJiraLink();
	}

	/**
	* Returns the status by user name of this test.
	*
	* @return the status by user name of this test
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _test.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this test.
	*
	* @return the status by user uuid of this test
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _test.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this test.
	*
	* @return the user name of this test
	*/
	@Override
	public java.lang.String getUserName() {
		return _test.getUserName();
	}

	/**
	* Returns the user uuid of this test.
	*
	* @return the user uuid of this test
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _test.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _test.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _test.toXmlString();
	}

	/**
	* Returns the create date of this test.
	*
	* @return the create date of this test
	*/
	@Override
	public Date getCreateDate() {
		return _test.getCreateDate();
	}

	/**
	* Returns the modified date of this test.
	*
	* @return the modified date of this test
	*/
	@Override
	public Date getModifiedDate() {
		return _test.getModifiedDate();
	}

	/**
	* Returns the status date of this test.
	*
	* @return the status date of this test
	*/
	@Override
	public Date getStatusDate() {
		return _test.getStatusDate();
	}

	/**
	* Returns the company ID of this test.
	*
	* @return the company ID of this test
	*/
	@Override
	public long getCompanyId() {
		return _test.getCompanyId();
	}

	/**
	* Returns the group ID of this test.
	*
	* @return the group ID of this test
	*/
	@Override
	public long getGroupId() {
		return _test.getGroupId();
	}

	/**
	* Returns the primary key of this test.
	*
	* @return the primary key of this test
	*/
	@Override
	public long getPrimaryKey() {
		return _test.getPrimaryKey();
	}

	/**
	* Returns the release ID of this test.
	*
	* @return the release ID of this test
	*/
	@Override
	public long getReleaseId() {
		return _test.getReleaseId();
	}

	/**
	* Returns the status by user ID of this test.
	*
	* @return the status by user ID of this test
	*/
	@Override
	public long getStatusByUserId() {
		return _test.getStatusByUserId();
	}

	/**
	* Returns the test case ID of this test.
	*
	* @return the test case ID of this test
	*/
	@Override
	public long getTestCaseId() {
		return _test.getTestCaseId();
	}

	/**
	* Returns the test ID of this test.
	*
	* @return the test ID of this test
	*/
	@Override
	public long getTestId() {
		return _test.getTestId();
	}

	/**
	* Returns the time of this test.
	*
	* @return the time of this test
	*/
	@Override
	public long getTime() {
		return _test.getTime();
	}

	/**
	* Returns the user ID of this test.
	*
	* @return the user ID of this test
	*/
	@Override
	public long getUserId() {
		return _test.getUserId();
	}

	@Override
	public void persist() {
		_test.persist();
	}

	/**
	* Sets the actual results of this test.
	*
	* @param actualResults the actual results of this test
	*/
	@Override
	public void setActualResults(java.lang.String actualResults) {
		_test.setActualResults(actualResults);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_test.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this test.
	*
	* @param companyId the company ID of this test
	*/
	@Override
	public void setCompanyId(long companyId) {
		_test.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this test.
	*
	* @param createDate the create date of this test
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_test.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_test.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_test.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_test.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this test.
	*
	* @param groupId the group ID of this test
	*/
	@Override
	public void setGroupId(long groupId) {
		_test.setGroupId(groupId);
	}

	/**
	* Sets the jira link of this test.
	*
	* @param jiraLink the jira link of this test
	*/
	@Override
	public void setJiraLink(java.lang.String jiraLink) {
		_test.setJiraLink(jiraLink);
	}

	/**
	* Sets the modified date of this test.
	*
	* @param modifiedDate the modified date of this test
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_test.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_test.setNew(n);
	}

	/**
	* Sets the primary key of this test.
	*
	* @param primaryKey the primary key of this test
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_test.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_test.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the release ID of this test.
	*
	* @param releaseId the release ID of this test
	*/
	@Override
	public void setReleaseId(long releaseId) {
		_test.setReleaseId(releaseId);
	}

	/**
	* Sets the status of this test.
	*
	* @param status the status of this test
	*/
	@Override
	public void setStatus(int status) {
		_test.setStatus(status);
	}

	/**
	* Sets the status by user ID of this test.
	*
	* @param statusByUserId the status by user ID of this test
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_test.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this test.
	*
	* @param statusByUserName the status by user name of this test
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_test.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this test.
	*
	* @param statusByUserUuid the status by user uuid of this test
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_test.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this test.
	*
	* @param statusDate the status date of this test
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_test.setStatusDate(statusDate);
	}

	/**
	* Sets the test case ID of this test.
	*
	* @param testCaseId the test case ID of this test
	*/
	@Override
	public void setTestCaseId(long testCaseId) {
		_test.setTestCaseId(testCaseId);
	}

	/**
	* Sets the test ID of this test.
	*
	* @param testId the test ID of this test
	*/
	@Override
	public void setTestId(long testId) {
		_test.setTestId(testId);
	}

	/**
	* Sets the time of this test.
	*
	* @param time the time of this test
	*/
	@Override
	public void setTime(long time) {
		_test.setTime(time);
	}

	/**
	* Sets the user ID of this test.
	*
	* @param userId the user ID of this test
	*/
	@Override
	public void setUserId(long userId) {
		_test.setUserId(userId);
	}

	/**
	* Sets the user name of this test.
	*
	* @param userName the user name of this test
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_test.setUserName(userName);
	}

	/**
	* Sets the user uuid of this test.
	*
	* @param userUuid the user uuid of this test
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_test.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestWrapper)) {
			return false;
		}

		TestWrapper testWrapper = (TestWrapper)obj;

		if (Objects.equals(_test, testWrapper._test)) {
			return true;
		}

		return false;
	}

	@Override
	public Test getWrappedModel() {
		return _test;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _test.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _test.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_test.resetOriginalValues();
	}

	private final Test _test;
}
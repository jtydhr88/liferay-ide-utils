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

package com.liferay.ide.utils.quality.track.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.ide.utils.quality.track.model.Test;
import com.liferay.ide.utils.quality.track.model.TestModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Test service. Represents a row in the &quot;qualitytrack_Test&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TestModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TestImpl}.
 * </p>
 *
 * @author Terry Jia
 * @see TestImpl
 * @see Test
 * @see TestModel
 * @generated
 */
@ProviderType
public class TestModelImpl extends BaseModelImpl<Test> implements TestModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a test model instance should use the {@link Test} interface instead.
	 */
	public static final String TABLE_NAME = "qualitytrack_Test";
	public static final Object[][] TABLE_COLUMNS = {
			{ "testId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "releaseId", Types.BIGINT },
			{ "testCaseId", Types.BIGINT },
			{ "actualResults", Types.VARCHAR },
			{ "jiraLink", Types.VARCHAR },
			{ "time_", Types.BIGINT },
			{ "comments", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("testId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("releaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("testCaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("actualResults", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jiraLink", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("time_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("comments", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table qualitytrack_Test (testId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,releaseId LONG,testCaseId LONG,actualResults VARCHAR(75) null,jiraLink VARCHAR(75) null,time_ LONG,comments VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table qualitytrack_Test";
	public static final String ORDER_BY_JPQL = " ORDER BY test.testId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY qualitytrack_Test.testId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(quality.track.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.ide.utils.quality.track.model.Test"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(quality.track.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.ide.utils.quality.track.model.Test"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(quality.track.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.ide.utils.quality.track.model.Test"));

	public TestModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _testId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _testId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("comments", getComments());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public long getTestId() {
		return _testId;
	}

	@Override
	public void setTestId(long testId) {
		_testId = testId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public long getReleaseId() {
		return _releaseId;
	}

	@Override
	public void setReleaseId(long releaseId) {
		_releaseId = releaseId;
	}

	@Override
	public long getTestCaseId() {
		return _testCaseId;
	}

	@Override
	public void setTestCaseId(long testCaseId) {
		_testCaseId = testCaseId;
	}

	@Override
	public String getActualResults() {
		if (_actualResults == null) {
			return StringPool.BLANK;
		}
		else {
			return _actualResults;
		}
	}

	@Override
	public void setActualResults(String actualResults) {
		_actualResults = actualResults;
	}

	@Override
	public String getJiraLink() {
		if (_jiraLink == null) {
			return StringPool.BLANK;
		}
		else {
			return _jiraLink;
		}
	}

	@Override
	public void setJiraLink(String jiraLink) {
		_jiraLink = jiraLink;
	}

	@Override
	public long getTime() {
		return _time;
	}

	@Override
	public void setTime(long time) {
		_time = time;
	}

	@Override
	public String getComments() {
		if (_comments == null) {
			return StringPool.BLANK;
		}
		else {
			return _comments;
		}
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Test.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Test toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Test)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TestImpl testImpl = new TestImpl();

		testImpl.setTestId(getTestId());
		testImpl.setGroupId(getGroupId());
		testImpl.setCompanyId(getCompanyId());
		testImpl.setUserId(getUserId());
		testImpl.setUserName(getUserName());
		testImpl.setCreateDate(getCreateDate());
		testImpl.setModifiedDate(getModifiedDate());
		testImpl.setStatus(getStatus());
		testImpl.setStatusByUserId(getStatusByUserId());
		testImpl.setStatusByUserName(getStatusByUserName());
		testImpl.setStatusDate(getStatusDate());
		testImpl.setReleaseId(getReleaseId());
		testImpl.setTestCaseId(getTestCaseId());
		testImpl.setActualResults(getActualResults());
		testImpl.setJiraLink(getJiraLink());
		testImpl.setTime(getTime());
		testImpl.setComments(getComments());

		testImpl.resetOriginalValues();

		return testImpl;
	}

	@Override
	public int compareTo(Test test) {
		long primaryKey = test.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Test)) {
			return false;
		}

		Test test = (Test)obj;

		long primaryKey = test.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TestModelImpl testModelImpl = this;

		testModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<Test> toCacheModel() {
		TestCacheModel testCacheModel = new TestCacheModel();

		testCacheModel.testId = getTestId();

		testCacheModel.groupId = getGroupId();

		testCacheModel.companyId = getCompanyId();

		testCacheModel.userId = getUserId();

		testCacheModel.userName = getUserName();

		String userName = testCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			testCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			testCacheModel.createDate = createDate.getTime();
		}
		else {
			testCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			testCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			testCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		testCacheModel.status = getStatus();

		testCacheModel.statusByUserId = getStatusByUserId();

		testCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = testCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			testCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			testCacheModel.statusDate = statusDate.getTime();
		}
		else {
			testCacheModel.statusDate = Long.MIN_VALUE;
		}

		testCacheModel.releaseId = getReleaseId();

		testCacheModel.testCaseId = getTestCaseId();

		testCacheModel.actualResults = getActualResults();

		String actualResults = testCacheModel.actualResults;

		if ((actualResults != null) && (actualResults.length() == 0)) {
			testCacheModel.actualResults = null;
		}

		testCacheModel.jiraLink = getJiraLink();

		String jiraLink = testCacheModel.jiraLink;

		if ((jiraLink != null) && (jiraLink.length() == 0)) {
			testCacheModel.jiraLink = null;
		}

		testCacheModel.time = getTime();

		testCacheModel.comments = getComments();

		String comments = testCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			testCacheModel.comments = null;
		}

		return testCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{testId=");
		sb.append(getTestId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", releaseId=");
		sb.append(getReleaseId());
		sb.append(", testCaseId=");
		sb.append(getTestCaseId());
		sb.append(", actualResults=");
		sb.append(getActualResults());
		sb.append(", jiraLink=");
		sb.append(getJiraLink());
		sb.append(", time=");
		sb.append(getTime());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.liferay.ide.utils.quality.track.model.Test");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>testId</column-name><column-value><![CDATA[");
		sb.append(getTestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releaseId</column-name><column-value><![CDATA[");
		sb.append(getReleaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testCaseId</column-name><column-value><![CDATA[");
		sb.append(getTestCaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actualResults</column-name><column-value><![CDATA[");
		sb.append(getActualResults());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraLink</column-name><column-value><![CDATA[");
		sb.append(getJiraLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Test.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Test.class
		};
	private long _testId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
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
	private Test _escapedModel;
}
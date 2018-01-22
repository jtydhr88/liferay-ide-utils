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

import com.liferay.ide.utils.quality.track.model.TestCase;
import com.liferay.ide.utils.quality.track.model.TestCaseModel;

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

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TestCase service. Represents a row in the &quot;qualitytrack_TestCase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TestCaseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TestCaseImpl}.
 * </p>
 *
 * @author Terry Jia
 * @see TestCaseImpl
 * @see TestCase
 * @see TestCaseModel
 * @generated
 */
@ProviderType
public class TestCaseModelImpl extends BaseModelImpl<TestCase>
	implements TestCaseModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a test case model instance should use the {@link TestCase} interface instead.
	 */
	public static final String TABLE_NAME = "qualitytrack_TestCase";
	public static final Object[][] TABLE_COLUMNS = {
			{ "testCaseId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "environment", Types.VARCHAR },
			{ "testCaseName", Types.VARCHAR },
			{ "beforeTestCaseId", Types.BIGINT },
			{ "automatic", Types.BOOLEAN },
			{ "afterTestCaseId", Types.BIGINT },
			{ "steps", Types.VARCHAR },
			{ "categroyId", Types.BIGINT },
			{ "expectedResults", Types.VARCHAR },
			{ "comments", Types.VARCHAR },
			{ "developer", Types.VARCHAR },
			{ "developerId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("testCaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("environment", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("testCaseName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("beforeTestCaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("automatic", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("afterTestCaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("steps", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("categroyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("expectedResults", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("comments", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("developer", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("developerId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table qualitytrack_TestCase (testCaseId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,environment VARCHAR(75) null,testCaseName VARCHAR(75) null,beforeTestCaseId LONG,automatic BOOLEAN,afterTestCaseId LONG,steps STRING null,categroyId LONG,expectedResults STRING null,comments VARCHAR(75) null,developer VARCHAR(75) null,developerId LONG)";
	public static final String TABLE_SQL_DROP = "drop table qualitytrack_TestCase";
	public static final String ORDER_BY_JPQL = " ORDER BY testCase.testCaseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY qualitytrack_TestCase.testCaseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(quality.track.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.ide.utils.quality.track.model.TestCase"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(quality.track.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.ide.utils.quality.track.model.TestCase"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final String MAPPING_TABLE_QUALITYTRACK_TESTCASES_RELEASES_NAME =
		"qualitytrack_TestCases_Releases";
	public static final Object[][] MAPPING_TABLE_QUALITYTRACK_TESTCASES_RELEASES_COLUMNS =
		{
			{ "companyId", Types.BIGINT },
			{ "releaseId", Types.BIGINT },
			{ "testCaseId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_QUALITYTRACK_TESTCASES_RELEASES_SQL_CREATE =
		"create table qualitytrack_TestCases_Releases (companyId LONG not null,releaseId LONG not null,testCaseId LONG not null,primary key (releaseId, testCaseId))";
	public static final boolean FINDER_CACHE_ENABLED_QUALITYTRACK_TESTCASES_RELEASES =
		GetterUtil.getBoolean(quality.track.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.qualitytrack_TestCases_Releases"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(quality.track.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.ide.utils.quality.track.model.TestCase"));

	public TestCaseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _testCaseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTestCaseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _testCaseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("comments", getComments());
		attributes.put("developer", getDeveloper());
		attributes.put("developerId", getDeveloperId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
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
	public long getTestCaseId() {
		return _testCaseId;
	}

	@Override
	public void setTestCaseId(long testCaseId) {
		_testCaseId = testCaseId;
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
	public String getEnvironment() {
		if (_environment == null) {
			return StringPool.BLANK;
		}
		else {
			return _environment;
		}
	}

	@Override
	public void setEnvironment(String environment) {
		_environment = environment;
	}

	@Override
	public String getTestCaseName() {
		if (_testCaseName == null) {
			return StringPool.BLANK;
		}
		else {
			return _testCaseName;
		}
	}

	@Override
	public void setTestCaseName(String testCaseName) {
		_testCaseName = testCaseName;
	}

	@Override
	public long getBeforeTestCaseId() {
		return _beforeTestCaseId;
	}

	@Override
	public void setBeforeTestCaseId(long beforeTestCaseId) {
		_beforeTestCaseId = beforeTestCaseId;
	}

	@Override
	public boolean getAutomatic() {
		return _automatic;
	}

	@Override
	public boolean isAutomatic() {
		return _automatic;
	}

	@Override
	public void setAutomatic(boolean automatic) {
		_automatic = automatic;
	}

	@Override
	public long getAfterTestCaseId() {
		return _afterTestCaseId;
	}

	@Override
	public void setAfterTestCaseId(long afterTestCaseId) {
		_afterTestCaseId = afterTestCaseId;
	}

	@Override
	public String getSteps() {
		if (_steps == null) {
			return StringPool.BLANK;
		}
		else {
			return _steps;
		}
	}

	@Override
	public void setSteps(String steps) {
		_steps = steps;
	}

	@Override
	public long getCategroyId() {
		return _categroyId;
	}

	@Override
	public void setCategroyId(long categroyId) {
		_categroyId = categroyId;
	}

	@Override
	public String getExpectedResults() {
		if (_expectedResults == null) {
			return StringPool.BLANK;
		}
		else {
			return _expectedResults;
		}
	}

	@Override
	public void setExpectedResults(String expectedResults) {
		_expectedResults = expectedResults;
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
	public String getDeveloper() {
		if (_developer == null) {
			return StringPool.BLANK;
		}
		else {
			return _developer;
		}
	}

	@Override
	public void setDeveloper(String developer) {
		_developer = developer;
	}

	@Override
	public long getDeveloperId() {
		return _developerId;
	}

	@Override
	public void setDeveloperId(long developerId) {
		_developerId = developerId;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TestCase.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TestCase toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TestCase)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TestCaseImpl testCaseImpl = new TestCaseImpl();

		testCaseImpl.setTestCaseId(getTestCaseId());
		testCaseImpl.setGroupId(getGroupId());
		testCaseImpl.setCompanyId(getCompanyId());
		testCaseImpl.setUserId(getUserId());
		testCaseImpl.setUserName(getUserName());
		testCaseImpl.setCreateDate(getCreateDate());
		testCaseImpl.setModifiedDate(getModifiedDate());
		testCaseImpl.setEnvironment(getEnvironment());
		testCaseImpl.setTestCaseName(getTestCaseName());
		testCaseImpl.setBeforeTestCaseId(getBeforeTestCaseId());
		testCaseImpl.setAutomatic(getAutomatic());
		testCaseImpl.setAfterTestCaseId(getAfterTestCaseId());
		testCaseImpl.setSteps(getSteps());
		testCaseImpl.setCategroyId(getCategroyId());
		testCaseImpl.setExpectedResults(getExpectedResults());
		testCaseImpl.setComments(getComments());
		testCaseImpl.setDeveloper(getDeveloper());
		testCaseImpl.setDeveloperId(getDeveloperId());

		testCaseImpl.resetOriginalValues();

		return testCaseImpl;
	}

	@Override
	public int compareTo(TestCase testCase) {
		long primaryKey = testCase.getPrimaryKey();

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

		if (!(obj instanceof TestCase)) {
			return false;
		}

		TestCase testCase = (TestCase)obj;

		long primaryKey = testCase.getPrimaryKey();

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
		TestCaseModelImpl testCaseModelImpl = this;

		testCaseModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<TestCase> toCacheModel() {
		TestCaseCacheModel testCaseCacheModel = new TestCaseCacheModel();

		testCaseCacheModel.testCaseId = getTestCaseId();

		testCaseCacheModel.groupId = getGroupId();

		testCaseCacheModel.companyId = getCompanyId();

		testCaseCacheModel.userId = getUserId();

		testCaseCacheModel.userName = getUserName();

		String userName = testCaseCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			testCaseCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			testCaseCacheModel.createDate = createDate.getTime();
		}
		else {
			testCaseCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			testCaseCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			testCaseCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		testCaseCacheModel.environment = getEnvironment();

		String environment = testCaseCacheModel.environment;

		if ((environment != null) && (environment.length() == 0)) {
			testCaseCacheModel.environment = null;
		}

		testCaseCacheModel.testCaseName = getTestCaseName();

		String testCaseName = testCaseCacheModel.testCaseName;

		if ((testCaseName != null) && (testCaseName.length() == 0)) {
			testCaseCacheModel.testCaseName = null;
		}

		testCaseCacheModel.beforeTestCaseId = getBeforeTestCaseId();

		testCaseCacheModel.automatic = getAutomatic();

		testCaseCacheModel.afterTestCaseId = getAfterTestCaseId();

		testCaseCacheModel.steps = getSteps();

		String steps = testCaseCacheModel.steps;

		if ((steps != null) && (steps.length() == 0)) {
			testCaseCacheModel.steps = null;
		}

		testCaseCacheModel.categroyId = getCategroyId();

		testCaseCacheModel.expectedResults = getExpectedResults();

		String expectedResults = testCaseCacheModel.expectedResults;

		if ((expectedResults != null) && (expectedResults.length() == 0)) {
			testCaseCacheModel.expectedResults = null;
		}

		testCaseCacheModel.comments = getComments();

		String comments = testCaseCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			testCaseCacheModel.comments = null;
		}

		testCaseCacheModel.developer = getDeveloper();

		String developer = testCaseCacheModel.developer;

		if ((developer != null) && (developer.length() == 0)) {
			testCaseCacheModel.developer = null;
		}

		testCaseCacheModel.developerId = getDeveloperId();

		return testCaseCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{testCaseId=");
		sb.append(getTestCaseId());
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
		sb.append(", environment=");
		sb.append(getEnvironment());
		sb.append(", testCaseName=");
		sb.append(getTestCaseName());
		sb.append(", beforeTestCaseId=");
		sb.append(getBeforeTestCaseId());
		sb.append(", automatic=");
		sb.append(getAutomatic());
		sb.append(", afterTestCaseId=");
		sb.append(getAfterTestCaseId());
		sb.append(", steps=");
		sb.append(getSteps());
		sb.append(", categroyId=");
		sb.append(getCategroyId());
		sb.append(", expectedResults=");
		sb.append(getExpectedResults());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", developer=");
		sb.append(getDeveloper());
		sb.append(", developerId=");
		sb.append(getDeveloperId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.liferay.ide.utils.quality.track.model.TestCase");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>testCaseId</column-name><column-value><![CDATA[");
		sb.append(getTestCaseId());
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
			"<column><column-name>environment</column-name><column-value><![CDATA[");
		sb.append(getEnvironment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testCaseName</column-name><column-value><![CDATA[");
		sb.append(getTestCaseName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beforeTestCaseId</column-name><column-value><![CDATA[");
		sb.append(getBeforeTestCaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>automatic</column-name><column-value><![CDATA[");
		sb.append(getAutomatic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>afterTestCaseId</column-name><column-value><![CDATA[");
		sb.append(getAfterTestCaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>steps</column-name><column-value><![CDATA[");
		sb.append(getSteps());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categroyId</column-name><column-value><![CDATA[");
		sb.append(getCategroyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedResults</column-name><column-value><![CDATA[");
		sb.append(getExpectedResults());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>developer</column-name><column-value><![CDATA[");
		sb.append(getDeveloper());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>developerId</column-name><column-value><![CDATA[");
		sb.append(getDeveloperId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TestCase.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TestCase.class
		};
	private long _testCaseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
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
	private TestCase _escapedModel;
}
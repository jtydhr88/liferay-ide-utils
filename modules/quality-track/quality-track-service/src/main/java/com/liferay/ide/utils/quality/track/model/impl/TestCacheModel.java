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

import com.liferay.ide.utils.quality.track.model.Test;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Test in entity cache.
 *
 * @author Terry Jia
 * @see Test
 * @generated
 */
@ProviderType
public class TestCacheModel implements CacheModel<Test>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestCacheModel)) {
			return false;
		}

		TestCacheModel testCacheModel = (TestCacheModel)obj;

		if (testId == testCacheModel.testId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, testId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{testId=");
		sb.append(testId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", releaseId=");
		sb.append(releaseId);
		sb.append(", testCaseId=");
		sb.append(testCaseId);
		sb.append(", actualResults=");
		sb.append(actualResults);
		sb.append(", jiraLink=");
		sb.append(jiraLink);
		sb.append(", time=");
		sb.append(time);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Test toEntityModel() {
		TestImpl testImpl = new TestImpl();

		testImpl.setTestId(testId);
		testImpl.setGroupId(groupId);
		testImpl.setCompanyId(companyId);
		testImpl.setUserId(userId);

		if (userName == null) {
			testImpl.setUserName(StringPool.BLANK);
		}
		else {
			testImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			testImpl.setCreateDate(null);
		}
		else {
			testImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			testImpl.setModifiedDate(null);
		}
		else {
			testImpl.setModifiedDate(new Date(modifiedDate));
		}

		testImpl.setStatus(status);
		testImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			testImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			testImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			testImpl.setStatusDate(null);
		}
		else {
			testImpl.setStatusDate(new Date(statusDate));
		}

		testImpl.setReleaseId(releaseId);
		testImpl.setTestCaseId(testCaseId);

		if (actualResults == null) {
			testImpl.setActualResults(StringPool.BLANK);
		}
		else {
			testImpl.setActualResults(actualResults);
		}

		if (jiraLink == null) {
			testImpl.setJiraLink(StringPool.BLANK);
		}
		else {
			testImpl.setJiraLink(jiraLink);
		}

		testImpl.setTime(time);

		if (comments == null) {
			testImpl.setComments(StringPool.BLANK);
		}
		else {
			testImpl.setComments(comments);
		}

		testImpl.resetOriginalValues();

		return testImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		testId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		releaseId = objectInput.readLong();

		testCaseId = objectInput.readLong();
		actualResults = objectInput.readUTF();
		jiraLink = objectInput.readUTF();

		time = objectInput.readLong();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(testId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(releaseId);

		objectOutput.writeLong(testCaseId);

		if (actualResults == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actualResults);
		}

		if (jiraLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jiraLink);
		}

		objectOutput.writeLong(time);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public long testId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long releaseId;
	public long testCaseId;
	public String actualResults;
	public String jiraLink;
	public long time;
	public String comments;
}
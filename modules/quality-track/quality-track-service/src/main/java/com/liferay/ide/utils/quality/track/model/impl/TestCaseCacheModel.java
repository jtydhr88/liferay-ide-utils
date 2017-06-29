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

import com.liferay.ide.utils.quality.track.model.TestCase;

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
 * The cache model class for representing TestCase in entity cache.
 *
 * @author Terry Jia
 * @see TestCase
 * @generated
 */
@ProviderType
public class TestCaseCacheModel implements CacheModel<TestCase>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestCaseCacheModel)) {
			return false;
		}

		TestCaseCacheModel testCaseCacheModel = (TestCaseCacheModel)obj;

		if (testCaseId == testCaseCacheModel.testCaseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, testCaseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{testCaseId=");
		sb.append(testCaseId);
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
		sb.append(", testCaseName=");
		sb.append(testCaseName);
		sb.append(", automatic=");
		sb.append(automatic);
		sb.append(", steps=");
		sb.append(steps);
		sb.append(", categroyId=");
		sb.append(categroyId);
		sb.append(", expectedResults=");
		sb.append(expectedResults);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TestCase toEntityModel() {
		TestCaseImpl testCaseImpl = new TestCaseImpl();

		testCaseImpl.setTestCaseId(testCaseId);
		testCaseImpl.setGroupId(groupId);
		testCaseImpl.setCompanyId(companyId);
		testCaseImpl.setUserId(userId);

		if (userName == null) {
			testCaseImpl.setUserName(StringPool.BLANK);
		}
		else {
			testCaseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			testCaseImpl.setCreateDate(null);
		}
		else {
			testCaseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			testCaseImpl.setModifiedDate(null);
		}
		else {
			testCaseImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (testCaseName == null) {
			testCaseImpl.setTestCaseName(StringPool.BLANK);
		}
		else {
			testCaseImpl.setTestCaseName(testCaseName);
		}

		testCaseImpl.setAutomatic(automatic);

		if (steps == null) {
			testCaseImpl.setSteps(StringPool.BLANK);
		}
		else {
			testCaseImpl.setSteps(steps);
		}

		testCaseImpl.setCategroyId(categroyId);

		if (expectedResults == null) {
			testCaseImpl.setExpectedResults(StringPool.BLANK);
		}
		else {
			testCaseImpl.setExpectedResults(expectedResults);
		}

		testCaseImpl.resetOriginalValues();

		return testCaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		testCaseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		testCaseName = objectInput.readUTF();

		automatic = objectInput.readBoolean();
		steps = objectInput.readUTF();

		categroyId = objectInput.readLong();
		expectedResults = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(testCaseId);

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

		if (testCaseName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(testCaseName);
		}

		objectOutput.writeBoolean(automatic);

		if (steps == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(steps);
		}

		objectOutput.writeLong(categroyId);

		if (expectedResults == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expectedResults);
		}
	}

	public long testCaseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String testCaseName;
	public boolean automatic;
	public String steps;
	public long categroyId;
	public String expectedResults;
}
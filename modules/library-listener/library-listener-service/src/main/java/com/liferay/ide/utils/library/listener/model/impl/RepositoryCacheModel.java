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

package com.liferay.ide.utils.library.listener.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.ide.utils.library.listener.model.Repository;

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
 * The cache model class for representing Repository in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Repository
 * @generated
 */
@ProviderType
public class RepositoryCacheModel implements CacheModel<Repository>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RepositoryCacheModel)) {
			return false;
		}

		RepositoryCacheModel repositoryCacheModel = (RepositoryCacheModel)obj;

		if (repositoryId == repositoryCacheModel.repositoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, repositoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{repositoryId=");
		sb.append(repositoryId);
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
		sb.append(", repositoryName=");
		sb.append(repositoryName);
		sb.append(", repositoryRootUrl=");
		sb.append(repositoryRootUrl);
		sb.append(", repositoryUserName=");
		sb.append(repositoryUserName);
		sb.append(", repositoryPassword=");
		sb.append(repositoryPassword);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Repository toEntityModel() {
		RepositoryImpl repositoryImpl = new RepositoryImpl();

		repositoryImpl.setRepositoryId(repositoryId);
		repositoryImpl.setGroupId(groupId);
		repositoryImpl.setCompanyId(companyId);
		repositoryImpl.setUserId(userId);

		if (userName == null) {
			repositoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			repositoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			repositoryImpl.setCreateDate(null);
		}
		else {
			repositoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			repositoryImpl.setModifiedDate(null);
		}
		else {
			repositoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (repositoryName == null) {
			repositoryImpl.setRepositoryName(StringPool.BLANK);
		}
		else {
			repositoryImpl.setRepositoryName(repositoryName);
		}

		if (repositoryRootUrl == null) {
			repositoryImpl.setRepositoryRootUrl(StringPool.BLANK);
		}
		else {
			repositoryImpl.setRepositoryRootUrl(repositoryRootUrl);
		}

		if (repositoryUserName == null) {
			repositoryImpl.setRepositoryUserName(StringPool.BLANK);
		}
		else {
			repositoryImpl.setRepositoryUserName(repositoryUserName);
		}

		if (repositoryPassword == null) {
			repositoryImpl.setRepositoryPassword(StringPool.BLANK);
		}
		else {
			repositoryImpl.setRepositoryPassword(repositoryPassword);
		}

		repositoryImpl.resetOriginalValues();

		return repositoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		repositoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		repositoryName = objectInput.readUTF();
		repositoryRootUrl = objectInput.readUTF();
		repositoryUserName = objectInput.readUTF();
		repositoryPassword = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(repositoryId);

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

		if (repositoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(repositoryName);
		}

		if (repositoryRootUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(repositoryRootUrl);
		}

		if (repositoryUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(repositoryUserName);
		}

		if (repositoryPassword == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(repositoryPassword);
		}
	}

	public long repositoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String repositoryName;
	public String repositoryRootUrl;
	public String repositoryUserName;
	public String repositoryPassword;
}
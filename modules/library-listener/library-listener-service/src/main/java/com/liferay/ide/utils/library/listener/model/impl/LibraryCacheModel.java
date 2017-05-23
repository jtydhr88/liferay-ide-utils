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

import com.liferay.ide.utils.library.listener.model.Library;

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
 * The cache model class for representing Library in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Library
 * @generated
 */
@ProviderType
public class LibraryCacheModel implements CacheModel<Library>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LibraryCacheModel)) {
			return false;
		}

		LibraryCacheModel libraryCacheModel = (LibraryCacheModel)obj;

		if (libraryId == libraryCacheModel.libraryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, libraryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{libraryId=");
		sb.append(libraryId);
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
		sb.append(", libraryGroupId=");
		sb.append(libraryGroupId);
		sb.append(", libraryArtifactId=");
		sb.append(libraryArtifactId);
		sb.append(", latestVersion=");
		sb.append(latestVersion);
		sb.append(", lastUpdated=");
		sb.append(lastUpdated);
		sb.append(", currentVersion=");
		sb.append(currentVersion);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Library toEntityModel() {
		LibraryImpl libraryImpl = new LibraryImpl();

		libraryImpl.setLibraryId(libraryId);
		libraryImpl.setGroupId(groupId);
		libraryImpl.setCompanyId(companyId);
		libraryImpl.setUserId(userId);

		if (userName == null) {
			libraryImpl.setUserName(StringPool.BLANK);
		}
		else {
			libraryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			libraryImpl.setCreateDate(null);
		}
		else {
			libraryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			libraryImpl.setModifiedDate(null);
		}
		else {
			libraryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (libraryGroupId == null) {
			libraryImpl.setLibraryGroupId(StringPool.BLANK);
		}
		else {
			libraryImpl.setLibraryGroupId(libraryGroupId);
		}

		if (libraryArtifactId == null) {
			libraryImpl.setLibraryArtifactId(StringPool.BLANK);
		}
		else {
			libraryImpl.setLibraryArtifactId(libraryArtifactId);
		}

		if (latestVersion == null) {
			libraryImpl.setLatestVersion(StringPool.BLANK);
		}
		else {
			libraryImpl.setLatestVersion(latestVersion);
		}

		if (lastUpdated == null) {
			libraryImpl.setLastUpdated(StringPool.BLANK);
		}
		else {
			libraryImpl.setLastUpdated(lastUpdated);
		}

		if (currentVersion == null) {
			libraryImpl.setCurrentVersion(StringPool.BLANK);
		}
		else {
			libraryImpl.setCurrentVersion(currentVersion);
		}

		libraryImpl.resetOriginalValues();

		return libraryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		libraryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		libraryGroupId = objectInput.readUTF();
		libraryArtifactId = objectInput.readUTF();
		latestVersion = objectInput.readUTF();
		lastUpdated = objectInput.readUTF();
		currentVersion = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(libraryId);

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

		if (libraryGroupId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryGroupId);
		}

		if (libraryArtifactId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryArtifactId);
		}

		if (latestVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latestVersion);
		}

		if (lastUpdated == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastUpdated);
		}

		if (currentVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentVersion);
		}
	}

	public long libraryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String libraryGroupId;
	public String libraryArtifactId;
	public String latestVersion;
	public String lastUpdated;
	public String currentVersion;
}
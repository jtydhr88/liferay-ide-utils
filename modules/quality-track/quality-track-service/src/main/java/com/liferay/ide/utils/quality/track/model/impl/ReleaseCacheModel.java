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

import com.liferay.ide.utils.quality.track.model.Release;

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
 * The cache model class for representing Release in entity cache.
 *
 * @author Terry Jia
 * @see Release
 * @generated
 */
@ProviderType
public class ReleaseCacheModel implements CacheModel<Release>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReleaseCacheModel)) {
			return false;
		}

		ReleaseCacheModel releaseCacheModel = (ReleaseCacheModel)obj;

		if (releaseId == releaseCacheModel.releaseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, releaseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{releaseId=");
		sb.append(releaseId);
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
		sb.append(", releaseName=");
		sb.append(releaseName);
		sb.append(", releaseDate=");
		sb.append(releaseDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Release toEntityModel() {
		ReleaseImpl releaseImpl = new ReleaseImpl();

		releaseImpl.setReleaseId(releaseId);
		releaseImpl.setGroupId(groupId);
		releaseImpl.setCompanyId(companyId);
		releaseImpl.setUserId(userId);

		if (userName == null) {
			releaseImpl.setUserName(StringPool.BLANK);
		}
		else {
			releaseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			releaseImpl.setCreateDate(null);
		}
		else {
			releaseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			releaseImpl.setModifiedDate(null);
		}
		else {
			releaseImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (releaseName == null) {
			releaseImpl.setReleaseName(StringPool.BLANK);
		}
		else {
			releaseImpl.setReleaseName(releaseName);
		}

		if (releaseDate == Long.MIN_VALUE) {
			releaseImpl.setReleaseDate(null);
		}
		else {
			releaseImpl.setReleaseDate(new Date(releaseDate));
		}

		releaseImpl.resetOriginalValues();

		return releaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		releaseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		releaseName = objectInput.readUTF();
		releaseDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(releaseId);

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

		if (releaseName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(releaseName);
		}

		objectOutput.writeLong(releaseDate);
	}

	public long releaseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String releaseName;
	public long releaseDate;
}
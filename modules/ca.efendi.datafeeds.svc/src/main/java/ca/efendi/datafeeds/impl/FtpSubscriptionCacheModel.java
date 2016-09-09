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

package ca.efendi.datafeeds.impl;

import aQute.bnd.annotation.ProviderType;

import ca.efendi.datafeeds.model.FtpSubscription;

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
 * The cache model class for representing FtpSubscription in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FtpSubscription
 * @generated
 */
@ProviderType
public class FtpSubscriptionCacheModel implements CacheModel<FtpSubscription>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FtpSubscriptionCacheModel)) {
			return false;
		}

		FtpSubscriptionCacheModel ftpSubscriptionCacheModel = (FtpSubscriptionCacheModel)obj;

		if (ftpSubscriptionId == ftpSubscriptionCacheModel.ftpSubscriptionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ftpSubscriptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{ftpSubscriptionId=");
		sb.append(ftpSubscriptionId);
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
		sb.append(", ftpHost=");
		sb.append(ftpHost);
		sb.append(", ftpUser=");
		sb.append(ftpUser);
		sb.append(", ftpPassword=");
		sb.append(ftpPassword);
		sb.append(", ftpFolder=");
		sb.append(ftpFolder);
		sb.append(", ftpFile=");
		sb.append(ftpFile);
		sb.append(", ftpDatafeedName=");
		sb.append(ftpDatafeedName);
		sb.append(", ftpDatafeedDescription=");
		sb.append(ftpDatafeedDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FtpSubscription toEntityModel() {
		FtpSubscriptionImpl ftpSubscriptionImpl = new FtpSubscriptionImpl();

		ftpSubscriptionImpl.setFtpSubscriptionId(ftpSubscriptionId);
		ftpSubscriptionImpl.setGroupId(groupId);
		ftpSubscriptionImpl.setCompanyId(companyId);
		ftpSubscriptionImpl.setUserId(userId);

		if (userName == null) {
			ftpSubscriptionImpl.setUserName(StringPool.BLANK);
		}
		else {
			ftpSubscriptionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ftpSubscriptionImpl.setCreateDate(null);
		}
		else {
			ftpSubscriptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ftpSubscriptionImpl.setModifiedDate(null);
		}
		else {
			ftpSubscriptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ftpHost == null) {
			ftpSubscriptionImpl.setFtpHost(StringPool.BLANK);
		}
		else {
			ftpSubscriptionImpl.setFtpHost(ftpHost);
		}

		if (ftpUser == null) {
			ftpSubscriptionImpl.setFtpUser(StringPool.BLANK);
		}
		else {
			ftpSubscriptionImpl.setFtpUser(ftpUser);
		}

		if (ftpPassword == null) {
			ftpSubscriptionImpl.setFtpPassword(StringPool.BLANK);
		}
		else {
			ftpSubscriptionImpl.setFtpPassword(ftpPassword);
		}

		if (ftpFolder == null) {
			ftpSubscriptionImpl.setFtpFolder(StringPool.BLANK);
		}
		else {
			ftpSubscriptionImpl.setFtpFolder(ftpFolder);
		}

		if (ftpFile == null) {
			ftpSubscriptionImpl.setFtpFile(StringPool.BLANK);
		}
		else {
			ftpSubscriptionImpl.setFtpFile(ftpFile);
		}

		if (ftpDatafeedName == null) {
			ftpSubscriptionImpl.setFtpDatafeedName(StringPool.BLANK);
		}
		else {
			ftpSubscriptionImpl.setFtpDatafeedName(ftpDatafeedName);
		}

		if (ftpDatafeedDescription == null) {
			ftpSubscriptionImpl.setFtpDatafeedDescription(StringPool.BLANK);
		}
		else {
			ftpSubscriptionImpl.setFtpDatafeedDescription(ftpDatafeedDescription);
		}

		ftpSubscriptionImpl.resetOriginalValues();

		return ftpSubscriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ftpSubscriptionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ftpHost = objectInput.readUTF();
		ftpUser = objectInput.readUTF();
		ftpPassword = objectInput.readUTF();
		ftpFolder = objectInput.readUTF();
		ftpFile = objectInput.readUTF();
		ftpDatafeedName = objectInput.readUTF();
		ftpDatafeedDescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ftpSubscriptionId);

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

		if (ftpHost == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ftpHost);
		}

		if (ftpUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ftpUser);
		}

		if (ftpPassword == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ftpPassword);
		}

		if (ftpFolder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ftpFolder);
		}

		if (ftpFile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ftpFile);
		}

		if (ftpDatafeedName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ftpDatafeedName);
		}

		if (ftpDatafeedDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ftpDatafeedDescription);
		}
	}

	public long ftpSubscriptionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ftpHost;
	public String ftpUser;
	public String ftpPassword;
	public String ftpFolder;
	public String ftpFile;
	public String ftpDatafeedName;
	public String ftpDatafeedDescription;
}
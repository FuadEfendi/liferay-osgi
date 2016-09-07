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

package ca.efendi.datafeeds.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FtpSubscriptionSoap implements Serializable {
	public static FtpSubscriptionSoap toSoapModel(FtpSubscription model) {
		FtpSubscriptionSoap soapModel = new FtpSubscriptionSoap();

		soapModel.setFtpSubscriptionId(model.getFtpSubscriptionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFtpHost(model.getFtpHost());
		soapModel.setFtpUser(model.getFtpUser());
		soapModel.setFtpPassword(model.getFtpPassword());
		soapModel.setFtpFolder(model.getFtpFolder());
		soapModel.setFtpFile(model.getFtpFile());
		soapModel.setFtpDatafeedName(model.getFtpDatafeedName());
		soapModel.setFtpDatafeedDescription(model.getFtpDatafeedDescription());

		return soapModel;
	}

	public static FtpSubscriptionSoap[] toSoapModels(FtpSubscription[] models) {
		FtpSubscriptionSoap[] soapModels = new FtpSubscriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FtpSubscriptionSoap[][] toSoapModels(
		FtpSubscription[][] models) {
		FtpSubscriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FtpSubscriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FtpSubscriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FtpSubscriptionSoap[] toSoapModels(
		List<FtpSubscription> models) {
		List<FtpSubscriptionSoap> soapModels = new ArrayList<FtpSubscriptionSoap>(models.size());

		for (FtpSubscription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FtpSubscriptionSoap[soapModels.size()]);
	}

	public FtpSubscriptionSoap() {
	}

	public long getPrimaryKey() {
		return _ftpSubscriptionId;
	}

	public void setPrimaryKey(long pk) {
		setFtpSubscriptionId(pk);
	}

	public long getFtpSubscriptionId() {
		return _ftpSubscriptionId;
	}

	public void setFtpSubscriptionId(long ftpSubscriptionId) {
		_ftpSubscriptionId = ftpSubscriptionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFtpHost() {
		return _ftpHost;
	}

	public void setFtpHost(String ftpHost) {
		_ftpHost = ftpHost;
	}

	public String getFtpUser() {
		return _ftpUser;
	}

	public void setFtpUser(String ftpUser) {
		_ftpUser = ftpUser;
	}

	public String getFtpPassword() {
		return _ftpPassword;
	}

	public void setFtpPassword(String ftpPassword) {
		_ftpPassword = ftpPassword;
	}

	public String getFtpFolder() {
		return _ftpFolder;
	}

	public void setFtpFolder(String ftpFolder) {
		_ftpFolder = ftpFolder;
	}

	public String getFtpFile() {
		return _ftpFile;
	}

	public void setFtpFile(String ftpFile) {
		_ftpFile = ftpFile;
	}

	public String getFtpDatafeedName() {
		return _ftpDatafeedName;
	}

	public void setFtpDatafeedName(String ftpDatafeedName) {
		_ftpDatafeedName = ftpDatafeedName;
	}

	public String getFtpDatafeedDescription() {
		return _ftpDatafeedDescription;
	}

	public void setFtpDatafeedDescription(String ftpDatafeedDescription) {
		_ftpDatafeedDescription = ftpDatafeedDescription;
	}

	private long _ftpSubscriptionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ftpHost;
	private String _ftpUser;
	private String _ftpPassword;
	private String _ftpFolder;
	private String _ftpFile;
	private String _ftpDatafeedName;
	private String _ftpDatafeedDescription;
}
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
 * This class is a wrapper for {@link FtpSubscription}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FtpSubscription
 * @generated
 */
@ProviderType
public class FtpSubscriptionWrapper implements FtpSubscription,
	ModelWrapper<FtpSubscription> {
	public FtpSubscriptionWrapper(FtpSubscription ftpSubscription) {
		_ftpSubscription = ftpSubscription;
	}

	@Override
	public Class<?> getModelClass() {
		return FtpSubscription.class;
	}

	@Override
	public String getModelClassName() {
		return FtpSubscription.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ftpSubscriptionId", getFtpSubscriptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ftpHost", getFtpHost());
		attributes.put("ftpUser", getFtpUser());
		attributes.put("ftpPassword", getFtpPassword());
		attributes.put("ftpFolder", getFtpFolder());
		attributes.put("ftpFile", getFtpFile());
		attributes.put("ftpDatafeedName", getFtpDatafeedName());
		attributes.put("ftpDatafeedDescription", getFtpDatafeedDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ftpSubscriptionId = (Long)attributes.get("ftpSubscriptionId");

		if (ftpSubscriptionId != null) {
			setFtpSubscriptionId(ftpSubscriptionId);
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

		String ftpHost = (String)attributes.get("ftpHost");

		if (ftpHost != null) {
			setFtpHost(ftpHost);
		}

		String ftpUser = (String)attributes.get("ftpUser");

		if (ftpUser != null) {
			setFtpUser(ftpUser);
		}

		String ftpPassword = (String)attributes.get("ftpPassword");

		if (ftpPassword != null) {
			setFtpPassword(ftpPassword);
		}

		String ftpFolder = (String)attributes.get("ftpFolder");

		if (ftpFolder != null) {
			setFtpFolder(ftpFolder);
		}

		String ftpFile = (String)attributes.get("ftpFile");

		if (ftpFile != null) {
			setFtpFile(ftpFile);
		}

		String ftpDatafeedName = (String)attributes.get("ftpDatafeedName");

		if (ftpDatafeedName != null) {
			setFtpDatafeedName(ftpDatafeedName);
		}

		String ftpDatafeedDescription = (String)attributes.get(
				"ftpDatafeedDescription");

		if (ftpDatafeedDescription != null) {
			setFtpDatafeedDescription(ftpDatafeedDescription);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _ftpSubscription.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ftpSubscription.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ftpSubscription.isNew();
	}

	@Override
	public ca.efendi.datafeeds.model.FtpSubscription toEscapedModel() {
		return new FtpSubscriptionWrapper(_ftpSubscription.toEscapedModel());
	}

	@Override
	public ca.efendi.datafeeds.model.FtpSubscription toUnescapedModel() {
		return new FtpSubscriptionWrapper(_ftpSubscription.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ftpSubscription.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ca.efendi.datafeeds.model.FtpSubscription> toCacheModel() {
		return _ftpSubscription.toCacheModel();
	}

	@Override
	public int compareTo(
		ca.efendi.datafeeds.model.FtpSubscription ftpSubscription) {
		return _ftpSubscription.compareTo(ftpSubscription);
	}

	@Override
	public int hashCode() {
		return _ftpSubscription.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ftpSubscription.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FtpSubscriptionWrapper((FtpSubscription)_ftpSubscription.clone());
	}

	/**
	* Returns the ftp datafeed description of this ftp subscription.
	*
	* @return the ftp datafeed description of this ftp subscription
	*/
	@Override
	public java.lang.String getFtpDatafeedDescription() {
		return _ftpSubscription.getFtpDatafeedDescription();
	}

	/**
	* Returns the ftp datafeed name of this ftp subscription.
	*
	* @return the ftp datafeed name of this ftp subscription
	*/
	@Override
	public java.lang.String getFtpDatafeedName() {
		return _ftpSubscription.getFtpDatafeedName();
	}

	/**
	* Returns the ftp file of this ftp subscription.
	*
	* @return the ftp file of this ftp subscription
	*/
	@Override
	public java.lang.String getFtpFile() {
		return _ftpSubscription.getFtpFile();
	}

	/**
	* Returns the ftp folder of this ftp subscription.
	*
	* @return the ftp folder of this ftp subscription
	*/
	@Override
	public java.lang.String getFtpFolder() {
		return _ftpSubscription.getFtpFolder();
	}

	/**
	* Returns the ftp host of this ftp subscription.
	*
	* @return the ftp host of this ftp subscription
	*/
	@Override
	public java.lang.String getFtpHost() {
		return _ftpSubscription.getFtpHost();
	}

	/**
	* Returns the ftp password of this ftp subscription.
	*
	* @return the ftp password of this ftp subscription
	*/
	@Override
	public java.lang.String getFtpPassword() {
		return _ftpSubscription.getFtpPassword();
	}

	/**
	* Returns the ftp user of this ftp subscription.
	*
	* @return the ftp user of this ftp subscription
	*/
	@Override
	public java.lang.String getFtpUser() {
		return _ftpSubscription.getFtpUser();
	}

	/**
	* Returns the user name of this ftp subscription.
	*
	* @return the user name of this ftp subscription
	*/
	@Override
	public java.lang.String getUserName() {
		return _ftpSubscription.getUserName();
	}

	/**
	* Returns the user uuid of this ftp subscription.
	*
	* @return the user uuid of this ftp subscription
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _ftpSubscription.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _ftpSubscription.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ftpSubscription.toXmlString();
	}

	/**
	* Returns the create date of this ftp subscription.
	*
	* @return the create date of this ftp subscription
	*/
	@Override
	public Date getCreateDate() {
		return _ftpSubscription.getCreateDate();
	}

	/**
	* Returns the modified date of this ftp subscription.
	*
	* @return the modified date of this ftp subscription
	*/
	@Override
	public Date getModifiedDate() {
		return _ftpSubscription.getModifiedDate();
	}

	/**
	* Returns the company ID of this ftp subscription.
	*
	* @return the company ID of this ftp subscription
	*/
	@Override
	public long getCompanyId() {
		return _ftpSubscription.getCompanyId();
	}

	/**
	* Returns the ftp subscription ID of this ftp subscription.
	*
	* @return the ftp subscription ID of this ftp subscription
	*/
	@Override
	public long getFtpSubscriptionId() {
		return _ftpSubscription.getFtpSubscriptionId();
	}

	/**
	* Returns the group ID of this ftp subscription.
	*
	* @return the group ID of this ftp subscription
	*/
	@Override
	public long getGroupId() {
		return _ftpSubscription.getGroupId();
	}

	/**
	* Returns the primary key of this ftp subscription.
	*
	* @return the primary key of this ftp subscription
	*/
	@Override
	public long getPrimaryKey() {
		return _ftpSubscription.getPrimaryKey();
	}

	/**
	* Returns the user ID of this ftp subscription.
	*
	* @return the user ID of this ftp subscription
	*/
	@Override
	public long getUserId() {
		return _ftpSubscription.getUserId();
	}

	@Override
	public void persist() {
		_ftpSubscription.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ftpSubscription.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this ftp subscription.
	*
	* @param companyId the company ID of this ftp subscription
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ftpSubscription.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this ftp subscription.
	*
	* @param createDate the create date of this ftp subscription
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_ftpSubscription.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ftpSubscription.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ftpSubscription.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ftpSubscription.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ftp datafeed description of this ftp subscription.
	*
	* @param ftpDatafeedDescription the ftp datafeed description of this ftp subscription
	*/
	@Override
	public void setFtpDatafeedDescription(
		java.lang.String ftpDatafeedDescription) {
		_ftpSubscription.setFtpDatafeedDescription(ftpDatafeedDescription);
	}

	/**
	* Sets the ftp datafeed name of this ftp subscription.
	*
	* @param ftpDatafeedName the ftp datafeed name of this ftp subscription
	*/
	@Override
	public void setFtpDatafeedName(java.lang.String ftpDatafeedName) {
		_ftpSubscription.setFtpDatafeedName(ftpDatafeedName);
	}

	/**
	* Sets the ftp file of this ftp subscription.
	*
	* @param ftpFile the ftp file of this ftp subscription
	*/
	@Override
	public void setFtpFile(java.lang.String ftpFile) {
		_ftpSubscription.setFtpFile(ftpFile);
	}

	/**
	* Sets the ftp folder of this ftp subscription.
	*
	* @param ftpFolder the ftp folder of this ftp subscription
	*/
	@Override
	public void setFtpFolder(java.lang.String ftpFolder) {
		_ftpSubscription.setFtpFolder(ftpFolder);
	}

	/**
	* Sets the ftp host of this ftp subscription.
	*
	* @param ftpHost the ftp host of this ftp subscription
	*/
	@Override
	public void setFtpHost(java.lang.String ftpHost) {
		_ftpSubscription.setFtpHost(ftpHost);
	}

	/**
	* Sets the ftp password of this ftp subscription.
	*
	* @param ftpPassword the ftp password of this ftp subscription
	*/
	@Override
	public void setFtpPassword(java.lang.String ftpPassword) {
		_ftpSubscription.setFtpPassword(ftpPassword);
	}

	/**
	* Sets the ftp subscription ID of this ftp subscription.
	*
	* @param ftpSubscriptionId the ftp subscription ID of this ftp subscription
	*/
	@Override
	public void setFtpSubscriptionId(long ftpSubscriptionId) {
		_ftpSubscription.setFtpSubscriptionId(ftpSubscriptionId);
	}

	/**
	* Sets the ftp user of this ftp subscription.
	*
	* @param ftpUser the ftp user of this ftp subscription
	*/
	@Override
	public void setFtpUser(java.lang.String ftpUser) {
		_ftpSubscription.setFtpUser(ftpUser);
	}

	/**
	* Sets the group ID of this ftp subscription.
	*
	* @param groupId the group ID of this ftp subscription
	*/
	@Override
	public void setGroupId(long groupId) {
		_ftpSubscription.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this ftp subscription.
	*
	* @param modifiedDate the modified date of this ftp subscription
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_ftpSubscription.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_ftpSubscription.setNew(n);
	}

	/**
	* Sets the primary key of this ftp subscription.
	*
	* @param primaryKey the primary key of this ftp subscription
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ftpSubscription.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ftpSubscription.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this ftp subscription.
	*
	* @param userId the user ID of this ftp subscription
	*/
	@Override
	public void setUserId(long userId) {
		_ftpSubscription.setUserId(userId);
	}

	/**
	* Sets the user name of this ftp subscription.
	*
	* @param userName the user name of this ftp subscription
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_ftpSubscription.setUserName(userName);
	}

	/**
	* Sets the user uuid of this ftp subscription.
	*
	* @param userUuid the user uuid of this ftp subscription
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ftpSubscription.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FtpSubscriptionWrapper)) {
			return false;
		}

		FtpSubscriptionWrapper ftpSubscriptionWrapper = (FtpSubscriptionWrapper)obj;

		if (Objects.equals(_ftpSubscription,
					ftpSubscriptionWrapper._ftpSubscription)) {
			return true;
		}

		return false;
	}

	@Override
	public FtpSubscription getWrappedModel() {
		return _ftpSubscription;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ftpSubscription.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ftpSubscription.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ftpSubscription.resetOriginalValues();
	}

	private final FtpSubscription _ftpSubscription;
}
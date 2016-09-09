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

package ca.efendi.datafeeds.service.impl;

import aQute.bnd.annotation.ProviderType;
import ca.efendi.datafeeds.model.FtpSubscription;
import ca.efendi.datafeeds.service.FtpSubscriptionLocalService;
import ca.efendi.datafeeds.service.FtpSubscriptionLocalServiceUtil;
import ca.efendi.datafeeds.service.base.FtpSubscriptionLocalServiceBaseImpl;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the ftp subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link FtpSubscriptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author fefendi
 * @see FtpSubscriptionLocalServiceBaseImpl
 * @see FtpSubscriptionLocalServiceUtil
 */
@ProviderType
public class FtpSubscriptionLocalServiceImpl
	extends FtpSubscriptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link ca.efendi.datafeeds.service.FtpSubscriptionLocalServiceUtil} to access the ftp subscription local service.
	 */

	@Override
	public FtpSubscription addFtpSubscription(final FtpSubscription newFtpSubscription, final long userId,
											  final ServiceContext serviceContext)

	{

		final FtpSubscription ftpSubscription = ftpSubscriptionPersistence.create(
				counterLocalService.increment(FtpSubscription.class.getName()));

		ftpSubscription.setCompanyId(newFtpSubscription.getCompanyId());
		ftpSubscription.setGroupId(newFtpSubscription.getGroupId());
		ftpSubscription.setUserId(newFtpSubscription.getUserId());
		ftpSubscription.setUserName(newFtpSubscription.getUserName());
		ftpSubscription.setCreateDate(newFtpSubscription.getCreateDate());
		ftpSubscription.setModifiedDate(newFtpSubscription.getModifiedDate());

		ftpSubscription.setFtpHost(newFtpSubscription.getFtpHost());
		ftpSubscription.setFtpUser(newFtpSubscription.getFtpUser());
		ftpSubscription.setFtpPassword(newFtpSubscription.getFtpPassword());
		ftpSubscription.setFtpFolder(newFtpSubscription.getFtpFolder());
		ftpSubscription.setFtpFile(newFtpSubscription.getFtpFile());
		ftpSubscription.setFtpDatafeedName(newFtpSubscription.getFtpDatafeedName());
		ftpSubscription.setFtpDatafeedDescription(newFtpSubscription.getFtpDatafeedDescription());

		// ftpSubscription.setStatus(WorkflowConstants.STATUS_DRAFT);

		return ftpSubscriptionPersistence.update(ftpSubscription);
	}

	@Override
	public List<FtpSubscription> getAllFtpSubscriptions(final long groupId)

	{
		final List<FtpSubscription> products = ftpSubscriptionPersistence.findByGroupId(groupId);
		return products;
	}

	@Override
	public List<FtpSubscription> getAllFtpSubscriptions()

	{
		final List<FtpSubscription> products = ftpSubscriptionPersistence.findAll();
		return products;
	}



}


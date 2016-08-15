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

package ca.efendi.datafeeds.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CJProduct. This utility wraps
 * {@link ca.efendi.datafeeds.service.impl.CJProductServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author fefendi
 * @see CJProductService
 * @see ca.efendi.datafeeds.service.base.CJProductServiceBaseImpl
 * @see ca.efendi.datafeeds.service.impl.CJProductServiceImpl
 * @generated
 */
@ProviderType
public class CJProductServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ca.efendi.datafeeds.service.impl.CJProductServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static ca.efendi.datafeeds.model.CJProduct getCJProduct(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCJProduct(groupId, urlTitle);
	}

	public static ca.efendi.datafeeds.model.CJProduct refresh(
		ca.efendi.datafeeds.model.CJProduct newCJProduct,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().refresh(newCJProduct, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CJProductService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CJProductService, CJProductService> _serviceTracker =
		ServiceTrackerFactory.open(CJProductService.class);
}
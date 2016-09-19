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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CJProductService}.
 *
 * @author Brian Wing Shun Chan
 * @see CJProductService
 * @generated
 */
@ProviderType
public class CJProductServiceWrapper implements CJProductService,
	ServiceWrapper<CJProductService> {
	public CJProductServiceWrapper(CJProductService cjProductService) {
		_cjProductService = cjProductService;
	}

	@Override
	public ca.efendi.datafeeds.model.CJProduct getCJProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProductService.getCJProduct(productId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _cjProductService.getOSGiServiceIdentifier();
	}

	@Override
	public CJProductService getWrappedService() {
		return _cjProductService;
	}

	@Override
	public void setWrappedService(CJProductService cjProductService) {
		_cjProductService = cjProductService;
	}

	private CJProductService _cjProductService;
}
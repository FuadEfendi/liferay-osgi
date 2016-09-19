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

import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.service.base.CJProductServiceBaseImpl;
import ca.efendi.datafeeds.service.permission.CJProductPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portlet.blogs.service.permission.BlogsEntryPermission;

/**
 * The implementation of the c j product remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ca.efendi.datafeeds.service.CJProductService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CJProductServiceBaseImpl
 * @see ca.efendi.datafeeds.service.CJProductServiceUtil
 */
@ProviderType
public class CJProductServiceImpl extends CJProductServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link ca.efendi.datafeeds.service.CJProductServiceUtil} to access the c j product remote service.
	 */

    @Override
    public CJProduct getCJProduct(long productId) throws PortalException {
        CJProductPermission.check(
                getPermissionChecker(), productId, ActionKeys.VIEW);

        return cjProductLocalService.getCJProduct(productId);
    }

}
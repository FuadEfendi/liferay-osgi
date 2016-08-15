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
import ca.efendi.datafeeds.exception.NoSuchCJProductException;
import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.service.base.CJProductLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

/**
 * The implementation of the c j product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ca.efendi.datafeeds.service.CJProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author fefendi
 * @see CJProductLocalServiceBaseImpl
 * @see ca.efendi.datafeeds.service.CJProductLocalServiceUtil
 */
@ProviderType
public class CJProductLocalServiceImpl extends CJProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link ca.efendi.datafeeds.service.CJProductLocalServiceUtil} to access the c j product local service.
	 */

    @Override
    @Indexable(type = IndexableType.REINDEX)
    // TODO: use primitives as a method parameters, same as for BlogsPortlet style
    public CJProduct refresh(final long userId, final CJProduct newCJProduct, final ServiceContext serviceContext) throws PortalException
    {

        final Date now = new Date();

        CJProduct cjProduct;

        try
        {
            cjProduct = cjProductPersistence.findByPROGRAM_CATALOG_SKU(newCJProduct.getProgramName(), newCJProduct.getCatalogName(), newCJProduct.getSku());
        }
        catch (final NoSuchCJProductException e)
        {

            final User user = userPersistence.findByPrimaryKey(userId);
            final long groupId = serviceContext.getScopeGroupId();
            final long productId = counterLocalService.increment(CJProduct.class.getName());
            cjProduct = cjProductPersistence.create(productId);

            cjProduct.setUuid(serviceContext.getUuid());
            cjProduct.setGroupId(groupId);
            cjProduct.setCompanyId(user.getCompanyId());
            cjProduct.setUserId(user.getUserId());
            cjProduct.setUserName(user.getFullName());

            cjProduct.setProgramName(newCJProduct.getProgramName());
            cjProduct.setCatalogName(newCJProduct.getCatalogName());
            cjProduct.setSku(newCJProduct.getSku());

            // TODO: is it already implemented by Liferay?
            //cjProduct.setCreateDate(now);

        }

        cjProduct.setProgramUrl(newCJProduct.getProgramUrl());
        cjProduct.setLastUpdated(newCJProduct.getLastUpdated());
        cjProduct.setName(newCJProduct.getName());
        cjProduct.setKeywords(newCJProduct.getKeywords());
        cjProduct.setDescription(newCJProduct.getDescription());
        cjProduct.setManufacturer(newCJProduct.getManufacturer());
        cjProduct.setManufacturerId(newCJProduct.getManufacturerId());
        cjProduct.setCurrency(newCJProduct.getCurrency());
        cjProduct.setPrice(newCJProduct.getPrice());
        cjProduct.setBuyUrl(newCJProduct.getBuyUrl());
        cjProduct.setImpressionUrl(newCJProduct.getImpressionUrl());
        cjProduct.setImageUrl(newCJProduct.getImageUrl());
        cjProduct.setInStock(newCJProduct.getInStock());

        cjProduct.setUrlTitle(newCJProduct.getUrlTitle());

        // TODO: is it already implemented by Liferay?
        //cjProduct.setModifiedDate(now);

        //cjProduct.setCompanyId(COMPANY_ID);
        //cjProduct.setGroupId(GROUP_ID);
        //cjProduct.setUserId(USER_ID);

        resourceLocalService.addResources(
                cjProduct.getCompanyId(), cjProduct.getGroupId(), cjProduct.getUserId(),
                CJProduct.class.getName(), cjProduct.getPrimaryKey(), false,
                true, true);

        assetEntryLocalService.updateEntry(
                cjProduct.getUserId(), cjProduct.getGroupId(), CJProduct.class.getName(),
                cjProduct.getProductId(),
                new long[] {}, //serviceContext.getAssetCategoryIds(),
                new String[] { "shopping" }); //serviceContext.getAssetTagNames());

        return cjProductPersistence.update(cjProduct);

    }

    @Override
    public CJProduct getCJProduct(final long groupId, final String urlTitle) throws NoSuchCJProductException
    {

        return cjProductPersistence.findByG_UT(groupId, urlTitle);
    }

    /*  public static final int COMPANY_ID = 20148;

      public static final int GROUP_ID = 20177; // guest

      public static final int USER_ID = 20204; // administrator
    */


}
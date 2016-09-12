/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ca.efendi.datafeeds.service.impl;

import aQute.bnd.annotation.ProviderType;
import ca.efendi.datafeeds.exception.NoSuchCJProductException;
import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.model.FtpSubscription;
import ca.efendi.datafeeds.service.CJProductLocalService;
import ca.efendi.datafeeds.service.CJProductLocalServiceUtil;
import ca.efendi.datafeeds.service.base.CJProductLocalServiceBaseImpl;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the c j product local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link CJProductLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author fefendi
 * @see CJProductLocalServiceBaseImpl
 * @see CJProductLocalServiceUtil
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
    public CJProduct refresh(final FtpSubscription subscription, final CJProduct newCJProduct) throws PortalException {

        final Date now = new Date();

        CJProduct cjProduct;

        try {
            cjProduct = cjProductPersistence.findByPROGRAM_CATALOG_SKU(newCJProduct.getProgramName(), newCJProduct.getCatalogName(), newCJProduct.getSku());
     } catch (final NoSuchCJProductException e) {

            final long productId = counterLocalService.increment(CJProduct.class.getName());

            cjProduct = cjProductPersistence.create(productId);

            resourceLocalService.addModelResources(
                    subscription.getCompanyId(), subscription.getGroupId(), subscription.getUserId(),
                    CJProduct.class.getName(), productId,
                    new String[]{"VIEW"}, new String[]{"VIEW"});


            cjProduct.setUuid(PortalUUIDUtil.generate());
            cjProduct.setGroupId(subscription.getGroupId());
            cjProduct.setCompanyId(subscription.getCompanyId());
            cjProduct.setUserId(subscription.getUserId());
            cjProduct.setUserName(subscription.getUserName());

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


        // TODO: is it already implemented by Liferay?
        //cjProduct.setModifiedDate(now);

        //cjProduct.setCompanyId(COMPANY_ID);
        //cjProduct.setGroupId(GROUP_ID);
        //cjProduct.setUserId(USER_ID);

        Date current = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        Date expire = cal.getTime();


       /* assetEntryLocalService.updateEntry(
                cjProduct.getUserId(), cjProduct.getGroupId(), CJProduct.class.getName(),
                cjProduct.getProductId(),
                new long[]{}, //serviceContext.getAssetCategoryIds(),
                new String[]{"shopping"}); //serviceContext.getAssetTagNames());

        assetEntryLocalService.updateEntry(
                CJProduct.class.getName(),
                cjProduct.getProductId(),
                current,
                expire,
                true,
                true);
*/

        String summary = HtmlUtil.extractText(
                StringUtil.shorten(cjProduct.getDescription(), 500));

        long[] assetCategoryIds = null;
        String[] assetTagNames = null;
        boolean visible = true;
        Double priority = null;

        AssetEntry assetEntry = assetEntryLocalService.updateEntry(
                cjProduct.getUserId(), cjProduct.getGroupId(), cjProduct.getCreateDate(),
                cjProduct.getModifiedDate(), CJProduct.class.getName(),
                cjProduct.getProductId(), cjProduct.getUuid(), 0, assetCategoryIds,
                assetTagNames, true, visible, current, expire, current, expire,
                ContentTypes.TEXT_HTML, cjProduct.getName(), cjProduct.getDescription(),
                summary, cjProduct.getBuyUrl(), null, 0, 0, priority);

        long[] assetLinkEntryIds = null;


        assetLinkLocalService.updateLinks(
                cjProduct.getUserId(), assetEntry.getEntryId(), assetLinkEntryIds,
                AssetLinkConstants.TYPE_RELATED);


        Indexer<CJProduct> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                CJProduct.class);

        indexer.reindex(cjProduct);

        return cjProductPersistence.update(cjProduct);

    }

    @Override
    public CJProduct getCJProduct(final long groupId, final String sku) throws NoSuchCJProductException {
        return cjProductPersistence.findByG_SKU(groupId, sku);
    }


    @Override
    public List<CJProduct> findByGroupId(long groupId, int start, int end) throws PortalException {

        return cjProductPersistence.findByGroupId(groupId, 0, 1000);

    }


    @Override
    public void deleteEntries(long groupId) throws PortalException {

        List<CJProduct> entries = null;
        entries = cjProductPersistence.findByGroupId(groupId, 0, 1000);

        while (entries != null) {

            for (CJProduct entry : cjProductPersistence.findByGroupId(groupId, 0, 1000)) {
                // TODO: why not calling directly "deleteEntry"? Analyze Liferay if this is consistent pattern. Perhaps because "Indexable" annotation?
                cjProductLocalService.deleteEntry(entry);
            }
            entries = cjProductPersistence.findByGroupId(groupId, 0, 1000);
        }

    }

    @Indexable(type = IndexableType.DELETE)
    @Override
    @SystemEvent(type = SystemEventConstants.TYPE_DELETE)
    public CJProduct deleteEntry(CJProduct entry) throws PortalException {

        // Entry

        cjProductPersistence.remove(entry);

        // Resources

        resourceLocalService.deleteResource(
                entry.getCompanyId(), CJProduct.class.getName(),
                ResourceConstants.SCOPE_INDIVIDUAL, entry.getProductId());

        // imageLocalService.deleteImage(entry.getSmallImageId());

        subscriptionLocalService.deleteSubscriptions(
                entry.getCompanyId(), CJProduct.class.getName(),
                entry.getProductId());

        //blogsStatsUserLocalService.updateStatsUser(
        //        entry.getGroupId(), entry.getUserId(), entry.getDisplayDate());

        assetEntryLocalService.deleteEntry(
                CJProduct.class.getName(), entry.getProductId());

//        long coverImageFileEntryId = entry.getCoverImageFileEntryId();
//
//        if (coverImageFileEntryId != 0) {
//            PortletFileRepositoryUtil.deletePortletFileEntry(
//                    coverImageFileEntryId);
//        }

//        long smallImageFileEntryId = entry.getSmallImageFileEntryId();
//
//        if (smallImageFileEntryId != 0) {
//            PortletFileRepositoryUtil.deletePortletFileEntry(
//                    smallImageFileEntryId);
//        }

        //deleteDiscussion(entry);
        //expandoRowLocalService.deleteRows(entry.getEntryId());

        // Ratings

        ratingsStatsLocalService.deleteStats(
                CJProduct.class.getName(), entry.getProductId());

        trashEntryLocalService.deleteEntry(
                CJProduct.class.getName(), entry.getProductId());

        // Workflow

        workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
                entry.getCompanyId(), entry.getGroupId(),
                CJProduct.class.getName(), entry.getProductId());

        return entry;
    }

    @Override
    public void deleteEntry(long entryId) throws PortalException {
        CJProduct entry = cjProductPersistence.findByPrimaryKey(entryId);

        cjProductLocalService.deleteEntry(entry);
    }


}
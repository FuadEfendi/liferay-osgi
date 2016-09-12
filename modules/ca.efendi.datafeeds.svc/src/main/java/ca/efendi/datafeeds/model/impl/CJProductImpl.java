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

package ca.efendi.datafeeds.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.webserver.WebServerServletTokenUtil;

/**
 * The extended model implementation for the CJProduct service. Represents a row in the &quot;FE_CJProduct&quot; database table, with each column mapped to a property of this class.
 * <p>
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ca.efendi.datafeeds.model.CJProduct} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class CJProductImpl extends CJProductBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a c j product model instance should use the {@link ca.efendi.datafeeds.model.CJProduct} interface instead.
     */
    public CJProductImpl() {
    }

    @Override
    public long getEntryId() {
        return getProductId();
    }

    @Override
    public String getCoverImageURL(ThemeDisplay themeDisplay)
            throws PortalException {

        long coverImageFileEntryId = getCoverImageFileEntryId();

        if (coverImageFileEntryId == 0) {
            return null;
        }

        FileEntry fileEntry = PortletFileRepositoryUtil.getPortletFileEntry(
                coverImageFileEntryId);

        return DLUtil.getPreviewURL(
                fileEntry, fileEntry.getFileVersion(), themeDisplay,
                StringPool.BLANK);
    }

    @Override
    public String getSmallImageURL(ThemeDisplay themeDisplay)
            throws PortalException {

        if (Validator.isNotNull(getSmallImageURL())) {
            return getSmallImageURL();
        }

        long smallImageFileEntryId = getSmallImageFileEntryId();

        if (smallImageFileEntryId != 0) {
            FileEntry fileEntry = PortletFileRepositoryUtil.getPortletFileEntry(
                    smallImageFileEntryId);

            return DLUtil.getPreviewURL(
                    fileEntry, fileEntry.getFileVersion(), themeDisplay,
                    StringPool.BLANK);
        }

        long smallImageId = getSmallImageId();

        if (smallImageId != 0) {
            return themeDisplay.getPathImage() + "/cjproduct/entry?img_id=" +
                    getSmallImageId() + "&t=" +
                    WebServerServletTokenUtil.getToken(getSmallImageId());
        }

        return getCoverImageURL(themeDisplay);
    }


}
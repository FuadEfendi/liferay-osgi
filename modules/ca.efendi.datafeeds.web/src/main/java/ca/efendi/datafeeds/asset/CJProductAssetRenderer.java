/*
 * Copyright (c) 2016 Fuad Efendi <fuad@efendi.ca>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.efendi.datafeeds.asset;

import ca.efendi.datafeeds.constants.DatafeedsPortletKeys;
import ca.efendi.datafeeds.model.CJProduct;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class CJProductAssetRenderer extends BaseJSPAssetRenderer<CJProduct> implements TrashRenderer {

    private final CJProduct _entry;

    public CJProductAssetRenderer(final CJProduct entry) {
        _entry = entry;
    }

    /**
     * @see com.liferay.asset.kernel.model.AssetRenderer#getAssetObject()
     */
    @Override
    public CJProduct getAssetObject() {
        return _entry;
    }

    /**
     * @see com.liferay.asset.kernel.model.Renderer#getClassName()
     */
    @Override
    public String getClassName() {
        return CJProduct.class.getName();
    }

    /**
     * @see com.liferay.asset.kernel.model.Renderer#getClassPK()
     */
    @Override
    public long getClassPK() {
        return _entry.getProductId();
    }

    @Override
    public String getIconCssClass() throws PortalException {
        return null;
    }


    @Override
    public String getDiscussionPath() {
        return "edit_entry_discussion";
    }

    /**
     * @see com.liferay.asset.kernel.model.AssetRenderer#getGroupId()
     */
    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }
    //@Override
    //public String getIconPath(final ThemeDisplay themeDisplay)
    //{
    //    return themeDisplay.getPathThemeImages() + "/blogs/blogs.png";
    //}

    /**
     * @see com.liferay.asset.kernel.model.BaseJSPAssetRenderer#getJspPath(HttpServletRequest,
     * String)
     */
    @Override
    public String getJspPath(final HttpServletRequest request, final String template) {
        if (template.equals(TEMPLATE_ABSTRACT) ||
                template.equals(TEMPLATE_FULL_CONTENT)) {
            return "/datafeeds/ca.efendi.datafeeds.asset/" + template + ".jsp";
        } else {
            return null;
        }
    }

    @Override
    public String getNewName(String oldName, String token) {
        return null;
    }

    /**
     * @see TrashRenderer#getPortletId()
     */
    @Override
    public String getPortletId() {
        final AssetRendererFactory<CJProduct> assetRendererFactory =
                getAssetRendererFactory();
        return assetRendererFactory.getPortletId();
    }


    /**
     * @see com.liferay.asset.kernel.model.Renderer#getSummary(PortletRequest,
     * PortletResponse)
     */
    @Override
    public String getSummary(final PortletRequest portletRequest, final PortletResponse portletResponse) {
        return _entry.getDescription();
    }

    @Override
    public String getThumbnailPath(final PortletRequest portletRequest)
            throws Exception {
        final ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        return themeDisplay.getPathThemeImages() +
                "/file_system/large/blog.png";
    }

    /**
     * @see com.liferay.asset.kernel.model.Renderer#getTitle(Locale)
     */
    @Override
    public String getTitle(final Locale locale) {
        return _entry.getName();
    }

    /**
     * @see TrashRenderer#getType()
     */
    @Override
    public String getType() {
        return CJProductAssetRendererFactory.TYPE;
    }

    @Override
    public String renderActions(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
        return null;
    }

    @Override
    public String getUrlTitle() {
        return _entry.getUrlTitle();
    }

    // @Override
//    public PortletURL getURLView2(
//            final LiferayPortletResponse liferayPortletResponse,
//            final WindowState windowState)
//            throws Exception {
//        final AssetRendererFactory<CJProduct> assetRendererFactory =
//                getAssetRendererFactory();
//        final PortletURL portletURL = assetRendererFactory.getURLView(
//                liferayPortletResponse, windowState);
//        portletURL.setParameter("mvcRenderCommandName", "/blogs/view_entry");
//        portletURL.setParameter("entryId", String.valueOf(_entry.getProductId()));
//        portletURL.setWindowState(windowState);
//        return portletURL;
//    }

    @Override
    public String getURLViewInContext(
            final LiferayPortletRequest liferayPortletRequest,
            final LiferayPortletResponse liferayPortletResponse,
            final String noSuchEntryRedirect) {
        return getURLViewInContext(
                liferayPortletRequest, noSuchEntryRedirect, "/blogs/find_entry",
                "entryId", _entry.getProductId());
    }

    /**
     * @see com.liferay.asset.kernel.model.AssetRenderer#getUserId()
     */
    @Override
    public long getUserId() {
        return _entry.getUserId();
    }

    /**
     * @see com.liferay.asset.kernel.model.AssetRenderer#getUserName()
     */
    @Override
    public String getUserName() {
        return _entry.getUserName();
    }

    /**
     * @see com.liferay.asset.kernel.model.AssetRenderer#getUuid()
     */
    @Override
    public String getUuid() {
        return _entry.getUuid();
    }

    @Override
    public boolean include(
            final HttpServletRequest request, final HttpServletResponse response,
            final String template)
            throws Exception {
        request.setAttribute(DatafeedsPortletKeys.CJ_PRODUCT_ENTRY, _entry);
        return super.include(request, response, template);
    }

    @Override
    public boolean isPrintable() {
        return true;
    }
}

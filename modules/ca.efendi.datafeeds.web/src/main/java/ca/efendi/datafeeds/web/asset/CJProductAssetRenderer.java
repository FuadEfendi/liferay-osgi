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

package ca.efendi.datafeeds.web.asset;

import ca.efendi.datafeeds.configuration.PropsValues;
import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.service.permission.CJProductPermission;
import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import ca.efendi.datafeeds.web.constants.CJProductWebKeys;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.asset.util.AssetUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class CJProductAssetRenderer extends BaseJSPAssetRenderer<CJProduct> implements TrashRenderer {


    public CJProductAssetRenderer(final CJProduct entry) {
        _entry = entry;
    }

    @Override
    public CJProduct getAssetObject() {
        return _entry;
    }

    @Override
    public String getClassName() {
        return CJProduct.class.getName();
    }

    @Override
    public long getClassPK() {
        return _entry.getProductId();
    }

    @Override
    public String getDiscussionPath() {
        if (PropsValues.CJPRODUCT_COMMENTS_ENABLED) {
            return "edit_cjproduct_discussion";
        } else {
            return null;
        }
    }

    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }

    @Override
    public String getJspPath(final HttpServletRequest request, final String template) {
        if (template.equals(TEMPLATE_ABSTRACT) ||
                template.equals(TEMPLATE_FULL_CONTENT)) {
            return "/cjproduct/asset/" + template + ".jsp";
        } else {
            return null;
        }
    }

    @Override
    public String getPortletId() {
        final AssetRendererFactory<CJProduct> assetRendererFactory =
                getAssetRendererFactory();
        return assetRendererFactory.getPortletId();
    }

    @Override
    public int getStatus() {
        return _entry.getStatus();
    }


    @Override
    public String getSummary(final PortletRequest portletRequest, final PortletResponse portletResponse) {

        int abstractLength = AssetUtil.ASSET_ENTRY_ABSTRACT_LENGTH;

        if (portletRequest != null) {
            abstractLength = GetterUtil.getInteger(
                    portletRequest.getAttribute(
                            WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH),
                    AssetUtil.ASSET_ENTRY_ABSTRACT_LENGTH);
        }

        String summary = _entry.getDescription();

        if (Validator.isNull(summary)) {
            summary = HtmlUtil.stripHtml(
                    StringUtil.shorten(_entry.getName(), abstractLength));
        }

        return summary;
    }



    @Override
    public String getTitle(final Locale locale) {
        return _entry.getName();
    }

    @Override
    public String getType() {
        return CJProductAssetRendererFactory.TYPE;
    }

    @Override
    public PortletURL getURLEdit(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse)
            throws Exception {

        Group group = GroupLocalServiceUtil.fetchGroup(_entry.getGroupId());

        PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
                liferayPortletRequest, group, CJProductPortletKeys.CJPRODUCT, 0, 0,
                PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcRenderCommandName", "/cjproduct/edit");
        portletURL.setParameter("productId", String.valueOf(_entry.getProductId()));

        return portletURL;
    }





    @Override
    public String getUrlTitle() {
        return _entry.getSku();
    }

    @Override
    public String getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState)
            throws Exception {

        AssetRendererFactory<CJProduct> assetRendererFactory =
                getAssetRendererFactory();

        PortletURL portletURL = assetRendererFactory.getURLView(
                liferayPortletResponse, windowState);

        portletURL.setParameter("mvcRenderCommandName", "/cjproduct/view_entry");
        portletURL.setParameter("productId", String.valueOf(_entry.getProductId()));
        portletURL.setWindowState(windowState);

        return portletURL.toString();
    }


    @Override
    public String getURLViewInContext(
            final LiferayPortletRequest liferayPortletRequest,
            final LiferayPortletResponse liferayPortletResponse,
            final String noSuchEntryRedirect) {
        return getURLViewInContext(
                liferayPortletRequest, null, "/cjproduct/find_entry",
                "productId", _entry.getProductId());
    }

    @Override
    public long getUserId() {
        return _entry.getUserId();
    }

    @Override
    public String getUserName() {
        return _entry.getUserName();
    }

    @Override
    public String getUuid() {
        return _entry.getUuid();
    }


    public boolean hasDeletePermission(PermissionChecker permissionChecker) {
        return CJProductPermission.contains(
                permissionChecker, _entry, ActionKeys.DELETE);
    }

    @Override
    public boolean hasEditPermission(PermissionChecker permissionChecker) {
        return CJProductPermission.contains(
                permissionChecker, _entry, ActionKeys.UPDATE);
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) {
        return CJProductPermission.contains(
                permissionChecker, _entry, ActionKeys.VIEW);
    }


    @Override
    public boolean include(
            final HttpServletRequest request, final HttpServletResponse response,
            final String template)
            throws Exception {
        request.setAttribute(CJProductWebKeys.CJPRODUCT_ENTRY, _entry);
        return super.include(request, response, template);
    }

    @Override
    public boolean isPrintable() {
        return true;
    }

    private final CJProduct _entry;

}

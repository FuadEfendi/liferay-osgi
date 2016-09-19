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

import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.service.CJProductLocalService;
import ca.efendi.datafeeds.service.permission.CJProductPermission;
import ca.efendi.datafeeds.service.permission.DatafeedsRootPermission;
import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

@Component(
        immediate = true,
        property = {"javax.portlet.name=" + CJProductPortletKeys.CJPRODUCT},
        service = AssetRendererFactory.class)
public class CJProductAssetRendererFactory
        extends BaseAssetRendererFactory<CJProduct> {

    public static final String TYPE = "cj_product";

    public CJProductAssetRendererFactory() {
        setClassName(CJProduct.class.getName());
        setLinkable(true);
        setSearchable(true);
        setPortletId(CJProductPortletKeys.CJPRODUCT);
    }

    @Override
    public AssetRenderer<CJProduct> getAssetRenderer(final long classPK, final int type)
            throws PortalException {
        final CJProduct product = _cjProductLocalService.getCJProduct(classPK);
        final CJProductAssetRenderer cjProductAssetRenderer = new CJProductAssetRenderer(product);
        cjProductAssetRenderer.setAssetRendererType(type);
        cjProductAssetRenderer.setServletContext(_servletContext);
        return cjProductAssetRenderer;
    }

    @Override
    public AssetRenderer<CJProduct> getAssetRenderer(
            long groupId, String urlTitle)
            throws PortalException {

        CJProduct entry = _cjProductLocalService.getCJProduct(groupId, urlTitle);
        final CJProductAssetRenderer cjProductAssetRenderer = new CJProductAssetRenderer(entry);
        cjProductAssetRenderer.setServletContext(_servletContext);
        return cjProductAssetRenderer;

    }


    @Override
    public String getClassName() {
        return CJProduct.class.getName();
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public PortletURL getURLAdd(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, long classTypeId) {

        PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
                liferayPortletRequest, getGroup(liferayPortletRequest),
                CJProductPortletKeys.CJPRODUCT, 0, 0, PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcRenderCommandName", "/cjproduct/edit_entry");

        return portletURL;
    }

    @Override
    public PortletURL getURLView(
            final LiferayPortletResponse liferayPortletResponse,
            final WindowState windowState) {
        final LiferayPortletURL liferayPortletURL = liferayPortletResponse.createLiferayPortletURL(
                CJProductPortletKeys.CJPRODUCT, PortletRequest.RENDER_PHASE);
        try {
            liferayPortletURL.setWindowState(windowState);
        } catch (final WindowStateException wse) {
        }
        return liferayPortletURL;
    }


    @Override
    public boolean hasAddPermission(
            PermissionChecker permissionChecker, long groupId, long classTypeId)
            throws Exception {

        return DatafeedsRootPermission.contains(
                permissionChecker, groupId, ActionKeys.ADD_ENTRY);
    }

    @Override
    public boolean hasPermission(
            PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {

        return CJProductPermission.contains(
                permissionChecker, classPK, actionId);
    }

    @Reference(
            target = "(osgi.web.symbolicname=ca.efendi.datafeeds.web)", unbind = "-"
    )
    public void setServletContext(ServletContext servletContext) {

        _servletContext = servletContext;
    }


    @Reference(unbind = "-")
    protected void setCJProductLocalService(CJProductLocalService cjProductLocalService) {
        this._cjProductLocalService = cjProductLocalService;
    }


    private CJProductLocalService _cjProductLocalService;
    private volatile ServletContext _servletContext;

}

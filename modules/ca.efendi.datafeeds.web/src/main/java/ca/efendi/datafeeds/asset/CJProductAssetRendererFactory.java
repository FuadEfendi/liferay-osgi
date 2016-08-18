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
import ca.efendi.datafeeds.service.CJProductLocalService;
import ca.efendi.datafeeds.service.CJProductLocalServiceUtil;
import ca.efendi.datafeeds.service.CJProductService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

@Component(immediate = true, property = {
        "javax.portlet.name=" + DatafeedsPortletKeys.DATAFEEDS}, service = AssetRendererFactory.class)
public class CJProductAssetRendererFactory
        extends BaseAssetRendererFactory<CJProduct> {

    public static final String TYPE = "product";

    public CJProductAssetRendererFactory() {
        setClassName(CJProduct.class.getName());
        setLinkable(true);
        setPortletId(DatafeedsPortletKeys.DATAFEEDS);
    }

    @Override
    public AssetRenderer<CJProduct> getAssetRenderer(
            final long classPK, final int type)
            throws PortalException, SystemException {
        final CJProduct product = CJProductLocalServiceUtil.getCJProduct(classPK);
        final CJProductAssetRenderer cjProductAssetRenderer = new CJProductAssetRenderer(product);
        cjProductAssetRenderer.setAssetRendererType(type);
        // cjProductAssetRenderer.setServletContext(_servletContext);
        return cjProductAssetRenderer;
    }

    @Override
    public AssetRenderer<CJProduct> getAssetRenderer(
            final long groupId, final String urlTitle)
            throws PortalException {
        final CJProduct entry = CJProductLocalServiceUtil.getCJProduct(groupId, urlTitle);
        return new CJProductAssetRenderer(entry);
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
    public PortletURL getURLView(
            final LiferayPortletResponse liferayPortletResponse,
            final WindowState windowState) {
        final LiferayPortletURL liferayPortletURL = liferayPortletResponse.createLiferayPortletURL(
                DatafeedsPortletKeys.DATAFEEDS, PortletRequest.RENDER_PHASE);
        try {
            liferayPortletURL.setWindowState(windowState);
        } catch (final WindowStateException wse) {
        }
        return liferayPortletURL;
    }

    @Reference(
            target = "(osgi.web.symbolicname=ca.tokenizer.web)", unbind = "-"
    )
    public void setServletContext(ServletContext servletContext) {
        _servletContext = servletContext;
    }

    // TODO: uncomment it later; current Liferay snapshot is outdated 
    // @Override
    protected String getIconPath(ThemeDisplay themeDisplay) {
        return themeDisplay.getPathThemeImages() + "/blogs/blogs.png";
    }

    @Reference(unbind = "-")
    protected void setCJProductLocalService(CJProductLocalService cjProductLocalService) {
        this._cjProductLocalService = cjProductLocalService;
    }

    @Reference(unbind = "-")
    protected void setCJProductService(CJProductService cjProductService) {
        this._cjProductService = cjProductService;
    }

    private volatile CJProductLocalService _cjProductLocalService;
    private volatile CJProductService _cjProductService;
    private volatile ServletContext _servletContext;
}

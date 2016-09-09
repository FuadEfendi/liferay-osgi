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

package ca.efendi.datafeeds.web.util;

import ca.efendi.datafeeds.model.CJProduct;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class CJProductURLHelper {

    public CJProductURLHelper(
            final RenderRequest renderRequest, final RenderResponse renderResponse,
            final String templatePath) {
        _renderRequest = renderRequest;
        _renderResponse = renderResponse;
        _templatePath = templatePath;
    }

    public PortletURL createViewURL(final CJProduct cjProduct)
            throws PortalException {
        final PortletURL portletURL = _renderResponse.createRenderURL();
        final String portletId = PortalUtil.getPortletId(_renderRequest);
        if (portletId.startsWith(PortletKeys.T_DATAFEEDS_ADMIN) ||
                portletId.startsWith(PortletKeys.T_DATAFEEDS_SEARCH)) {
            portletURL.setParameter(
                    "mvcPath", _templatePath + "view_cjproduct.jsp");
        }
        if (portletId.startsWith(PortletKeys.T_DATAFEEDS_ADMIN)) {
            portletURL.setParameter(
                    "redirect", PortalUtil.getCurrentURL(_renderRequest));
        }
        if (portletId.equals(PortletKeys.T_DATAFEEDS_ADMIN)) {
            portletURL.setParameter(
                    "resourceClassNameId",
                    String.valueOf(PortalUtil.getClassNameId(
                            CJProduct.class.getName())));
            portletURL.setParameter(
                    "resourcePrimKey",
                    String.valueOf(cjProduct.getPrimaryKey()));
        } else {
            portletURL.setParameter("urlTitle", cjProduct.getName());
        }
        return portletURL;
    }

    public PortletURL createViewWithCommentsURL(final CJProduct cjProduct)
            throws PortalException {
        final PortletURL portletURL = createViewURL(cjProduct);
        portletURL.setParameter("expanded", Boolean.TRUE.toString());
        return portletURL;
    }

    public PortletURL createViewWithRedirectURL(
            final CJProduct cjProduct, final String redirect)
            throws PortalException {
        final PortletURL portletURL = createViewURL(cjProduct);
        if (Validator.isNotNull(redirect)) {
            portletURL.setParameter("redirect", redirect);
        }
        return portletURL;
    }

    private final RenderRequest _renderRequest;

    private final RenderResponse _renderResponse;

    private final String _templatePath;
}
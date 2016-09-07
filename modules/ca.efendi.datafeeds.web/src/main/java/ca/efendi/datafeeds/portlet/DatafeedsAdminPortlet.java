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

package ca.efendi.datafeeds.portlet;

import ca.efendi.datafeeds.constants.DatafeedsPortletKeys;
import ca.efendi.datafeeds.exception.NoSuchFtpSubscriptionException;
import ca.efendi.datafeeds.model.FtpSubscription;
import ca.efendi.datafeeds.service.FtpSubscriptionLocalService;
import ca.efendi.datafeeds.util.FtpSubscriptionValidator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY;


@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=datafeeds-web Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/datafeeds_admin/view.jsp",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class DatafeedsAdminPortlet extends MVCPortlet {

    protected String editFtpSubscriptionJSP = "/datafeeds_admin/edit_ftp_subscription.jsp";

    public void addFtpSubscription(final ActionRequest request, final ActionResponse response)
            throws Exception {
        final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(THEME_DISPLAY);
        final FtpSubscription ftpSubscription = ftpSubscriptionFromRequest(request);
        final ArrayList<String> errors = new ArrayList<String>();
        if (FtpSubscriptionValidator.validate(request, errors)) {
            getFtpSubscriptionLocalService().addFtpSubscription(
                    ftpSubscription);
            SessionMessages.add(request, "product-saved-successfully");
        } else {
            SessionErrors.add(request, "fields-required");
        }
    }

    public void updateFtpSubscription(final ActionRequest request, final ActionResponse response)
            throws PortalException, SystemException {
        final ArrayList<String> errors = new ArrayList<>();
        final ServiceContext serviceContext = ServiceContextFactory.getInstance(
                FtpSubscription.class.getName(), request);
        long ftpSubscriptionId = ParamUtil.getLong(request, "ftpSubscriptionId");
        FtpSubscription ftpSubscriptionFromRequest = ftpSubscriptionFromRequest(request);
        if (!FtpSubscriptionValidator.validate(request, errors)) {
            for (final String error : errors) {
                SessionErrors.add(request, error);
            }
            request.setAttribute(DatafeedsPortletKeys.FTP_SUBSCRIPTION_ENTRY, ftpSubscriptionFromRequest);
            response.setRenderParameter(
                    "jspPage", editFtpSubscriptionJSP);
            return;
        }
        if (ftpSubscriptionId > 0) {
            // Updating
            try {
                FtpSubscription ftp = getFtpSubscriptionLocalService()
                        .getFtpSubscription(ftpSubscriptionId);
                if (ftp != null) {
                    ftp.setModifiedDate(new Date());
                    ftp.setFtpHost(ParamUtil.getString(request, "ftpHost"));
                    ftp.setFtpUser(ParamUtil.getString(request, "ftpUser"));
                    ftp.setFtpPassword(ParamUtil.getString(request, "ftpPassword"));
                    ftp.setFtpFolder(ParamUtil.getString(request, "ftpFolder"));
                    ftp.setFtpDatafeedName(ParamUtil.getString(request, "ftpDatafeedName"));
                    ftp.setFtpFile(ParamUtil.getString(request, "ftpFile"));
                    ftp.setFtpDatafeedDescription(ParamUtil.getString(request, "ftpDatafeedDescription"));
                    getFtpSubscriptionLocalService()
                            .updateFtpSubscription(ftp);
                    SessionMessages.add(request, "ftp-subscription-added");
                }
            } catch (final PortalException e) {
                errors.add("failed-to-update");
            } catch (final SystemException e) {
                errors.add("failed-to-update");
            }
        } else {
            // Adding
            try {
                // TODO: FE: "context" is needed for Workflows only; please
                // confirm.
                getFtpSubscriptionLocalService().addFtpSubscription(
                        ftpSubscriptionFromRequest, ftpSubscriptionFromRequest.getUserId(), serviceContext);
            } catch (final SystemException e) {
                errors.add("failed-to-add");
            }
        }
        // response.setRenderParameter("jspPage", "/html/view2.jsp");
    }

    public void deleteFtpSubscription(
            final ActionRequest actionRequest, final ActionResponse actionResponse)
            throws Exception {
        final long ftpSubscriptionId = ParamUtil.getLong(actionRequest, "ftpSubscriptionIdToDelete");
        getFtpSubscriptionLocalService().deleteFtpSubscription(ftpSubscriptionId);
    }

    @Override
    public void render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        try {
            FtpSubscription ftpSubscription = null;
            final long ftpSubscriptionId = ParamUtil.getLong(renderRequest, "ftpSubscriptionId");
            if (ftpSubscriptionId > 0) {
                ftpSubscription = getFtpSubscriptionLocalService().getFtpSubscription(ftpSubscriptionId);
            } else {
                ftpSubscription = getFtpSubscriptionLocalService().createFtpSubscription(0);
            }
            renderRequest.setAttribute(DatafeedsPortletKeys.FTP_SUBSCRIPTION_ENTRY, ftpSubscription);
        } catch (final Exception e) {
            if (e instanceof NoSuchFtpSubscriptionException) {
                SessionErrors.add(renderRequest, e.getClass().getName());
            } else {
                throw new PortletException(e);
            }
        }
        super.render(renderRequest, renderResponse);
    }

    /**
     * @param request
     * @return
     */
    public FtpSubscription ftpSubscriptionFromRequest(final ActionRequest request) {
        final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(THEME_DISPLAY);
        long ftpSubscriptionId = ParamUtil.getLong(request, "ftpSubscriptionId");
        final FtpSubscription ftpSubscription = getFtpSubscriptionLocalService().createFtpSubscription(0);
        ftpSubscription.setFtpSubscriptionId(ParamUtil.getInteger(request, "ftpSubscriptionId"));
        _log.warn("ftpSubscriptionId:" + ftpSubscription.getFtpSubscriptionId());
        ftpSubscription.setCompanyId(themeDisplay.getCompanyId());
        ftpSubscription.setGroupId(themeDisplay.getScopeGroupId());
        ftpSubscription.setUserId(themeDisplay.getUser().getUserId());
        ftpSubscription.setUserName(themeDisplay.getUser().getFullName());
        final Date now = new Date();
        ftpSubscription.setCreateDate(now);
        ftpSubscription.setModifiedDate(now);
        // _log.warn("ftpSubscriptionId:" + ParamUtil.getInteger(request,
        // "ftpSubscriptionId"));
        ftpSubscription.setFtpHost(ParamUtil.getString(request, "ftpHost"));
        ftpSubscription.setFtpUser(ParamUtil.getString(request, "ftpUser"));
        ftpSubscription.setFtpPassword(ParamUtil.getString(request, "ftpPassword"));
        ftpSubscription.setFtpFolder(ParamUtil.getString(request, "ftpFolder"));
        ftpSubscription.setFtpDatafeedName(ParamUtil.getString(request, "ftpDatafeedName"));
        ftpSubscription.setFtpFile(ParamUtil.getString(request, "ftpFile"));
        ftpSubscription.setFtpDatafeedDescription(ParamUtil.getString(request, "ftpDatafeedDescription"));
        return ftpSubscription;
    }

    public FtpSubscriptionLocalService getFtpSubscriptionLocalService() {
        return _ftpSubscriptionLocalService;
    }

    @Reference
    public void setFtpSubscriptionLocalService(FtpSubscriptionLocalService ftpSubscriptionLocalService) {
        this._ftpSubscriptionLocalService = ftpSubscriptionLocalService;
    }

    private static final Log _log = LogFactoryUtil.getLog(DatafeedsAdminPortlet.class);

    private FtpSubscriptionLocalService _ftpSubscriptionLocalService;
}
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

import com.liferay.message.boards.kernel.model.MBMessage;
import com.liferay.message.boards.kernel.service.MBMessageServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;

public class DatafeedsPortlet extends MVCPortlet {

    /*
     * @Override public void serveResource( final ResourceRequest
     * resourceRequest, final ResourceResponse resourceResponse) throws
     * IOException, PortletException { try {
     * 
     * CJProduct kbArticle = null;
     * 
     * final long productId = ParamUtil.getLong( resourceRequest,
     * "resourcePrimKey");
     * 
     * if (productId > 0) { kbArticle =
     * CJProductLocalServiceUtil.getCJProduct(productId); }
     * 
     * resourceRequest.setAttribute( WebKeys.CJ_PRODUCT, kbArticle); } catch
     * (final Exception e) { if ((e instanceof NoSuchArticleException) || (e
     * instanceof PrincipalException)) { SessionErrors.add(resourceRequest,
     * e.getClass()); } }
     * 
     * super.serveResource(resourceRequest, resourceResponse);
     * 
     * }
     */

    /*
     * @Override public void render( final RenderRequest renderRequest, final
     * RenderResponse renderResponse) throws IOException, PortletException {
     * 
     * try { final int status = getStatus(renderRequest);
     * 
     * //renderRequest.setAttribute(WebKeys.KNOWLEDGE_BASE_STATUS, status);
     * 
     * CJProduct kbArticle = null;
     * 
     * final long productId = ParamUtil.getLong( renderRequest,
     * "resourcePrimKey");
     * 
     * if (productId > 0) { kbArticle =
     * CJProductLocalServiceUtil.getCJProduct(productId); }
     * 
     * renderRequest.setAttribute( WebKeys.CJ_PRODUCT, kbArticle); } catch
     * (final Exception e) { if ((e instanceof NoSuchArticleException) || (e
     * instanceof PrincipalException)) {
     * 
     * SessionErrors.add(renderRequest, e.getClass()); } else { throw new
     * PortletException(e); } }
     * 
     * super.render(renderRequest, renderResponse); }
     * 
     */

    /*
     * @Override protected void doDispatch( final RenderRequest renderRequest,
     * final RenderResponse renderResponse) throws IOException, PortletException
     * {
     * 
     * final String mvcPath = ParamUtil.getString( renderRequest, "mvcPath",
     * viewTemplate);
     * 
     * final long assetCategoryId = ParamUtil.getLong(renderRequest,
     * "categoryId"); final String assetTagName =
     * ParamUtil.getString(renderRequest, "tag");
     * 
     * if ((mvcPath.equals(viewTemplate) && (assetCategoryId > 0)) ||
     * (mvcPath.equals(viewTemplate) && Validator.isNotNull(assetTagName))) {
     * 
     * final String path = templatePath + "view_prp_articles.jsp";
     * 
     * include(path, renderRequest, renderResponse); } else if
     * (SessionErrors.contains( renderRequest,
     * NoSuchCJProductException.class.getName())) {
     * 
     * include(templatePath + "error.jsp", renderRequest, renderResponse); }
     * else { super.doDispatch(renderRequest, renderResponse); } }
     */

    protected int getStatus(final RenderRequest renderRequest) throws Exception {
        final ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        if (!themeDisplay.isSignedIn()) {
            return WorkflowConstants.STATUS_APPROVED;
        }
        final String value = renderRequest.getParameter("status");
        final int status = GetterUtil.getInteger(value);
        if ((value != null) && (status == WorkflowConstants.STATUS_APPROVED)) {
            return WorkflowConstants.STATUS_APPROVED;
        }
        final long resourcePrimKey = ParamUtil.getLong(
                renderRequest, "resourcePrimKey");
        if (resourcePrimKey == 0) {
            return WorkflowConstants.STATUS_APPROVED;
        }
        //final PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
        /**
         * if (KBArticlePermission.contains( permissionChecker, resourcePrimKey,
         * ActionKeys.UPDATE)) {
         *
         * return ParamUtil.getInteger( renderRequest, "status",
         * WorkflowConstants.STATUS_ANY); }
         */
        return WorkflowConstants.STATUS_APPROVED;
    }

    public void updateDiscussion(
            final ActionRequest actionRequest, final ActionResponse actionResponse)
            throws Exception {
        final String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
        if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
            updateMessage(actionRequest);
        } else if (cmd.equals(Constants.DELETE)) {
            deleteMessage(actionRequest);
        } else if (cmd.equals(Constants.SUBSCRIBE_TO_COMMENTS)) {
            subscribeToComments(actionRequest, true);
        } else if (cmd.equals(Constants.UNSUBSCRIBE_FROM_COMMENTS)) {
            subscribeToComments(actionRequest, false);
        }
    }

    protected MBMessage updateMessage(final ActionRequest actionRequest)
            throws Exception {
        final ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        final String className = ParamUtil.getString(actionRequest, "className");
        final long classPK = ParamUtil.getLong(actionRequest, "classPK");
        final String permissionClassName = ParamUtil.getString(
                actionRequest, "permissionClassName");
        final long permissionClassPK = ParamUtil.getLong(
                actionRequest, "permissionClassPK");
        final long permissionOwnerId = ParamUtil.getLong(
                actionRequest, "permissionOwnerId");
        final long messageId = ParamUtil.getLong(actionRequest, "messageId");
        final long threadId = ParamUtil.getLong(actionRequest, "threadId");
        final long parentMessageId = ParamUtil.getLong(
                actionRequest, "parentMessageId");
        final String subject = ParamUtil.getString(actionRequest, "subject");
        final String body = ParamUtil.getString(actionRequest, "body");
        final ServiceContext serviceContext = ServiceContextFactory.getInstance(
                MBMessage.class.getName(), actionRequest);
        final MBMessage message = null;

        /*
         * if (messageId <= 0) { message =
         * MBMessageServiceUtil.addDiscussionMessage(
         * serviceContext.getScopeGroupId(), className, classPK,
         * permissionClassName, permissionClassPK, permissionOwnerId, threadId,
         * parentMessageId, subject, body, serviceContext); } else { message =
         * MBMessageServiceUtil.updateDiscussionMessage( className, classPK,
         * permissionClassName, permissionClassPK, permissionOwnerId, messageId,
         * subject, body, serviceContext); }
         */
        // Subscription
        final boolean subscribe = ParamUtil.getBoolean(actionRequest, "subscribe");
        if (subscribe) {
            SubscriptionLocalServiceUtil.addSubscription(
                    themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
                    className, classPK);
        }
        return message;
    }

    protected void deleteMessage(final ActionRequest actionRequest) throws Exception {
        final long groupId = PortalUtil.getScopeGroupId(actionRequest);
        final String className = ParamUtil.getString(actionRequest, "className");
        final long classPK = ParamUtil.getLong(actionRequest, "classPK");
        final String permissionClassName = ParamUtil.getString(
                actionRequest, "permissionClassName");
        final long permissionClassPK = ParamUtil.getLong(
                actionRequest, "permissionClassPK");
        final long permissionOwnerId = ParamUtil.getLong(
                actionRequest, "permissionOwnerId");
        final long messageId = ParamUtil.getLong(actionRequest, "messageId");
        MBMessageServiceUtil.deleteDiscussionMessage(
                groupId, className, classPK, permissionClassName, permissionClassPK,
                permissionOwnerId, messageId);
    }

    protected void subscribeToComments(
            final ActionRequest actionRequest, final boolean subscribe)
            throws Exception {
        final ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        final String className = ParamUtil.getString(actionRequest, "className");
        final long classPK = ParamUtil.getLong(actionRequest, "classPK");
        if (subscribe) {
            SubscriptionLocalServiceUtil.addSubscription(
                    themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
                    className, classPK);
        } else {
            SubscriptionLocalServiceUtil.deleteSubscription(
                    themeDisplay.getUserId(), className, classPK);
        }
    }
}
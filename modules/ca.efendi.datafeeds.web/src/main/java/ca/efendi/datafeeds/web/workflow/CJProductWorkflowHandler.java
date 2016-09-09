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

package ca.efendi.datafeeds.web.workflow;

import ca.efendi.datafeeds.model.CJProduct;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public class CJProductWorkflowHandler extends BaseWorkflowHandler<CJProduct> {

    @Override
    public String getClassName() {
        return CJProduct.class.getName();
    }

    @Override
    public String getType(final Locale locale) {
        return ResourceActionsUtil.getModelResource(locale, getClassName());
    }

    /*    @Override
        public KBArticle updateStatus(
                final int status, final Map<String, Serializable> workflowContext)
                throws PortalException
        {

            final long userId = GetterUtil.getLong(
                    (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
            final long resourcePrimKey = GetterUtil.getLong(
                    (String) workflowContext.get(
                            WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

            final ServiceContext serviceContext = (ServiceContext) workflowContext.get(
                    "serviceContext");

            return CJProductLocalServiceUtil.updateStatus(
                    userId, resourcePrimKey, status, serviceContext);
        }
    */
    //@Override
    //protected String getIconPath(final ThemeDisplay themeDisplay)
    //{
    //    return themeDisplay.getPathThemeImages() + "/trees/page.png";
    //}

    /**
     * @see com.liferay.portal.kernel.workflow.WorkflowHandler#updateStatus(int,
     * Map)
     */
    @Override
    public CJProduct updateStatus(final int status, final Map<String, Serializable> workflowContext) throws PortalException {
        // TODO Auto-generated method stub
        return null;
    }
}
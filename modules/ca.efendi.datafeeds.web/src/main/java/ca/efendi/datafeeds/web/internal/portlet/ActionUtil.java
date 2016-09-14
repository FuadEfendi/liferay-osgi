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

package ca.efendi.datafeeds.web.internal.portlet;

import ca.efendi.datafeeds.model.FtpSubscription;
import ca.efendi.datafeeds.service.FtpSubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class ActionUtil {

    public static List<FtpSubscription> getFtpSubscriptions(final RenderRequest request) {
        final ThemeDisplay themeDisplay =
                (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        final long groupId = themeDisplay.getScopeGroupId();
        List<FtpSubscription> tempResults;
        try {
            tempResults = FtpSubscriptionLocalServiceUtil.getAllFtpSubscriptions(groupId);
        } catch (final SystemException se) {
            tempResults = Collections.EMPTY_LIST;
        }
        return tempResults;
    }
}

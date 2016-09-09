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

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusMessageTranslator;
import com.liferay.portal.kernel.messaging.Message;

import java.io.Serializable;

public class MyBackgroundTaskStatusMessageTranslator
        implements BackgroundTaskStatusMessageTranslator {

    /**
     * @see BackgroundTaskStatusMessageTranslator#translate(BackgroundTaskStatus,
     * Message)
     */
    @Override
    public void translate(final BackgroundTaskStatus backgroundTaskStatus, final Message message) {
        backgroundTaskStatus.setAttribute("xy", doTranslate(message.getString("xy")));
    }

    Serializable doTranslate(final String message) {
        return message;
    }
}
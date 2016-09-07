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

package ca.efendi.datafeeds.configuration;


import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "collaboration")
@Meta.OCD(
        id = "ca.efendi.datafeeds.configuration.FtpSubscriptionConfiguration",
        localization = "content/Language", name = "ftpsubscription.configuration.name"
)
public interface FtpSubscriptionConfiguration {


    /**
     * Set the interval in minutes on how often CheckEntryMessageListener will
     * run to check for and display blog entries scheduled to display.
     */
    @Meta.AD(deflt = "1", required = false)
    public int entryCheckInterval();

    /**
     * Set the interval on which the LinkbackMessageListener will run. The value
     * is set in one minute increments.
     */
    @Meta.AD(deflt = "5", required = false)
    public int linkbackJobInterval();

}

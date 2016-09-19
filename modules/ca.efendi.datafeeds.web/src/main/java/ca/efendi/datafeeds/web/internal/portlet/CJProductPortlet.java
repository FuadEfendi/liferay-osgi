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

import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import com.liferay.portal.kernel.model.Release;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.application-type=full-page-application",
                "com.liferay.portlet.application-type=widget",
                "com.liferay.portlet.css-class-wrapper=portlet-cjproduct",
                "com.liferay.portlet.display-category=category.datafeeds",
                "com.liferay.portlet.header-portlet-css=/blogs/css/main.css",
                "com.liferay.portlet.icon=/blogs/icons/blogs.png",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.preferences-unique-per-layout=false",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.scopeable=true",
                "com.liferay.portlet.struts-path=cjproduct",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=CJProduct",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.always-display-default-configuration-icons=true",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.name=" + CJProductPortletKeys.CJPRODUCT,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=guest,power-user,user",
                "javax.portlet.supported-public-render-parameter=categoryId",
                "javax.portlet.supported-public-render-parameter=resetCur",
                "javax.portlet.supported-public-render-parameter=tag",
                "javax.portlet.supports.mime-type=text/html"
        },
        service = Portlet.class
)
public class CJProductPortlet extends MVCPortlet {

}
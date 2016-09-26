package ca.efendi.socialcomments.web.internal.portlet;

import ca.efendi.socialcomments.web.internal.constants.SocialCommentsPortletKeys;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.css-class-wrapper=social-comments-portlet",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.header-portlet-javascript=/js/main.js",
                "com.liferay.portlet.icon=/icon.png",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=Social Comments",
                "com.liferay.portlet.control-panel-entry-category=content",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + SocialCommentsPortletKeys.SOCIAL_COMMENTS_PORTLET,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator,guest,power-user,user",
                "javax.portlet.supports.mime-type=text/html"
        },
        service = Portlet.class
)
public class SocialCommentsPortlet extends MVCPortlet {

    public void updateConfiguration(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {

        try {
            ServiceContext serviceContext =
                    ServiceContextFactory.getInstance(actionRequest);

            long scopeGroupId = serviceContext.getScopeGroupId();

            Group scopeGroup = GroupLocalServiceUtil.getGroup(scopeGroupId);

            if (scopeGroup.isStagingGroup()) {
                scopeGroup = scopeGroup.getLiveGroup();
            }

            UnicodeProperties typeSettingsProperties =
                    scopeGroup.getTypeSettingsProperties();

            UnicodeProperties properties = PropertiesParamUtil.getProperties(
                    actionRequest, "settings--");

            typeSettingsProperties.putAll(properties);

            GroupServiceUtil.updateGroup(
                    scopeGroup.getGroupId(), scopeGroup.getTypeSettings());
        } catch (Exception e) {
            SessionErrors.add(actionRequest, e.getClass().getName());
        }
    }

}

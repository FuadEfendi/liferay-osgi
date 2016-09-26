package ca.efendi.socialcomments.web.internal.portlet;

import ca.efendi.socialcomments.web.internal.constants.SocialCommentsPortletKeys;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.BaseControlPanelEntry;
import com.liferay.portal.kernel.portlet.ControlPanelEntry;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SocialCommentsPortletKeys.SOCIAL_COMMENTS_PORTLET
        },
        service = ControlPanelEntry.class
)
public class SocialCommentsControlPanelEntry extends BaseControlPanelEntry {

    @Override
    protected boolean hasAccessPermissionDenied(
            PermissionChecker permissionChecker, Group group, Portlet portlet)
            throws Exception {

        if (group.isLayoutSetPrototype()) {
            return true;
        }

        return super.hasAccessPermissionDenied(
                permissionChecker, group, portlet);
    }

}

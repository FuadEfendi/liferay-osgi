package ca.efendi.datafeeds.web.internal.portlet.route;

import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
                "javax.portlet.name=" + CJProductPortletKeys.CJPRODUCT
        },
        service = FriendlyURLMapper.class
)
public class CJProductFriendlyURLMapper extends DefaultFriendlyURLMapper {

    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "cjproduct";

}
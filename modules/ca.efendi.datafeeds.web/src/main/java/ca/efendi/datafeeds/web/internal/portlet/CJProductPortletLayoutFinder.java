package ca.efendi.datafeeds.web.internal.portlet;

import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import com.liferay.portal.kernel.portlet.BasePortletLayoutFinder;
import com.liferay.portal.kernel.portlet.PortletLayoutFinder;
import org.osgi.service.component.annotations.Component;


@Component(
        immediate = true,
        property = {"model.class.name=ca.efendi.datafeeds.model.CJProduct"},
        service = PortletLayoutFinder.class
)
public class CJProductPortletLayoutFinder extends BasePortletLayoutFinder {

    @Override
    protected String[] getPortletIds() {
        return _PORTLET_IDS;
    }

    private static final String[] _PORTLET_IDS = {CJProductPortletKeys.CJPRODUCT};

}
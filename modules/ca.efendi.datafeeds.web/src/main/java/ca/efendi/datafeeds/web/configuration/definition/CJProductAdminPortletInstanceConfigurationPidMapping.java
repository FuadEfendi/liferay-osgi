package ca.efendi.datafeeds.web.configuration.definition;

import ca.efendi.datafeeds.web.configuration.CJProductPortletInstanceConfiguration;
import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import org.osgi.service.component.annotations.Component;


@Component
public class CJProductAdminPortletInstanceConfigurationPidMapping
        implements ConfigurationPidMapping {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return CJProductPortletInstanceConfiguration.class;
    }

    @Override
    public String getConfigurationPid() {
        return CJProductPortletKeys.CJPRODUCT_ADMIN;
    }

}
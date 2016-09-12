package ca.efendi.datafeeds.configuration.definition;

import ca.efendi.datafeeds.configuration.CJProductGroupServiceConfiguration;
import ca.efendi.datafeeds.constants.CJProductConstants;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import org.osgi.service.component.annotations.Component;

@Component
public class CJProductGroupServiceConfigurationPidMapping
        implements ConfigurationPidMapping {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return CJProductGroupServiceConfiguration.class;
    }

    @Override
    public String getConfigurationPid() {
        return CJProductConstants.SERVICE_NAME;
    }

}
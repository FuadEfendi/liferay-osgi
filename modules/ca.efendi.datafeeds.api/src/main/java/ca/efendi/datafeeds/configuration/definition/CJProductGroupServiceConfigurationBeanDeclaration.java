package ca.efendi.datafeeds.configuration.definition;

import ca.efendi.datafeeds.configuration.CJProductGroupServiceConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import org.osgi.service.component.annotations.Component;

@Component
public class CJProductGroupServiceConfigurationBeanDeclaration
        implements ConfigurationBeanDeclaration {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return CJProductGroupServiceConfiguration.class;
    }

}
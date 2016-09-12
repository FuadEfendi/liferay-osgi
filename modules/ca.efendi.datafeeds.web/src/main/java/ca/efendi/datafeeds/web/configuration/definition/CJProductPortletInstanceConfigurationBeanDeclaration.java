package ca.efendi.datafeeds.web.configuration.definition;

import ca.efendi.datafeeds.web.configuration.CJProductPortletInstanceConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import org.osgi.service.component.annotations.Component;

@Component
public class CJProductPortletInstanceConfigurationBeanDeclaration
        implements ConfigurationBeanDeclaration {

    @Override
    public Class<?> getConfigurationBeanClass() {
        return CJProductPortletInstanceConfiguration.class;
    }

}
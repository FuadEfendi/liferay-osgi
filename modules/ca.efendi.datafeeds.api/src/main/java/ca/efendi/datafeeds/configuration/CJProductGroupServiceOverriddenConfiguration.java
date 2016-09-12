package ca.efendi.datafeeds.configuration;

import ca.efendi.datafeeds.configuration.definition.CJProductGroupServiceConfigurationOverrideImpl;
import com.liferay.portal.kernel.settings.Settings;

@Settings.OverrideClass(CJProductGroupServiceConfigurationOverrideImpl.class)
public interface CJProductGroupServiceOverriddenConfiguration
        extends CJProductGroupServiceConfiguration,
        CJProductGroupServiceConfigurationOverride {
}
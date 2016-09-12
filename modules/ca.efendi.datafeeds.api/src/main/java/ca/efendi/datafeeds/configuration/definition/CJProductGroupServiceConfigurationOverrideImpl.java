package ca.efendi.datafeeds.configuration.definition;

import ca.efendi.datafeeds.configuration.CJProductGroupServiceConfigurationOverride;
import com.liferay.portal.kernel.settings.TypedSettings;
import com.liferay.portal.kernel.util.PortalUtil;

public class CJProductGroupServiceConfigurationOverrideImpl
        implements CJProductGroupServiceConfigurationOverride {

    public CJProductGroupServiceConfigurationOverrideImpl(
            TypedSettings typedSettings) {

        _typedSettings = typedSettings;
    }

    @Override
    public boolean enableRss() {
        if (!PortalUtil.isRSSFeedsEnabled()) {
            return false;
        }

        return _typedSettings.getBooleanValue("enableRss");
    }

    private final TypedSettings _typedSettings;

}
package ca.efendi.datafeeds.web.internal.display.context;

import ca.efendi.datafeeds.web.configuration.CJProductPortletInstanceConfiguration;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;

public class CJProductPortletInstanceSettingsHelper {

    public CJProductPortletInstanceSettingsHelper(
            HttpServletRequest request,
            CJProductPortletInstanceConfiguration blogsPortletInstanceConfiguration) {

        _request = request;
        _blogsPortletInstanceConfiguration = blogsPortletInstanceConfiguration;
    }

    public long getDisplayStyleGroupId() {
        if (_displayStyleGroupId != 0) {
            return _displayStyleGroupId;
        }

        _displayStyleGroupId =
                _blogsPortletInstanceConfiguration.displayStyleGroupId();

        if (_displayStyleGroupId <= 0) {
            ThemeDisplay themeDisplay = (ThemeDisplay) _request.getAttribute(
                    WebKeys.THEME_DISPLAY);

            _displayStyleGroupId = themeDisplay.getScopeGroupId();
        }

        return _displayStyleGroupId;
    }

    private final CJProductPortletInstanceConfiguration
            _blogsPortletInstanceConfiguration;
    private long _displayStyleGroupId;
    private final HttpServletRequest _request;

}
<%@ page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil" %>
<%@ page import="com.liferay.portal.kernel.settings.GroupServiceSettingsLocator" %>
<%@ page import="com.liferay.portal.kernel.settings.PortletInstanceSettingsLocator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PropsValues" %>
<%@ page import="com.liferay.portlet.blogs.constants.BlogsConstants" %>
<%@ page import="ca.efendi.datafeeds.configuration.CJProductGroupServiceOverriddenConfiguration" %>
<%@ page import="ca.efendi.datafeeds.configuration.CJProductGroupServiceSettings" %>
<%@ page import="ca.efendi.datafeeds.web.configuration.CJProductPortletInstanceConfiguration" %>
<%@ page import="ca.efendi.datafeeds.web.internal.display.context.CJProductPortletInstanceSettingsHelper" %>

<%@ include file="/init.jsp" %>
<%
    String portletResource = ParamUtil.getString(request, "portletResource");

    String portletId = portletDisplay.getId();

    if (Validator.isNotNull(portletResource)) {
        portletId = portletResource;
        portletName = portletResource;
    }

    CJProductGroupServiceOverriddenConfiguration blogsGroupServiceOverriddenConfiguration =
            ConfigurationProviderUtil.getConfiguration(
                    CJProductGroupServiceOverriddenConfiguration.class,
                    new GroupServiceSettingsLocator(themeDisplay.getSiteGroupId(), BlogsConstants.SERVICE_NAME));

    CJProductGroupServiceSettings blogsGroupServiceSettings = CJProductGroupServiceSettings.getInstance(scopeGroupId);

    CJProductPortletInstanceConfiguration blogsPortletInstanceConfiguration =
            ConfigurationProviderUtil.getConfiguration(
                    CJProductPortletInstanceConfiguration.class,
                    new PortletInstanceSettingsLocator(themeDisplay.getLayout(), portletDisplay.getId()));

    CJProductPortletInstanceSettingsHelper blogsPortletInstanceSettingsHelper =
            new CJProductPortletInstanceSettingsHelper(request, blogsPortletInstanceConfiguration);

    int pageAbstractLength = PropsValues.BLOGS_PAGE_ABSTRACT_LENGTH;
%>


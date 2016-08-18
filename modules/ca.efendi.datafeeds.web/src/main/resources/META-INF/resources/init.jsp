<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@ taglib uri="http://liferay.com/tld/flags" prefix="liferay-flags" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/item-selector" prefix="liferay-item-selector" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/trash" prefix="liferay-trash" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="java.text.Format" %>



<liferay-theme:defineObjects/>

<portlet:defineObjects/>

<%
    // for "resource" such as comments pagination it won't work:
//WindowState windowState = renderRequest.getWindowState();
    String currentURL = PortalUtil.getCurrentURL(request);
// String redirect = ParamUtil.getString(request, "redirect", currentURL);
    String rootPortletId = portletDisplay.getRootPortletId();
    String templatePath = portletConfig.getInitParameter("template-path");
    Format dateFormatDate = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.LONG, locale, timeZone);
    Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.LONG, FastDateFormatConstants.SHORT, locale, timeZone);
    Format dateFormatTime = FastDateFormatFactoryUtil.getTime(locale, timeZone);
    String kbArticlesOrderByCol = portletPreferences.getValue("kbArticlesOrderByCol", StringPool.BLANK);
    String kbArticlesOrderByType = portletPreferences.getValue("kbArticlesOrderByType", StringPool.BLANK);
    boolean enableKBArticleDescription = GetterUtil.getBoolean(portletPreferences.getValue("enableKBArticleDescription", null));
    boolean enableKBArticleRatings = GetterUtil.getBoolean(portletPreferences.getValue("enableKBArticleRatings", null));
    String kbArticleRatingsType = GetterUtil.getString(portletPreferences.getValue("kbArticleRatingsType", null), "thumbs");
    boolean showKBArticleAssetEntries = GetterUtil.getBoolean(portletPreferences.getValue("showKBArticleAssetEntries", null));
    boolean enableKBArticleAssetLinks = GetterUtil.getBoolean(portletPreferences.getValue("enableKBArticleAssetLinks", null), true);
    boolean enableKBArticleViewCountIncrement = GetterUtil.getBoolean(portletPreferences.getValue("enableKBArticleViewCountIncrement", null));
    boolean enableKBArticleSubscriptions = GetterUtil.getBoolean(portletPreferences.getValue("enableKBArticleSubscriptions", null), true);
    boolean enableKBArticleHistory = GetterUtil.getBoolean(portletPreferences.getValue("enableKBArticleHistory", null), true);
    boolean enableKBArticlePrint = GetterUtil.getBoolean(portletPreferences.getValue("enableKBArticlePrint", null), true);
    boolean enableSocialBookmarks = GetterUtil.getBoolean(portletPreferences.getValue("enableSocialBookmarks", null), false);
    String socialBookmarksDisplayStyle = portletPreferences.getValue("socialBookmarksDisplayStyle", ""); // TODO: default style?
    String socialBookmarksDisplayPosition = portletPreferences.getValue("socialBookmarksDisplayPosition", "bottom");
    String socialBookmarksTypes = portletPreferences.getValue("socialBookmarksTypes", PropsUtil.get(PropsKeys.SOCIAL_BOOKMARK_TYPES));
    boolean enableKBTemplateKBComments = GetterUtil.getBoolean(portletPreferences.getValue("enableKBTemplateKBComments", null));
    boolean showKBTemplateKBComments = GetterUtil.getBoolean(portletPreferences.getValue("showKBTemplateKBComments", null));
    boolean enableRSS = !PortalUtil.isRSSFeedsEnabled() ? false : GetterUtil.getBoolean(portletPreferences.getValue("enableRss", null), true);
    int rssDelta = GetterUtil.getInteger(portletPreferences.getValue("rssDelta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
    String rssDisplayStyle = portletPreferences.getValue("rssDisplayStyle", RSSUtil.DISPLAY_STYLE_FULL_CONTENT);
    String rssFeedType = portletPreferences.getValue("rssFeedType", RSSUtil.FEED_TYPE_DEFAULT);

%>

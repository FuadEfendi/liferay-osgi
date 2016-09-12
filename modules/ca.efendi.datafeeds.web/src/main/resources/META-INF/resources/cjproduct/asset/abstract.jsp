<%@ page import="ca.efendi.datafeeds.model.CJProduct" %>
<%@ page import="ca.efendi.datafeeds.web.constants.CJProductWebKeys" %>
<%@ include file="/cjproduct/init.jsp" %>

<%
    AssetRenderer<?> assetRenderer = (AssetRenderer<?>) request.getAttribute(WebKeys.ASSET_RENDERER);

    CJProduct entry = (CJProduct) request.getAttribute(CJProductWebKeys.CJPRODUCT_ENTRY);

    Portlet portlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletDisplay.getId());
%>

<liferay-util:html-top outputKey="cjproduct_common_main_css">
    <link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/cjproduct/css/common_main.css", portlet.getTimestamp()) %>"
          rel="stylesheet" type="text/css"/>
</liferay-util:html-top>

<c:if test="<%= entry.isSmallImage() %>">
    <div class="asset-small-image">
        <img alt="" class="asset-small-image img-thumbnail"
             src="<%= HtmlUtil.escape(entry.getSmallImageURL(themeDisplay)) %>" width="150"/>
    </div>
</c:if>

<div class="portlet-blogs">
    <div class="entry-body">

        <%
            String coverImageURL = entry.getCoverImageURL(themeDisplay);
        %>

        <c:if test="<%= Validator.isNotNull(coverImageURL) %>">
            <div class="cover-image-container" style="background-image: url(<%= coverImageURL %>)"></div>
        </c:if>

        <%= assetRenderer.getSummary(renderRequest, renderResponse) %>
    </div>
</div>
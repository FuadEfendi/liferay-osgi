<%@ page import="ca.efendi.datafeeds.model.CJProduct" %>
<%@ page import="ca.efendi.datafeeds.web.constants.CJProductWebKeys" %>

<%@ include file="/cjproduct/init.jsp" %>

<%
    CJProduct entry = (CJProduct) request.getAttribute(CJProductWebKeys.CJPRODUCT_ENTRY);

    Portlet portlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletDisplay.getId());
%>

<liferay-util:html-top outputKey="cjproduct_common_main_css">
    <link href="<%= PortalUtil.getStaticResourceURL(request, application.getContextPath() + "/cjproduct/css/common_main.css", portlet.getTimestamp()) %>"
          rel="stylesheet" type="text/css"/>
</liferay-util:html-top>

<div class="portlet-blogs">
    <div class="entry-body">

        <%
            String coverImageURL = entry.getCoverImageURL(themeDisplay);
        %>

        <c:if test="<%= Validator.isNotNull(coverImageURL) %>">
            <div class="cover-image-container" style="background-image: url(<%= coverImageURL %>)"></div>
        </c:if>

        <%
            String subtitle = entry.getSubtitle();
        %>

        <c:if test="<%= Validator.isNotNull(subtitle) %>">
            <div class="entry-subtitle">
                <p><%= HtmlUtil.escape(subtitle) %>
                </p>
            </div>
        </c:if>

        <div class="entry-date icon-calendar">
            <span class="hide-accessible"><liferay-ui:message key="published-date"/></span>

            <%= dateFormatDateTime.format(entry.getModifiedDate()) %>
        </div>

        <%= entry.getContent() %>

        <liferay-ui:custom-attributes-available className="<%= CJProduct.class.getName() %>">
            <liferay-ui:custom-attribute-list
                    className="<%= CJProduct.class.getName() %>"
                    classPK="<%= (entry != null) ? entry.getEntryId() : 0 %>"
                    editable="<%= false %>"
                    label="<%= true %>"
            />
        </liferay-ui:custom-attributes-available>
    </div>
</div>
<%@ page import="ca.efendi.datafeeds.model.CJProduct" %>
<%@ page import="ca.efendi.datafeeds.web.constants.CJProductWebKeys" %>


<%@ include file="/cjproduct/init.jsp" %>

<aui:input name="redirect" type="hidden" value="<%= currentURL %>"/>

<%
    //String redirect = ParamUtil.getString(request, "redirect");
    //portletDisplay.setShowBackIcon(true);
    //portletDisplay.setURLBack(redirect);

    CJProduct product = (CJProduct) request.getAttribute(CJProductWebKeys.CJPRODUCT_ENTRY);
%>

<c:if test="<%= product != null %>">
    <%
        //product = product.toEscapedModel();
        renderResponse.setTitle(product.getSku());
    %>
    <div class="container-fluid">

        <aui:row>

            <aui:col span="4">
                <img src="<%= product.getImageUrl() %>" class="img-responsive img-thumbnail" />
            </aui:col>
            <aui:col span="8">
                <img src="<%= product.getImpressionUrl() %>" vspace="0"/>
                <h2>SKU: <%=product.getSku()%></h2>
                <h3>Suggested price: <%= product.getPrice() %> <%= product.getCurrency() %></h3>
                <aui:a cssClass="btn btn-default" href="<%= product.getBuyUrl() %>" target="_blank">
                    <liferay-ui:message key="check-retail-price"/>
                </aui:a>
                <h5 class="text-default"><%= product.getName() %></h5>
                <h6 class="text-default"><%= product.getDescription() %></h6>
                <h7 class="text-default">Category: </h7>

            </aui:col>

        </aui:row>

        <%
            Discussion discussion = CommentManagerUtil.getDiscussion(user.getUserId(), scopeGroupId, CJProduct.class.getName(), product.getProductId(), new ServiceContextFunction(request));
        %>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <c:if test="<%= (discussion != null) && blogsPortletInstanceConfiguration.enableComments() %>">
                    <h2>
                        <strong><liferay-ui:message arguments="<%= CommentManagerUtil.getCommentsCount(CJProduct.class.getName(), product.getEntryId()) %>" key="x-comments" /></strong>
                    </h2>



                    <liferay-ui:discussion
                            className="<%= CJProduct.class.getName() %>"
                            classPK="<%= product.getEntryId() %>"
                            formName="fm2"
                            ratingsEnabled="<%= blogsPortletInstanceConfiguration.enableCommentRatings() %>"
                            redirect="<%= currentURL %>"
                            userId="<%= product.getUserId() %>"
                    />
                </c:if>
            </div>
        </div>


    </div>

</c:if>

<c:if test="<%= product == null %>">
    <h3><strong>No product selected</strong></h3>
</c:if>


<%
    PortalUtil.setPageTitle(product.getName(), request);
    PortalUtil.setPageSubtitle(product.getSubtitle(), request);
    PortalUtil.setPageDescription(product.getDescription(), request);

    List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(CJProduct.class.getName(), product.getEntryId());

    PortalUtil.setPageKeywords(ListUtil.toString(assetTags, AssetTag.NAME_ACCESSOR), request);

    PortalUtil.addPortletBreadcrumbEntry(request, product.getName(), currentURL);
%>

<liferay-util:dynamic-include key="com.liferay.blogs.web#/blogs/view_entry.jsp#post" />
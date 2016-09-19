<%@ page import="ca.efendi.datafeeds.model.CJProduct" %>
<%@ page import="ca.efendi.datafeeds.web.constants.CJProductWebKeys" %>
<%@ include file="/cjproduct/init.jsp" %>

<aui:input name="redirect" type="hidden" value="<%= currentURL %>"/>

<%
    String redirect = ParamUtil.getString(request, "redirect");
    portletDisplay.setShowBackIcon(true);
    portletDisplay.setURLBack(redirect);

    CJProduct product = (CJProduct) request.getAttribute(CJProductWebKeys.CJPRODUCT_ENTRY);
%>

<c:if test="<%= product != null %>">
    <%
        product = product.toEscapedModel();
        renderResponse.setTitle(product.getName());
    %>

    <aui:form name="fm"
              onSubmit="submitForm(document.<portlet:namespace />fm, '<%=product.getBuyUrl()%>', false); return false;"
              target="_blank">
        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset>
                <h4><strong><%= product.getSku() %>
                </strong></h4>


                <img src="<%= product.getImpressionUrl() %>" vspace="0"/>

                <img src="<%= product.getImageUrl() %>"/>

                <h3><strong><%= product.getName() %>
                </strong></h3>

                <c:if test="<%= Validator.isNotNull(product.getDescription()) %>">
                    <h6 class="text-default"><%= product.getDescription() %>
                    </h6>
                </c:if>


            </aui:fieldset>
        </aui:fieldset-group>

        <aui:button-row>
            <aui:button cssClass="btn-lg" onClick='<%= renderResponse.getNamespace() + "addToCart();" %>'
                        primary="<%= true %>" value="add-to-shopping-cart"/>
            <aui:button type="submit" value='<liferay-ui:message key="BUY" />'/>

        </aui:button-row>

    </aui:form>

</c:if>

<c:if test="<%= product == null %>">
    <h3><strong>No product selected</strong></h3>
</c:if>

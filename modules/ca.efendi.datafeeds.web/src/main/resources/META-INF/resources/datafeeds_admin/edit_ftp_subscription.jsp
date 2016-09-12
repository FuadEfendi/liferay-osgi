<%@include file="/datafeeds_admin/init.jsp" %>


<portlet:renderURL windowState="normal" var="backURL">
    <portlet:param name="jspPage" value="/datafeeds_admin/view.jsp"></portlet:param>
</portlet:renderURL>
<liferay-ui:header backURL="<%=backURL%>" title="FTP Subscriptions"/>
<%
    FtpSubscription ftpSubscription = (FtpSubscription) request.getAttribute(DatafeedsPortletKeys.FTP_SUBSCRIPTION_ENTRY);
    String redirect = ParamUtil.getString(request, "redirect");
    long ftpSubscriptionId = BeanParamUtil.getLong(ftpSubscription, request, "ftpSubscriptionId");
    // from "slogan" portlet:
    // int status = BeanParamUtil.getInteger(ftpSubscription, request, "status", WorkflowConstants.STATUS_DRAFT);
%>
<portlet:actionURL name="updateFtpSubscription" var="updateURL">
    <portlet:param name="redirect" value="<%=redirect%>"/>
</portlet:actionURL>
<portlet:renderURL var="cancelURL">
    <portlet:param name="jspPage" value="/datafeeds_admin/view.jsp"/>
</portlet:renderURL>
<aui:form name="fm" action="<%=updateURL.toString()%>" method="post">
    <aui:fieldset>
        <aui:model-context bean="<%=ftpSubscription%>" model="<%=FtpSubscription.class%>"/>
        <aui:input name="ftpSubscriptionId" type="hidden"/>
        <h1>FTP Subscription Entry</h1>
        <liferay-ui:error key="ftp-subscription-required" message="ftp-subscription-required"/>
        <aui:input name="ftpHost" autoFocus="true" size="45"/>
        <aui:input name="ftpFolder" size="45"/>
        <aui:input name="ftpFile" size="45"/>
        <aui:input name="ftpUser" size="45"/>
        <aui:input name="ftpPassword" size="45"/>
        <aui:input name="ftpDatafeedName" size="45"/>
        <aui:input name="ftpDatafeedDescription" size="45"/>
        <aui:button-row>
            <aui:button type="submit"/>
            <aui:button type="cancel" value="Cancel" onClick="<%=cancelURL%>"/>
        </aui:button-row>
    </aui:fieldset>
</aui:form>

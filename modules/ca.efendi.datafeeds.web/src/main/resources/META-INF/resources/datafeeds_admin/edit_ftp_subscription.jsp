<%@ page import="ca.efendi.datafeeds.constants.DatafeedsPortletKeys" %>
<%@ page import="ca.efendi.datafeeds.model.FtpSubscription" %><%--
  ~ Copyright (c) 2016 Fuad Efendi <fuad@efendi.ca>
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~     http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
  --%>
<%@include file="init.jsp" %>

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

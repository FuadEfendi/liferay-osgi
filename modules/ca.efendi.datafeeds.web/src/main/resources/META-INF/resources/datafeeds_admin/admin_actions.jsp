
<%--
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

<%
    ResultRow row = (ResultRow) request.getAttribute(
            WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    FtpSubscription ftpSubscription = (FtpSubscription) row.getObject();
    long groupId = themeDisplay.getLayout().getGroupId();
    String name = FtpSubscription.class.getName();
    String ftpSubscriptionId = String.valueOf(ftpSubscription.getFtpSubscriptionId());
    String jspPage = ParamUtil.getString(request, "jspPage");
    String redirect = ParamUtil.getString(request, "redirect");

%>
<liferay-ui:icon-menu>
    <portlet:renderURL var="edit">
        <portlet:param name="ftpSubscriptionId" value="<%=ftpSubscriptionId%>"/>
        <portlet:param name="jspPage" value="/admin/edit_ftp_subscription.jsp"/>
    </portlet:renderURL>
    <liferay-ui:icon image="edit" message="Edit" url="<%=edit.toString()%>"/>
    <portlet:actionURL name="deleteFtpSubscription" var="deleteURL">
        <portlet:param name="redirect" value="<%=redirect%>"/>
        <portlet:param name="ftpSubscriptionIdToDelete" value="<%=ftpSubscriptionId%>"/>
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%=deleteURL.toString()%>"/>
</liferay-ui:icon-menu>
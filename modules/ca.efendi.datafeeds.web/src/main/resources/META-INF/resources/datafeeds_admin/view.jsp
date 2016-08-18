<%@include file="init.jsp" %>
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

<%--
<liferay-ui:icon-menu>
    <portlet:actionURL name="fetch" var="fetchURL">
    </portlet:actionURL>
    <liferay-ui:icon message="Fetch New Data" url="<%= fetchURL.toString() %>" />
</liferay-ui:icon-menu>
 --%>
<portlet:renderURL var="addFtpSubscriptionURL">
    <portlet:param name="jspPage" value="/admin/edit_ftp_subscription.jsp"/>
</portlet:renderURL>
<input type="button" value="<liferay-ui:message key="add-ftp-subscription" />"
       onClick="location.href = '<%=addFtpSubscriptionURL.toString()%>';"/>
<%@include file="browse_records.jsp" %>

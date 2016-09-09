<%@ page import="ca.efendi.datafeeds.web.portlet.ActionUtil" %>
<%@ page import="ca.efendi.datafeeds.model.FtpSubscription" %>
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

<liferay-ui:search-container emptyResultsMessage="there-are-no-registrations" delta="5">
    <liferay-ui:search-container-results>
        <%
            List<FtpSubscription> tempResults = ActionUtil.getFtpSubscriptions(renderRequest);
            results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
            total = tempResults.size();
            pageContext.setAttribute("results", results);
            pageContext.setAttribute("total", total);
        %>
    </liferay-ui:search-container-results>
    <liferay-ui:search-container-row className="ca.efendi.datafeeds.model.FtpSubscription"
                                     keyProperty="ftpSubscriptionId" modelVar="ftpSubscription">
        <liferay-ui:search-container-column-text name="ftpHost" property="ftpHost"/>
        <liferay-ui:search-container-column-text name="ftpUser" property="ftpUser"/>
        <liferay-ui:search-container-column-text name="ftpPassword" property="ftpPassword"/>
        <liferay-ui:search-container-column-text name="ftpFolder" property="ftpFolder"/>
        <liferay-ui:search-container-column-text name="ftpFile" property="ftpFile"/>
        <liferay-ui:search-container-column-text name="ftpDatafeedName" property="ftpDatafeedName"/>
        <liferay-ui:search-container-column-text name="ftpDatafeedDescription" property="ftpDatafeedDescription"/>
        <liferay-ui:search-container-column-jsp path="/datafeeds_admin/admin_actions.jsp" align="right"/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>
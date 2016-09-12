<%@include file="/datafeeds_admin/init.jsp" %>

<%--
<liferay-ui:icon-menu>
    <portlet:actionURL name="fetch" var="fetchURL">
    </portlet:actionURL>
    <liferay-ui:icon message="Fetch New Data" url="<%= fetchURL.toString() %>" />
</liferay-ui:icon-menu>
 --%>
<portlet:renderURL var="addFtpSubscriptionURL">
    <portlet:param name="jspPage" value="/datafeeds_admin/edit_ftp_subscription.jsp"/>
</portlet:renderURL>
<input type="button" value="<liferay-ui:message key="add-ftp-subscription" />"
       onClick="location.href = '<%=addFtpSubscriptionURL.toString()%>';"/>


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
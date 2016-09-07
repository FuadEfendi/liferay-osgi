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
        <portlet:param name="jspPage" value="/datafeeds_admin/edit_ftp_subscription.jsp"/>
    </portlet:renderURL>
    <liferay-ui:icon image="edit" message="Edit" url="<%=edit.toString()%>"/>
    <portlet:actionURL name="deleteFtpSubscription" var="deleteURL">
        <portlet:param name="redirect" value="<%=redirect%>"/>
        <portlet:param name="ftpSubscriptionIdToDelete" value="<%=ftpSubscriptionId%>"/>
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%=deleteURL.toString()%>"/>
</liferay-ui:icon-menu>
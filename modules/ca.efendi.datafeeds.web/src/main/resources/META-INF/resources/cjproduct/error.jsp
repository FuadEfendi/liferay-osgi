<%@ page import="ca.efendi.datafeeds.exception.NoSuchCJProductException" %>

<%@ include file="/cjproduct/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchCJProductException.class %>" message="the-entry-could-not-be-found" />

<liferay-ui:error-principal />
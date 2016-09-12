<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.blogs.kernel.service.BlogsEntryServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.portlet.blogs.util.BlogsUtil" %>
<%@ page import="com.liferay.blogs.kernel.util.comparator.EntryModifiedDateComparator" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainerResults" %><%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/cjproduct/init.jsp" %>

<%
String mvcRenderCommandName = ParamUtil.getString(request, "mvcRenderCommandName");

long assetCategoryId = ParamUtil.getLong(request, "categoryId");
String assetTagName = ParamUtil.getString(request, "tag");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcRenderCommandName", "/cjproduct/view");
%>

<portlet:actionURL name="/cjproduct/edit_entry" var="restoreTrashEntriesURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>" />
</portlet:actionURL>

<liferay-trash:undo
	portletURL="<%= restoreTrashEntriesURL %>"
/>

<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />

<%
int pageDelta = GetterUtil.getInteger(blogsPortletInstanceConfiguration.pageDelta());

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, pageDelta, currentURLObj, null, null);

searchContainer.setDelta(pageDelta);
searchContainer.setDeltaConfigurable(false);

int total = 0;
List results = null;

int notPublishedEntriesCount = BlogsEntryServiceUtil.getGroupUserEntriesCount(scopeGroupId, themeDisplay.getUserId(), new int[] {WorkflowConstants.STATUS_DRAFT, WorkflowConstants.STATUS_PENDING, WorkflowConstants.STATUS_SCHEDULED});

if ((assetCategoryId != 0) || Validator.isNotNull(assetTagName)) {
	SearchContainerResults<AssetEntry> searchContainerResults = BlogsUtil.getSearchContainerResults(searchContainer);

	searchContainer.setTotal(searchContainerResults.getTotal());

	results = searchContainerResults.getResults();
}
else if ((notPublishedEntriesCount > 0) && mvcRenderCommandName.equals("/cjproduct/view_not_published_entries")) {
	total = notPublishedEntriesCount;

	searchContainer.setTotal(total);

	results = BlogsEntryServiceUtil.getGroupUserEntries(scopeGroupId, themeDisplay.getUserId(), new int[] {WorkflowConstants.STATUS_DRAFT, WorkflowConstants.STATUS_PENDING, WorkflowConstants.STATUS_SCHEDULED}, searchContainer.getStart(), searchContainer.getEnd(), new EntryModifiedDateComparator());

	searchContainer.setResults(results);
}
else {
	int status = WorkflowConstants.STATUS_APPROVED;

	total = BlogsEntryServiceUtil.getGroupEntriesCount(scopeGroupId, status);

	searchContainer.setTotal(total);

	results = BlogsEntryServiceUtil.getGroupEntries(scopeGroupId, status, searchContainer.getStart(), searchContainer.getEnd());
}

searchContainer.setResults(results);
%>

<c:if test="<%= notPublishedEntriesCount > 0 %>">
	<aui:nav-bar markupView="lexicon">
		<aui:nav cssClass="navbar-nav">
			<aui:nav-item
				href="<%= portletURL.toString() %>"
				label="published"
				selected='<%= !mvcRenderCommandName.equals("/blogs/view_not_published_entries") %>'
			/>

			<portlet:renderURL var="viewNotPublishedEntriesURL">
				<portlet:param name="mvcRenderCommandName" value="/blogs/view_not_published_entries" />
			</portlet:renderURL>

			<aui:nav-item
				href="<%= viewNotPublishedEntriesURL %>"
				label='<%= LanguageUtil.format(resourceBundle, "not-published-x", notPublishedEntriesCount, false) %>'
				selected='<%= mvcRenderCommandName.equals("/blogs/view_not_published_entries") %>'
			/>
		</aui:nav>
	</aui:nav-bar>
</c:if>

<%@ include file="/cjproduct/view_entries.jspf" %>
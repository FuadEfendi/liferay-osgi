/*
 * Copyright (c) 2016 Fuad Efendi <fuad@efendi.ca>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.efendi.datafeeds.search;

import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.service.CJProductLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.Locale;

public class CJProductIndexer extends BaseIndexer<CJProduct> {

    private static final Log _log = LogFactoryUtil.getLog(CJProductIndexer.class);

    public static final String CLASS_NAME = CJProduct.class.getName();
    //public static final int COMPANY_ID = 20148;
    //public static final int GROUP_ID = 20177; // guest
    //public static final String PORTLET_ID = WebKeys.CJ_PRODUCT_PORTLET_ID;

    public CJProductIndexer() {
        setDefaultSelectedFieldNames(
                Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
                Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
                Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);
        setFilterSearch(true);
        setPermissionAware(false);
    }

    /**
     * @see com.liferay.portal.kernel.search.Indexer#getClassName()
     */
    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    /**
     * @see BaseIndexer#doDelete(Object)
     */
    @Override
    protected void doDelete(final CJProduct object) throws Exception {
        deleteDocument(object.getCompanyId(), object.getProductId());
    }

    /**
     * @see BaseIndexer#doGetDocument(Object)
     */
    @Override
    protected Document doGetDocument(final CJProduct object) throws Exception {
        final Document document = getBaseModelDocument(CLASS_NAME, object);
        document.addText(Field.CAPTION, object.getName());
        document.addText(
                Field.CONTENT, HtmlUtil.extractText(object.getDescription()));
        //document.addText(Field.DESCRIPTION, object.getDescription());
        document.addDate(Field.MODIFIED_DATE, object.getModifiedDate());
        //document.addText(Field.SUBTITLE, blogsEntry.getSubtitle());
        document.addText(Field.TITLE, object.getName());
        return document;
    }

    /**
     * @see BaseIndexer#doGetSummary(Document,
     * Locale, String, PortletRequest,
     * PortletResponse)
     */
    @Override
    protected Summary doGetSummary(final Document document, final Locale locale, final String snippet, final PortletRequest portletRequest,
                                   final PortletResponse portletResponse)
            throws Exception {
        final Summary summary = createSummary(document);
        summary.setMaxContentLength(200);
        return summary;
    }

    /**
     * @see BaseIndexer#doReindex(Object)
     */
    @Override
    protected void doReindex(final CJProduct object) throws Exception {
        final Document document = getDocument(object);
        SearchEngineUtil.updateDocument(
                getSearchEngineId(), object.getCompanyId(), document,
                isCommitImmediately());
    }

    /**
     * @see BaseIndexer#doReindex(String,
     * long)
     */
    @Override
    protected void doReindex(final String className, final long classPK) throws Exception {
        final CJProduct entry = CJProductLocalServiceUtil.getCJProduct(classPK);
        doReindex(entry);
    }

    /**
     * @see BaseIndexer#doReindex(String[])
     */
    @Override
    protected void doReindex(final String[] ids) throws Exception {
        _log.info("doReindex called with " + ids.length + " IDs");
        final long companyId = GetterUtil.getLong(ids[0]);
        reindexEntries(companyId);
    }

    protected void reindexEntries(final long companyId) throws PortalException {
        final ActionableDynamicQuery actionableDynamicQuery =
                CJProductLocalServiceUtil.getActionableDynamicQuery();
        actionableDynamicQuery.setAddCriteriaMethod(
                new ActionableDynamicQuery.AddCriteriaMethod() {

                    @Override
                    public void addCriteria(final DynamicQuery dynamicQuery) {
                        //final Property displayDateProperty = PropertyFactoryUtil.forName(
                        //        "displayDate");
                        //dynamicQuery.add(displayDateProperty.lt(new Date()));
                        //final Property statusProperty = PropertyFactoryUtil.forName(
                        //        "status");
                        //final Integer[] statuses = {
                        //        WorkflowConstants.STATUS_APPROVED,
                        //        WorkflowConstants.STATUS_IN_TRASH
                        //};
                        //dynamicQuery.add(statusProperty.in(statuses));
                    }
                });
        actionableDynamicQuery.setCompanyId(companyId);
        actionableDynamicQuery.setPerformActionMethod(
                new ActionableDynamicQuery.PerformActionMethod() {

                    @Override
                    public void performAction(final Object object) {
                        final CJProduct entry = (CJProduct) object;
                        try {
                            final Document document = getDocument(entry);
                            // TODO:
                            // actionableDynamicQuery.addDocument(document);
                        } catch (final PortalException pe) {
                            if (_log.isWarnEnabled()) {
                                _log.warn(
                                        "Unable to index product " +
                                                entry.getProductId(),
                                        pe);
                            }
                        }
                    }
                });
        // TODO:
        // actionableDynamicQuery.setSearchEngineId(getSearchEngineId());
        actionableDynamicQuery.performActions();
    }
}

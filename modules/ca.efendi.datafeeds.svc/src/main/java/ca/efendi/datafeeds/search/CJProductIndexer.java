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
import ca.efendi.datafeeds.service.CJProductLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.List;
import java.util.Locale;

@Component(immediate = true, service = Indexer.class)
public class CJProductIndexer extends BaseIndexer<CJProduct> {

    private static final Log _log = LogFactoryUtil.getLog(CJProductIndexer.class);

    public static final String CLASS_NAME = CJProduct.class.getName();

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


    @Override
    public boolean hasPermission(
            PermissionChecker permissionChecker, String entryClassName,
            long entryClassPK, String actionId)
            throws Exception {

//        return BlogsEntryPermission.contains(
//                permissionChecker, entryClassPK, ActionKeys.VIEW);

        return true;

    }

    @Override
    public boolean isVisible(long classPK, int status) throws Exception {
        //BlogsEntry entry = _blogsEntryLocalService.getEntry(classPK);

//        return isVisible(entry.getStatus(), status);

        return true;

    }


    @Override
    protected void doDelete(final CJProduct object) throws Exception {
        deleteDocument(object.getCompanyId(), object.getProductId());
    }


    @Override
    protected Document doGetDocument(final CJProduct object) throws Exception {
        final Document document = getBaseModelDocument(CLASS_NAME, object);
        document.addText(Field.CAPTION, object.getName());
        document.addText(
                Field.CONTENT, HtmlUtil.extractText(object.getDescription()));
        document.addText(Field.DESCRIPTION, object.getDescription());
        document.addDate(Field.MODIFIED_DATE, object.getModifiedDate());
        //document.addText(Field.SUBTITLE, blogsEntry.getSubtitle());
        document.addText(Field.TITLE, object.getName());
        return document;
    }


    @Override
    protected Summary doGetSummary(final Document document, final Locale locale, final String snippet, final PortletRequest portletRequest,
                                   final PortletResponse portletResponse)
            throws Exception {
        final Summary summary = createSummary(document);
        summary.setMaxContentLength(200);
        return summary;
    }

    @Override
    protected void doReindex(final CJProduct object) throws Exception {
        final Document document = getDocument(object);

        //System.out.println("reindexing document:\n" + document);

        IndexWriterHelperUtil.updateDocument(
                getSearchEngineId(), object.getCompanyId(), document,
                isCommitImmediately());

    }

    @Override
    protected void doReindex(final String className, final long classPK) throws Exception {
        final CJProduct entry = _cjProductLocalService.getCJProduct(classPK);
        doReindex(entry);
    }

    @Override
    protected void doReindex(final String[] ids) throws Exception {
        final long companyId = GetterUtil.getLong(ids[0]);
        reindexEntries(companyId);
    }

    protected void reindexEntries(final long companyId) throws Exception {


        List<CJProduct> products = _cjProductLocalService.getCJProducts(0, 100000);

        for (CJProduct entry : products) {
            doReindex(entry);
        }
    }

//    @Reference(unbind = "-")
//    protected void setFtpSubscriptionLocalService(
//            FtpSubscriptionLocalService ftpSubscriptionLocalService) {
//        _ftpSubscriptionLocalService = ftpSubscriptionLocalService;
//    }

    @Reference(unbind = "-")
    public void setCJProductLocalService(CJProductLocalService cjProductLocalService) {
        _cjProductLocalService = cjProductLocalService;
    }

    //private FtpSubscriptionLocalService _ftpSubscriptionLocalService;
    private CJProductLocalService _cjProductLocalService;

}

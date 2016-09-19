package ca.efendi.datafeeds.web.internal.portlet.action;

import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.service.CJProductLocalService;
import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletLayoutFinder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.BaseFindActionHelper;
import com.liferay.portal.struts.FindActionHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

@Component(
        immediate = true,
        property = "model.class.name=ca.efendi.datafeeds.model.CJProduct",
        service = FindActionHelper.class
)
public class CJProductFindEntryHelper extends BaseFindActionHelper {

    @Override
    public long getGroupId(long primaryKey) throws Exception {
        CJProduct entry = _cjProductEntryLocalService.getCJProduct(primaryKey);

        return entry.getGroupId();
    }

    @Override
    public String getPrimaryKeyParameterName() {
        return "productId";
    }

    @Override
    public PortletURL processPortletURL(
            HttpServletRequest request, PortletURL portletURL)
            throws Exception {

        return portletURL;
    }

    @Override
    public void setPrimaryKeyParameter(PortletURL portletURL, long primaryKey)
            throws Exception {

        CJProduct entry = _cjProductEntryLocalService.getCJProduct(primaryKey);

        //if (Validator.isNotNull(entry.getUrlTitle())) {
        //    portletURL.setParameter("urlTitle", entry.getUrlTitle());
        //} else {
            portletURL.setParameter(
                    "productId", String.valueOf(entry.getProductId()));
        //}
    }

    @Override
    protected void addRequiredParameters(
            HttpServletRequest request, String portletId, PortletURL portletURL) {

        String mvcRenderCommandName = null;

        if (portletId.equals(CJProductPortletKeys.CJPRODUCT)) {
            mvcRenderCommandName = "/cjproduct/view_entry";
        } else if (portletId.equals(CJProductPortletKeys.CJPRODUCT_ADMIN)) {
            mvcRenderCommandName = "/cjproduct_admin/view_entry";
        } else {
            mvcRenderCommandName = "/cjproduct_aggregator/view";
        }

        portletURL.setParameter("mvcRenderCommandName", mvcRenderCommandName);
    }

    @Override
    protected PortletLayoutFinder getPortletLayoutFinder() {
        return _portletLayoutFinder;
    }

    @Reference(unbind = "-")
    protected void setCJProductLocalService(
            CJProductLocalService cjProductEntryLocalService) {

        _cjProductEntryLocalService = cjProductEntryLocalService;
    }

    @Reference(
            target = "(model.class.name=ca.efendi.datafeeds.model.CJProduct)",
            unbind = "-"
    )
    protected void setPortletLayoutFinder(
            PortletLayoutFinder portletPageFinder) {
        _portletLayoutFinder = portletPageFinder;
    }

    private CJProductLocalService _cjProductEntryLocalService;
    private PortletLayoutFinder _portletLayoutFinder;


    private static final Log _log = LogFactoryUtil.getLog(
            CJProductFindEntryHelper.class);

}
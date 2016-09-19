package ca.efendi.datafeeds.web.internal.portlet;

import ca.efendi.datafeeds.exception.NoSuchCJProductException;
import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import ca.efendi.datafeeds.web.internal.portlet.action.ActionUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + CJProductPortletKeys.CJPRODUCT,
                "javax.portlet.name=" + CJProductPortletKeys.CJPRODUCT_ADMIN,
                "javax.portlet.name=" + CJProductPortletKeys.CJPRODUCT_AGGREGATOR,
                "mvc.command.name=/cjproduct/view_entry"
        },
        service = MVCRenderCommand.class
)
public class ViewEntryMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        long assetCategoryId = ParamUtil.getLong(renderRequest, "categoryId");
        String assetCategoryName = ParamUtil.getString(renderRequest, "tag");

        if ((assetCategoryId > 0) || Validator.isNotNull(assetCategoryName)) {
            return "/cjproduct/view.jsp";
        }

        try {
            ActionUtil.getItem(renderRequest);
        } catch (Exception e) {
            if (e instanceof NoSuchCJProductException ||
                    e instanceof PrincipalException) {

                SessionErrors.add(renderRequest, e.getClass());

                return "/cjproduct/error.jsp";
            } else {
                throw new PortletException(e);
            }
        }

        return "/cjproduct/view_entry.jsp";
    }

}
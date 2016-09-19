package ca.efendi.datafeeds.web.internal.portlet.action;

import ca.efendi.datafeeds.exception.NoSuchCJProductException;
import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + CJProductPortletKeys.CJPRODUCT,
                "mvc.command.name=/",
                "mvc.command.name=/cjproduct/view"
        },
        service = MVCRenderCommand.class
)
public class CJProductViewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException{

        try {
            ActionUtil.getItem(renderRequest);
        }
        catch (Exception e) {
            if (e instanceof NoSuchCJProductException ||
                    e instanceof PrincipalException) {

                SessionErrors.add(renderRequest, e.getClass());

                return "/error.jsp";
            }
            else {
                throw new PortletException(e);
            }
        }


        return "/cjproduct/view.jsp";
    }

}
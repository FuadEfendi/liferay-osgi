package ca.efendi.datafeeds.web.internal.portlet.action;

import ca.efendi.datafeeds.web.constants.CJProductPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CJProductPortletKeys.CJPRODUCT, "mvc.command.name=/",
		"mvc.command.name=/blogs/view"
	},
	service = MVCRenderCommand.class
)
public class CJProductViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		return "/cjproduct/view.jsp";
	}

}
package ca.efendi.datafeeds.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.struts.FindActionHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component(
        immediate = true,
        property = "path=/cjproduct/find_entry",
        service = StrutsAction.class
)
public class FindEntryAction extends BaseStrutsAction {

    @Override
    public String execute(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        _findActionHelper.execute(request, response);
        return null;
    }

    @Reference(
            target = "(model.class.name=ca.efendi.datafeeds.model.CJProduct)",
            unbind = "-"
    )
    protected void setFindActionHelper(FindActionHelper findActionHelper) {
        _findActionHelper = findActionHelper;
    }

    private FindActionHelper _findActionHelper;

    private static final Log _log = LogFactoryUtil.getLog(
            FindEntryAction.class);

}
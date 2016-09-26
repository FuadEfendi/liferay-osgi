package ca.efendi.socialcomments.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;


@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=portlet-jsp",
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=JSP Portlet No. 2",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view2.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class JSPPortlet extends MVCPortlet {
}
package ca.efendi.datafeeds.service.permission;

import ca.efendi.datafeeds.model.CJProduct;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

@OSGiBeanProperties(
	property = {"resource.name=" + DatafeedsRootPermission.RESOURCE_NAME}
)
public class DatafeedsRootPermission extends BaseResourcePermissionChecker {

	public static final String RESOURCE_NAME = "ca.efendi.datafeeds";

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker.getUserId(), RESOURCE_NAME, groupId,
				actionId);
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long classPK, String actionId) {

		String portletId = PortletProviderUtil.getPortletId(
			CJProduct.class.getName(), PortletProvider.Action.EDIT);

		return contains(
			permissionChecker, RESOURCE_NAME, portletId, classPK, actionId);
	}

	@Override
	public Boolean checkResource(
		PermissionChecker permissionChecker, long classPK, String actionId) {

		return contains(permissionChecker, classPK, actionId);
	}

}
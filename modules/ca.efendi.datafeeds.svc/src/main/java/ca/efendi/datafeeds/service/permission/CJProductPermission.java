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

package ca.efendi.datafeeds.service.permission;


import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.service.CJProductLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = {"model.class.name=ca.efendi.datafeeds.model.CJProduct"},
        service = BaseModelPermissionChecker.class
)
public class CJProductPermission implements BaseModelPermissionChecker {

    public static void check(
            PermissionChecker permissionChecker, CJProduct entry,
            String actionId)
            throws PortalException {

        if (!contains(permissionChecker, entry, actionId)) {
            throw new PrincipalException.MustHavePermission(
                    permissionChecker, CJProduct.class.getName(),
                    entry.getProductId(), actionId);
        }
    }

    public static void check(
            PermissionChecker permissionChecker, long entryId, String actionId)
            throws PortalException {

        if (!contains(permissionChecker, entryId, actionId)) {
            throw new PrincipalException.MustHavePermission(
                    permissionChecker, CJProduct.class.getName(), entryId,
                    actionId);
        }
    }

    public static boolean contains(
            PermissionChecker permissionChecker, CJProduct entry,
            String actionId) {

        String portletId = PortletProviderUtil.getPortletId(
                CJProduct.class.getName(), PortletProvider.Action.EDIT);

        Boolean hasPermission = StagingPermissionUtil.hasPermission(
                permissionChecker, entry.getGroupId(), CJProduct.class.getName(),
                entry.getProductId(), portletId, actionId);

        if (hasPermission != null) {
            return hasPermission.booleanValue();
        }

        if (entry.isDraft() || entry.isScheduled()) {
            if (actionId.equals(ActionKeys.VIEW) &&
                    !contains(permissionChecker, entry, ActionKeys.UPDATE)) {

                return false;
            }
        } else if (entry.isPending()) {
            hasPermission = WorkflowPermissionUtil.hasPermission(
                    permissionChecker, entry.getGroupId(),
                    CJProduct.class.getName(), entry.getProductId(), actionId);

            if (hasPermission != null) {
                return hasPermission.booleanValue();
            }
        }

        if (permissionChecker.hasOwnerPermission(
                entry.getCompanyId(), CJProduct.class.getName(),
                entry.getProductId(), entry.getUserId(), actionId)) {

            return true;
        }

        return permissionChecker.hasPermission(
                entry.getGroupId(), CJProduct.class.getName(), entry.getProductId(),
                actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long entryId, String actionId)
            throws PortalException {

        CJProduct entry = _cjProductLocalService.getCJProduct(entryId);
        return contains(permissionChecker, entry, actionId);
    }

    @Override
    public void checkBaseModel(
            PermissionChecker permissionChecker, long groupId, long primaryKey,
            String actionId)
            throws PortalException {

        check(permissionChecker, primaryKey, actionId);
    }

    @Reference(unbind = "-")
    protected void setCJProductLocalService(CJProductLocalService cjProductLocalService) {
        this._cjProductLocalService = cjProductLocalService;
    }


    private static CJProductLocalService _cjProductLocalService;

}
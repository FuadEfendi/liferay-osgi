/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ca.efendi.datafeeds.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CJProduct. This utility wraps
 * {@link ca.efendi.datafeeds.service.impl.CJProductLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CJProductLocalService
 * @see ca.efendi.datafeeds.service.base.CJProductLocalServiceBaseImpl
 * @see ca.efendi.datafeeds.service.impl.CJProductLocalServiceImpl
 * @generated
 */
@ProviderType
public class CJProductLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ca.efendi.datafeeds.service.impl.CJProductLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the c j product to the database. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was added
	*/
	public static ca.efendi.datafeeds.model.CJProduct addCJProduct(
		ca.efendi.datafeeds.model.CJProduct cjProduct) {
		return getService().addCJProduct(cjProduct);
	}

	/**
	* Creates a new c j product with the primary key. Does not add the c j product to the database.
	*
	* @param productId the primary key for the new c j product
	* @return the new c j product
	*/
	public static ca.efendi.datafeeds.model.CJProduct createCJProduct(
		long productId) {
		return getService().createCJProduct(productId);
	}

	/**
	* Deletes the c j product from the database. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was removed
	*/
	public static ca.efendi.datafeeds.model.CJProduct deleteCJProduct(
		ca.efendi.datafeeds.model.CJProduct cjProduct) {
		return getService().deleteCJProduct(cjProduct);
	}

	/**
	* Deletes the c j product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the c j product
	* @return the c j product that was removed
	* @throws PortalException if a c j product with the primary key could not be found
	*/
	public static ca.efendi.datafeeds.model.CJProduct deleteCJProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCJProduct(productId);
	}

	public static ca.efendi.datafeeds.model.CJProduct fetchCJProduct(
		long productId) {
		return getService().fetchCJProduct(productId);
	}

	/**
	* Returns the c j product matching the UUID and group.
	*
	* @param uuid the c j product's UUID
	* @param groupId the primary key of the group
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static ca.efendi.datafeeds.model.CJProduct fetchCJProductByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchCJProductByUuidAndGroupId(uuid, groupId);
	}

	public static ca.efendi.datafeeds.model.CJProduct getCJProduct(
		long groupId, java.lang.String sku)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getService().getCJProduct(groupId, sku);
	}

	/**
	* Returns the c j product with the primary key.
	*
	* @param productId the primary key of the c j product
	* @return the c j product
	* @throws PortalException if a c j product with the primary key could not be found
	*/
	public static ca.efendi.datafeeds.model.CJProduct getCJProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCJProduct(productId);
	}

	/**
	* Returns the c j product matching the UUID and group.
	*
	* @param uuid the c j product's UUID
	* @param groupId the primary key of the group
	* @return the matching c j product
	* @throws PortalException if a matching c j product could not be found
	*/
	public static ca.efendi.datafeeds.model.CJProduct getCJProductByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCJProductByUuidAndGroupId(uuid, groupId);
	}

	public static ca.efendi.datafeeds.model.CJProduct refresh(long userId,
		ca.efendi.datafeeds.model.CJProduct newCJProduct)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().refresh(userId, newCJProduct);
	}

	/**
	* Updates the c j product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was updated
	*/
	public static ca.efendi.datafeeds.model.CJProduct updateCJProduct(
		ca.efendi.datafeeds.model.CJProduct cjProduct) {
		return getService().updateCJProduct(cjProduct);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of c j products.
	*
	* @return the number of c j products
	*/
	public static int getCJProductsCount() {
		return getService().getCJProductsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ca.efendi.datafeeds.model.impl.CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ca.efendi.datafeeds.model.impl.CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the c j products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ca.efendi.datafeeds.model.impl.CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @return the range of c j products
	*/
	public static java.util.List<ca.efendi.datafeeds.model.CJProduct> getCJProducts(
		int start, int end) {
		return getService().getCJProducts(start, end);
	}

	/**
	* Returns all the c j products matching the UUID and company.
	*
	* @param uuid the UUID of the c j products
	* @param companyId the primary key of the company
	* @return the matching c j products, or an empty list if no matches were found
	*/
	public static java.util.List<ca.efendi.datafeeds.model.CJProduct> getCJProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getCJProductsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of c j products matching the UUID and company.
	*
	* @param uuid the UUID of the c j products
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching c j products, or an empty list if no matches were found
	*/
	public static java.util.List<ca.efendi.datafeeds.model.CJProduct> getCJProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ca.efendi.datafeeds.model.CJProduct> orderByComparator) {
		return getService()
				   .getCJProductsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CJProductLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CJProductLocalService, CJProductLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CJProductLocalService.class);
}
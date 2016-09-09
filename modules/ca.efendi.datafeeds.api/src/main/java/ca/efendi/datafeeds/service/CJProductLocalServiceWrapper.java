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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CJProductLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CJProductLocalService
 * @generated
 */
@ProviderType
public class CJProductLocalServiceWrapper implements CJProductLocalService,
	ServiceWrapper<CJProductLocalService> {
	public CJProductLocalServiceWrapper(
		CJProductLocalService cjProductLocalService) {
		_cjProductLocalService = cjProductLocalService;
	}

	/**
	* Adds the c j product to the database. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was added
	*/
	@Override
	public ca.efendi.datafeeds.model.CJProduct addCJProduct(
		ca.efendi.datafeeds.model.CJProduct cjProduct) {
		return _cjProductLocalService.addCJProduct(cjProduct);
	}

	/**
	* Creates a new c j product with the primary key. Does not add the c j product to the database.
	*
	* @param productId the primary key for the new c j product
	* @return the new c j product
	*/
	@Override
	public ca.efendi.datafeeds.model.CJProduct createCJProduct(long productId) {
		return _cjProductLocalService.createCJProduct(productId);
	}

	/**
	* Deletes the c j product from the database. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was removed
	*/
	@Override
	public ca.efendi.datafeeds.model.CJProduct deleteCJProduct(
		ca.efendi.datafeeds.model.CJProduct cjProduct) {
		return _cjProductLocalService.deleteCJProduct(cjProduct);
	}

	/**
	* Deletes the c j product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the c j product
	* @return the c j product that was removed
	* @throws PortalException if a c j product with the primary key could not be found
	*/
	@Override
	public ca.efendi.datafeeds.model.CJProduct deleteCJProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProductLocalService.deleteCJProduct(productId);
	}

	@Override
	public ca.efendi.datafeeds.model.CJProduct fetchCJProduct(long productId) {
		return _cjProductLocalService.fetchCJProduct(productId);
	}

	/**
	* Returns the c j product matching the UUID and group.
	*
	* @param uuid the c j product's UUID
	* @param groupId the primary key of the group
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	@Override
	public ca.efendi.datafeeds.model.CJProduct fetchCJProductByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _cjProductLocalService.fetchCJProductByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public ca.efendi.datafeeds.model.CJProduct getCJProduct(long groupId,
		java.lang.String sku)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return _cjProductLocalService.getCJProduct(groupId, sku);
	}

	/**
	* Returns the c j product with the primary key.
	*
	* @param productId the primary key of the c j product
	* @return the c j product
	* @throws PortalException if a c j product with the primary key could not be found
	*/
	@Override
	public ca.efendi.datafeeds.model.CJProduct getCJProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProductLocalService.getCJProduct(productId);
	}

	/**
	* Returns the c j product matching the UUID and group.
	*
	* @param uuid the c j product's UUID
	* @param groupId the primary key of the group
	* @return the matching c j product
	* @throws PortalException if a matching c j product could not be found
	*/
	@Override
	public ca.efendi.datafeeds.model.CJProduct getCJProductByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProductLocalService.getCJProductByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public ca.efendi.datafeeds.model.CJProduct refresh(long userId,
		ca.efendi.datafeeds.model.CJProduct newCJProduct)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProductLocalService.refresh(userId, newCJProduct);
	}

	/**
	* Updates the c j product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was updated
	*/
	@Override
	public ca.efendi.datafeeds.model.CJProduct updateCJProduct(
		ca.efendi.datafeeds.model.CJProduct cjProduct) {
		return _cjProductLocalService.updateCJProduct(cjProduct);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _cjProductLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cjProductLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _cjProductLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _cjProductLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProductLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProductLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of c j products.
	*
	* @return the number of c j products
	*/
	@Override
	public int getCJProductsCount() {
		return _cjProductLocalService.getCJProductsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _cjProductLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _cjProductLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _cjProductLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _cjProductLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<ca.efendi.datafeeds.model.CJProduct> getCJProducts(
		int start, int end) {
		return _cjProductLocalService.getCJProducts(start, end);
	}

	/**
	* Returns all the c j products matching the UUID and company.
	*
	* @param uuid the UUID of the c j products
	* @param companyId the primary key of the company
	* @return the matching c j products, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<ca.efendi.datafeeds.model.CJProduct> getCJProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _cjProductLocalService.getCJProductsByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<ca.efendi.datafeeds.model.CJProduct> getCJProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ca.efendi.datafeeds.model.CJProduct> orderByComparator) {
		return _cjProductLocalService.getCJProductsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _cjProductLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _cjProductLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public CJProductLocalService getWrappedService() {
		return _cjProductLocalService;
	}

	@Override
	public void setWrappedService(CJProductLocalService cjProductLocalService) {
		_cjProductLocalService = cjProductLocalService;
	}

	private CJProductLocalService _cjProductLocalService;
}
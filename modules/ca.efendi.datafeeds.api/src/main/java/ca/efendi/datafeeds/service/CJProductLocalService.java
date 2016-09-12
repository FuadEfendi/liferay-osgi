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

import ca.efendi.datafeeds.exception.NoSuchCJProductException;
import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.model.FtpSubscription;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for CJProduct. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CJProductLocalServiceUtil
 * @see ca.efendi.datafeeds.service.base.CJProductLocalServiceBaseImpl
 * @see ca.efendi.datafeeds.service.impl.CJProductLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CJProductLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CJProductLocalServiceUtil} to access the c j product local service. Add custom service methods to {@link ca.efendi.datafeeds.service.impl.CJProductLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the c j product to the database. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CJProduct addCJProduct(CJProduct cjProduct);

	/**
	* Creates a new c j product with the primary key. Does not add the c j product to the database.
	*
	* @param productId the primary key for the new c j product
	* @return the new c j product
	*/
	public CJProduct createCJProduct(long productId);

	/**
	* Deletes the c j product from the database. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public CJProduct deleteCJProduct(CJProduct cjProduct);

	/**
	* Deletes the c j product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the c j product
	* @return the c j product that was removed
	* @throws PortalException if a c j product with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public CJProduct deleteCJProduct(long productId) throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public CJProduct deleteEntry(CJProduct entry) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CJProduct fetchCJProduct(long productId);

	/**
	* Returns the c j product matching the UUID and group.
	*
	* @param uuid the c j product's UUID
	* @param groupId the primary key of the group
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CJProduct fetchCJProductByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CJProduct getCJProduct(long groupId, java.lang.String sku)
		throws NoSuchCJProductException;

	/**
	* Returns the c j product with the primary key.
	*
	* @param productId the primary key of the c j product
	* @return the c j product
	* @throws PortalException if a c j product with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CJProduct getCJProduct(long productId) throws PortalException;

	/**
	* Returns the c j product matching the UUID and group.
	*
	* @param uuid the c j product's UUID
	* @param groupId the primary key of the group
	* @return the matching c j product
	* @throws PortalException if a matching c j product could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CJProduct getCJProductByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public CJProduct refresh(FtpSubscription subscription,
		CJProduct newCJProduct) throws PortalException;

	/**
	* Updates the c j product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cjProduct the c j product
	* @return the c j product that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CJProduct updateCJProduct(CJProduct cjProduct);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of c j products.
	*
	* @return the number of c j products
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCJProductsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	public List<CJProduct> findByGroupId(long groupId, int start, int end)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CJProduct> getCJProducts(int start, int end);

	/**
	* Returns all the c j products matching the UUID and company.
	*
	* @param uuid the UUID of the c j products
	* @param companyId the primary key of the company
	* @return the matching c j products, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CJProduct> getCJProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CJProduct> getCJProductsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<CJProduct> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	public void deleteEntries(long groupId) throws PortalException;

	public void deleteEntry(long entryId) throws PortalException;
}
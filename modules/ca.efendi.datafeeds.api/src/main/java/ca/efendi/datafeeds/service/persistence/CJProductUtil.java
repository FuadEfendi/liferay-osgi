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

package ca.efendi.datafeeds.service.persistence;

import aQute.bnd.annotation.ProviderType;

import ca.efendi.datafeeds.model.CJProduct;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the c j product service. This utility wraps {@link ca.efendi.datafeeds.service.persistence.impl.CJProductPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fefendi
 * @see CJProductPersistence
 * @see ca.efendi.datafeeds.service.persistence.impl.CJProductPersistenceImpl
 * @generated
 */
@ProviderType
public class CJProductUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CJProduct cjProduct) {
		getPersistence().clearCache(cjProduct);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CJProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CJProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CJProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CJProduct update(CJProduct cjProduct) {
		return getPersistence().update(cjProduct);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CJProduct update(CJProduct cjProduct,
		ServiceContext serviceContext) {
		return getPersistence().update(cjProduct, serviceContext);
	}

	/**
	* Returns all the c j products where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching c j products
	*/
	public static List<CJProduct> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the c j products where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @return the range of matching c j products
	*/
	public static List<CJProduct> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the c j products where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c j products
	*/
	public static List<CJProduct> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the c j products where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c j products
	*/
	public static List<CJProduct> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first c j product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByUuid_First(java.lang.String uuid,
		OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first c j product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last c j product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByUuid_Last(java.lang.String uuid,
		OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last c j product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the c j products before and after the current c j product in the ordered set where uuid = &#63;.
	*
	* @param productId the primary key of the current c j product
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c j product
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public static CJProduct[] findByUuid_PrevAndNext(long productId,
		java.lang.String uuid, OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .findByUuid_PrevAndNext(productId, uuid, orderByComparator);
	}

	/**
	* Removes all the c j products where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of c j products where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching c j products
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the c j product where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByUUID_G(java.lang.String uuid, long groupId)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the c j product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the c j product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the c j product where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the c j product that was removed
	*/
	public static CJProduct removeByUUID_G(java.lang.String uuid, long groupId)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of c j products where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching c j products
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the c j products where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching c j products
	*/
	public static List<CJProduct> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the c j products where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @return the range of matching c j products
	*/
	public static List<CJProduct> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the c j products where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c j products
	*/
	public static List<CJProduct> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the c j products where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c j products
	*/
	public static List<CJProduct> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the c j products before and after the current c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param productId the primary key of the current c j product
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c j product
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public static CJProduct[] findByUuid_C_PrevAndNext(long productId,
		java.lang.String uuid, long companyId,
		OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(productId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the c j products where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of c j products where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching c j products
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @return the matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByPROGRAM_CATALOG_SKU(
		java.lang.String programName, java.lang.String catalogName,
		java.lang.String sku)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .findByPROGRAM_CATALOG_SKU(programName, catalogName, sku);
	}

	/**
	* Returns the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByPROGRAM_CATALOG_SKU(
		java.lang.String programName, java.lang.String catalogName,
		java.lang.String sku) {
		return getPersistence()
				   .fetchByPROGRAM_CATALOG_SKU(programName, catalogName, sku);
	}

	/**
	* Returns the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByPROGRAM_CATALOG_SKU(
		java.lang.String programName, java.lang.String catalogName,
		java.lang.String sku, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROGRAM_CATALOG_SKU(programName, catalogName, sku,
			retrieveFromCache);
	}

	/**
	* Removes the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; from the database.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @return the c j product that was removed
	*/
	public static CJProduct removeByPROGRAM_CATALOG_SKU(
		java.lang.String programName, java.lang.String catalogName,
		java.lang.String sku)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .removeByPROGRAM_CATALOG_SKU(programName, catalogName, sku);
	}

	/**
	* Returns the number of c j products where programName = &#63; and catalogName = &#63; and sku = &#63;.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @return the number of matching c j products
	*/
	public static int countByPROGRAM_CATALOG_SKU(java.lang.String programName,
		java.lang.String catalogName, java.lang.String sku) {
		return getPersistence()
				   .countByPROGRAM_CATALOG_SKU(programName, catalogName, sku);
	}

	/**
	* Returns all the c j products where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @return the matching c j products
	*/
	public static List<CJProduct> findByManufacturer(
		java.lang.String manufacturer) {
		return getPersistence().findByManufacturer(manufacturer);
	}

	/**
	* Returns a range of all the c j products where manufacturer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param manufacturer the manufacturer
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @return the range of matching c j products
	*/
	public static List<CJProduct> findByManufacturer(
		java.lang.String manufacturer, int start, int end) {
		return getPersistence().findByManufacturer(manufacturer, start, end);
	}

	/**
	* Returns an ordered range of all the c j products where manufacturer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param manufacturer the manufacturer
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c j products
	*/
	public static List<CJProduct> findByManufacturer(
		java.lang.String manufacturer, int start, int end,
		OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence()
				   .findByManufacturer(manufacturer, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the c j products where manufacturer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param manufacturer the manufacturer
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c j products
	*/
	public static List<CJProduct> findByManufacturer(
		java.lang.String manufacturer, int start, int end,
		OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByManufacturer(manufacturer, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first c j product in the ordered set where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByManufacturer_First(
		java.lang.String manufacturer,
		OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .findByManufacturer_First(manufacturer, orderByComparator);
	}

	/**
	* Returns the first c j product in the ordered set where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByManufacturer_First(
		java.lang.String manufacturer,
		OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence()
				   .fetchByManufacturer_First(manufacturer, orderByComparator);
	}

	/**
	* Returns the last c j product in the ordered set where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByManufacturer_Last(
		java.lang.String manufacturer,
		OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .findByManufacturer_Last(manufacturer, orderByComparator);
	}

	/**
	* Returns the last c j product in the ordered set where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByManufacturer_Last(
		java.lang.String manufacturer,
		OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence()
				   .fetchByManufacturer_Last(manufacturer, orderByComparator);
	}

	/**
	* Returns the c j products before and after the current c j product in the ordered set where manufacturer = &#63;.
	*
	* @param productId the primary key of the current c j product
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c j product
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public static CJProduct[] findByManufacturer_PrevAndNext(long productId,
		java.lang.String manufacturer,
		OrderByComparator<CJProduct> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence()
				   .findByManufacturer_PrevAndNext(productId, manufacturer,
			orderByComparator);
	}

	/**
	* Removes all the c j products where manufacturer = &#63; from the database.
	*
	* @param manufacturer the manufacturer
	*/
	public static void removeByManufacturer(java.lang.String manufacturer) {
		getPersistence().removeByManufacturer(manufacturer);
	}

	/**
	* Returns the number of c j products where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @return the number of matching c j products
	*/
	public static int countByManufacturer(java.lang.String manufacturer) {
		return getPersistence().countByManufacturer(manufacturer);
	}

	/**
	* Returns the c j product where groupId = &#63; and urlTitle = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public static CJProduct findByG_UT(long groupId, java.lang.String urlTitle)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence().findByG_UT(groupId, urlTitle);
	}

	/**
	* Returns the c j product where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByG_UT(long groupId, java.lang.String urlTitle) {
		return getPersistence().fetchByG_UT(groupId, urlTitle);
	}

	/**
	* Returns the c j product where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public static CJProduct fetchByG_UT(long groupId,
		java.lang.String urlTitle, boolean retrieveFromCache) {
		return getPersistence().fetchByG_UT(groupId, urlTitle, retrieveFromCache);
	}

	/**
	* Removes the c j product where groupId = &#63; and urlTitle = &#63; from the database.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the c j product that was removed
	*/
	public static CJProduct removeByG_UT(long groupId, java.lang.String urlTitle)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence().removeByG_UT(groupId, urlTitle);
	}

	/**
	* Returns the number of c j products where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the number of matching c j products
	*/
	public static int countByG_UT(long groupId, java.lang.String urlTitle) {
		return getPersistence().countByG_UT(groupId, urlTitle);
	}

	/**
	* Caches the c j product in the entity cache if it is enabled.
	*
	* @param cjProduct the c j product
	*/
	public static void cacheResult(CJProduct cjProduct) {
		getPersistence().cacheResult(cjProduct);
	}

	/**
	* Caches the c j products in the entity cache if it is enabled.
	*
	* @param cjProducts the c j products
	*/
	public static void cacheResult(List<CJProduct> cjProducts) {
		getPersistence().cacheResult(cjProducts);
	}

	/**
	* Creates a new c j product with the primary key. Does not add the c j product to the database.
	*
	* @param productId the primary key for the new c j product
	* @return the new c j product
	*/
	public static CJProduct create(long productId) {
		return getPersistence().create(productId);
	}

	/**
	* Removes the c j product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the c j product
	* @return the c j product that was removed
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public static CJProduct remove(long productId)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence().remove(productId);
	}

	public static CJProduct updateImpl(CJProduct cjProduct) {
		return getPersistence().updateImpl(cjProduct);
	}

	/**
	* Returns the c j product with the primary key or throws a {@link NoSuchCJProductException} if it could not be found.
	*
	* @param productId the primary key of the c j product
	* @return the c j product
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public static CJProduct findByPrimaryKey(long productId)
		throws ca.efendi.datafeeds.exception.NoSuchCJProductException {
		return getPersistence().findByPrimaryKey(productId);
	}

	/**
	* Returns the c j product with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param productId the primary key of the c j product
	* @return the c j product, or <code>null</code> if a c j product with the primary key could not be found
	*/
	public static CJProduct fetchByPrimaryKey(long productId) {
		return getPersistence().fetchByPrimaryKey(productId);
	}

	public static java.util.Map<java.io.Serializable, CJProduct> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the c j products.
	*
	* @return the c j products
	*/
	public static List<CJProduct> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the c j products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @return the range of c j products
	*/
	public static List<CJProduct> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the c j products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c j products
	*/
	public static List<CJProduct> findAll(int start, int end,
		OrderByComparator<CJProduct> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the c j products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CJProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c j products
	* @param end the upper bound of the range of c j products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of c j products
	*/
	public static List<CJProduct> findAll(int start, int end,
		OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the c j products from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of c j products.
	*
	* @return the number of c j products
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CJProductPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CJProductPersistence, CJProductPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CJProductPersistence.class);
}
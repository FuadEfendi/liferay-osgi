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

import ca.efendi.datafeeds.exception.NoSuchCJProductException;
import ca.efendi.datafeeds.model.CJProduct;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the c j product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ca.efendi.datafeeds.service.persistence.impl.CJProductPersistenceImpl
 * @see CJProductUtil
 * @generated
 */
@ProviderType
public interface CJProductPersistence extends BasePersistence<CJProduct> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CJProductUtil} to access the c j product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the c j products where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching c j products
	*/
	public java.util.List<CJProduct> findByUuid(java.lang.String uuid);

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
	public java.util.List<CJProduct> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<CJProduct> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

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
	public java.util.List<CJProduct> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first c j product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Returns the first c j product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

	/**
	* Returns the last c j product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Returns the last c j product in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

	/**
	* Returns the c j products before and after the current c j product in the ordered set where uuid = &#63;.
	*
	* @param productId the primary key of the current c j product
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c j product
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public CJProduct[] findByUuid_PrevAndNext(long productId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Removes all the c j products where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of c j products where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching c j products
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the c j product where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchCJProductException;

	/**
	* Returns the c j product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the c j product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the c j product where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the c j product that was removed
	*/
	public CJProduct removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchCJProductException;

	/**
	* Returns the number of c j products where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching c j products
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the c j products where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching c j products
	*/
	public java.util.List<CJProduct> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<CJProduct> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<CJProduct> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

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
	public java.util.List<CJProduct> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Returns the first c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

	/**
	* Returns the last c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Returns the last c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

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
	public CJProduct[] findByUuid_C_PrevAndNext(long productId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Removes all the c j products where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of c j products where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching c j products
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @return the matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByPROGRAM_CATALOG_SKU(java.lang.String programName,
		java.lang.String catalogName, java.lang.String sku)
		throws NoSuchCJProductException;

	/**
	* Returns the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByPROGRAM_CATALOG_SKU(java.lang.String programName,
		java.lang.String catalogName, java.lang.String sku);

	/**
	* Returns the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByPROGRAM_CATALOG_SKU(java.lang.String programName,
		java.lang.String catalogName, java.lang.String sku,
		boolean retrieveFromCache);

	/**
	* Removes the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; from the database.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @return the c j product that was removed
	*/
	public CJProduct removeByPROGRAM_CATALOG_SKU(java.lang.String programName,
		java.lang.String catalogName, java.lang.String sku)
		throws NoSuchCJProductException;

	/**
	* Returns the number of c j products where programName = &#63; and catalogName = &#63; and sku = &#63;.
	*
	* @param programName the program name
	* @param catalogName the catalog name
	* @param sku the sku
	* @return the number of matching c j products
	*/
	public int countByPROGRAM_CATALOG_SKU(java.lang.String programName,
		java.lang.String catalogName, java.lang.String sku);

	/**
	* Returns all the c j products where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @return the matching c j products
	*/
	public java.util.List<CJProduct> findByManufacturer(
		java.lang.String manufacturer);

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
	public java.util.List<CJProduct> findByManufacturer(
		java.lang.String manufacturer, int start, int end);

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
	public java.util.List<CJProduct> findByManufacturer(
		java.lang.String manufacturer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

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
	public java.util.List<CJProduct> findByManufacturer(
		java.lang.String manufacturer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first c j product in the ordered set where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByManufacturer_First(java.lang.String manufacturer,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Returns the first c j product in the ordered set where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByManufacturer_First(java.lang.String manufacturer,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

	/**
	* Returns the last c j product in the ordered set where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByManufacturer_Last(java.lang.String manufacturer,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Returns the last c j product in the ordered set where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByManufacturer_Last(java.lang.String manufacturer,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

	/**
	* Returns the c j products before and after the current c j product in the ordered set where manufacturer = &#63;.
	*
	* @param productId the primary key of the current c j product
	* @param manufacturer the manufacturer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c j product
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public CJProduct[] findByManufacturer_PrevAndNext(long productId,
		java.lang.String manufacturer,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException;

	/**
	* Removes all the c j products where manufacturer = &#63; from the database.
	*
	* @param manufacturer the manufacturer
	*/
	public void removeByManufacturer(java.lang.String manufacturer);

	/**
	* Returns the number of c j products where manufacturer = &#63;.
	*
	* @param manufacturer the manufacturer
	* @return the number of matching c j products
	*/
	public int countByManufacturer(java.lang.String manufacturer);

	/**
	* Returns the c j product where groupId = &#63; and sku = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	*
	* @param groupId the group ID
	* @param sku the sku
	* @return the matching c j product
	* @throws NoSuchCJProductException if a matching c j product could not be found
	*/
	public CJProduct findByG_SKU(long groupId, java.lang.String sku)
		throws NoSuchCJProductException;

	/**
	* Returns the c j product where groupId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param sku the sku
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByG_SKU(long groupId, java.lang.String sku);

	/**
	* Returns the c j product where groupId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param sku the sku
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	*/
	public CJProduct fetchByG_SKU(long groupId, java.lang.String sku,
		boolean retrieveFromCache);

	/**
	* Removes the c j product where groupId = &#63; and sku = &#63; from the database.
	*
	* @param groupId the group ID
	* @param sku the sku
	* @return the c j product that was removed
	*/
	public CJProduct removeByG_SKU(long groupId, java.lang.String sku)
		throws NoSuchCJProductException;

	/**
	* Returns the number of c j products where groupId = &#63; and sku = &#63;.
	*
	* @param groupId the group ID
	* @param sku the sku
	* @return the number of matching c j products
	*/
	public int countByG_SKU(long groupId, java.lang.String sku);

	/**
	* Caches the c j product in the entity cache if it is enabled.
	*
	* @param cjProduct the c j product
	*/
	public void cacheResult(CJProduct cjProduct);

	/**
	* Caches the c j products in the entity cache if it is enabled.
	*
	* @param cjProducts the c j products
	*/
	public void cacheResult(java.util.List<CJProduct> cjProducts);

	/**
	* Creates a new c j product with the primary key. Does not add the c j product to the database.
	*
	* @param productId the primary key for the new c j product
	* @return the new c j product
	*/
	public CJProduct create(long productId);

	/**
	* Removes the c j product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the c j product
	* @return the c j product that was removed
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public CJProduct remove(long productId) throws NoSuchCJProductException;

	public CJProduct updateImpl(CJProduct cjProduct);

	/**
	* Returns the c j product with the primary key or throws a {@link NoSuchCJProductException} if it could not be found.
	*
	* @param productId the primary key of the c j product
	* @return the c j product
	* @throws NoSuchCJProductException if a c j product with the primary key could not be found
	*/
	public CJProduct findByPrimaryKey(long productId)
		throws NoSuchCJProductException;

	/**
	* Returns the c j product with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param productId the primary key of the c j product
	* @return the c j product, or <code>null</code> if a c j product with the primary key could not be found
	*/
	public CJProduct fetchByPrimaryKey(long productId);

	@Override
	public java.util.Map<java.io.Serializable, CJProduct> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the c j products.
	*
	* @return the c j products
	*/
	public java.util.List<CJProduct> findAll();

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
	public java.util.List<CJProduct> findAll(int start, int end);

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
	public java.util.List<CJProduct> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator);

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
	public java.util.List<CJProduct> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the c j products from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of c j products.
	*
	* @return the number of c j products
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}
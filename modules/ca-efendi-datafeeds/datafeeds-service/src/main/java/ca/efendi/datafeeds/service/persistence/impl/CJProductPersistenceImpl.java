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

package ca.efendi.datafeeds.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import ca.efendi.datafeeds.exception.NoSuchCJProductException;
import ca.efendi.datafeeds.model.CJProduct;
import ca.efendi.datafeeds.model.impl.CJProductImpl;
import ca.efendi.datafeeds.model.impl.CJProductModelImpl;
import ca.efendi.datafeeds.service.persistence.CJProductPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the c j product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fefendi
 * @see CJProductPersistence
 * @see ca.efendi.datafeeds.service.persistence.CJProductUtil
 * @generated
 */
@ProviderType
public class CJProductPersistenceImpl extends BasePersistenceImpl<CJProduct>
	implements CJProductPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CJProductUtil} to access the c j product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CJProductImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CJProductModelImpl.UUID_COLUMN_BITMASK |
			CJProductModelImpl.MANUFACTURER_COLUMN_BITMASK |
			CJProductModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the c j products where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching c j products
	 */
	@Override
	public List<CJProduct> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CJProduct> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CJProduct> findByUuid(String uuid, int start, int end,
		OrderByComparator<CJProduct> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CJProduct> findByUuid(String uuid, int start, int end,
		OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<CJProduct> list = null;

		if (retrieveFromCache) {
			list = (List<CJProduct>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CJProduct cjProduct : list) {
					if (!Objects.equals(uuid, cjProduct.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CJPRODUCT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CJProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<CJProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CJProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first c j product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c j product
	 * @throws NoSuchCJProductException if a matching c j product could not be found
	 */
	@Override
	public CJProduct findByUuid_First(String uuid,
		OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByUuid_First(uuid, orderByComparator);

		if (cjProduct != null) {
			return cjProduct;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCJProductException(msg.toString());
	}

	/**
	 * Returns the first c j product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByUuid_First(String uuid,
		OrderByComparator<CJProduct> orderByComparator) {
		List<CJProduct> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c j product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c j product
	 * @throws NoSuchCJProductException if a matching c j product could not be found
	 */
	@Override
	public CJProduct findByUuid_Last(String uuid,
		OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByUuid_Last(uuid, orderByComparator);

		if (cjProduct != null) {
			return cjProduct;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCJProductException(msg.toString());
	}

	/**
	 * Returns the last c j product in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByUuid_Last(String uuid,
		OrderByComparator<CJProduct> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CJProduct> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CJProduct[] findByUuid_PrevAndNext(long productId, String uuid,
		OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			CJProduct[] array = new CJProductImpl[3];

			array[0] = getByUuid_PrevAndNext(session, cjProduct, uuid,
					orderByComparator, true);

			array[1] = cjProduct;

			array[2] = getByUuid_PrevAndNext(session, cjProduct, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CJProduct getByUuid_PrevAndNext(Session session,
		CJProduct cjProduct, String uuid,
		OrderByComparator<CJProduct> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CJPRODUCT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CJProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cjProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CJProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c j products where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CJProduct cjProduct : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cjProduct);
		}
	}

	/**
	 * Returns the number of c j products where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching c j products
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CJPRODUCT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "cjProduct.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "cjProduct.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(cjProduct.uuid IS NULL OR cjProduct.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			CJProductModelImpl.UUID_COLUMN_BITMASK |
			CJProductModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the c j product where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching c j product
	 * @throws NoSuchCJProductException if a matching c j product could not be found
	 */
	@Override
	public CJProduct findByUUID_G(String uuid, long groupId)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByUUID_G(uuid, groupId);

		if (cjProduct == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCJProductException(msg.toString());
		}

		return cjProduct;
	}

	/**
	 * Returns the c j product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the c j product where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof CJProduct) {
			CJProduct cjProduct = (CJProduct)result;

			if (!Objects.equals(uuid, cjProduct.getUuid()) ||
					(groupId != cjProduct.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CJPRODUCT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<CJProduct> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					CJProduct cjProduct = list.get(0);

					result = cjProduct;

					cacheResult(cjProduct);

					if ((cjProduct.getUuid() == null) ||
							!cjProduct.getUuid().equals(uuid) ||
							(cjProduct.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, cjProduct);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CJProduct)result;
		}
	}

	/**
	 * Removes the c j product where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the c j product that was removed
	 */
	@Override
	public CJProduct removeByUUID_G(String uuid, long groupId)
		throws NoSuchCJProductException {
		CJProduct cjProduct = findByUUID_G(uuid, groupId);

		return remove(cjProduct);
	}

	/**
	 * Returns the number of c j products where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching c j products
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CJPRODUCT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "cjProduct.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "cjProduct.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(cjProduct.uuid IS NULL OR cjProduct.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "cjProduct.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			CJProductModelImpl.UUID_COLUMN_BITMASK |
			CJProductModelImpl.COMPANYID_COLUMN_BITMASK |
			CJProductModelImpl.MANUFACTURER_COLUMN_BITMASK |
			CJProductModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the c j products where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching c j products
	 */
	@Override
	public List<CJProduct> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CJProduct> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CJProduct> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<CJProduct> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CJProduct> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<CJProduct> list = null;

		if (retrieveFromCache) {
			list = (List<CJProduct>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CJProduct cjProduct : list) {
					if (!Objects.equals(uuid, cjProduct.getUuid()) ||
							(companyId != cjProduct.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CJPRODUCT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CJProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<CJProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CJProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CJProduct findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (cjProduct != null) {
			return cjProduct;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCJProductException(msg.toString());
	}

	/**
	 * Returns the first c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<CJProduct> orderByComparator) {
		List<CJProduct> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CJProduct findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (cjProduct != null) {
			return cjProduct;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCJProductException(msg.toString());
	}

	/**
	 * Returns the last c j product in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<CJProduct> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CJProduct> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CJProduct[] findByUuid_C_PrevAndNext(long productId, String uuid,
		long companyId, OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			CJProduct[] array = new CJProductImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, cjProduct, uuid,
					companyId, orderByComparator, true);

			array[1] = cjProduct;

			array[2] = getByUuid_C_PrevAndNext(session, cjProduct, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CJProduct getByUuid_C_PrevAndNext(Session session,
		CJProduct cjProduct, String uuid, long companyId,
		OrderByComparator<CJProduct> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CJPRODUCT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CJProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cjProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CJProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c j products where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CJProduct cjProduct : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cjProduct);
		}
	}

	/**
	 * Returns the number of c j products where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching c j products
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CJPRODUCT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "cjProduct.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "cjProduct.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(cjProduct.uuid IS NULL OR cjProduct.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "cjProduct.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPROGRAM_CATALOG_SKU",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			CJProductModelImpl.PROGRAMNAME_COLUMN_BITMASK |
			CJProductModelImpl.CATALOGNAME_COLUMN_BITMASK |
			CJProductModelImpl.SKU_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROGRAM_CATALOG_SKU = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROGRAM_CATALOG_SKU",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	 *
	 * @param programName the program name
	 * @param catalogName the catalog name
	 * @param sku the sku
	 * @return the matching c j product
	 * @throws NoSuchCJProductException if a matching c j product could not be found
	 */
	@Override
	public CJProduct findByPROGRAM_CATALOG_SKU(String programName,
		String catalogName, String sku) throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByPROGRAM_CATALOG_SKU(programName,
				catalogName, sku);

		if (cjProduct == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("programName=");
			msg.append(programName);

			msg.append(", catalogName=");
			msg.append(catalogName);

			msg.append(", sku=");
			msg.append(sku);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCJProductException(msg.toString());
		}

		return cjProduct;
	}

	/**
	 * Returns the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programName the program name
	 * @param catalogName the catalog name
	 * @param sku the sku
	 * @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByPROGRAM_CATALOG_SKU(String programName,
		String catalogName, String sku) {
		return fetchByPROGRAM_CATALOG_SKU(programName, catalogName, sku, true);
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
	@Override
	public CJProduct fetchByPROGRAM_CATALOG_SKU(String programName,
		String catalogName, String sku, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { programName, catalogName, sku };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU,
					finderArgs, this);
		}

		if (result instanceof CJProduct) {
			CJProduct cjProduct = (CJProduct)result;

			if (!Objects.equals(programName, cjProduct.getProgramName()) ||
					!Objects.equals(catalogName, cjProduct.getCatalogName()) ||
					!Objects.equals(sku, cjProduct.getSku())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CJPRODUCT_WHERE);

			boolean bindProgramName = false;

			if (programName == null) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_1);
			}
			else if (programName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_3);
			}
			else {
				bindProgramName = true;

				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_2);
			}

			boolean bindCatalogName = false;

			if (catalogName == null) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_1);
			}
			else if (catalogName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_3);
			}
			else {
				bindCatalogName = true;

				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_2);
			}

			boolean bindSku = false;

			if (sku == null) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_1);
			}
			else if (sku.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_3);
			}
			else {
				bindSku = true;

				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProgramName) {
					qPos.add(programName);
				}

				if (bindCatalogName) {
					qPos.add(catalogName);
				}

				if (bindSku) {
					qPos.add(sku);
				}

				List<CJProduct> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU,
						finderArgs, list);
				}
				else {
					CJProduct cjProduct = list.get(0);

					result = cjProduct;

					cacheResult(cjProduct);

					if ((cjProduct.getProgramName() == null) ||
							!cjProduct.getProgramName().equals(programName) ||
							(cjProduct.getCatalogName() == null) ||
							!cjProduct.getCatalogName().equals(catalogName) ||
							(cjProduct.getSku() == null) ||
							!cjProduct.getSku().equals(sku)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU,
							finderArgs, cjProduct);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CJProduct)result;
		}
	}

	/**
	 * Removes the c j product where programName = &#63; and catalogName = &#63; and sku = &#63; from the database.
	 *
	 * @param programName the program name
	 * @param catalogName the catalog name
	 * @param sku the sku
	 * @return the c j product that was removed
	 */
	@Override
	public CJProduct removeByPROGRAM_CATALOG_SKU(String programName,
		String catalogName, String sku) throws NoSuchCJProductException {
		CJProduct cjProduct = findByPROGRAM_CATALOG_SKU(programName,
				catalogName, sku);

		return remove(cjProduct);
	}

	/**
	 * Returns the number of c j products where programName = &#63; and catalogName = &#63; and sku = &#63;.
	 *
	 * @param programName the program name
	 * @param catalogName the catalog name
	 * @param sku the sku
	 * @return the number of matching c j products
	 */
	@Override
	public int countByPROGRAM_CATALOG_SKU(String programName,
		String catalogName, String sku) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROGRAM_CATALOG_SKU;

		Object[] finderArgs = new Object[] { programName, catalogName, sku };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CJPRODUCT_WHERE);

			boolean bindProgramName = false;

			if (programName == null) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_1);
			}
			else if (programName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_3);
			}
			else {
				bindProgramName = true;

				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_2);
			}

			boolean bindCatalogName = false;

			if (catalogName == null) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_1);
			}
			else if (catalogName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_3);
			}
			else {
				bindCatalogName = true;

				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_2);
			}

			boolean bindSku = false;

			if (sku == null) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_1);
			}
			else if (sku.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_3);
			}
			else {
				bindSku = true;

				query.append(_FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProgramName) {
					qPos.add(programName);
				}

				if (bindCatalogName) {
					qPos.add(catalogName);
				}

				if (bindSku) {
					qPos.add(sku);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_1 =
		"cjProduct.programName IS NULL AND ";
	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_2 =
		"cjProduct.programName = ? AND ";
	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_PROGRAMNAME_3 =
		"(cjProduct.programName IS NULL OR cjProduct.programName = '') AND ";
	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_1 =
		"cjProduct.catalogName IS NULL AND ";
	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_2 =
		"cjProduct.catalogName = ? AND ";
	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_CATALOGNAME_3 =
		"(cjProduct.catalogName IS NULL OR cjProduct.catalogName = '') AND ";
	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_1 = "cjProduct.sku IS NULL";
	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_2 = "cjProduct.sku = ?";
	private static final String _FINDER_COLUMN_PROGRAM_CATALOG_SKU_SKU_3 = "(cjProduct.sku IS NULL OR cjProduct.sku = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MANUFACTURER =
		new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByManufacturer",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER =
		new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByManufacturer",
			new String[] { String.class.getName() },
			CJProductModelImpl.MANUFACTURER_COLUMN_BITMASK |
			CJProductModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MANUFACTURER = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByManufacturer",
			new String[] { String.class.getName() });

	/**
	 * Returns all the c j products where manufacturer = &#63;.
	 *
	 * @param manufacturer the manufacturer
	 * @return the matching c j products
	 */
	@Override
	public List<CJProduct> findByManufacturer(String manufacturer) {
		return findByManufacturer(manufacturer, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CJProduct> findByManufacturer(String manufacturer, int start,
		int end) {
		return findByManufacturer(manufacturer, start, end, null);
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
	@Override
	public List<CJProduct> findByManufacturer(String manufacturer, int start,
		int end, OrderByComparator<CJProduct> orderByComparator) {
		return findByManufacturer(manufacturer, start, end, orderByComparator,
			true);
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
	@Override
	public List<CJProduct> findByManufacturer(String manufacturer, int start,
		int end, OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER;
			finderArgs = new Object[] { manufacturer };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MANUFACTURER;
			finderArgs = new Object[] {
					manufacturer,
					
					start, end, orderByComparator
				};
		}

		List<CJProduct> list = null;

		if (retrieveFromCache) {
			list = (List<CJProduct>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CJProduct cjProduct : list) {
					if (!Objects.equals(manufacturer,
								cjProduct.getManufacturer())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CJPRODUCT_WHERE);

			boolean bindManufacturer = false;

			if (manufacturer == null) {
				query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_1);
			}
			else if (manufacturer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_3);
			}
			else {
				bindManufacturer = true;

				query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CJProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindManufacturer) {
					qPos.add(manufacturer);
				}

				if (!pagination) {
					list = (List<CJProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CJProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first c j product in the ordered set where manufacturer = &#63;.
	 *
	 * @param manufacturer the manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c j product
	 * @throws NoSuchCJProductException if a matching c j product could not be found
	 */
	@Override
	public CJProduct findByManufacturer_First(String manufacturer,
		OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByManufacturer_First(manufacturer,
				orderByComparator);

		if (cjProduct != null) {
			return cjProduct;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("manufacturer=");
		msg.append(manufacturer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCJProductException(msg.toString());
	}

	/**
	 * Returns the first c j product in the ordered set where manufacturer = &#63;.
	 *
	 * @param manufacturer the manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByManufacturer_First(String manufacturer,
		OrderByComparator<CJProduct> orderByComparator) {
		List<CJProduct> list = findByManufacturer(manufacturer, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c j product in the ordered set where manufacturer = &#63;.
	 *
	 * @param manufacturer the manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c j product
	 * @throws NoSuchCJProductException if a matching c j product could not be found
	 */
	@Override
	public CJProduct findByManufacturer_Last(String manufacturer,
		OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByManufacturer_Last(manufacturer,
				orderByComparator);

		if (cjProduct != null) {
			return cjProduct;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("manufacturer=");
		msg.append(manufacturer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCJProductException(msg.toString());
	}

	/**
	 * Returns the last c j product in the ordered set where manufacturer = &#63;.
	 *
	 * @param manufacturer the manufacturer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByManufacturer_Last(String manufacturer,
		OrderByComparator<CJProduct> orderByComparator) {
		int count = countByManufacturer(manufacturer);

		if (count == 0) {
			return null;
		}

		List<CJProduct> list = findByManufacturer(manufacturer, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CJProduct[] findByManufacturer_PrevAndNext(long productId,
		String manufacturer, OrderByComparator<CJProduct> orderByComparator)
		throws NoSuchCJProductException {
		CJProduct cjProduct = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			CJProduct[] array = new CJProductImpl[3];

			array[0] = getByManufacturer_PrevAndNext(session, cjProduct,
					manufacturer, orderByComparator, true);

			array[1] = cjProduct;

			array[2] = getByManufacturer_PrevAndNext(session, cjProduct,
					manufacturer, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CJProduct getByManufacturer_PrevAndNext(Session session,
		CJProduct cjProduct, String manufacturer,
		OrderByComparator<CJProduct> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CJPRODUCT_WHERE);

		boolean bindManufacturer = false;

		if (manufacturer == null) {
			query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_1);
		}
		else if (manufacturer.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_3);
		}
		else {
			bindManufacturer = true;

			query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CJProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindManufacturer) {
			qPos.add(manufacturer);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cjProduct);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CJProduct> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c j products where manufacturer = &#63; from the database.
	 *
	 * @param manufacturer the manufacturer
	 */
	@Override
	public void removeByManufacturer(String manufacturer) {
		for (CJProduct cjProduct : findByManufacturer(manufacturer,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cjProduct);
		}
	}

	/**
	 * Returns the number of c j products where manufacturer = &#63;.
	 *
	 * @param manufacturer the manufacturer
	 * @return the number of matching c j products
	 */
	@Override
	public int countByManufacturer(String manufacturer) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MANUFACTURER;

		Object[] finderArgs = new Object[] { manufacturer };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CJPRODUCT_WHERE);

			boolean bindManufacturer = false;

			if (manufacturer == null) {
				query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_1);
			}
			else if (manufacturer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_3);
			}
			else {
				bindManufacturer = true;

				query.append(_FINDER_COLUMN_MANUFACTURER_MANUFACTURER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindManufacturer) {
					qPos.add(manufacturer);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MANUFACTURER_MANUFACTURER_1 = "cjProduct.manufacturer IS NULL";
	private static final String _FINDER_COLUMN_MANUFACTURER_MANUFACTURER_2 = "cjProduct.manufacturer = ?";
	private static final String _FINDER_COLUMN_MANUFACTURER_MANUFACTURER_3 = "(cjProduct.manufacturer IS NULL OR cjProduct.manufacturer = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_UT = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, CJProductImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_UT",
			new String[] { Long.class.getName(), String.class.getName() },
			CJProductModelImpl.GROUPID_COLUMN_BITMASK |
			CJProductModelImpl.URLTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_UT = new FinderPath(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_UT",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the c j product where groupId = &#63; and urlTitle = &#63; or throws a {@link NoSuchCJProductException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching c j product
	 * @throws NoSuchCJProductException if a matching c j product could not be found
	 */
	@Override
	public CJProduct findByG_UT(long groupId, String urlTitle)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByG_UT(groupId, urlTitle);

		if (cjProduct == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", urlTitle=");
			msg.append(urlTitle);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCJProductException(msg.toString());
		}

		return cjProduct;
	}

	/**
	 * Returns the c j product where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByG_UT(long groupId, String urlTitle) {
		return fetchByG_UT(groupId, urlTitle, true);
	}

	/**
	 * Returns the c j product where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching c j product, or <code>null</code> if a matching c j product could not be found
	 */
	@Override
	public CJProduct fetchByG_UT(long groupId, String urlTitle,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { groupId, urlTitle };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_G_UT,
					finderArgs, this);
		}

		if (result instanceof CJProduct) {
			CJProduct cjProduct = (CJProduct)result;

			if ((groupId != cjProduct.getGroupId()) ||
					!Objects.equals(urlTitle, cjProduct.getUrlTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CJPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				List<CJProduct> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_G_UT,
						finderArgs, list);
				}
				else {
					CJProduct cjProduct = list.get(0);

					result = cjProduct;

					cacheResult(cjProduct);

					if ((cjProduct.getGroupId() != groupId) ||
							(cjProduct.getUrlTitle() == null) ||
							!cjProduct.getUrlTitle().equals(urlTitle)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_G_UT,
							finderArgs, cjProduct);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_G_UT, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CJProduct)result;
		}
	}

	/**
	 * Removes the c j product where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the c j product that was removed
	 */
	@Override
	public CJProduct removeByG_UT(long groupId, String urlTitle)
		throws NoSuchCJProductException {
		CJProduct cjProduct = findByG_UT(groupId, urlTitle);

		return remove(cjProduct);
	}

	/**
	 * Returns the number of c j products where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching c j products
	 */
	@Override
	public int countByG_UT(long groupId, String urlTitle) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_UT;

		Object[] finderArgs = new Object[] { groupId, urlTitle };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CJPRODUCT_WHERE);

			query.append(_FINDER_COLUMN_G_UT_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_UT_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_G_UT_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_UT_GROUPID_2 = "cjProduct.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_UT_URLTITLE_1 = "cjProduct.urlTitle IS NULL";
	private static final String _FINDER_COLUMN_G_UT_URLTITLE_2 = "cjProduct.urlTitle = ?";
	private static final String _FINDER_COLUMN_G_UT_URLTITLE_3 = "(cjProduct.urlTitle IS NULL OR cjProduct.urlTitle = '')";

	public CJProductPersistenceImpl() {
		setModelClass(CJProduct.class);
	}

	/**
	 * Caches the c j product in the entity cache if it is enabled.
	 *
	 * @param cjProduct the c j product
	 */
	@Override
	public void cacheResult(CJProduct cjProduct) {
		entityCache.putResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductImpl.class, cjProduct.getPrimaryKey(), cjProduct);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { cjProduct.getUuid(), cjProduct.getGroupId() },
			cjProduct);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU,
			new Object[] {
				cjProduct.getProgramName(), cjProduct.getCatalogName(),
				cjProduct.getSku()
			}, cjProduct);

		finderCache.putResult(FINDER_PATH_FETCH_BY_G_UT,
			new Object[] { cjProduct.getGroupId(), cjProduct.getUrlTitle() },
			cjProduct);

		cjProduct.resetOriginalValues();
	}

	/**
	 * Caches the c j products in the entity cache if it is enabled.
	 *
	 * @param cjProducts the c j products
	 */
	@Override
	public void cacheResult(List<CJProduct> cjProducts) {
		for (CJProduct cjProduct : cjProducts) {
			if (entityCache.getResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
						CJProductImpl.class, cjProduct.getPrimaryKey()) == null) {
				cacheResult(cjProduct);
			}
			else {
				cjProduct.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all c j products.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CJProductImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the c j product.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CJProduct cjProduct) {
		entityCache.removeResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductImpl.class, cjProduct.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CJProductModelImpl)cjProduct);
	}

	@Override
	public void clearCache(List<CJProduct> cjProducts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CJProduct cjProduct : cjProducts) {
			entityCache.removeResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
				CJProductImpl.class, cjProduct.getPrimaryKey());

			clearUniqueFindersCache((CJProductModelImpl)cjProduct);
		}
	}

	protected void cacheUniqueFindersCache(
		CJProductModelImpl cjProductModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					cjProductModelImpl.getUuid(),
					cjProductModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				cjProductModelImpl);

			args = new Object[] {
					cjProductModelImpl.getProgramName(),
					cjProductModelImpl.getCatalogName(),
					cjProductModelImpl.getSku()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_PROGRAM_CATALOG_SKU,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU,
				args, cjProductModelImpl);

			args = new Object[] {
					cjProductModelImpl.getGroupId(),
					cjProductModelImpl.getUrlTitle()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_G_UT, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_G_UT, args,
				cjProductModelImpl);
		}
		else {
			if ((cjProductModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cjProductModelImpl.getUuid(),
						cjProductModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					cjProductModelImpl);
			}

			if ((cjProductModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cjProductModelImpl.getProgramName(),
						cjProductModelImpl.getCatalogName(),
						cjProductModelImpl.getSku()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_PROGRAM_CATALOG_SKU,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU,
					args, cjProductModelImpl);
			}

			if ((cjProductModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_UT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cjProductModelImpl.getGroupId(),
						cjProductModelImpl.getUrlTitle()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_G_UT, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_G_UT, args,
					cjProductModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CJProductModelImpl cjProductModelImpl) {
		Object[] args = new Object[] {
				cjProductModelImpl.getUuid(), cjProductModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((cjProductModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					cjProductModelImpl.getOriginalUuid(),
					cjProductModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				cjProductModelImpl.getProgramName(),
				cjProductModelImpl.getCatalogName(), cjProductModelImpl.getSku()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_PROGRAM_CATALOG_SKU, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU, args);

		if ((cjProductModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU.getColumnBitmask()) != 0) {
			args = new Object[] {
					cjProductModelImpl.getOriginalProgramName(),
					cjProductModelImpl.getOriginalCatalogName(),
					cjProductModelImpl.getOriginalSku()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROGRAM_CATALOG_SKU,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROGRAM_CATALOG_SKU,
				args);
		}

		args = new Object[] {
				cjProductModelImpl.getGroupId(),
				cjProductModelImpl.getUrlTitle()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_G_UT, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_G_UT, args);

		if ((cjProductModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_UT.getColumnBitmask()) != 0) {
			args = new Object[] {
					cjProductModelImpl.getOriginalGroupId(),
					cjProductModelImpl.getOriginalUrlTitle()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_UT, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_G_UT, args);
		}
	}

	/**
	 * Creates a new c j product with the primary key. Does not add the c j product to the database.
	 *
	 * @param productId the primary key for the new c j product
	 * @return the new c j product
	 */
	@Override
	public CJProduct create(long productId) {
		CJProduct cjProduct = new CJProductImpl();

		cjProduct.setNew(true);
		cjProduct.setPrimaryKey(productId);

		String uuid = PortalUUIDUtil.generate();

		cjProduct.setUuid(uuid);

		cjProduct.setCompanyId(companyProvider.getCompanyId());

		return cjProduct;
	}

	/**
	 * Removes the c j product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the c j product
	 * @return the c j product that was removed
	 * @throws NoSuchCJProductException if a c j product with the primary key could not be found
	 */
	@Override
	public CJProduct remove(long productId) throws NoSuchCJProductException {
		return remove((Serializable)productId);
	}

	/**
	 * Removes the c j product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c j product
	 * @return the c j product that was removed
	 * @throws NoSuchCJProductException if a c j product with the primary key could not be found
	 */
	@Override
	public CJProduct remove(Serializable primaryKey)
		throws NoSuchCJProductException {
		Session session = null;

		try {
			session = openSession();

			CJProduct cjProduct = (CJProduct)session.get(CJProductImpl.class,
					primaryKey);

			if (cjProduct == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCJProductException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cjProduct);
		}
		catch (NoSuchCJProductException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CJProduct removeImpl(CJProduct cjProduct) {
		cjProduct = toUnwrappedModel(cjProduct);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cjProduct)) {
				cjProduct = (CJProduct)session.get(CJProductImpl.class,
						cjProduct.getPrimaryKeyObj());
			}

			if (cjProduct != null) {
				session.delete(cjProduct);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cjProduct != null) {
			clearCache(cjProduct);
		}

		return cjProduct;
	}

	@Override
	public CJProduct updateImpl(CJProduct cjProduct) {
		cjProduct = toUnwrappedModel(cjProduct);

		boolean isNew = cjProduct.isNew();

		CJProductModelImpl cjProductModelImpl = (CJProductModelImpl)cjProduct;

		if (Validator.isNull(cjProduct.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cjProduct.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (cjProduct.getCreateDate() == null)) {
			if (serviceContext == null) {
				cjProduct.setCreateDate(now);
			}
			else {
				cjProduct.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!cjProductModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cjProduct.setModifiedDate(now);
			}
			else {
				cjProduct.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (cjProduct.isNew()) {
				session.save(cjProduct);

				cjProduct.setNew(false);
			}
			else {
				cjProduct = (CJProduct)session.merge(cjProduct);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CJProductModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cjProductModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cjProductModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { cjProductModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((cjProductModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cjProductModelImpl.getOriginalUuid(),
						cjProductModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						cjProductModelImpl.getUuid(),
						cjProductModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((cjProductModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cjProductModelImpl.getOriginalManufacturer()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MANUFACTURER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER,
					args);

				args = new Object[] { cjProductModelImpl.getManufacturer() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MANUFACTURER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER,
					args);
			}
		}

		entityCache.putResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
			CJProductImpl.class, cjProduct.getPrimaryKey(), cjProduct, false);

		clearUniqueFindersCache(cjProductModelImpl);
		cacheUniqueFindersCache(cjProductModelImpl, isNew);

		cjProduct.resetOriginalValues();

		return cjProduct;
	}

	protected CJProduct toUnwrappedModel(CJProduct cjProduct) {
		if (cjProduct instanceof CJProductImpl) {
			return cjProduct;
		}

		CJProductImpl cjProductImpl = new CJProductImpl();

		cjProductImpl.setNew(cjProduct.isNew());
		cjProductImpl.setPrimaryKey(cjProduct.getPrimaryKey());

		cjProductImpl.setUuid(cjProduct.getUuid());
		cjProductImpl.setProductId(cjProduct.getProductId());
		cjProductImpl.setGroupId(cjProduct.getGroupId());
		cjProductImpl.setCompanyId(cjProduct.getCompanyId());
		cjProductImpl.setUserId(cjProduct.getUserId());
		cjProductImpl.setUserName(cjProduct.getUserName());
		cjProductImpl.setCreateDate(cjProduct.getCreateDate());
		cjProductImpl.setModifiedDate(cjProduct.getModifiedDate());
		cjProductImpl.setUrlTitle(cjProduct.getUrlTitle());
		cjProductImpl.setProgramName(cjProduct.getProgramName());
		cjProductImpl.setCatalogName(cjProduct.getCatalogName());
		cjProductImpl.setSku(cjProduct.getSku());
		cjProductImpl.setProgramUrl(cjProduct.getProgramUrl());
		cjProductImpl.setLastUpdated(cjProduct.getLastUpdated());
		cjProductImpl.setName(cjProduct.getName());
		cjProductImpl.setKeywords(cjProduct.getKeywords());
		cjProductImpl.setDescription(cjProduct.getDescription());
		cjProductImpl.setManufacturer(cjProduct.getManufacturer());
		cjProductImpl.setManufacturerId(cjProduct.getManufacturerId());
		cjProductImpl.setCurrency(cjProduct.getCurrency());
		cjProductImpl.setPrice(cjProduct.getPrice());
		cjProductImpl.setBuyUrl(cjProduct.getBuyUrl());
		cjProductImpl.setImpressionUrl(cjProduct.getImpressionUrl());
		cjProductImpl.setImageUrl(cjProduct.getImageUrl());
		cjProductImpl.setInStock(cjProduct.getInStock());
		cjProductImpl.setViewCount(cjProduct.getViewCount());

		return cjProductImpl;
	}

	/**
	 * Returns the c j product with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c j product
	 * @return the c j product
	 * @throws NoSuchCJProductException if a c j product with the primary key could not be found
	 */
	@Override
	public CJProduct findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCJProductException {
		CJProduct cjProduct = fetchByPrimaryKey(primaryKey);

		if (cjProduct == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCJProductException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cjProduct;
	}

	/**
	 * Returns the c j product with the primary key or throws a {@link NoSuchCJProductException} if it could not be found.
	 *
	 * @param productId the primary key of the c j product
	 * @return the c j product
	 * @throws NoSuchCJProductException if a c j product with the primary key could not be found
	 */
	@Override
	public CJProduct findByPrimaryKey(long productId)
		throws NoSuchCJProductException {
		return findByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns the c j product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c j product
	 * @return the c j product, or <code>null</code> if a c j product with the primary key could not be found
	 */
	@Override
	public CJProduct fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
				CJProductImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CJProduct cjProduct = (CJProduct)serializable;

		if (cjProduct == null) {
			Session session = null;

			try {
				session = openSession();

				cjProduct = (CJProduct)session.get(CJProductImpl.class,
						primaryKey);

				if (cjProduct != null) {
					cacheResult(cjProduct);
				}
				else {
					entityCache.putResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
						CJProductImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
					CJProductImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cjProduct;
	}

	/**
	 * Returns the c j product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the c j product
	 * @return the c j product, or <code>null</code> if a c j product with the primary key could not be found
	 */
	@Override
	public CJProduct fetchByPrimaryKey(long productId) {
		return fetchByPrimaryKey((Serializable)productId);
	}

	@Override
	public Map<Serializable, CJProduct> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CJProduct> map = new HashMap<Serializable, CJProduct>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CJProduct cjProduct = fetchByPrimaryKey(primaryKey);

			if (cjProduct != null) {
				map.put(primaryKey, cjProduct);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
					CJProductImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CJProduct)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CJPRODUCT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CJProduct cjProduct : (List<CJProduct>)q.list()) {
				map.put(cjProduct.getPrimaryKeyObj(), cjProduct);

				cacheResult(cjProduct);

				uncachedPrimaryKeys.remove(cjProduct.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CJProductModelImpl.ENTITY_CACHE_ENABLED,
					CJProductImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the c j products.
	 *
	 * @return the c j products
	 */
	@Override
	public List<CJProduct> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CJProduct> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CJProduct> findAll(int start, int end,
		OrderByComparator<CJProduct> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CJProduct> findAll(int start, int end,
		OrderByComparator<CJProduct> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CJProduct> list = null;

		if (retrieveFromCache) {
			list = (List<CJProduct>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CJPRODUCT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CJPRODUCT;

				if (pagination) {
					sql = sql.concat(CJProductModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CJProduct>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CJProduct>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the c j products from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CJProduct cjProduct : findAll()) {
			remove(cjProduct);
		}
	}

	/**
	 * Returns the number of c j products.
	 *
	 * @return the number of c j products
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CJPRODUCT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CJProductModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the c j product persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CJProductImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CJPRODUCT = "SELECT cjProduct FROM CJProduct cjProduct";
	private static final String _SQL_SELECT_CJPRODUCT_WHERE_PKS_IN = "SELECT cjProduct FROM CJProduct cjProduct WHERE productId IN (";
	private static final String _SQL_SELECT_CJPRODUCT_WHERE = "SELECT cjProduct FROM CJProduct cjProduct WHERE ";
	private static final String _SQL_COUNT_CJPRODUCT = "SELECT COUNT(cjProduct) FROM CJProduct cjProduct";
	private static final String _SQL_COUNT_CJPRODUCT_WHERE = "SELECT COUNT(cjProduct) FROM CJProduct cjProduct WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cjProduct.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CJProduct exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CJProduct exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CJProductPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "currency"
			});
}
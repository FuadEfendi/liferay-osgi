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

import ca.efendi.datafeeds.model.FtpSubscription;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ftp subscription service. This utility wraps {@link ca.efendi.datafeeds.service.persistence.impl.FtpSubscriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FtpSubscriptionPersistence
 * @see ca.efendi.datafeeds.service.persistence.impl.FtpSubscriptionPersistenceImpl
 * @generated
 */
@ProviderType
public class FtpSubscriptionUtil {
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
	public static void clearCache(FtpSubscription ftpSubscription) {
		getPersistence().clearCache(ftpSubscription);
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
	public static List<FtpSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FtpSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FtpSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FtpSubscription> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FtpSubscription update(FtpSubscription ftpSubscription) {
		return getPersistence().update(ftpSubscription);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FtpSubscription update(FtpSubscription ftpSubscription,
		ServiceContext serviceContext) {
		return getPersistence().update(ftpSubscription, serviceContext);
	}

	/**
	* Returns all the ftp subscriptions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching ftp subscriptions
	*/
	public static List<FtpSubscription> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the ftp subscriptions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of ftp subscriptions
	* @param end the upper bound of the range of ftp subscriptions (not inclusive)
	* @return the range of matching ftp subscriptions
	*/
	public static List<FtpSubscription> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the ftp subscriptions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of ftp subscriptions
	* @param end the upper bound of the range of ftp subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ftp subscriptions
	*/
	public static List<FtpSubscription> findByGroupId(long groupId, int start,
		int end, OrderByComparator<FtpSubscription> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ftp subscriptions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of ftp subscriptions
	* @param end the upper bound of the range of ftp subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ftp subscriptions
	*/
	public static List<FtpSubscription> findByGroupId(long groupId, int start,
		int end, OrderByComparator<FtpSubscription> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ftp subscription
	* @throws NoSuchFtpSubscriptionException if a matching ftp subscription could not be found
	*/
	public static FtpSubscription findByGroupId_First(long groupId,
		OrderByComparator<FtpSubscription> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchFtpSubscriptionException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ftp subscription, or <code>null</code> if a matching ftp subscription could not be found
	*/
	public static FtpSubscription fetchByGroupId_First(long groupId,
		OrderByComparator<FtpSubscription> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ftp subscription
	* @throws NoSuchFtpSubscriptionException if a matching ftp subscription could not be found
	*/
	public static FtpSubscription findByGroupId_Last(long groupId,
		OrderByComparator<FtpSubscription> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchFtpSubscriptionException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ftp subscription, or <code>null</code> if a matching ftp subscription could not be found
	*/
	public static FtpSubscription fetchByGroupId_Last(long groupId,
		OrderByComparator<FtpSubscription> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the ftp subscriptions before and after the current ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param ftpSubscriptionId the primary key of the current ftp subscription
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ftp subscription
	* @throws NoSuchFtpSubscriptionException if a ftp subscription with the primary key could not be found
	*/
	public static FtpSubscription[] findByGroupId_PrevAndNext(
		long ftpSubscriptionId, long groupId,
		OrderByComparator<FtpSubscription> orderByComparator)
		throws ca.efendi.datafeeds.exception.NoSuchFtpSubscriptionException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(ftpSubscriptionId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the ftp subscriptions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of ftp subscriptions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching ftp subscriptions
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Caches the ftp subscription in the entity cache if it is enabled.
	*
	* @param ftpSubscription the ftp subscription
	*/
	public static void cacheResult(FtpSubscription ftpSubscription) {
		getPersistence().cacheResult(ftpSubscription);
	}

	/**
	* Caches the ftp subscriptions in the entity cache if it is enabled.
	*
	* @param ftpSubscriptions the ftp subscriptions
	*/
	public static void cacheResult(List<FtpSubscription> ftpSubscriptions) {
		getPersistence().cacheResult(ftpSubscriptions);
	}

	/**
	* Creates a new ftp subscription with the primary key. Does not add the ftp subscription to the database.
	*
	* @param ftpSubscriptionId the primary key for the new ftp subscription
	* @return the new ftp subscription
	*/
	public static FtpSubscription create(long ftpSubscriptionId) {
		return getPersistence().create(ftpSubscriptionId);
	}

	/**
	* Removes the ftp subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription that was removed
	* @throws NoSuchFtpSubscriptionException if a ftp subscription with the primary key could not be found
	*/
	public static FtpSubscription remove(long ftpSubscriptionId)
		throws ca.efendi.datafeeds.exception.NoSuchFtpSubscriptionException {
		return getPersistence().remove(ftpSubscriptionId);
	}

	public static FtpSubscription updateImpl(FtpSubscription ftpSubscription) {
		return getPersistence().updateImpl(ftpSubscription);
	}

	/**
	* Returns the ftp subscription with the primary key or throws a {@link NoSuchFtpSubscriptionException} if it could not be found.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription
	* @throws NoSuchFtpSubscriptionException if a ftp subscription with the primary key could not be found
	*/
	public static FtpSubscription findByPrimaryKey(long ftpSubscriptionId)
		throws ca.efendi.datafeeds.exception.NoSuchFtpSubscriptionException {
		return getPersistence().findByPrimaryKey(ftpSubscriptionId);
	}

	/**
	* Returns the ftp subscription with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription, or <code>null</code> if a ftp subscription with the primary key could not be found
	*/
	public static FtpSubscription fetchByPrimaryKey(long ftpSubscriptionId) {
		return getPersistence().fetchByPrimaryKey(ftpSubscriptionId);
	}

	public static java.util.Map<java.io.Serializable, FtpSubscription> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ftp subscriptions.
	*
	* @return the ftp subscriptions
	*/
	public static List<FtpSubscription> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ftp subscriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ftp subscriptions
	* @param end the upper bound of the range of ftp subscriptions (not inclusive)
	* @return the range of ftp subscriptions
	*/
	public static List<FtpSubscription> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ftp subscriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ftp subscriptions
	* @param end the upper bound of the range of ftp subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ftp subscriptions
	*/
	public static List<FtpSubscription> findAll(int start, int end,
		OrderByComparator<FtpSubscription> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ftp subscriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ftp subscriptions
	* @param end the upper bound of the range of ftp subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ftp subscriptions
	*/
	public static List<FtpSubscription> findAll(int start, int end,
		OrderByComparator<FtpSubscription> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ftp subscriptions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ftp subscriptions.
	*
	* @return the number of ftp subscriptions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FtpSubscriptionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FtpSubscriptionPersistence, FtpSubscriptionPersistence> _serviceTracker =
		ServiceTrackerFactory.open(FtpSubscriptionPersistence.class);
}
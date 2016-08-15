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

import ca.efendi.datafeeds.exception.NoSuchFtpSubscriptionException;
import ca.efendi.datafeeds.model.FtpSubscription;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the ftp subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fefendi
 * @see ca.efendi.datafeeds.service.persistence.impl.FtpSubscriptionPersistenceImpl
 * @see FtpSubscriptionUtil
 * @generated
 */
@ProviderType
public interface FtpSubscriptionPersistence extends BasePersistence<FtpSubscription> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FtpSubscriptionUtil} to access the ftp subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ftp subscriptions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching ftp subscriptions
	*/
	public java.util.List<FtpSubscription> findByGroupId(long groupId);

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
	public java.util.List<FtpSubscription> findByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<FtpSubscription> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator);

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
	public java.util.List<FtpSubscription> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ftp subscription
	* @throws NoSuchFtpSubscriptionException if a matching ftp subscription could not be found
	*/
	public FtpSubscription findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator)
		throws NoSuchFtpSubscriptionException;

	/**
	* Returns the first ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ftp subscription, or <code>null</code> if a matching ftp subscription could not be found
	*/
	public FtpSubscription fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator);

	/**
	* Returns the last ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ftp subscription
	* @throws NoSuchFtpSubscriptionException if a matching ftp subscription could not be found
	*/
	public FtpSubscription findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator)
		throws NoSuchFtpSubscriptionException;

	/**
	* Returns the last ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ftp subscription, or <code>null</code> if a matching ftp subscription could not be found
	*/
	public FtpSubscription fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator);

	/**
	* Returns the ftp subscriptions before and after the current ftp subscription in the ordered set where groupId = &#63;.
	*
	* @param ftpSubscriptionId the primary key of the current ftp subscription
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ftp subscription
	* @throws NoSuchFtpSubscriptionException if a ftp subscription with the primary key could not be found
	*/
	public FtpSubscription[] findByGroupId_PrevAndNext(long ftpSubscriptionId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator)
		throws NoSuchFtpSubscriptionException;

	/**
	* Removes all the ftp subscriptions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of ftp subscriptions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching ftp subscriptions
	*/
	public int countByGroupId(long groupId);

	/**
	* Caches the ftp subscription in the entity cache if it is enabled.
	*
	* @param ftpSubscription the ftp subscription
	*/
	public void cacheResult(FtpSubscription ftpSubscription);

	/**
	* Caches the ftp subscriptions in the entity cache if it is enabled.
	*
	* @param ftpSubscriptions the ftp subscriptions
	*/
	public void cacheResult(java.util.List<FtpSubscription> ftpSubscriptions);

	/**
	* Creates a new ftp subscription with the primary key. Does not add the ftp subscription to the database.
	*
	* @param ftpSubscriptionId the primary key for the new ftp subscription
	* @return the new ftp subscription
	*/
	public FtpSubscription create(long ftpSubscriptionId);

	/**
	* Removes the ftp subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription that was removed
	* @throws NoSuchFtpSubscriptionException if a ftp subscription with the primary key could not be found
	*/
	public FtpSubscription remove(long ftpSubscriptionId)
		throws NoSuchFtpSubscriptionException;

	public FtpSubscription updateImpl(FtpSubscription ftpSubscription);

	/**
	* Returns the ftp subscription with the primary key or throws a {@link NoSuchFtpSubscriptionException} if it could not be found.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription
	* @throws NoSuchFtpSubscriptionException if a ftp subscription with the primary key could not be found
	*/
	public FtpSubscription findByPrimaryKey(long ftpSubscriptionId)
		throws NoSuchFtpSubscriptionException;

	/**
	* Returns the ftp subscription with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription, or <code>null</code> if a ftp subscription with the primary key could not be found
	*/
	public FtpSubscription fetchByPrimaryKey(long ftpSubscriptionId);

	@Override
	public java.util.Map<java.io.Serializable, FtpSubscription> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ftp subscriptions.
	*
	* @return the ftp subscriptions
	*/
	public java.util.List<FtpSubscription> findAll();

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
	public java.util.List<FtpSubscription> findAll(int start, int end);

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
	public java.util.List<FtpSubscription> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator);

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
	public java.util.List<FtpSubscription> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FtpSubscription> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ftp subscriptions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ftp subscriptions.
	*
	* @return the number of ftp subscriptions
	*/
	public int countAll();
}
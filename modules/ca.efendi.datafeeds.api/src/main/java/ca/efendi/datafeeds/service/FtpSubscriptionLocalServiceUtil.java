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
 * Provides the local service utility for FtpSubscription. This utility wraps
 * {@link ca.efendi.datafeeds.service.impl.FtpSubscriptionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author fefendi
 * @see FtpSubscriptionLocalService
 * @see ca.efendi.datafeeds.service.base.FtpSubscriptionLocalServiceBaseImpl
 * @see ca.efendi.datafeeds.service.impl.FtpSubscriptionLocalServiceImpl
 * @generated
 */
@ProviderType
public class FtpSubscriptionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ca.efendi.datafeeds.service.impl.FtpSubscriptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ftp subscription to the database. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscription the ftp subscription
	* @return the ftp subscription that was added
	*/
	public static ca.efendi.datafeeds.model.FtpSubscription addFtpSubscription(
		ca.efendi.datafeeds.model.FtpSubscription ftpSubscription) {
		return getService().addFtpSubscription(ftpSubscription);
	}

	public static ca.efendi.datafeeds.model.FtpSubscription addFtpSubscription(
		ca.efendi.datafeeds.model.FtpSubscription newFtpSubscription,
		long userId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return getService()
				   .addFtpSubscription(newFtpSubscription, userId,
			serviceContext);
	}

	/**
	* Creates a new ftp subscription with the primary key. Does not add the ftp subscription to the database.
	*
	* @param ftpSubscriptionId the primary key for the new ftp subscription
	* @return the new ftp subscription
	*/
	public static ca.efendi.datafeeds.model.FtpSubscription createFtpSubscription(
		long ftpSubscriptionId) {
		return getService().createFtpSubscription(ftpSubscriptionId);
	}

	/**
	* Deletes the ftp subscription from the database. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscription the ftp subscription
	* @return the ftp subscription that was removed
	*/
	public static ca.efendi.datafeeds.model.FtpSubscription deleteFtpSubscription(
		ca.efendi.datafeeds.model.FtpSubscription ftpSubscription) {
		return getService().deleteFtpSubscription(ftpSubscription);
	}

	/**
	* Deletes the ftp subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription that was removed
	* @throws PortalException if a ftp subscription with the primary key could not be found
	*/
	public static ca.efendi.datafeeds.model.FtpSubscription deleteFtpSubscription(
		long ftpSubscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFtpSubscription(ftpSubscriptionId);
	}

	public static ca.efendi.datafeeds.model.FtpSubscription fetchFtpSubscription(
		long ftpSubscriptionId) {
		return getService().fetchFtpSubscription(ftpSubscriptionId);
	}

	/**
	* Returns the ftp subscription with the primary key.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription
	* @throws PortalException if a ftp subscription with the primary key could not be found
	*/
	public static ca.efendi.datafeeds.model.FtpSubscription getFtpSubscription(
		long ftpSubscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFtpSubscription(ftpSubscriptionId);
	}

	/**
	* Updates the ftp subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscription the ftp subscription
	* @return the ftp subscription that was updated
	*/
	public static ca.efendi.datafeeds.model.FtpSubscription updateFtpSubscription(
		ca.efendi.datafeeds.model.FtpSubscription ftpSubscription) {
		return getService().updateFtpSubscription(ftpSubscription);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
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
	* Returns the number of ftp subscriptions.
	*
	* @return the number of ftp subscriptions
	*/
	public static int getFtpSubscriptionsCount() {
		return getService().getFtpSubscriptionsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ca.efendi.datafeeds.model.impl.FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ca.efendi.datafeeds.model.impl.FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<ca.efendi.datafeeds.model.FtpSubscription> getAllFtpSubscriptions() {
		return getService().getAllFtpSubscriptions();
	}

	public static java.util.List<ca.efendi.datafeeds.model.FtpSubscription> getAllFtpSubscriptions(
		long groupId) {
		return getService().getAllFtpSubscriptions(groupId);
	}

	/**
	* Returns a range of all the ftp subscriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ca.efendi.datafeeds.model.impl.FtpSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ftp subscriptions
	* @param end the upper bound of the range of ftp subscriptions (not inclusive)
	* @return the range of ftp subscriptions
	*/
	public static java.util.List<ca.efendi.datafeeds.model.FtpSubscription> getFtpSubscriptions(
		int start, int end) {
		return getService().getFtpSubscriptions(start, end);
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

	public static FtpSubscriptionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FtpSubscriptionLocalService, FtpSubscriptionLocalService> _serviceTracker =
		ServiceTrackerFactory.open(FtpSubscriptionLocalService.class);
}
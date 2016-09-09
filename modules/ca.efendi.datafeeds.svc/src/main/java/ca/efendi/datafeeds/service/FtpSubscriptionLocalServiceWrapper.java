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

import ca.efendi.datafeeds.model.FtpSubscription;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FtpSubscriptionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FtpSubscriptionLocalService
 * @generated
 */
@ProviderType
public class FtpSubscriptionLocalServiceWrapper
	implements FtpSubscriptionLocalService,
		ServiceWrapper<FtpSubscriptionLocalService> {
	public FtpSubscriptionLocalServiceWrapper(
		FtpSubscriptionLocalService ftpSubscriptionLocalService) {
		_ftpSubscriptionLocalService = ftpSubscriptionLocalService;
	}

	/**
	* Adds the ftp subscription to the database. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscription the ftp subscription
	* @return the ftp subscription that was added
	*/
	@Override
	public FtpSubscription addFtpSubscription(
		FtpSubscription ftpSubscription) {
		return _ftpSubscriptionLocalService.addFtpSubscription(ftpSubscription);
	}

	@Override
	public FtpSubscription addFtpSubscription(
		FtpSubscription newFtpSubscription,
		long userId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _ftpSubscriptionLocalService.addFtpSubscription(newFtpSubscription,
			userId, serviceContext);
	}

	/**
	* Creates a new ftp subscription with the primary key. Does not add the ftp subscription to the database.
	*
	* @param ftpSubscriptionId the primary key for the new ftp subscription
	* @return the new ftp subscription
	*/
	@Override
	public FtpSubscription createFtpSubscription(
		long ftpSubscriptionId) {
		return _ftpSubscriptionLocalService.createFtpSubscription(ftpSubscriptionId);
	}

	/**
	* Deletes the ftp subscription from the database. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscription the ftp subscription
	* @return the ftp subscription that was removed
	*/
	@Override
	public FtpSubscription deleteFtpSubscription(
		FtpSubscription ftpSubscription) {
		return _ftpSubscriptionLocalService.deleteFtpSubscription(ftpSubscription);
	}

	/**
	* Deletes the ftp subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription that was removed
	* @throws PortalException if a ftp subscription with the primary key could not be found
	*/
	@Override
	public FtpSubscription deleteFtpSubscription(
		long ftpSubscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ftpSubscriptionLocalService.deleteFtpSubscription(ftpSubscriptionId);
	}

	@Override
	public FtpSubscription fetchFtpSubscription(
		long ftpSubscriptionId) {
		return _ftpSubscriptionLocalService.fetchFtpSubscription(ftpSubscriptionId);
	}

	/**
	* Returns the ftp subscription with the primary key.
	*
	* @param ftpSubscriptionId the primary key of the ftp subscription
	* @return the ftp subscription
	* @throws PortalException if a ftp subscription with the primary key could not be found
	*/
	@Override
	public FtpSubscription getFtpSubscription(
		long ftpSubscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ftpSubscriptionLocalService.getFtpSubscription(ftpSubscriptionId);
	}

	/**
	* Updates the ftp subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ftpSubscription the ftp subscription
	* @return the ftp subscription that was updated
	*/
	@Override
	public FtpSubscription updateFtpSubscription(
		FtpSubscription ftpSubscription) {
		return _ftpSubscriptionLocalService.updateFtpSubscription(ftpSubscription);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ftpSubscriptionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ftpSubscriptionLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ftpSubscriptionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ftpSubscriptionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ftpSubscriptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of ftp subscriptions.
	*
	* @return the number of ftp subscriptions
	*/
	@Override
	public int getFtpSubscriptionsCount() {
		return _ftpSubscriptionLocalService.getFtpSubscriptionsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _ftpSubscriptionLocalService.getOSGiServiceIdentifier();
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
		return _ftpSubscriptionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _ftpSubscriptionLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ftpSubscriptionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<FtpSubscription> getAllFtpSubscriptions() {
		return _ftpSubscriptionLocalService.getAllFtpSubscriptions();
	}

	@Override
	public java.util.List<FtpSubscription> getAllFtpSubscriptions(
		long groupId) {
		return _ftpSubscriptionLocalService.getAllFtpSubscriptions(groupId);
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
	@Override
	public java.util.List<FtpSubscription> getFtpSubscriptions(
		int start, int end) {
		return _ftpSubscriptionLocalService.getFtpSubscriptions(start, end);
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
		return _ftpSubscriptionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ftpSubscriptionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public FtpSubscriptionLocalService getWrappedService() {
		return _ftpSubscriptionLocalService;
	}

	@Override
	public void setWrappedService(
		FtpSubscriptionLocalService ftpSubscriptionLocalService) {
		_ftpSubscriptionLocalService = ftpSubscriptionLocalService;
	}

	private FtpSubscriptionLocalService _ftpSubscriptionLocalService;
}
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

package ca.efendi.datafeeds.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the FtpSubscription service. Represents a row in the &quot;FE_FtpSubscription&quot; database table, with each column mapped to a property of this class.
 *
 * @author fefendi
 * @see FtpSubscriptionModel
 * @see ca.efendi.datafeeds.model.impl.FtpSubscriptionImpl
 * @see ca.efendi.datafeeds.model.impl.FtpSubscriptionModelImpl
 * @generated
 */
@ImplementationClassName("ca.efendi.datafeeds.model.impl.FtpSubscriptionImpl")
@ProviderType
public interface FtpSubscription extends FtpSubscriptionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link ca.efendi.datafeeds.model.impl.FtpSubscriptionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FtpSubscription, Long> FTP_SUBSCRIPTION_ID_ACCESSOR =
		new Accessor<FtpSubscription, Long>() {
			@Override
			public Long get(FtpSubscription ftpSubscription) {
				return ftpSubscription.getFtpSubscriptionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FtpSubscription> getTypeClass() {
				return FtpSubscription.class;
			}
		};
}
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
 * The extended model interface for the CJProduct service. Represents a row in the &quot;FE_CJProduct&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CJProductModel
 * @see ca.efendi.datafeeds.model.impl.CJProductImpl
 * @see ca.efendi.datafeeds.model.impl.CJProductModelImpl
 * @generated
 */
@ImplementationClassName("ca.efendi.datafeeds.model.impl.CJProductImpl")
@ProviderType
public interface CJProduct extends CJProductModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link ca.efendi.datafeeds.model.impl.CJProductImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CJProduct, Long> PRODUCT_ID_ACCESSOR = new Accessor<CJProduct, Long>() {
			@Override
			public Long get(CJProduct cjProduct) {
				return cjProduct.getProductId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CJProduct> getTypeClass() {
				return CJProduct.class;
			}
		};

	public long getEntryId();

	public java.lang.String getCoverImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.lang.String getSmallImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException;
}
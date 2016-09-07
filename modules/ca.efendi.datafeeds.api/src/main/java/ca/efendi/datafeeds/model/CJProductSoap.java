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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CJProductSoap implements Serializable {
	public static CJProductSoap toSoapModel(CJProduct model) {
		CJProductSoap soapModel = new CJProductSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProductId(model.getProductId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUrlTitle(model.getUrlTitle());
		soapModel.setProgramName(model.getProgramName());
		soapModel.setCatalogName(model.getCatalogName());
		soapModel.setSku(model.getSku());
		soapModel.setProgramUrl(model.getProgramUrl());
		soapModel.setLastUpdated(model.getLastUpdated());
		soapModel.setName(model.getName());
		soapModel.setKeywords(model.getKeywords());
		soapModel.setDescription(model.getDescription());
		soapModel.setManufacturer(model.getManufacturer());
		soapModel.setManufacturerId(model.getManufacturerId());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setPrice(model.getPrice());
		soapModel.setBuyUrl(model.getBuyUrl());
		soapModel.setImpressionUrl(model.getImpressionUrl());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setInStock(model.getInStock());
		soapModel.setViewCount(model.getViewCount());

		return soapModel;
	}

	public static CJProductSoap[] toSoapModels(CJProduct[] models) {
		CJProductSoap[] soapModels = new CJProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CJProductSoap[][] toSoapModels(CJProduct[][] models) {
		CJProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CJProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CJProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CJProductSoap[] toSoapModels(List<CJProduct> models) {
		List<CJProductSoap> soapModels = new ArrayList<CJProductSoap>(models.size());

		for (CJProduct model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CJProductSoap[soapModels.size()]);
	}

	public CJProductSoap() {
	}

	public long getPrimaryKey() {
		return _productId;
	}

	public void setPrimaryKey(long pk) {
		setProductId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getUrlTitle() {
		return _urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	public String getProgramName() {
		return _programName;
	}

	public void setProgramName(String programName) {
		_programName = programName;
	}

	public String getCatalogName() {
		return _catalogName;
	}

	public void setCatalogName(String catalogName) {
		_catalogName = catalogName;
	}

	public String getSku() {
		return _sku;
	}

	public void setSku(String sku) {
		_sku = sku;
	}

	public String getProgramUrl() {
		return _programUrl;
	}

	public void setProgramUrl(String programUrl) {
		_programUrl = programUrl;
	}

	public String getLastUpdated() {
		return _lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		_lastUpdated = lastUpdated;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getKeywords() {
		return _keywords;
	}

	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getManufacturer() {
		return _manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		_manufacturer = manufacturer;
	}

	public String getManufacturerId() {
		return _manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		_manufacturerId = manufacturerId;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public String getPrice() {
		return _price;
	}

	public void setPrice(String price) {
		_price = price;
	}

	public String getBuyUrl() {
		return _buyUrl;
	}

	public void setBuyUrl(String buyUrl) {
		_buyUrl = buyUrl;
	}

	public String getImpressionUrl() {
		return _impressionUrl;
	}

	public void setImpressionUrl(String impressionUrl) {
		_impressionUrl = impressionUrl;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getInStock() {
		return _inStock;
	}

	public void setInStock(String inStock) {
		_inStock = inStock;
	}

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	private String _uuid;
	private long _productId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _urlTitle;
	private String _programName;
	private String _catalogName;
	private String _sku;
	private String _programUrl;
	private String _lastUpdated;
	private String _name;
	private String _keywords;
	private String _description;
	private String _manufacturer;
	private String _manufacturerId;
	private String _currency;
	private String _price;
	private String _buyUrl;
	private String _impressionUrl;
	private String _imageUrl;
	private String _inStock;
	private int _viewCount;
}
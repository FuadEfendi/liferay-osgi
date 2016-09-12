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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CJProduct}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CJProduct
 * @generated
 */
@ProviderType
public class CJProductWrapper implements CJProduct, ModelWrapper<CJProduct> {
	public CJProductWrapper(CJProduct cjProduct) {
		_cjProduct = cjProduct;
	}

	@Override
	public Class<?> getModelClass() {
		return CJProduct.class;
	}

	@Override
	public String getModelClassName() {
		return CJProduct.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productId", getProductId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("programName", getProgramName());
		attributes.put("catalogName", getCatalogName());
		attributes.put("sku", getSku());
		attributes.put("programUrl", getProgramUrl());
		attributes.put("lastUpdated", getLastUpdated());
		attributes.put("name", getName());
		attributes.put("keywords", getKeywords());
		attributes.put("description", getDescription());
		attributes.put("manufacturer", getManufacturer());
		attributes.put("manufacturerId", getManufacturerId());
		attributes.put("currency", getCurrency());
		attributes.put("price", getPrice());
		attributes.put("buyUrl", getBuyUrl());
		attributes.put("impressionUrl", getImpressionUrl());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("inStock", getInStock());
		attributes.put("viewCount", getViewCount());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("subtitle", getSubtitle());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("content", getContent());
		attributes.put("displayDate", getDisplayDate());
		attributes.put("coverImageCaption", getCoverImageCaption());
		attributes.put("coverImageFileEntryId", getCoverImageFileEntryId());
		attributes.put("coverImageURL", getCoverImageURL());
		attributes.put("smallImage", getSmallImage());
		attributes.put("smallImageFileEntryId", getSmallImageFileEntryId());
		attributes.put("smallImageId", getSmallImageId());
		attributes.put("smallImageURL", getSmallImageURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String programName = (String)attributes.get("programName");

		if (programName != null) {
			setProgramName(programName);
		}

		String catalogName = (String)attributes.get("catalogName");

		if (catalogName != null) {
			setCatalogName(catalogName);
		}

		String sku = (String)attributes.get("sku");

		if (sku != null) {
			setSku(sku);
		}

		String programUrl = (String)attributes.get("programUrl");

		if (programUrl != null) {
			setProgramUrl(programUrl);
		}

		String lastUpdated = (String)attributes.get("lastUpdated");

		if (lastUpdated != null) {
			setLastUpdated(lastUpdated);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String keywords = (String)attributes.get("keywords");

		if (keywords != null) {
			setKeywords(keywords);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String manufacturer = (String)attributes.get("manufacturer");

		if (manufacturer != null) {
			setManufacturer(manufacturer);
		}

		String manufacturerId = (String)attributes.get("manufacturerId");

		if (manufacturerId != null) {
			setManufacturerId(manufacturerId);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String buyUrl = (String)attributes.get("buyUrl");

		if (buyUrl != null) {
			setBuyUrl(buyUrl);
		}

		String impressionUrl = (String)attributes.get("impressionUrl");

		if (impressionUrl != null) {
			setImpressionUrl(impressionUrl);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String inStock = (String)attributes.get("inStock");

		if (inStock != null) {
			setInStock(inStock);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String subtitle = (String)attributes.get("subtitle");

		if (subtitle != null) {
			setSubtitle(subtitle);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Date displayDate = (Date)attributes.get("displayDate");

		if (displayDate != null) {
			setDisplayDate(displayDate);
		}

		String coverImageCaption = (String)attributes.get("coverImageCaption");

		if (coverImageCaption != null) {
			setCoverImageCaption(coverImageCaption);
		}

		Long coverImageFileEntryId = (Long)attributes.get(
				"coverImageFileEntryId");

		if (coverImageFileEntryId != null) {
			setCoverImageFileEntryId(coverImageFileEntryId);
		}

		String coverImageURL = (String)attributes.get("coverImageURL");

		if (coverImageURL != null) {
			setCoverImageURL(coverImageURL);
		}

		Boolean smallImage = (Boolean)attributes.get("smallImage");

		if (smallImage != null) {
			setSmallImage(smallImage);
		}

		Long smallImageFileEntryId = (Long)attributes.get(
				"smallImageFileEntryId");

		if (smallImageFileEntryId != null) {
			setSmallImageFileEntryId(smallImageFileEntryId);
		}

		Long smallImageId = (Long)attributes.get("smallImageId");

		if (smallImageId != null) {
			setSmallImageId(smallImageId);
		}

		String smallImageURL = (String)attributes.get("smallImageURL");

		if (smallImageURL != null) {
			setSmallImageURL(smallImageURL);
		}
	}

	/**
	* Returns the small image of this c j product.
	*
	* @return the small image of this c j product
	*/
	@Override
	public boolean getSmallImage() {
		return _cjProduct.getSmallImage();
	}

	/**
	* Returns <code>true</code> if this c j product is approved.
	*
	* @return <code>true</code> if this c j product is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _cjProduct.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _cjProduct.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this c j product is denied.
	*
	* @return <code>true</code> if this c j product is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _cjProduct.isDenied();
	}

	/**
	* Returns <code>true</code> if this c j product is a draft.
	*
	* @return <code>true</code> if this c j product is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _cjProduct.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _cjProduct.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this c j product is expired.
	*
	* @return <code>true</code> if this c j product is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _cjProduct.isExpired();
	}

	/**
	* Returns <code>true</code> if this c j product is inactive.
	*
	* @return <code>true</code> if this c j product is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _cjProduct.isInactive();
	}

	/**
	* Returns <code>true</code> if this c j product is incomplete.
	*
	* @return <code>true</code> if this c j product is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _cjProduct.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _cjProduct.isNew();
	}

	/**
	* Returns <code>true</code> if this c j product is pending.
	*
	* @return <code>true</code> if this c j product is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _cjProduct.isPending();
	}

	/**
	* Returns <code>true</code> if this c j product is scheduled.
	*
	* @return <code>true</code> if this c j product is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _cjProduct.isScheduled();
	}

	/**
	* Returns <code>true</code> if this c j product is small image.
	*
	* @return <code>true</code> if this c j product is small image; <code>false</code> otherwise
	*/
	@Override
	public boolean isSmallImage() {
		return _cjProduct.isSmallImage();
	}

	@Override
	public ca.efendi.datafeeds.model.CJProduct toEscapedModel() {
		return new CJProductWrapper(_cjProduct.toEscapedModel());
	}

	@Override
	public ca.efendi.datafeeds.model.CJProduct toUnescapedModel() {
		return new CJProductWrapper(_cjProduct.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cjProduct.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ca.efendi.datafeeds.model.CJProduct> toCacheModel() {
		return _cjProduct.toCacheModel();
	}

	@Override
	public int compareTo(ca.efendi.datafeeds.model.CJProduct cjProduct) {
		return _cjProduct.compareTo(cjProduct);
	}

	/**
	* Returns the status of this c j product.
	*
	* @return the status of this c j product
	*/
	@Override
	public int getStatus() {
		return _cjProduct.getStatus();
	}

	/**
	* Returns the view count of this c j product.
	*
	* @return the view count of this c j product
	*/
	@Override
	public int getViewCount() {
		return _cjProduct.getViewCount();
	}

	@Override
	public int hashCode() {
		return _cjProduct.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cjProduct.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CJProductWrapper((CJProduct)_cjProduct.clone());
	}

	/**
	* Returns the buy url of this c j product.
	*
	* @return the buy url of this c j product
	*/
	@Override
	public java.lang.String getBuyUrl() {
		return _cjProduct.getBuyUrl();
	}

	/**
	* Returns the catalog name of this c j product.
	*
	* @return the catalog name of this c j product
	*/
	@Override
	public java.lang.String getCatalogName() {
		return _cjProduct.getCatalogName();
	}

	/**
	* Returns the content of this c j product.
	*
	* @return the content of this c j product
	*/
	@Override
	public java.lang.String getContent() {
		return _cjProduct.getContent();
	}

	/**
	* Returns the cover image caption of this c j product.
	*
	* @return the cover image caption of this c j product
	*/
	@Override
	public java.lang.String getCoverImageCaption() {
		return _cjProduct.getCoverImageCaption();
	}

	/**
	* Returns the cover image u r l of this c j product.
	*
	* @return the cover image u r l of this c j product
	*/
	@Override
	public java.lang.String getCoverImageURL() {
		return _cjProduct.getCoverImageURL();
	}

	@Override
	public java.lang.String getCoverImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProduct.getCoverImageURL(themeDisplay);
	}

	/**
	* Returns the currency of this c j product.
	*
	* @return the currency of this c j product
	*/
	@Override
	public java.lang.String getCurrency() {
		return _cjProduct.getCurrency();
	}

	/**
	* Returns the description of this c j product.
	*
	* @return the description of this c j product
	*/
	@Override
	public java.lang.String getDescription() {
		return _cjProduct.getDescription();
	}

	/**
	* Returns the image url of this c j product.
	*
	* @return the image url of this c j product
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _cjProduct.getImageUrl();
	}

	/**
	* Returns the impression url of this c j product.
	*
	* @return the impression url of this c j product
	*/
	@Override
	public java.lang.String getImpressionUrl() {
		return _cjProduct.getImpressionUrl();
	}

	/**
	* Returns the in stock of this c j product.
	*
	* @return the in stock of this c j product
	*/
	@Override
	public java.lang.String getInStock() {
		return _cjProduct.getInStock();
	}

	/**
	* Returns the keywords of this c j product.
	*
	* @return the keywords of this c j product
	*/
	@Override
	public java.lang.String getKeywords() {
		return _cjProduct.getKeywords();
	}

	/**
	* Returns the last updated of this c j product.
	*
	* @return the last updated of this c j product
	*/
	@Override
	public java.lang.String getLastUpdated() {
		return _cjProduct.getLastUpdated();
	}

	/**
	* Returns the manufacturer of this c j product.
	*
	* @return the manufacturer of this c j product
	*/
	@Override
	public java.lang.String getManufacturer() {
		return _cjProduct.getManufacturer();
	}

	/**
	* Returns the manufacturer ID of this c j product.
	*
	* @return the manufacturer ID of this c j product
	*/
	@Override
	public java.lang.String getManufacturerId() {
		return _cjProduct.getManufacturerId();
	}

	/**
	* Returns the name of this c j product.
	*
	* @return the name of this c j product
	*/
	@Override
	public java.lang.String getName() {
		return _cjProduct.getName();
	}

	/**
	* Returns the price of this c j product.
	*
	* @return the price of this c j product
	*/
	@Override
	public java.lang.String getPrice() {
		return _cjProduct.getPrice();
	}

	/**
	* Returns the program name of this c j product.
	*
	* @return the program name of this c j product
	*/
	@Override
	public java.lang.String getProgramName() {
		return _cjProduct.getProgramName();
	}

	/**
	* Returns the program url of this c j product.
	*
	* @return the program url of this c j product
	*/
	@Override
	public java.lang.String getProgramUrl() {
		return _cjProduct.getProgramUrl();
	}

	/**
	* Returns the sku of this c j product.
	*
	* @return the sku of this c j product
	*/
	@Override
	public java.lang.String getSku() {
		return _cjProduct.getSku();
	}

	/**
	* Returns the small image u r l of this c j product.
	*
	* @return the small image u r l of this c j product
	*/
	@Override
	public java.lang.String getSmallImageURL() {
		return _cjProduct.getSmallImageURL();
	}

	@Override
	public java.lang.String getSmallImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cjProduct.getSmallImageURL(themeDisplay);
	}

	/**
	* Returns the status by user name of this c j product.
	*
	* @return the status by user name of this c j product
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _cjProduct.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this c j product.
	*
	* @return the status by user uuid of this c j product
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _cjProduct.getStatusByUserUuid();
	}

	/**
	* Returns the subtitle of this c j product.
	*
	* @return the subtitle of this c j product
	*/
	@Override
	public java.lang.String getSubtitle() {
		return _cjProduct.getSubtitle();
	}

	/**
	* Returns the url title of this c j product.
	*
	* @return the url title of this c j product
	*/
	@Override
	public java.lang.String getUrlTitle() {
		return _cjProduct.getUrlTitle();
	}

	/**
	* Returns the user name of this c j product.
	*
	* @return the user name of this c j product
	*/
	@Override
	public java.lang.String getUserName() {
		return _cjProduct.getUserName();
	}

	/**
	* Returns the user uuid of this c j product.
	*
	* @return the user uuid of this c j product
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _cjProduct.getUserUuid();
	}

	/**
	* Returns the uuid of this c j product.
	*
	* @return the uuid of this c j product
	*/
	@Override
	public java.lang.String getUuid() {
		return _cjProduct.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _cjProduct.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cjProduct.toXmlString();
	}

	/**
	* Returns the create date of this c j product.
	*
	* @return the create date of this c j product
	*/
	@Override
	public Date getCreateDate() {
		return _cjProduct.getCreateDate();
	}

	/**
	* Returns the display date of this c j product.
	*
	* @return the display date of this c j product
	*/
	@Override
	public Date getDisplayDate() {
		return _cjProduct.getDisplayDate();
	}

	/**
	* Returns the modified date of this c j product.
	*
	* @return the modified date of this c j product
	*/
	@Override
	public Date getModifiedDate() {
		return _cjProduct.getModifiedDate();
	}

	/**
	* Returns the status date of this c j product.
	*
	* @return the status date of this c j product
	*/
	@Override
	public Date getStatusDate() {
		return _cjProduct.getStatusDate();
	}

	/**
	* Returns the company ID of this c j product.
	*
	* @return the company ID of this c j product
	*/
	@Override
	public long getCompanyId() {
		return _cjProduct.getCompanyId();
	}

	/**
	* Returns the cover image file entry ID of this c j product.
	*
	* @return the cover image file entry ID of this c j product
	*/
	@Override
	public long getCoverImageFileEntryId() {
		return _cjProduct.getCoverImageFileEntryId();
	}

	@Override
	public long getEntryId() {
		return _cjProduct.getEntryId();
	}

	/**
	* Returns the group ID of this c j product.
	*
	* @return the group ID of this c j product
	*/
	@Override
	public long getGroupId() {
		return _cjProduct.getGroupId();
	}

	/**
	* Returns the primary key of this c j product.
	*
	* @return the primary key of this c j product
	*/
	@Override
	public long getPrimaryKey() {
		return _cjProduct.getPrimaryKey();
	}

	/**
	* Returns the product ID of this c j product.
	*
	* @return the product ID of this c j product
	*/
	@Override
	public long getProductId() {
		return _cjProduct.getProductId();
	}

	/**
	* Returns the small image file entry ID of this c j product.
	*
	* @return the small image file entry ID of this c j product
	*/
	@Override
	public long getSmallImageFileEntryId() {
		return _cjProduct.getSmallImageFileEntryId();
	}

	/**
	* Returns the small image ID of this c j product.
	*
	* @return the small image ID of this c j product
	*/
	@Override
	public long getSmallImageId() {
		return _cjProduct.getSmallImageId();
	}

	/**
	* Returns the status by user ID of this c j product.
	*
	* @return the status by user ID of this c j product
	*/
	@Override
	public long getStatusByUserId() {
		return _cjProduct.getStatusByUserId();
	}

	/**
	* Returns the user ID of this c j product.
	*
	* @return the user ID of this c j product
	*/
	@Override
	public long getUserId() {
		return _cjProduct.getUserId();
	}

	@Override
	public void persist() {
		_cjProduct.persist();
	}

	/**
	* Sets the buy url of this c j product.
	*
	* @param buyUrl the buy url of this c j product
	*/
	@Override
	public void setBuyUrl(java.lang.String buyUrl) {
		_cjProduct.setBuyUrl(buyUrl);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cjProduct.setCachedModel(cachedModel);
	}

	/**
	* Sets the catalog name of this c j product.
	*
	* @param catalogName the catalog name of this c j product
	*/
	@Override
	public void setCatalogName(java.lang.String catalogName) {
		_cjProduct.setCatalogName(catalogName);
	}

	/**
	* Sets the company ID of this c j product.
	*
	* @param companyId the company ID of this c j product
	*/
	@Override
	public void setCompanyId(long companyId) {
		_cjProduct.setCompanyId(companyId);
	}

	/**
	* Sets the content of this c j product.
	*
	* @param content the content of this c j product
	*/
	@Override
	public void setContent(java.lang.String content) {
		_cjProduct.setContent(content);
	}

	/**
	* Sets the cover image caption of this c j product.
	*
	* @param coverImageCaption the cover image caption of this c j product
	*/
	@Override
	public void setCoverImageCaption(java.lang.String coverImageCaption) {
		_cjProduct.setCoverImageCaption(coverImageCaption);
	}

	/**
	* Sets the cover image file entry ID of this c j product.
	*
	* @param coverImageFileEntryId the cover image file entry ID of this c j product
	*/
	@Override
	public void setCoverImageFileEntryId(long coverImageFileEntryId) {
		_cjProduct.setCoverImageFileEntryId(coverImageFileEntryId);
	}

	/**
	* Sets the cover image u r l of this c j product.
	*
	* @param coverImageURL the cover image u r l of this c j product
	*/
	@Override
	public void setCoverImageURL(java.lang.String coverImageURL) {
		_cjProduct.setCoverImageURL(coverImageURL);
	}

	/**
	* Sets the create date of this c j product.
	*
	* @param createDate the create date of this c j product
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_cjProduct.setCreateDate(createDate);
	}

	/**
	* Sets the currency of this c j product.
	*
	* @param currency the currency of this c j product
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_cjProduct.setCurrency(currency);
	}

	/**
	* Sets the description of this c j product.
	*
	* @param description the description of this c j product
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_cjProduct.setDescription(description);
	}

	/**
	* Sets the display date of this c j product.
	*
	* @param displayDate the display date of this c j product
	*/
	@Override
	public void setDisplayDate(Date displayDate) {
		_cjProduct.setDisplayDate(displayDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cjProduct.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_cjProduct.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cjProduct.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this c j product.
	*
	* @param groupId the group ID of this c j product
	*/
	@Override
	public void setGroupId(long groupId) {
		_cjProduct.setGroupId(groupId);
	}

	/**
	* Sets the image url of this c j product.
	*
	* @param imageUrl the image url of this c j product
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_cjProduct.setImageUrl(imageUrl);
	}

	/**
	* Sets the impression url of this c j product.
	*
	* @param impressionUrl the impression url of this c j product
	*/
	@Override
	public void setImpressionUrl(java.lang.String impressionUrl) {
		_cjProduct.setImpressionUrl(impressionUrl);
	}

	/**
	* Sets the in stock of this c j product.
	*
	* @param inStock the in stock of this c j product
	*/
	@Override
	public void setInStock(java.lang.String inStock) {
		_cjProduct.setInStock(inStock);
	}

	/**
	* Sets the keywords of this c j product.
	*
	* @param keywords the keywords of this c j product
	*/
	@Override
	public void setKeywords(java.lang.String keywords) {
		_cjProduct.setKeywords(keywords);
	}

	/**
	* Sets the last updated of this c j product.
	*
	* @param lastUpdated the last updated of this c j product
	*/
	@Override
	public void setLastUpdated(java.lang.String lastUpdated) {
		_cjProduct.setLastUpdated(lastUpdated);
	}

	/**
	* Sets the manufacturer of this c j product.
	*
	* @param manufacturer the manufacturer of this c j product
	*/
	@Override
	public void setManufacturer(java.lang.String manufacturer) {
		_cjProduct.setManufacturer(manufacturer);
	}

	/**
	* Sets the manufacturer ID of this c j product.
	*
	* @param manufacturerId the manufacturer ID of this c j product
	*/
	@Override
	public void setManufacturerId(java.lang.String manufacturerId) {
		_cjProduct.setManufacturerId(manufacturerId);
	}

	/**
	* Sets the modified date of this c j product.
	*
	* @param modifiedDate the modified date of this c j product
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_cjProduct.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this c j product.
	*
	* @param name the name of this c j product
	*/
	@Override
	public void setName(java.lang.String name) {
		_cjProduct.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_cjProduct.setNew(n);
	}

	/**
	* Sets the price of this c j product.
	*
	* @param price the price of this c j product
	*/
	@Override
	public void setPrice(java.lang.String price) {
		_cjProduct.setPrice(price);
	}

	/**
	* Sets the primary key of this c j product.
	*
	* @param primaryKey the primary key of this c j product
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cjProduct.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cjProduct.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the product ID of this c j product.
	*
	* @param productId the product ID of this c j product
	*/
	@Override
	public void setProductId(long productId) {
		_cjProduct.setProductId(productId);
	}

	/**
	* Sets the program name of this c j product.
	*
	* @param programName the program name of this c j product
	*/
	@Override
	public void setProgramName(java.lang.String programName) {
		_cjProduct.setProgramName(programName);
	}

	/**
	* Sets the program url of this c j product.
	*
	* @param programUrl the program url of this c j product
	*/
	@Override
	public void setProgramUrl(java.lang.String programUrl) {
		_cjProduct.setProgramUrl(programUrl);
	}

	/**
	* Sets the sku of this c j product.
	*
	* @param sku the sku of this c j product
	*/
	@Override
	public void setSku(java.lang.String sku) {
		_cjProduct.setSku(sku);
	}

	/**
	* Sets whether this c j product is small image.
	*
	* @param smallImage the small image of this c j product
	*/
	@Override
	public void setSmallImage(boolean smallImage) {
		_cjProduct.setSmallImage(smallImage);
	}

	/**
	* Sets the small image file entry ID of this c j product.
	*
	* @param smallImageFileEntryId the small image file entry ID of this c j product
	*/
	@Override
	public void setSmallImageFileEntryId(long smallImageFileEntryId) {
		_cjProduct.setSmallImageFileEntryId(smallImageFileEntryId);
	}

	/**
	* Sets the small image ID of this c j product.
	*
	* @param smallImageId the small image ID of this c j product
	*/
	@Override
	public void setSmallImageId(long smallImageId) {
		_cjProduct.setSmallImageId(smallImageId);
	}

	/**
	* Sets the small image u r l of this c j product.
	*
	* @param smallImageURL the small image u r l of this c j product
	*/
	@Override
	public void setSmallImageURL(java.lang.String smallImageURL) {
		_cjProduct.setSmallImageURL(smallImageURL);
	}

	/**
	* Sets the status of this c j product.
	*
	* @param status the status of this c j product
	*/
	@Override
	public void setStatus(int status) {
		_cjProduct.setStatus(status);
	}

	/**
	* Sets the status by user ID of this c j product.
	*
	* @param statusByUserId the status by user ID of this c j product
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_cjProduct.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this c j product.
	*
	* @param statusByUserName the status by user name of this c j product
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_cjProduct.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this c j product.
	*
	* @param statusByUserUuid the status by user uuid of this c j product
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_cjProduct.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this c j product.
	*
	* @param statusDate the status date of this c j product
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_cjProduct.setStatusDate(statusDate);
	}

	/**
	* Sets the subtitle of this c j product.
	*
	* @param subtitle the subtitle of this c j product
	*/
	@Override
	public void setSubtitle(java.lang.String subtitle) {
		_cjProduct.setSubtitle(subtitle);
	}

	/**
	* Sets the url title of this c j product.
	*
	* @param urlTitle the url title of this c j product
	*/
	@Override
	public void setUrlTitle(java.lang.String urlTitle) {
		_cjProduct.setUrlTitle(urlTitle);
	}

	/**
	* Sets the user ID of this c j product.
	*
	* @param userId the user ID of this c j product
	*/
	@Override
	public void setUserId(long userId) {
		_cjProduct.setUserId(userId);
	}

	/**
	* Sets the user name of this c j product.
	*
	* @param userName the user name of this c j product
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_cjProduct.setUserName(userName);
	}

	/**
	* Sets the user uuid of this c j product.
	*
	* @param userUuid the user uuid of this c j product
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_cjProduct.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this c j product.
	*
	* @param uuid the uuid of this c j product
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_cjProduct.setUuid(uuid);
	}

	/**
	* Sets the view count of this c j product.
	*
	* @param viewCount the view count of this c j product
	*/
	@Override
	public void setViewCount(int viewCount) {
		_cjProduct.setViewCount(viewCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CJProductWrapper)) {
			return false;
		}

		CJProductWrapper cjProductWrapper = (CJProductWrapper)obj;

		if (Objects.equals(_cjProduct, cjProductWrapper._cjProduct)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _cjProduct.getStagedModelType();
	}

	@Override
	public CJProduct getWrappedModel() {
		return _cjProduct;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cjProduct.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cjProduct.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cjProduct.resetOriginalValues();
	}

	private final CJProduct _cjProduct;
}
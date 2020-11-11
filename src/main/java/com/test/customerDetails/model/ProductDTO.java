package com.test.customerDetails.model;

import com.google.gson.JsonObject;

public class ProductDTO {
	Long id;
	String title, vendor, product_type, published_scope;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getPublished_scope() {
		return published_scope;
	}

	public void setPublished_scope(String published_scope) {
		this.published_scope = published_scope;
	}

	public ProductMetaModel _toConvert(ProductDTO dto, JsonObject jsonObject) {
		ProductMetaModel metaModel = new ProductMetaModel();
		metaModel.setpId(dto.getId());
		metaModel.setTitle(dto.getTitle());
		metaModel.setVendor(dto.getVendor());
		metaModel.setProduct_type(dto.getProduct_type());
		metaModel.setPublished_scope(dto.getPublished_scope());
		metaModel.setVariantId(jsonObject.get("id").getAsLong());
		metaModel.setVariantTitle(jsonObject.get("title").getAsString());
		metaModel.setVariantPrice(jsonObject.get("price").getAsFloat());
		metaModel.setVariantWeight(jsonObject.get("weight").getAsFloat());
		return metaModel;
	}
}

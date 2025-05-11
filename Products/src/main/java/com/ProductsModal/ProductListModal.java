package com.ProductsModal;

public class ProductListModal {

	private String productID;
	private String productName;
	private String productType;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public ProductListModal() {

	}

	public ProductListModal(String productID, String productName, String productType) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "ProductList [productID=" + productID + ", productName=" + productName + ", productType=" + productType
				+ "]";
	}

}

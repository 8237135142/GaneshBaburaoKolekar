package com.shop.dto;

public class SearchProductResponseDto {

    public int productId;
	
	public String productName;
	
	public String productDescription;
	
	public int productPrice;
	
	public SearchProductResponseDto()
	{
		
	}

	public SearchProductResponseDto(int productId, String productName, String productDescription, int productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	
}

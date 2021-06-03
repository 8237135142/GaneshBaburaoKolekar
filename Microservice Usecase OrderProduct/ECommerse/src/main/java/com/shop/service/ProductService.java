package com.shop.service;

import java.util.List;

import com.shop.dto.SearchProductResponseDto;
import com.shop.exception.ResourceNotFoundException;

public interface ProductService {

	public List<SearchProductResponseDto> searchProductByCategory(String categoryName) throws ResourceNotFoundException;
	
	public SearchProductResponseDto searchProductByProductName(String productName) throws ResourceNotFoundException;
	
	public void updateProductQuantity(int productId, int productQuantity) throws ResourceNotFoundException;
	
}

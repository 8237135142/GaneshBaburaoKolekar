package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.SearchProductResponseDto;
import com.shop.entity.Product;
import com.shop.exception.ResourceNotFoundException;
import com.shop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<SearchProductResponseDto> searchProductByCategory(String categoryName) throws ResourceNotFoundException {
		List<SearchProductResponseDto> searchProductResponseDto=new ArrayList<SearchProductResponseDto>();
		List<Product> products= productRepository.findAllProductsByCategoryNameIgnoreCase(categoryName);
		logger.info("search by category name its shows all product names..");
		if(products.isEmpty())
			throw new ResourceNotFoundException("Category is not matched..");
		else
			for (Product product: products ) {
				SearchProductResponseDto target= new SearchProductResponseDto();
		        BeanUtils.copyProperties(product , target);
		        searchProductResponseDto.add(target);
		     }
			return searchProductResponseDto;
	}

	@Override
	public SearchProductResponseDto searchProductByProductName(String productName) throws ResourceNotFoundException {
		SearchProductResponseDto searchProductResponseDto= new SearchProductResponseDto();
		//Product product=new Product();
			logger.info("search by product name its show particular product..");
			Product product = productRepository.findByProductNameContains(productName)
					.orElseThrow(()->new ResourceNotFoundException("Product Not Found!"));
			BeanUtils.copyProperties(product, searchProductResponseDto);
		return searchProductResponseDto;
	}
	
	/*@Override
	public List<SearchProductResponseDto> searchProductByCategory(String categoryName) throws ResourceNotFoundException
	{
		List<SearchProductResponseDto> searchProductResponseDto=new ArrayList<SearchProductResponseDto>();
		
		
		logger.info("search by category name its shows all product names..");
		List<Product> products = productRepository.findByCategoryNameIgnoreCase(categoryName).orElseThrow(() -> new ResourceNotFoundException("Category not found :: " + categoryName));
		BeanUtils.copyProperties(products, searchProductResponseDto);
		return searchProductResponseDto;
	}*/
	
	/*@Override
	public SearchProductResponseDto searchProductByProductName(String productName) throws ResourceNotFoundException {
		SearchProductResponseDto searchProductResponseDto= new SearchProductResponseDto();
		Product product=new Product();
		logger.info("search by product name its show particular product..");
		product = productRepository.findByProductNameIgnoreCase(productName).orElseThrow(() -> new ResourceNotFoundException("Product not found :: " + productName));
		BeanUtils.copyProperties(product, searchProductResponseDto);
		return searchProductResponseDto;
	}*/

	@Transactional
	@Override
	public void updateProductQuantity(int productId, int productQuantity) throws ResourceNotFoundException {
		int updateQuantity;
		Product product = productRepository.findById(productId)
			.orElseThrow(()->new ResourceNotFoundException("Product Not Found!"));
		int quantity = product.getProductQuantity();
		if(quantity > productQuantity){
			updateQuantity = quantity - productQuantity;
			product.setProductQuantity(updateQuantity);
		}
		else
			throw new ResourceNotFoundException("Product Quantity is less..");
	}
}



package com.shop.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.BuyProductRequestDto;
import com.shop.dto.SearchProductResponseDto;
import com.shop.entity.Orders;
import com.shop.exception.ResourceNotFoundException;
import com.shop.service.OrderService;
import com.shop.service.ProductService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/products")
@Validated
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	ProductService productService;

	@Autowired
	OrderService orderService;

	/*
	 * @GetMapping("/port") public String getCarServicePortNo() { return
	 * userService.getCarServicePortNo(); }
	 */

	@GetMapping("/search/category")
	public ResponseEntity<List<SearchProductResponseDto>> searchByCategory(@RequestParam String categoryName)
			throws ResourceNotFoundException {
		logger.info("search product by catgory name: use searchProductByCategory() method..");
		return new ResponseEntity<List<SearchProductResponseDto>>(productService.searchProductByCategory(categoryName),
				HttpStatus.FOUND);

	}

	@GetMapping("/search")
	public ResponseEntity<SearchProductResponseDto> searchByProduct(@RequestParam(required = true) String productName)
			throws ResourceNotFoundException {
		logger.info("search product by product name: use searchProductByProductName() method..");
		return new ResponseEntity<SearchProductResponseDto>(productService.searchProductByProductName(productName),
				HttpStatus.FOUND);
	}

	@PostMapping("/buy")
	public ResponseEntity<String> buy(@Valid @RequestBody BuyProductRequestDto buyProductRequestDto)
			throws ResourceNotFoundException {
		System.out.println("Account:" + buyProductRequestDto.getAccountNumber());
		return new ResponseEntity<String>(orderService.buyProduct(buyProductRequestDto), HttpStatus.CREATED);

	}

	@GetMapping("/users/{userId}/orders")
	public ResponseEntity<List<Orders>> orderHistory(@PathVariable int userId) throws ResourceNotFoundException {

		return new ResponseEntity<List<Orders>>(orderService.findOrderHistoryByUserId(userId), HttpStatus.FOUND);

	}
}

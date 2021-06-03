package com.shop.service;

import java.util.List;

import com.shop.dto.BuyProductRequestDto;
import com.shop.entity.Orders;
import com.shop.exception.ResourceNotFoundException;

public interface OrderService {
	public String buyProduct(BuyProductRequestDto buyProductRequestDto) throws ResourceNotFoundException;

	public int billAmount(int price, int quantity);

	public List<Orders> findOrderHistoryByUserId(int userId)
			throws ResourceNotFoundException;

}

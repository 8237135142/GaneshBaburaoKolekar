package com.shop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.BuyProductRequestDto;
import com.shop.dto.ProductRequestDto;
import com.shop.entity.Customer;
import com.shop.entity.OrderDetails;
import com.shop.entity.Orders;
import com.shop.entity.Product;
import com.shop.exception.ResourceNotFoundException;
import com.shop.feignclient.BankClient;
import com.shop.repository.CustomerRepository;
import com.shop.repository.OrderDetailsRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	ProductService productService;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	BankClient bankClient;
	
	@Autowired
	CustomerRepository customerRepository;

	@Transactional
	@Override
	public String buyProduct(BuyProductRequestDto buyProductRequestDto) throws ResourceNotFoundException {
		int totalPrice = 0, productID = 0, productQuantity = 0;
		Orders orders;
		logger.info("using fetchBalance() method fetch balance from Bank-Service...");
		OrderDetails orderDetails = new OrderDetails();
		List<ProductRequestDto> productRequestDtoList = buyProductRequestDto.getProducts();
		//List<Product> productList = new ArrayList<Product>();
		List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
		Product products = new Product();
		
		Customer customer = customerRepository.findById(buyProductRequestDto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found.."));
		//Product product = new Product();
		if(customer==null){
			throw new ResourceNotFoundException("User not found");
		}
		else{
		for(ProductRequestDto productRequestDto : productRequestDtoList)
		{
			//ProductRequestDto productRequestDto = new ProductRequestDto();
			BeanUtils.copyProperties(productRequestDto , products);
			productID = products.getProductId();
			productQuantity = products.getProductQuantity();
			//BeanUtils.copyProperties(products, orderDetails);
			
			logger.info("fetch product price from product table by pasing the productID...");
			Product product = productRepository.findById(productID)
					.orElseThrow(() -> new ResourceNotFoundException("product not found...."));

			int price = product.getProductPrice();
			orders = new Orders();
			orderDetails.setPrice(billAmount(price, productQuantity));
			orderDetails.setProductId(productID);
			orderDetails.setQuantity(productQuantity);
			orderDetails.setOrders(orders);
			orderDetailsList.add(orderDetails);
			
			totalPrice = totalPrice + billAmount(price, productQuantity);
			productService.updateProductQuantity(productID, productQuantity);
			
		}
		int accountNumber = buyProductRequestDto.getAccountNumber();
		bankClient.updatedBalance(accountNumber, totalPrice);
		
		logger.info("move to data..");
		orders = new Orders();
		orders.setOrderDate(new Date());
		orders.setTotalPrice(totalPrice);
	
		orders.setUserId(buyProductRequestDto.getUserId());
		orderRepository.save(orders);
		
		for(OrderDetails orderDetail : orderDetailsList)
		{
			orderDetailsRepository.save(orderDetail);
		}

		return "Order Placed Successfully...";
		}
	}

	@Override
	public int billAmount(int price, int quantity) {
		logger.info("return this price to buyProduct() method for totalPrice");
		return price * quantity;
	}

	@Override
	public List<Orders> findOrderHistoryByUserId(int userId) throws ResourceNotFoundException
	{
		List<Orders> orders = orderRepository.findByUserId(userId);
		if(orders.isEmpty())
			throw new ResourceNotFoundException("this user not have any order ");
		else
			return orders;
	}

}

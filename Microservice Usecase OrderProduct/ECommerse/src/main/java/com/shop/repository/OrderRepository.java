package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {


	public List<Orders> findByUserId(@Param("userId") int userId);

	/*@Query(value = "update product set product_quantity=:product_quantity-productQuantity where product_id=:productId", nativeQuery = true)
	public void updateProductQuantity(@Param("productId") int productId, @Param("productQuantity") int productQuantity);*/

}

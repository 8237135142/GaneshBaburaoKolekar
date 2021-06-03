package com.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	@Query(value = "select * from product p INNER JOIN category c ON p.category_id = c.category_id where c.category_name=:categoryName", nativeQuery = true)
	public List<Product> findAllProductsByCategoryNameIgnoreCase(@Param("categoryName") String categoryName);
	
	Optional<Product> findByProductNameContains(String productName);
		
	/*@Query(value = "select * from product where product_name=:productName", nativeQuery = true)
	public Product findByProductNameIgnoreCase(@Param("productName") String productName);*/
		
	@Query(value = "select product_price from product where product_id=:productId", nativeQuery = true)
	public int findPriceByProductId(@Param("productId") int productId);
	/*
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "update product p set p.product_quantity=:p.product_quantity-productQuantity where p.product_id=:productId", nativeQuery = true)
	public void updateProductQuantity(@Param("productId") int productId, @Param("productQuantity") int productQuantity);*/
	
	
	/*@Modifying
    @Query("UPDATE Company c SET c.address = :address WHERE c.id = :companyId")
    int updateAddress(@Param("companyId") int companyId, @Param("address") String address);*/
	
	
	
	
	
/*@Query(value = "select * from product p INNER JOIN category c ON p.category_id = c.category_id where c.category_name=:categoryName OR p.product_name=:productName", nativeQuery = true)
public List<SearchProductResponseDto> findByCategoryNameIgnoreCaseOrProductNameIgnoreCase(@Param("categoryName") String categoryName, @Param("productName") String productName);
	*/


	//product.product_id, product.product_name, product.product_description, product.product_price, product.product_quantity
	
	//@Query("SELECT t.title FROM Todo t where t.id = :id") inner
	
	//findByDescriptionIgnoreCaseContainingOrderByDescriptionAsc
}

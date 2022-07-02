package com.zensar.ide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.ide.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByProductName(String productName);

	List<Product> findByProductNameAndProductPrice(String productName, int productPrice);

	List<Product> findByProductNameOrProductPrice(String productName, int productPrice);

	
	//List<Product> byName(String productName);
	//@Query(value="from Product p where p.productName =:name")
	@Query(value="select * from product p where p.product_name=:name",nativeQuery=true)
	List<Product> byName(@Param("name")String productName);

	//List<Product> byNameOrPrice(String productName, int productPrice);
	//@Query(value="from Product p where p.productName=:name or p.productPrice=:price")
	@Query(value="select * from product p where p.product_name=:name or p.product_price=:price",nativeQuery=true)
	List<Product> byNameOrPrice(@Param("name")String productName, @Param("price")int productPrice);
}

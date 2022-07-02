package com.zensar.ide.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

import com.zensar.ide.dto.ProductDto;



@Entity
//@NamedQueries(value = { @NamedQuery(name = "Product.byName", query = "from Product p where p.productName =?1"),
//		@NamedQuery(name = "Product.byNameOrPrice", query = "from Product p where p.productName=?1 or p.productPrice=?2") })

//@NamedNativeQueries(value = {
//		@NamedNativeQuery(name = "Product.byName", query = "select * from product p where p.product_name=?1",resultClass = Product.class),
//		@NamedNativeQuery(name = "Product.byNameOrPrice", query = "select * from product p where p.product_name=?1 or p.product_price=?2",resultClass = Product.class) })

public class Product {
	@Id
	private int productId;
	private String productName;
	private int productPrice;
	

	@Transient
	private String couponCode;

	public Product() {
		super();
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

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", couponCode=" + couponCode + "]";
	}
	
	
}

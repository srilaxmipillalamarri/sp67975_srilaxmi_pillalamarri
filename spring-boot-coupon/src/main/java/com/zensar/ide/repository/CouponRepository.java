package com.zensar.ide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.ide.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	Coupon findByCouponCode(String couponCode);

	List<Coupon> findByCouponCodeOrCouponPrice(String couponCode, int price);

	List<Coupon> findByCouponCodeAndExpDate(String couponCode, String expDate);

	List<Coupon> findByCouponCodeOrderByCouponPrice(String CouponCode);

	// List<Coupon> test( String couponCode);
	// @Query(value = "from Coupon c where c.couponCode=:code")
	@Query(value = "select * from coupon c where c.coupon_code=:code", nativeQuery = true)
	List<Coupon> test(@Param("code") String CouponCode);

	// List<Coupon> test1( String couponCode,String expDate);
	// @Query(value = "from Coupon c where c.couponCode=:code and c.expDate=:date")
	@Query(value = "select * from coupon c where c.coupon_code=:code and c.exp_date=:date", nativeQuery = true)
	List<Coupon> test1(@Param("code") String couponCode, @Param("date") String expDate);
}

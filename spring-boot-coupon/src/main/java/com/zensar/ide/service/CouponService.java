package com.zensar.ide.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.zensar.ide.dto.CouponDto;

public interface CouponService {
	public CouponDto getCoupon(int CouponId);

	// public List<CouponDto> getCoupons();
	public List<CouponDto> getCoupons(int pageNumber, int pageSize, String sortBy, Direction dir);

	public CouponDto insertCoupon(CouponDto couponDto);

	public void updateCoupon(int CouponId, CouponDto couponDto);

	public void deleteCoupon(int CouponId);

	public CouponDto getByCouponCode(String couponCode);

	public List<CouponDto> getByCouponCodeOrCouponPrice(String couponCode, int price);

	public List<CouponDto> getByCouponCodeAndExpDate(String couponCode, String expDate);

	public List<CouponDto> getByCouponCodeOrderByCouponPrice(String couponCode);

}

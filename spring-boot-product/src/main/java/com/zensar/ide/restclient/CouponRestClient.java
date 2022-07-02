package com.zensar.ide.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.ide.dto.CouponDto;

@FeignClient("GATEWAY-SERVICE2")
public interface CouponRestClient {

	@GetMapping(value="coupon-api/coupons/code/{couponCode}",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	CouponDto getCoupon(@PathVariable("couponCode")String couponCode);
}

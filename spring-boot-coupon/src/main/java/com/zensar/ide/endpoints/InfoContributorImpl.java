package com.zensar.ide.endpoints;

import org.springframework.boot.actuate.info.Info.Builder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
@Component
public class InfoContributorImpl implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		Map<String, Object> couponDetails = new HashMap<String,Object>();
		couponDetails.put("CreatedBy", "Ahika");
		couponDetails.put("CreatedOn","July22nd2022");
		builder.withDetail("CouponXYZ", couponDetails);
		
	}

}

package com.zensar.endpoint.Info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;

public class TotalInfoContributor  implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		Map<String, Object> studentDetails = new HashMap<String,Object>();
		studentDetails.put("CreatedBy:", "srilaxmi");
		studentDetails.put("ModifiedOn:","July22nd2022");
		//builder.withDetails(studentDetails);
		builder.withDetail("Student", studentDetails);
	}

}

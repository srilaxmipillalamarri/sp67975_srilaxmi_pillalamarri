package com.zensar.ide.endpoints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
@Component
@Endpoint(id="damaged-products")
public class CustomEndPoint {
	private Map<String, List<String>> damagedProductsByCode = new HashMap<>();

	@PostConstruct
	public void init() {
		damagedProductsByCode.put("cd1", Arrays.asList("Screen damaged","Touch Screen was not working for product"));
		damagedProductsByCode.put("cd2",Arrays.asList("Battery Expired","Product wasn't functioning properly") );
						
				
	}
	@ReadOperation
	public Map<String, List<String>> getAllDamages() {
		return damagedProductsByCode;
		
	}
	@ReadOperation
	public List<String> getDamagedProductByCode(@Selector String productCode) {
		
		return damagedProductsByCode.get(productCode);
		
	}
	
	@WriteOperation
	public void addDamagedProducts(@Selector String productCode,@Selector String damages) {
		damagedProductsByCode.put(productCode, Arrays.asList(damages.split(",")));
	}

	@DeleteOperation
	public void deleteDamagedProducts(@Selector String productCode) {
		damagedProductsByCode.remove(productCode);
	}
}

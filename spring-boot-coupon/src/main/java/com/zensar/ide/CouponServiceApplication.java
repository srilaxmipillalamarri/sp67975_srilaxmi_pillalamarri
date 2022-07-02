package com.zensar.ide;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class CouponServiceApplication {
     @Value("${test.myLanguage}")
	private String language;
     @Autowired
     private MyConfig config;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}
	
	
	
	public String testConfig() {
		return "your language is" +language+ "\n your training is " +config.getTestProperty();
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	
	}
}

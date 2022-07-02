package com.zensar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.controller.entity.Student;

@RestController
public class RestActuatorController {
	@GetMapping("/students")
	public String student() {
		
		System.out.println("hello");
		return "hello world";	}

}

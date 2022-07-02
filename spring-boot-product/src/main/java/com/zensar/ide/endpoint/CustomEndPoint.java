package com.zensar.ide.endpoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;



@Endpoint(id = "myEndPoint")
@Component
public class CustomEndPoint {
	private Map<String, List<String>> myEndPointByVersionMap = new HashMap<>();

	@ReadOperation
	public String sayHello() {
		return "<h2>hello hi</h2>";

	}

	@GetMapping("/student")
	@ReadOperation

	public String myEndPointByName(@Selector String studentName) {
		return "custom-end-point";
	}

	@WriteOperation
	public String writeOperation(@Selector String name) {
		// perform write operation
		return "hello";
	}

	@DeleteOperation
	public String deleteOperation(@Selector String name) {
		return name;
		// delete operation
	}
}

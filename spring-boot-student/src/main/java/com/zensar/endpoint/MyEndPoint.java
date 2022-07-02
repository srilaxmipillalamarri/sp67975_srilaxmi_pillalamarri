package com.zensar.endpoint;

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
public class MyEndPoint {
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
	public void writeOperation(@Selector String name) {
		// perform write operation
	}

	@DeleteOperation
	public void deleteOperation(@Selector String name) {
		// delete operation
	}
}

package com.servicetwo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Service2Controller {

	private static final Logger logger = LoggerFactory.getLogger(Service2Controller.class);

	@GetMapping("/greet")
	public ResponseEntity<String> getStatus(@RequestHeader("traceID") String traceID) {

		logger.info("TRACE_ID[{}]:Received request from service2", traceID);
		return ResponseEntity.ok("Hello");
	}

}

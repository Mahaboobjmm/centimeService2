package com.io.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.entity.Customer;
import com.io.service.CustomerService;
import com.io.utility.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TaskOneController {

	private static final Logger logger = LoggerFactory.getLogger(TaskOneController.class);

	@Autowired
	CustomerService customerService;
	
	

	@Operation(summary = "get response from service-2 and service-3 and concat both of them")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success from service-3"),
			@ApiResponse(responseCode = "404", description = "Service not found"),
			@ApiResponse(responseCode = "400", description = "Bad Request") })
	@PostMapping("/postService")
	public ResponseEntity<String> postCustomer(@Valid @RequestBody Customer customer) {

		String traceID = UUID.randomUUID().toString();
		logger.info("TRACE_ID [{}]: Received request to concatenate", traceID);

		ResponseEntity<String> serviceTwoResponse = customerService.getCustomer(traceID);

		if (serviceTwoResponse.getStatusCode().is2xxSuccessful()) {

			ResponseEntity<String> serviceThreeResponse = customerService.createCustomerService(customer);

			if (serviceThreeResponse.getStatusCode().is2xxSuccessful()) {

				String greetings = serviceTwoResponse.getBody();
				String personName = serviceThreeResponse.getBody();

				return ResponseEntity.ok(greetings.concat(" ").concat(personName));
			} else {
				return ResponseEntity.badRequest().body(Constants.ERROR_FROM_SERVICE3);
			}

		}

		return ResponseEntity.badRequest().body(Constants.ERROR_FROM_SERVICE2);
	}

	@Operation(summary = "to check the service health check")
	@GetMapping("/status")
	public String getStatus() {
		return "Up";
	}

}

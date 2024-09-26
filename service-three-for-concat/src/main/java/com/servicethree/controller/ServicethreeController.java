package com.servicethree.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicethree.model.Person;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ServicethreeController {

	private static final Logger logger = LoggerFactory.getLogger(ServicethreeController.class);

	@PostMapping("/name")
	public String getName(@Valid @RequestBody Person person) {

		logger.info("Received person:" + person.toString());

		String fullName = person.getName() + " " + person.getSurname();

		return fullName;

	}

}

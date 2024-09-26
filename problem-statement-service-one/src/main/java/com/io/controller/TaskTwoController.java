package com.io.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.config.LogMethodParam;
import com.io.entity.Character;
import com.io.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class TaskTwoController {

	@Autowired
	CustomerService customerService;

	@Operation(summary = "Creates new characters")
	@ApiResponse(responseCode = "201", description = "Customer created successfully")
	@PostMapping("/addCharacter")
	public Character createCharacter(@RequestBody Character character) {
		return customerService.createChar(character);
	}

	@Operation(summary = "get characters by parentId")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "characters found successfully"),
			@ApiResponse(responseCode = "404", description = "characters not found") })
	@GetMapping("/getCharacters/{parentId}")
	public List<Character> getCharacterById(@PathVariable Long parentId) {
		return customerService.getByParentId(parentId);
	}

	@Operation(summary = "get characters by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "character found successfully"),
			@ApiResponse(responseCode = "404", description = "character not found") })
	@GetMapping("/getCharacterById/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {

		Optional<Character> character = customerService.getById(id);

		return character.isPresent() ? ResponseEntity.ok(character.get())
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " ID not found");
	}

	@Operation(summary = "get all characters")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "characters found successfully"),
			@ApiResponse(responseCode = "404", description = "Characters not found") })
	@GetMapping("/getGroupByCharacters")
	public List<Map<String, Object>> getAGroupByCharacters() {

		return customerService.getAllChar();

	}

	@Operation(summary = "To add all characters")
	@ApiResponse(responseCode = "200", description = "characters added successfully")
	@PostMapping("/addAll")
	public ResponseEntity<?> addAllUsers(@RequestBody List<Character> characters) {
		customerService.addAllUsers(characters);

		return ResponseEntity.status(HttpStatus.OK).body("All characters added successfully");

	}

	@LogMethodParam
	@GetMapping("/test")
	public String testMethod(String name, int id) {
		return "Method Called";
	}

}

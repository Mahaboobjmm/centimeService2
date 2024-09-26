package com.io.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.io.builder.ResponseBuilder;
import com.io.entity.Character;
import com.io.entity.Customer;
import com.io.repository.CharacterRepository;
import com.io.repository.GreetServiceClient;
import com.io.repository.NameServiceClient;

@Service
public class CustomerService {

	@Autowired
	CharacterRepository characterRepository;

	@Autowired
	private NameServiceClient nameService;

	@Autowired
	private GreetServiceClient greetService;

	@Autowired
	private ResponseBuilder responseBuilder;

	// task1
	public ResponseEntity<String> getCustomer(String traceID) {
		return greetService.getGreetings(traceID);
	}

	public ResponseEntity<String> createCustomerService(Customer customer) {
		return nameService.postName(customer);
	}

	// task2
	public Character createChar(Character character) {
		return characterRepository.save(character);
	}

	public List<Character> getByParentId(Long id) {
		return characterRepository.findByParentId(id);
	}
	
	public Optional<Character> getById(Integer id) {
		return characterRepository.findById(id);
	}

	public List<Map<String, Object>> getAllChar() {
		return responseBuilder.getNestedCharacters(characterRepository.findAll());

	}

	public void addAllUsers(List<Character> characters) {
		characterRepository.saveAll(characters);
	}

}

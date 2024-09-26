package com.servicethree.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

	@NotNull(message = "Name cannot be null")
	@Size(min = 1, message = "Name cannot be empty")
	private String name;

	@NotNull(message = "Surname cannot be null")
	@Size(min = 1, message = "Surname cannot be empty")
	private String surname;
	
	
	

}

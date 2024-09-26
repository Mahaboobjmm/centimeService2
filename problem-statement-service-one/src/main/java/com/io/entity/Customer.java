package com.io.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Customer entity")
public class Customer {


    @Schema(description = "First Name of the user", example = "John")
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name should not contain Numeric values")
    private String name;

    @Schema(description = "Last Name of the user", example = "Doe")
    @NotNull(message = "Surname cannot be null")
    @NotBlank(message = "Surname cannot be empty")
    @Pattern(regexp = "^[A-Za-z]+$", message = "surname should not contain Numeric values")
    private String surname;
}
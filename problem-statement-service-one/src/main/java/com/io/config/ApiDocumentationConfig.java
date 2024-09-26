package com.io.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ApiDocumentationConfig {

	@Bean
	public OpenAPI apiDocConfig() {
		return new OpenAPI()
				.info(new Info().title("Centime Tasks").description("example API for routing ").version("1.0.0")
						.contact(new Contact().name("Mahaboob").email("mahaboobjmm@gmail.com")))
				.externalDocs(new ExternalDocumentation().description("SourceCode").url("https://github.com/Mahaboobjmm/centimeService2.git"));
	}

}
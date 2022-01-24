package com.todo.todo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.todo.todo.converter.TodoItemConverter;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication

public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Bean
	public TodoItemConverter todoItemConverter() {
		return new TodoItemConverter();
	}

	@Bean // For open API
	public OpenAPI customOpenAPI(@Value("${application-description}") String description,
			@Value("${application-version}") String version) {
		return new OpenAPI().info(new Info().title("Todo APP").version(version).description(description)
				.license(new License().name("Todo APPLicence")));
	}

}

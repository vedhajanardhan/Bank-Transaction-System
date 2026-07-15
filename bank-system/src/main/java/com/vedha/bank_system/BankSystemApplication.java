package com.vedha.bank_system;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Bank Transaction System API",
				version = "1.0",
				description = "REST API for Bank Transaction System built using Spring Boot",
				contact = @Contact(
						name = "Vedha Janardhan",
						email = "vedhajanardhan@gmail.com"
				)
		)
)

@SpringBootApplication
public class BankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSystemApplication.class, args);
	}

}

package acc.accountservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
		info = @Info(
				title = "Account Service REST APIs",
				description = "Backend REST APIS for Account Microservice",
				version = "Version 1",
				contact = @Contact(
						name = "Accounts Service",
						email = "tradefinancebackend@gmail.com",
						url = "tradefinancebackend@gmail.com"
				),
				license = @License(
						name = "Account Microservice",
						url = "tradefinancebackend@gmail.com"

				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Micro services Documentation",
				url = "https://microservices.io/")

)
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

}

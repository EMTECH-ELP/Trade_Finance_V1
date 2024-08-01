package com.TradeFinance;



import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "BG-LC REST API Documentation",
				description = "bankDto Guarantee and Letter of Credit Microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Backend Team",
						email = "test@test.com",
						url = "https://www.emtechnologies.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.emtechnologies.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "bankDto Guarantee and Letter of Credit Microservice REST API Documentation",
				url = "https://localhost:8085/swagger-ui.html"
		)
)
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.TradeFinance"})
public class  TradeFinanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TradeFinanceApplication.class, args);
	}

}

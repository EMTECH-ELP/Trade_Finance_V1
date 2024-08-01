package com.trade.authservice.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
Open API Configuration
dev-url=http://{your-ip}:port/swagger-ui/index.html#/
 */
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        Contact myContact = new Contact();
        myContact.setName("Trade Finace-Security");
        myContact.setEmail("emtech@linuxmail.org");

        Info information = new Info()
                .title("Trade Finace-Security")
                .version("1.1")
                .description("This API exposes endpoints to Trade Finance-Security.")
                .contact(myContact);

        return new OpenAPI().info(information)
                ;
    }
}

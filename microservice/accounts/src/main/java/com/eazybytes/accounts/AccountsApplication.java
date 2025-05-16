package com.eazybytes.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef ="auditorAware" )
@OpenAPIDefinition(
    info = @Info(
        title = "Accounts Microservice Rest API Documentation",
        version = "1.0",
        description = "Accounts Microservice",
        
        contact = @Contact(
            name = "Vipin Tyagi",
            email = "vipinvats42@gmail.com",
            url = "https://github.com/vipinvats"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
    )
)
public class AccountsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }
}

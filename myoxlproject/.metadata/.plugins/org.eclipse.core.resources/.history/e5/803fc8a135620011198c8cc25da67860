package com.zensar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
		info = @Info(
				title = "UserManagement REST API Documentation",
				description = "UserManagement application",
				version = "1.0",
				license = @License(
						name = "LGPL",
						url = "http://lgpl.com"
				),
				contact = @Contact(
						name = "Anand",
						email = "anand.kulkarni1@zensar.com"
)))
@SecurityScheme(
	    name = "bearerAuth",
	    type = SecuritySchemeType.HTTP,
	    bearerFormat = "JWT",
	    scheme = "bearer"
)
public class ApiConfig {

}

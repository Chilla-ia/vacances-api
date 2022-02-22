package com.projet_conges.api_conges.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.projet_conges.api_conges")).paths(PathSelectors.any())
				.build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("API REST PROJET CONGE",
				"Voici un microservice permettant l'accès aux données concernant les congés des employés de Sogeti Bordeaux",
				"MVP", "TERMS OF SERVICE URL",
				new Contact("Romain Wilbert", "https://www.fr.sogeti.com/", "romain.wilbert@sogeti.com"), "LICENSE",
				"LICENSE URL", Collections.emptyList());
	}

}
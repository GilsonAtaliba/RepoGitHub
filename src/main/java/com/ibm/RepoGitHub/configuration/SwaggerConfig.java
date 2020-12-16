package com.ibm.RepoGitHub.configuration;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http:localhost:8082/swagger-ui.html
@Configuration
@EnableSwagger2
@Profile("swagger")
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.ibm.RepoGitHub"))
          .paths(PathSelectors.any())
          .build()
          .ignoredParameterTypes(User.class)
		  .globalOperationParameters(Arrays.asList(new	ParameterBuilder()
															.name("Authorization")
															.description("apiKey")
															.modelRef(new ModelRef("string"))
															.parameterType("header")
															.required(false)
															.build()))
          .apiInfo(informacoes());
    }
    
    
    private ApiInfo informacoes() {
		return new ApiInfoBuilder()
				.title("API REST Repo GitHub")
				.description("API REST para listar todos os repositórios de um determinado usuário do GitHub.")
				.version("1.0.0")
				.contact(new springfox.documentation.service.Contact("Gilson", "", "gilson@br.ibm.com"))
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.build();
 
	}
    
}
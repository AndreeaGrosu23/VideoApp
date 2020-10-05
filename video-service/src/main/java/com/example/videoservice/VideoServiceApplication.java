package com.example.videoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class VideoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/** @EnableSwagger2 enables SpringFox support for Swagger 2.
	 * DocumentationType.SWAGGER_2 tells the Docket bean that we are using version 2 of Swagger specification.
	 * select() creates a builder, which is used to define which controllers and which of their methods should be included in the generated documentation.
	 * apis() defines the classes (controller and model classes) to be included.
	 * Here we are including all of them, but you can limit them by a base package, class annotations and more.
	 * paths() allow you to define which controller's methods should be included based on their path mappings.
	 * We are now including all of them but you can limit it using regex and more.
	 */

//	@Bean
//	public Docket apiDocket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build();
//	}

	@Bean
	public Docket videoApp() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}

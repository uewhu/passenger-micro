package com.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableEurekaClient
//@EnableCircuitBreaker
@EnableFeignClients
public class PassengerMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerMicroApplication.class, args);
	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.passenger"))
				.paths(PathSelectors.any()).build();
	}

	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 * 
	 * @Bean
	 * 
	 * @LoadBalanced public RestTemplate restTemplate2() { return new
	 * RestTemplate(); }
	 */

}

package com.douzone.nest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan({"com.douzone.nest.controller, com.douzone.nest.service, com.douzone.nest.repository"})
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BootApplication.class); 
	}
}

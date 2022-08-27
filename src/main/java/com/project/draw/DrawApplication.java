package com.project.draw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class DrawApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrawApplication.class, args);
	}

}
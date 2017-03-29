package com.ge.pmms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Class for managing Spring Application context.<br>
 *
 * @author Sohail Shaikh
 */
@SpringBootApplication
public class AppConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application;
    }	
	
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}	
}

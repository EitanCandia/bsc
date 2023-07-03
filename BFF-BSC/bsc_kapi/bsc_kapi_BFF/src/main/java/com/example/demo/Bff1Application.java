package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:micro.properties")
@EnableFeignClients
public class Bff1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bff1Application.class, args);
	}

}

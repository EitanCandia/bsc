package com.bff.bsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:micro.properties")
@EnableFeignClients
public class BscApplication {

	public static void main(String[] args) {
		SpringApplication.run(BscApplication.class, args);
	}

}

package com.guusto.buygift.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.guusto.buygift"})
@EntityScan("com.guusto.buygift")
public class BuyGiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyGiftApplication.class, args);
	}

}
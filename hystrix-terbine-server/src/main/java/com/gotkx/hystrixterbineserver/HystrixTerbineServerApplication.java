package com.gotkx.hystrixterbineserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class HystrixTerbineServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixTerbineServerApplication.class, args);
	}

}

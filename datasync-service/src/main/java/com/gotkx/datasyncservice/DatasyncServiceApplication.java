package com.gotkx.datasyncservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DatasyncServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasyncServiceApplication.class, args);
	}

}

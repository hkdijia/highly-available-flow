package com.gotkx.userserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
/*@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker*/

@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker

public class UserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}

}

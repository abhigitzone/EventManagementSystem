package com.stackroute.userauthenticationmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserAuthenticationManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserAuthenticationManagementApplication.class, args);
	}

}

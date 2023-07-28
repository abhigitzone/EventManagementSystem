package com.stackroute.organizerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class OrganizerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizerServiceApplication.class, args);
    }

}

package com.microservicesuniversity.addressservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.microservicesuniversity.addressservice.controller", "com.microservicesuniversity.addressservice.service"})
@EntityScan("com.microservicesuniversity.addressservice.entity")
@EnableJpaRepositories("com.microservicesuniversity.addressservice.repository")
@EnableEurekaClient
public class AddressServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceApplication.class, args);
    }

}

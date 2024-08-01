package com.Registation.EurekaDiscoverserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaDiscoverServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoverServerApplication.class, args);
	}

}

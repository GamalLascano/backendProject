package com.gamal.msconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConsumerApplication.class, args);
	}

}

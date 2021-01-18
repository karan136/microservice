package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootHelloWorldApplicationProducer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplicationProducer.class, args);
	}
}

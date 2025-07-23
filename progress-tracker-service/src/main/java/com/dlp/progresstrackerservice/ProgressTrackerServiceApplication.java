package com.dlp.progresstrackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProgressTrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgressTrackerServiceApplication.class, args);
	}

}

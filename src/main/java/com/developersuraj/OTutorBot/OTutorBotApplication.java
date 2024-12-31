package com.developersuraj.OTutorBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OTutorBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(OTutorBotApplication.class, args);
	}

}

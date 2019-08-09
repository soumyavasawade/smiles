package com.test.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.test.sample.repository")
public class MongoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}
	
	public void run() {
	}
}

package com.tweetapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tweetapp.service.AuthenticationService;

@SpringBootApplication
public class TweetappApplication implements CommandLineRunner {

	@Autowired
	AuthenticationService authenticationService;
	
	public static void main(String[] args) {
		SpringApplication.run(TweetappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(true){
			authenticationService.validateSession();
		}
		
	}
	
}

package com.tweetapp.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TweetConfiguration {

	@Bean
	public Scanner getScanner(){
		return new Scanner(System.in);
	}
	
}

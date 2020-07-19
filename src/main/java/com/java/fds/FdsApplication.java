package com.java.fds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FdsApplication.class, args);
		
		System.out.println( "Food delivery system has started!" );
	}

}

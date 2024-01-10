package com.ternopil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GuidApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuidApplication.class, args);
	}
}
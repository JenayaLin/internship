package com.tips.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tips.*")
public class TipsApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TipsApplication.class, args);

	}

}

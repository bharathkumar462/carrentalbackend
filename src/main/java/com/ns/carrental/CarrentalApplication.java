package com.ns.carrental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrentalApplication {
	private static final Logger logger= LoggerFactory.getLogger(CarrentalApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CarrentalApplication.class, args);

		}
	}



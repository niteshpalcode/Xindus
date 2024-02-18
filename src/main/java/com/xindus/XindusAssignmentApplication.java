 package com.xindus;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XindusAssignmentApplication {

	 private static final org.slf4j.Logger logger = LoggerFactory.getLogger(XindusAssignmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(XindusAssignmentApplication.class, args);
		logger.info("App is running...");
	}

}

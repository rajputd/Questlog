package com.ctrlaltdileep.questlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestlogApplication {
	private static final Logger log = LoggerFactory.getLogger(QuestlogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(QuestlogApplication.class, args);
	}
}

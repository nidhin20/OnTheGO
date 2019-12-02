package com.project.onthego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@SpringBootApplication
//@RestController
//@EnableJpaRepositories(basePackages="com.project.onthego.repository")
public class OnthegoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnthegoApplication.class, args);
	}
	 
}

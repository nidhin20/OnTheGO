package com.project.onthego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@ServletComponentScan
@SpringBootApplication
public class OnthegoApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnthegoApplication.class, args);
	}
	 
}

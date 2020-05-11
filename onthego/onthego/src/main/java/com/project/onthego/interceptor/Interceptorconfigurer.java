package com.project.onthego.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class Interceptorconfigurer implements WebMvcConfigurer {

	@Autowired
	private Virusinterceptor virusinterceptor;

	@Bean
	public Virusinterceptor pageVirusinterceptor() {
		return virusinterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(pageVirusinterceptor());
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}

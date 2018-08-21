package com.jda.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.jda")
@EnableWebMvc
public class SpringConfig {
	@Bean
	public ViewResolver getviewResolver() {
		InternalResourceViewResolver obj = new InternalResourceViewResolver();
		obj.setPrefix("/WEB-INF/template/");
		obj.setSuffix(".jsp");
		return obj;
	}
}

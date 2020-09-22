package com.alexyamaoka.lc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alexyamaoka.lc.formatter.CreditCardFormatter;
import com.alexyamaoka.lc.formatter.CurrencyFormatter;
import com.alexyamaoka.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.alexyamaoka.lc.controllers")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {
	
	// set up view resolver
	@Bean
	public InternalResourceViewResolver ViewResolver() {
		InternalResourceViewResolver ViewResolver = new InternalResourceViewResolver();
		ViewResolver.setPrefix("/WEB-INF/view/");
		ViewResolver.setSuffix(".jsp");
		
		return ViewResolver;
	}
	
	
	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");	// messages.properties file
		
		return messageSource;
	}
	
	
	
	// let spring know to use formatter for phone number
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("inside add formatters method");
		registry.addFormatter(new PhoneNumberFormatter());
		registry.addFormatter(new CreditCardFormatter());
		registry.addFormatter(new CurrencyFormatter());
	}
}

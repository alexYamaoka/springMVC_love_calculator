package com.alexyamaoka.lc.config;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alexyamaoka.lc.converters.CreditCardConverter;
import com.alexyamaoka.lc.converters.CreditCardConverterObjectToString;
import com.alexyamaoka.lc.formatter.CreditCardFormatter;
import com.alexyamaoka.lc.formatter.CurrencyFormatter;
import com.alexyamaoka.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.alexyamaoka.lc"})
public class LoveCalculatorAppConfig implements WebMvcConfigurer {
	
	// set up view resolver
	@Bean
	public InternalResourceViewResolver ViewResolver() {
		InternalResourceViewResolver ViewResolver = new InternalResourceViewResolver();
		ViewResolver.setPrefix("/WEB-INF/view/");
		ViewResolver.setSuffix(".jsp");
		
		return ViewResolver;
	}
	
	
	// for validation message - messages.properties file 
	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");	
		
		return messageSource;
	}
	
	
	// validator bean - tell spring we are using message source method 
	@Bean("validator")
	public LocalValidatorFactoryBean validator() {
		
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		
		return localValidatorFactoryBean;
	}
	
	

	// let spring know to use formatter for phone number, etc...
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("inside add formatters method");
		registry.addFormatter(new PhoneNumberFormatter());
		
		registry.addFormatter(new CurrencyFormatter());
		
		registry.addConverter(new CreditCardConverter());
		registry.addConverter(new CreditCardConverterObjectToString());
		//registry.addFormatter(new CreditCardFormatter());
	}

	
	// tell spring to use our custom validator
	@Override
	public Validator getValidator() {
		
		return validator();
	}
	
	
	
	
	
	// configure java mail sender
	// need to turn on less secure app feature inside gmail 
	// sign into the gmail and google "less secure app" and enable it
	@Bean 
	public JavaMailSender getJavaMailSender() {
		
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setUsername("sampleEmail@gmail.com");
		javaMailSenderImpl.setPassword("samplePassword");
		javaMailSenderImpl.setPort(587);		// port number has to be 587
		
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		javaMailSenderImpl.setJavaMailProperties(mailProperties);
		
		
		return javaMailSenderImpl;
	}
	
	
	
	
	
	
	
	
}

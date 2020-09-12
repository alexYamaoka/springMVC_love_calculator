package com.alexyamaoka.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		//webApplicationContext.setConfigLocation("classpath:application-config.xml");
		
		// register configuration class 
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorAppConfig.class);
		
		// create a dispatcher servlet object 
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		
		// registered dispatcher servlet with servlet context
		ServletRegistration.Dynamic myCustomDispatcherServletDynamic = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		
		
		myCustomDispatcherServletDynamic.setLoadOnStartup(1); // boolean true
		myCustomDispatcherServletDynamic.addMapping("/mywebsite.com/*");
		
	}

}

package com.alexyamaoka.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LCAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	// default name for spring dispatcher servlet:  "dispatcher"
	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		// register spring config class
		Class[] classArray = {LoveCalculatorAppConfig.class};

		return classArray;
	}

	@Override
	protected String[] getServletMappings() {
		
		// configuring mapping for dispatcher servlet
		String[] mapping = {"/"};
		
		return mapping;
	}

}

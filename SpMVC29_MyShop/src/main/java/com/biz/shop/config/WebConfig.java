package com.biz.shop.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.biz.shop.config.security.JasyptConfig;
import com.biz.shop.config.security.SecurityConfig;
/**
 * web.xml을 대신할 클래스
 * @author Master
 *
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { 
				RootConfig.class,
				SecurityConfig.class,
				JasyptConfig.class,
				DBSetupConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { ServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

}









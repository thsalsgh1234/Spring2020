package com.biz.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * serlvet.xml을 대신할 클래스
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { 
			"com.biz.shop.controller", 
			"com.biz.shop.service" 
		})
public class ServletConfig implements WebMvcConfigurer {
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
		
		registry.addResourceHandler("/files/**")
		.addResourceLocations("/files/");
		
		registry.addResourceHandler("/images/**")
		.addResourceLocations("/images/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	/*
	 * fileUpload를 하기 위한 설정
	 */
	@Bean
	public MultipartResolver multiResolver() {
		MultipartResolver mr = new CommonsMultipartResolver();
		((CommonsMultipartResolver)mr).setMaxUploadSize(10000000);
		((CommonsMultipartResolver)mr).setMaxUploadSizePerFile(1000000);
		return mr;
	}
	
	/*
	 * jsp Rendering을 위한 설정
	 */
	@Bean
	public InternalResourceViewResolver resolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}

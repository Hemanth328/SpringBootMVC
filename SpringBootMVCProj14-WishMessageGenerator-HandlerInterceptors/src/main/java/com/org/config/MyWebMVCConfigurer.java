package com.org.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.org.interceptor.TimeCheckInterceptor;


@Component
public class MyWebMVCConfigurer implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("MyWebMVCConfigurer.addInterceptors()");
	   registry.addInterceptor(new TimeCheckInterceptor());
	}

}

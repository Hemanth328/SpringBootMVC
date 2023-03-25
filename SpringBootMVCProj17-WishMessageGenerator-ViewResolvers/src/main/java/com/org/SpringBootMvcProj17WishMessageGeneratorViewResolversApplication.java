package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@SpringBootApplication
public class SpringBootMvcProj17WishMessageGeneratorViewResolversApplication {
	
	/*@Bean
	public ViewResolver createIRVR() {
		System.out.println("SpringBootMvcProj17WishMessageGeneratorViewResolversApplication.createIRVR()");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
		
	}*/
	
	
	/*@Bean
	public ViewResolver UBVResolver() {
		System.out.println("SpringBootMvcProj17WishMessageGeneratorViewResolversApplication.UBVResolver()");
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(InternalResourceView.class);
		
		return resolver;
	}*/
	
	/*@Bean
	public ViewResolver RBVResolver() {
		
		System.out.println("SpringBootMvcProj17WishMessageGeneratorViewResolversApplication.RBVResolver()");
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("com/org/commons/views");
		
		return resolver;
	}
	*/
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcProj17WishMessageGeneratorViewResolversApplication.class, args);
	}

}

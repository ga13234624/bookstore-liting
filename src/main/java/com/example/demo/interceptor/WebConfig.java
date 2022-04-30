package com.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/getcart")
		.addPathPatterns("/addtocart")
		.addPathPatterns("/member/myaccount/**");
		registry.addInterceptor(new ReLoginInterceptor())
		.addPathPatterns("/member/join")
		.addPathPatterns("/member/login")
		.addPathPatterns("/forgot");
		registry.addInterceptor(new CartInterceptor())
		.addPathPatterns("/order/addorderinfo")
		.addPathPatterns("/order/confirm");
	}
}

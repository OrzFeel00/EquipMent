package com.yc.tc.equipment.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.tc.equipment.util.LoginInterceptor;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

	@Resource
	private LoginInterceptor loginInterceptor;
	
	// 这个方法是用来配置静态资源的，比如html，js，css，等等
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	// 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截所有请求，排除1个请求/toadlogin，不需要拦截登录请求
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(
				"/toadlogin",
				"/adlogin.do",
				"/dist/**",
				"/admin/**"
			
				);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addViewControllers(registry);
	}
	
	
	

}

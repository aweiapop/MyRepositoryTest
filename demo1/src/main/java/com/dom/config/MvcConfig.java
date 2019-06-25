package com.dom.config;

import com.dom.converter.MyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;

/**
 * Created by little Stone
 * Date 2019/6/24 Time 17:11
 */
@ComponentScan(basePackages = "com.dom.controller")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    ConfigurableConversionService configurableConversionService;
    @Bean
    @Primary
    public ConfigurableConversionService configurableConversionService() {
        return configurableConversionService;
    }

    @PostConstruct
    public void addConverterToService() {
        configurableConversionService.addConverter(new MyConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/jsp/**").addResourceLocations("/WEB-INF/jsp/");
    }

    /*传文件*/
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxInMemorySize(50000);
        return commonsMultipartResolver;
    }

    /*视图解析器*/
    @Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
	}
}

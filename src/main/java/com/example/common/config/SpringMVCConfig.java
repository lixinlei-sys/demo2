package com.example.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*@Configuration
@ComponentScan(basePackages = "com.example.core.controller")
@EnableWebMvc*/
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }*/
}

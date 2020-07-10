package com.xy.kfmb.common.lanjie;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CustomInterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor()).order(1).addPathPatterns("/**");
        registry.addInterceptor(new CustomInterceptor2()).order(2).addPathPatterns("/**");
    }
}
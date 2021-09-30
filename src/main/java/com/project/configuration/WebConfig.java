package com.project.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ImportResource({"classpath:/config/web.xml"})
public class WebConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD","OPTIONS","GET","POST","PUT","PATCH","DELETE")
                .maxAge(MAX_AGE_SECS);
    }

}

package com.project.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@ImportResource({"classpath:/config/datasource.xml"})
public class CoreConfig {
}

package com.sanket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages = "com.sanket.sbeans")
public class AppConfig {

    @Bean(name = "ldt")
    public LocalDateTime creteLdt()
    {
        return LocalDateTime.now();
    }
}

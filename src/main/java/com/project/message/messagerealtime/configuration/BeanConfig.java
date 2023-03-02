package com.project.message.messagerealtime.configuration;

import com.project.message.messagerealtime.security.JwtAuthenticationEntryPoint;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper configMapper() {
        return new ModelMapper();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }
}

package com.example.leaveapplicationprocessingsystem.config;

import com.example.leaveapplicationprocessingsystem.validator.LeaveApplicationValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.util.Set;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Bean
    public LeaveApplicationValidator leaveApplicationValidator() {
        Set<LocalDate> publicHolidays = Set.of(
                // List of public holidays
        );
        return new LeaveApplicationValidator(publicHolidays);
    }
}
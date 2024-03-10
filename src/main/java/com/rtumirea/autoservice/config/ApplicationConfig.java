package com.rtumirea.autoservice.config;

import com.rtumirea.autoservice.mapper.CycleAvoidingMappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public CycleAvoidingMappingContext cycleAvoidingMappingContext(){
        return new CycleAvoidingMappingContext();
    }
}

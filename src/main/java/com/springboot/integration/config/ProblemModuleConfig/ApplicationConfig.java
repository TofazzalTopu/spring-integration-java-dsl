package com.springboot.integration.config.ProblemModuleConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProblemModule problemModule() {
        return new ProblemModule().withStackTraces(false);
    }
}

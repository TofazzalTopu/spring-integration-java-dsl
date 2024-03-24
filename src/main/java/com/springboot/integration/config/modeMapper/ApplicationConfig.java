package com.springboot.integration.config.modeMapper;

//import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;

@Configuration
public class ApplicationConfig {
//	@Bean
//	public ModelMapper modelMapper() {
//	      ModelMapper modelMapper = new ModelMapper();
//	      modelMapper.getConfiguration().setAmbiguityIgnored(true);
//	      return modelMapper;
//	   }


    @Bean
    public ProblemModule problemModule() {
        return new ProblemModule().withStackTraces(false);
    }
}

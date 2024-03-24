package com.springboot.integration.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandler implements ProblemHandling {
//    @Bean
//    public ObjectMapper objObjectMapper() {
//        return new ObjectMapper().registerModules(
//                new ProblemModule(),
//                new ConstraintViolationProblemModule());
//    }
}


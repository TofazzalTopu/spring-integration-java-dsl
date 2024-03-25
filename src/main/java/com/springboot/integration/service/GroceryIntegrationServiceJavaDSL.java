package com.springboot.integration.service;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.dto.GroceryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Configuration
@EnableIntegration
@IntegrationComponentScan
public class GroceryIntegrationServiceJavaDSL {

    @Autowired
    private GroceryService groceryService;

    @Bean
    public MessageChannel receiveTextChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel returnResponseChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel findAllGroceryChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel findByGroceryIdChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel crateGroceryChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel updateGroceryChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel deleteGroceryChannel() {
        return new DirectChannel();
    }


    @Bean
    public IntegrationFlow findByGroceryId() {
        return IntegrationFlows.from(findByGroceryIdChannel())
                .transform((String id) -> groceryService.findById(id))
                .channel(findByGroceryIdChannel())
                .log(AppConstants.RECORD_FETCHED_SUCCESSFULLY)
                .get();
    }

    @Bean
    public IntegrationFlow createGrocery() {
        return IntegrationFlows.from(crateGroceryChannel())
                .transform((GroceryDTO grocery) -> groceryService.create(new GroceryDTO()))
                .channel(crateGroceryChannel())
                .log(AppConstants.RECORD_CREATED_SUCCESSFULLY)
                .get();
    }

    @Bean
    public IntegrationFlow updateGrocery() {
        return IntegrationFlows.from(updateGroceryChannel())
                .transform((GroceryDTO grocery) -> groceryService.update(new GroceryDTO()))
                .channel(updateGroceryChannel())
                .log(AppConstants.RECORD_UPDATED_SUCCESSFULLY)
                .get();
    }

    @Bean
    public IntegrationFlow deleteGrocery() {
        return IntegrationFlows.from(deleteGroceryChannel())
                .transform((String id) -> groceryService.delete(id))
                .channel(deleteGroceryChannel())
                .log(AppConstants.RECORD_DELETED_SUCCESSFULLY)
                .get();
    }


}

package com.springboot.integration.service;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.model.Shop;
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
public class ShopIntegrationServiceJavaDSL {

    @Autowired
    private ShopService shopService;

    @Bean
    public MessageChannel findAllShopChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel findByShopIdChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel crateShopChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel updateShopChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel deleteShopChannel() {
        return new DirectChannel();
    }


    @Bean
    public IntegrationFlow findByShopId() {
        return IntegrationFlows.from(findByShopIdChannel())
                .transform((String id) -> shopService.findById(id))
                .channel(findByShopIdChannel())
                .log(AppConstants.RECORD_FETCHED_SUCCESSFULLY)
                .get();
    }

    @Bean
    public IntegrationFlow createShop() {
        return IntegrationFlows.from(crateShopChannel())
                .transform((Shop shop) -> shopService.create(shop))
                .channel(crateShopChannel())
                .log(AppConstants.RECORD_CREATED_SUCCESSFULLY)
                .get();
    }

    @Bean
    public IntegrationFlow updateShop() {
        return IntegrationFlows.from(updateShopChannel())
                .transform((Shop shop) -> shopService.update(shop))
                .channel(updateShopChannel())
                .log(AppConstants.RECORD_UPDATED_SUCCESSFULLY)
                .get();
    }

    @Bean
    public IntegrationFlow deleteShop() {
        return IntegrationFlows.from(deleteShopChannel())
                .transform((String id) -> shopService.delete(id))
                .channel(deleteShopChannel())
                .log(AppConstants.RECORD_DELETED_SUCCESSFULLY)
                .get();
    }


}

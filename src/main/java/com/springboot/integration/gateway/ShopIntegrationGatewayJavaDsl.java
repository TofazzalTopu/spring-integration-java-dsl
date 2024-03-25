package com.springboot.integration.gateway;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.model.Grocery;
import com.springboot.integration.model.Shop;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface ShopIntegrationGatewayJavaDsl {

    @Gateway(requestChannel = AppConstants.FIND_BY_SHOP_ID_CHANNEL, replyChannel = AppConstants.FIND_BY_SHOP_ID_CHANNEL)
    public Shop findById(String id);

    @Gateway(requestChannel = AppConstants.CRATE_SHOP_CHANNEL, replyChannel = AppConstants.CRATE_SHOP_CHANNEL)
    public Shop create(Shop grocery);
    @Gateway(requestChannel = AppConstants.UPDATE_SHOP_CHANNEL, replyChannel = AppConstants.UPDATE_SHOP_CHANNEL)
    public Shop update(Shop grocery);

    @Gateway(requestChannel = AppConstants.DELETE_SHOP_CHANNEL, replyChannel = AppConstants.DELETE_SHOP_CHANNEL)
    public String delete(String id);


}

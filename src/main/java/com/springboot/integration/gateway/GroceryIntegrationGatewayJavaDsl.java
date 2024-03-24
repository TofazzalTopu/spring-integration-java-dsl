package com.springboot.integration.gateway;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.model.Grocery;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface GroceryIntegrationGatewayJavaDsl {

    @Gateway(requestChannel = AppConstants.FIND_BY_GROCERY_ID_CHANNEL, replyChannel = AppConstants.FIND_BY_GROCERY_ID_CHANNEL)
    public Grocery findById(String id);

    @Gateway(requestChannel = AppConstants.CRATE_GROCERY_CHANNEL, replyChannel = AppConstants.CRATE_GROCERY_CHANNEL)
    public Grocery create(Grocery grocery);
    @Gateway(requestChannel = AppConstants.UPDATE_GROCERY_CHANNEL, replyChannel = AppConstants.UPDATE_GROCERY_CHANNEL)
    public Grocery update(Grocery grocery);

    @Gateway(requestChannel = AppConstants.DELETE_GROCERY_CHANNEL, replyChannel = AppConstants.DELETE_GROCERY_CHANNEL)
    public String delete(String id);


}

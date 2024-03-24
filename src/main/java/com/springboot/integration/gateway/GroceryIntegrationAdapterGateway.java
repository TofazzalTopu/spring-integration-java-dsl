package com.springboot.integration.gateway;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.model.Grocery;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.List;

@MessagingGateway
public interface GroceryIntegrationAdapterGateway {

    @Gateway(requestChannel = AppConstants.INTEGRATION_FIND_ALL_GROCERY_GATEWAY_CHANNEL)
    public List<Grocery> findAll();

    @Gateway(requestChannel = AppConstants.INTEGRATION_FIND_BY_ID_GROCERY_GATEWAY_CHANNEL)
    public Grocery findById(String id);

    @Gateway(requestChannel = AppConstants.INTEGRATION_CREATE_GROCERY_GATEWAY_CHANNEL)
    public Grocery create(Grocery grocery);

    @Gateway(requestChannel = AppConstants.INTEGRATION_UPDATE_GROCERY_GATEWAY_CHANNEL)
    public Grocery update(Grocery grocery);

    @Gateway(requestChannel = AppConstants.INTEGRATION_DELETE_GROCERY_GATEWAY_CHANNEL)
    public void delete(String id);

}

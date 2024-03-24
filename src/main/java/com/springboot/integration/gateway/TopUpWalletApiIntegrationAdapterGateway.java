package com.springboot.integration.gateway;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.request.PostApiRequest;
import com.springboot.integration.response.ApiResponse;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface TopUpWalletApiIntegrationAdapterGateway {

    @Gateway(requestChannel = AppConstants.TEXT_MESSAGE_CHANNEL, replyChannel = AppConstants.TEXT_MESSAGE_CHANNEL)
    public String sendMessage(String message);

    @Gateway(requestChannel = AppConstants.HTTP_OUT_BOUND_REQUEST_CHANNEL, replyChannel = AppConstants.HTTP_OUT_BOUND_REQUEST_CHANNEL)
    public PostApiRequest httpOutRequest(PostApiRequest postApiRequest);


}

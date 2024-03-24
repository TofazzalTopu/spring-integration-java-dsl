package com.springboot.integration.service;

import com.springboot.integration.request.PostApiRequest;
import com.springboot.integration.response.ApiResponse;

public interface TopUpWalletApiIntegrationService {
    ApiResponse consumeTopUpWalletApi(PostApiRequest postApiRequest);

}

package com.springboot.integration.service.impl;

import com.springboot.integration.request.PostApiRequest;
import com.springboot.integration.response.ApiResponse;
import com.springboot.integration.service.TopUpWalletApiIntegrationService;
import com.springboot.integration.util.Utility;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TopUpWalletApiIntegrationServiceImpl implements TopUpWalletApiIntegrationService {
    private static String POST_URL = "https://open.revenuemonster.my/v3/wallet/topup";

    @Override
    public ApiResponse consumeTopUpWalletApi(PostApiRequest postApiRequest) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<PostApiRequest> getEntity = new HttpEntity<>(postApiRequest, Utility.requestHeaders());

        ResponseEntity<ApiResponse> responseEntity = restTemplate
                .exchange(POST_URL, HttpMethod.POST, getEntity, ApiResponse.class);
        System.out.println("Success " + responseEntity.getStatusCode());
        ApiResponse getApiResponse = responseEntity.getBody();
        System.out.println("Success " + getApiResponse);
        return getApiResponse;
    }
}

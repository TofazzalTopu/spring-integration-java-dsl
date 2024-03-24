package com.springboot.integration.controller;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.gateway.TopUpWalletApiIntegrationAdapterGateway;
import com.springboot.integration.gateway.GroceryIntegrationGatewayJavaDsl;
import com.springboot.integration.request.PostApiRequest;
import com.springboot.integration.response.ApiResponse;
import com.springboot.integration.response.Response;
import com.springboot.integration.service.TopUpWalletApiIntegrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TopUpWalletAPIConsumerController {

    private GroceryIntegrationGatewayJavaDsl groceryIntegrationGatewayJavaDSL;
    private TopUpWalletApiIntegrationAdapterGateway apiIntegrationAdapterGateway;

    private TopUpWalletApiIntegrationService topUpWalletApiIntegrationService;

    public TopUpWalletAPIConsumerController(GroceryIntegrationGatewayJavaDsl groceryIntegrationGatewayJavaDSL, TopUpWalletApiIntegrationAdapterGateway topUpWalletApiIntegrationAdapterGateway, TopUpWalletApiIntegrationService topUpWalletApiIntegrationService) {
        this.groceryIntegrationGatewayJavaDSL = groceryIntegrationGatewayJavaDSL;
        this.apiIntegrationAdapterGateway = topUpWalletApiIntegrationAdapterGateway;
        this.topUpWalletApiIntegrationService = topUpWalletApiIntegrationService;
    }

    @GetMapping
    public String message() {
        return apiIntegrationAdapterGateway.sendMessage("My name is Hesam");
    }

    @PostMapping
    public ResponseEntity<Response<PostApiRequest>> httpOutRequest(@RequestBody PostApiRequest postApiRequest) {
        return ResponseEntity.ok().body(new Response<>(HttpStatus.OK.value(), AppConstants.RECORD_FETCHED_SUCCESSFULLY,
                apiIntegrationAdapterGateway.httpOutRequest(postApiRequest)));

    }

    @PostMapping(value = "/rest",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<ApiResponse>> consumeTopUpWalletApi(@RequestBody PostApiRequest postApiRequest) {
        return ResponseEntity.ok().body(new Response<>(HttpStatus.OK.value(), AppConstants.RECORD_FETCHED_SUCCESSFULLY,
                topUpWalletApiIntegrationService.consumeTopUpWalletApi(postApiRequest)));

    }

}

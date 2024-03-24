package com.springboot.integration.service;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.exceptions.InvalidCreditCardException;
import com.springboot.integration.request.PostApiRequest;
import com.springboot.integration.response.ApiResponse;
import com.springboot.integration.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Slf4j
@Component
@Configuration
@EnableIntegration
@IntegrationComponentScan
public class TopUpWalletApiIntegrationServiceJavaDsl {
    private static final String POST_URL = "https://open.revenuemonster.my/v3/wallet/topup";

    @Bean
    public MessageChannel httpOutBoundRequestChannel() {
        return new DirectChannel();
    }
    @Bean
    public MessageChannel textMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow sendMessage() {
        return IntegrationFlows.from(textMessageChannel())
                .transform((String s)-> s.toUpperCase(Locale.ROOT))
                .channel(textMessageChannel())
                .get();
    }

    @Bean
    public IntegrationFlow consumeExternalApi() {
        return IntegrationFlows.from(httpOutBoundRequestChannel())
                .enrichHeaders(Utility.requestHeadersInMap())
                .handle(Http.outboundGateway(POST_URL)
                        .httpMethod(HttpMethod.POST)
                        .extractPayload(true)
                        .expectedResponseType(PostApiRequest.class)
                )
                .log(message -> "\n======: " + message.getPayload())
                .channel(httpOutBoundRequestChannel())
                .get();
    }

}

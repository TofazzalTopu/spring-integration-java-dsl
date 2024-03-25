package com.springboot.integration.service;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.exceptions.NotFoundException;
import com.springboot.integration.model.Grocery;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class GroceryIntegrationService {
    final Logger logger = LoggerFactory.getLogger(GroceryIntegrationService.class);

    @ServiceActivator(inputChannel = AppConstants.INTEGRATION_FIND_ALL_GROCERY_GATEWAY_CHANNEL)
    public void findAll(Message<?> message) {
        MessageChannel messageChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        messageChannel.send(message);
    }

    @ServiceActivator(inputChannel = AppConstants.INTEGRATION_FIND_BY_ID_GROCERY_GATEWAY_CHANNEL)
    public void findById(Message<String> message) throws MessagingException {
        String id = message.getPayload();
        if (Objects.isNull(id)) throw new NotFoundException(AppConstants.RECORD_NOT_FOUND_BY_ID);
        MessageChannel messageChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        logger.info("Grocery deleted by id {}", id);
        messageChannel.send(message);
    }

    @ServiceActivator(inputChannel = AppConstants.INTEGRATION_CREATE_GROCERY_GATEWAY_CHANNEL)
    public void create(Message<Grocery> message) {
        logger.info("Creating grocery..", message);
        MessageChannel messageChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        Grocery grocery = message.getPayload();
        message.getPayload().setCurrency("USD");
        messageChannel.send(message);
    }

    @ServiceActivator(inputChannel = AppConstants.INTEGRATION_UPDATE_GROCERY_GATEWAY_CHANNEL)
    public void update(Message<Grocery> message) {
        logger.info("Updating grocery..", message);
        MessageChannel messageChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        Grocery grocery = message.getPayload();
        message.getPayload().setCurrency("USD");
        messageChannel.send(message);
    }

    @ServiceActivator(inputChannel = AppConstants.INTEGRATION_DELETE_GROCERY_GATEWAY_CHANNEL)
    public void delete(Message<String> message) {
        MessageChannel messageChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        logger.info("Grocery deleted by id {}", message.getPayload());
        messageChannel.send(message);
    }

}

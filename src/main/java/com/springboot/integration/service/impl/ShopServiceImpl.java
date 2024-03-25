package com.springboot.integration.service.impl;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.exceptions.NotFoundException;
import com.springboot.integration.model.Shop;
import com.springboot.integration.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {

    Shop shop = new Shop(UUID.randomUUID().toString(), "Jaya Grocer", "3KM", "12m", "Mart");
    List<Shop> shopList = new ArrayList<>(Arrays.asList(shop));

    @Override
    public List<Shop> findAll() {
        return shopList;
    }

    @Override
    public Shop findById(String id) {
        if (id == null) throw new NotFoundException(AppConstants.RECORD_ID_CAN_NOT_BE_NULL);
        if (Objects.isNull(shop.getId())) throw new NotFoundException(AppConstants.RECORD_NOT_FOUND_BY_ID);
        return shop;
    }

    @Override
    public Shop create(Shop grocery) {
        return grocery;
    }

    @Override
    public Shop update(Shop shop) {
        Shop existingShop = Optional.of(findById(shop.getId())).orElseThrow(() -> new NotFoundException(AppConstants.RECORD_NOT_FOUND_BY_ID));
        return existingShop;
    }

    @Override
    public boolean delete(String id) {
        return true;
    }
}

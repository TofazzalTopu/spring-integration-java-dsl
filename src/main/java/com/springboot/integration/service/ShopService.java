package com.springboot.integration.service;

import com.springboot.integration.model.Shop;

import java.util.List;

public interface ShopService {

    public List<Shop> findAll();

    public Shop findById(String id);
    public Shop create(Shop shop);
    public Shop update(Shop shop);
    public boolean delete(String id);

}

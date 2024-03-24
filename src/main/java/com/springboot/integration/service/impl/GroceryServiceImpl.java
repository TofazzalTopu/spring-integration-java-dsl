package com.springboot.integration.service.impl;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.exceptions.NotFoundException;
import com.springboot.integration.model.Grocery;
import com.springboot.integration.model.Shop;
import com.springboot.integration.service.GroceryService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroceryServiceImpl implements GroceryService {

    @Override
    public List<Grocery> findAll() {
        List<Grocery> groceryList = new ArrayList<>();
        Shop shop = Shop.builder().shopName("Mart").shopType(UUID.randomUUID().toString()).distance("3km").time("12m").build();
        Grocery grocery = Grocery.builder().id(UUID.randomUUID().toString()).name("Milk").description("1KG").ratings(4.3f).currency("USD")
                .isPromoAvailable(true).isDiscountAvailable(true).shopId(shop.getId()).build();
        groceryList.add(grocery);
        return groceryList;
    }

    @Override
    public Grocery findById(String id) {
        Grocery grocery = new Grocery();
        if (id == null) throw new NotFoundException(AppConstants.GROCERY_ID_CAN_NOT_BE_NULL);
        if (Objects.isNull(grocery.getId())) throw new NotFoundException(AppConstants.GROCERY_NOT_FOUND_BY_ID);
        return grocery;
    }

    @Override
    public Grocery create(Grocery grocery) {
        return grocery;
    }

    @Override
    public Grocery update(Grocery grocery) {
        Grocery existingGrocery = Optional.of(findById(grocery.getId())).orElseThrow(() -> new NotFoundException(AppConstants.GROCERY_NOT_FOUND_BY_ID));
        existingGrocery.setCurrency(grocery.getCurrency());
        return existingGrocery;
    }

    @Override
    public boolean delete(String id) {
        return true;
    }
}

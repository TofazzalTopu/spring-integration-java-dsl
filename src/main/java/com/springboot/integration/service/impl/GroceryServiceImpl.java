package com.springboot.integration.service.impl;

import com.springboot.integration.constant.AppConstants;
import com.springboot.integration.exceptions.NotFoundException;
import com.springboot.integration.model.Grocery;
import com.springboot.integration.dto.GroceryDTO;
import com.springboot.integration.model.Shop;
import com.springboot.integration.service.GroceryService;
import com.springboot.integration.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroceryServiceImpl implements GroceryService {

    @Autowired
    private ShopService shopService;

    public Shop shop = new Shop(UUID.randomUUID().toString(), "Jaya Grocer", "3KM", "12m", "Mart");
    public Grocery grocery = new Grocery(UUID.randomUUID().toString(), "Milk", "1KG", 4.3f, 1.0, "USD", true, true, "", shop.getId());
    public List<Grocery> groceryList = new ArrayList<>(Arrays.asList(grocery));

    @Override
    public List<Grocery> findAll() {
        return groceryList;
    }

    @Override
    public GroceryDTO findById(String id) {
        if (id == null) throw new NotFoundException(AppConstants.RECORD_ID_CAN_NOT_BE_NULL);
        if (Objects.isNull(grocery.getId())) throw new NotFoundException(AppConstants.RECORD_NOT_FOUND_BY_ID);
        if (Objects.isNull(grocery.getShopId())) throw new NotFoundException(AppConstants.RECORD_NOT_FOUND_BY_ID);
        return groceryToGroceryDTO(grocery);
    }

    @Override
    public GroceryDTO create(GroceryDTO groceryDTO) {
        Grocery grocery1 = dToToGrocery(groceryDTO);
//        grocery1 = groceryRepository.save(grocery1);
        groceryDTO.setShop(shopService.findById(groceryDTO.getId()));
        return groceryDTO;
    }

    @Override
    public GroceryDTO update(GroceryDTO groceryDTO) {
        GroceryDTO existingGrocery = Optional.of(findById(grocery.getId())).orElseThrow(() -> new NotFoundException(AppConstants.RECORD_NOT_FOUND_BY_ID));
        existingGrocery.setCurrency(grocery.getCurrency());
        existingGrocery.setShop(shopService.findById(groceryDTO.getId()));
        return groceryDTO;
    }

    @Override
    public boolean delete(String id) {
        return true;
    }


    public GroceryDTO groceryToGroceryDTO(Grocery grocery) {
        GroceryDTO dto = new GroceryDTO();
        dto.setId(grocery.getId());
        dto.setName(grocery.getName());
        dto.setDescription(grocery.getDescription());
        dto.setRatings(grocery.getRatings());
        dto.setPrice(grocery.getPrice());
        dto.setShop(shopService.findById(grocery.getId()));
        return dto;
    }

    public Grocery dToToGrocery(GroceryDTO dto) {
        Grocery grocery = new Grocery();
        grocery.setId(dto.getId());
        grocery.setName(dto.getName());
        grocery.setDescription(dto.getDescription());
        grocery.setRatings(dto.getRatings());
        grocery.setPrice(dto.getPrice());
        grocery.setShopId(shopService.findById(dto.getId()).getId());
        return grocery;
    }
}

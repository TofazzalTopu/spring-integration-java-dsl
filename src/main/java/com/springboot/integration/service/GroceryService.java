package com.springboot.integration.service;

import com.springboot.integration.model.Grocery;
import com.springboot.integration.dto.GroceryDTO;

import java.util.List;

public interface GroceryService {

    public List<Grocery> findAll();

    public GroceryDTO findById(String id);
    public GroceryDTO create(GroceryDTO grocery);
    public GroceryDTO update(GroceryDTO grocery);
    public boolean delete(String id);

}

package com.springboot.integration.service;

import com.springboot.integration.model.Grocery;

import java.util.List;

public interface GroceryService {

    public List<Grocery> findAll();

    public Grocery findById(String id);
    public Grocery create(Grocery grocery);
    public Grocery update(Grocery grocery);
    public boolean delete(String id);

}

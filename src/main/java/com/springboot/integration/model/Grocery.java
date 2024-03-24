package com.springboot.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.UUID;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Grocery implements Serializable {

    private String id = UUID.randomUUID().toString();

    @NotNull
    @Size(min = 2, max = 50, message
            = "Name must be between 2 and 50 characters")
    private String name = "Sugar";

    @NotNull
    @Size(min = 5, max = 250, message
            = "Description must be between 5 and 250 characters")
    private String description = "1Kg Sugar";

    @Max(value = 5, message = "Ratings should not be greater than 5")
    private float ratings = 4.3f;

    @Min(value = 1, message = "Price should not be less than 1")
    private double price = 1.0;

    @NotNull(message = "Currency can not be null!")
    private String currency = "USD";

    private Boolean isPromoAvailable = true;

    private Boolean isDiscountAvailable = true;

    private String image;

    private String shopId;

    public Grocery() {
    }

    public Grocery(String id, String name, String description, float ratings, double price, String currency, Boolean isPromoAvailable, Boolean isDiscountAvailable, String image, String shopId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ratings = ratings;
        this.price = price;
        this.currency = currency;
        this.isPromoAvailable = isPromoAvailable;
        this.isDiscountAvailable = isDiscountAvailable;
        this.image = image;
        this.shopId = shopId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getPromoAvailable() {
        return isPromoAvailable;
    }

    public void setPromoAvailable(Boolean promoAvailable) {
        isPromoAvailable = promoAvailable;
    }

    public Boolean getDiscountAvailable() {
        return isDiscountAvailable;
    }

    public void setDiscountAvailable(Boolean discountAvailable) {
        isDiscountAvailable = discountAvailable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}

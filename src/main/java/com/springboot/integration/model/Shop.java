package com.springboot.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shop implements Serializable {

    private String id = UUID.randomUUID().toString();

    @NotNull
    @Size(min = 2, max = 100, message
            = "Shop Name must be between 2 and 100 characters")
    private String shopName = "Jaya Grocer";
    @NotNull
    private String distance;
    @NotNull
    private String time;
    @NotNull
    private String shopType = "Mart";

    public Shop() {
    }

    public Shop(String id, String shopName, String distance, String time, String shopType) {
        this.id = id;
        this.shopName = shopName;
        this.distance = distance;
        this.time = time;
        this.shopType = shopType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }
}

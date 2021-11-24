package com.example.CoffeeShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrinkDTO {
    private int drinkId;
    private String name;
    private int price;
    private String imageUrl;
}

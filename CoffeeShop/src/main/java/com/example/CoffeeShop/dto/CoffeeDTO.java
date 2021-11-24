package com.example.CoffeeShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeDTO {
    private int coffeeId;
    private String name;
    private int price;
    private String imageUrl;
}

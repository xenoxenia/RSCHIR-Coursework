package com.example.CoffeeShop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drink_id")
    private int coffeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "image_url")
    private String imageUrl;

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + coffeeId +
                ", name='" + name + '\'' +
                ", price ='" + price + '\'' +
                '}';
    }
}

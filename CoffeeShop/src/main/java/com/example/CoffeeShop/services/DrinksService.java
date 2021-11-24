package com.example.CoffeeShop.services;

import com.example.CoffeeShop.dao.CoffeeDAO;
import com.example.CoffeeShop.dao.DrinkDAO;
import com.example.CoffeeShop.dto.CoffeeDTO;
import com.example.CoffeeShop.dto.DrinkDTO;
import com.example.CoffeeShop.models.Coffee;
import com.example.CoffeeShop.models.Drink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DrinksService {
    private final DrinkDAO drinkDAO;

    @Autowired
    public DrinksService(DrinkDAO drinkDAO) {
        this.drinkDAO = drinkDAO;
    }

    @Transactional
    public List<Drink> getAll() {
        return drinkDAO.findAll();
    }

    @Transactional
    public void save(DrinkDTO drinkDTO) {
        Drink drink = new Drink();
        drink.setCoffeeId(drinkDTO.getDrinkId());
        drink.setName(drinkDTO.getName());
        drink.setPrice(drinkDTO.getPrice());
        drink.setImageUrl(drinkDTO.getImageUrl());
    }
}

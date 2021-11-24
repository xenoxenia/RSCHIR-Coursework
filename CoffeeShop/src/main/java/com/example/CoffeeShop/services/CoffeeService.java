package com.example.CoffeeShop.services;

import com.example.CoffeeShop.dao.CoffeeDAO;
import com.example.CoffeeShop.dto.CoffeeDTO;
import com.example.CoffeeShop.models.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CoffeeService {
    private final CoffeeDAO coffeeDAO;

    @Autowired
    public CoffeeService(CoffeeDAO coffeeDAO) {
        this.coffeeDAO = coffeeDAO;
    }

    @Transactional
    public List<Coffee> getAll() {
        return coffeeDAO.findAll();
    }

    @Transactional
    public void save(CoffeeDTO coffeeDTO) {
        Coffee coffee = new Coffee();
        coffee.setCoffeeId(coffeeDTO.getCoffeeId());
        coffee.setName(coffeeDTO.getName());
        coffee.setPrice(coffeeDTO.getPrice());
        coffee.setImageUrl(coffeeDTO.getImageUrl());
    }
}

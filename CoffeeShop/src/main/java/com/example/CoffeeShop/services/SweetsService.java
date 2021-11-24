package com.example.CoffeeShop.services;

import com.example.CoffeeShop.dao.SweetDAO;
import com.example.CoffeeShop.dto.SweetDTO;
import com.example.CoffeeShop.models.Coffee;
import com.example.CoffeeShop.models.Sweet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class SweetsService {
    private final SweetDAO sweetDAO;

    @Autowired
    public SweetsService(SweetDAO sweetDAO) {
        this.sweetDAO = sweetDAO;
    }

    @Transactional
    public List<Sweet> getAll() {
        return sweetDAO.findAll();
    }

    @Transactional
    public void save(SweetDTO sweetDTO) {
        Sweet sweet = new Sweet();
        sweet.setCoffeeId(sweetDTO.getSweetId());
        sweet.setName(sweetDTO.getName());
        sweet.setPrice(sweetDTO.getPrice());
        sweet.setImageUrl(sweetDTO.getImageUrl());
    }
}

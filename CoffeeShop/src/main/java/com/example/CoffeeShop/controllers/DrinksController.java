package com.example.CoffeeShop.controllers;

import com.example.CoffeeShop.dto.DrinkDTO;
import com.example.CoffeeShop.services.DrinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrinksController {
    private final DrinksService drinksService;

    @Autowired
    public DrinksController(DrinksService drinksService) {
        this.drinksService = drinksService;
    }

    @GetMapping("/drinks")
    public String getAll(Model model) {
        model.addAttribute("drinks", drinksService.getAll());
        return "drinks";
    }

    @PostMapping("/drinks")
    public String create(@ModelAttribute("newDrink") DrinkDTO drinkDTO) {
        drinksService.save(drinkDTO);
        return "redirect:/drinks";
    }
}

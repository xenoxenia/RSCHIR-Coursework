package com.example.CoffeeShop.controllers;

import com.example.CoffeeShop.dto.SweetDTO;
import com.example.CoffeeShop.services.SweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SweetsController {
    private final SweetsService sweetsService;

    @Autowired
    public SweetsController(SweetsService sweetsService) {
        this.sweetsService = sweetsService;
    }

    @GetMapping("/sweets")
    public String getAll(Model model) {
        model.addAttribute("sweets", sweetsService.getAll());
        return "sweets";
    }

    @PostMapping("/sweets")
    public String create(@ModelAttribute("newCoffee") SweetDTO sweetDTO) {
        sweetsService.save(sweetDTO);
        return "redirect:/sweets";
    }
}

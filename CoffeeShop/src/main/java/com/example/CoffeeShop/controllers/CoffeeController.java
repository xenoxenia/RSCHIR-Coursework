package com.example.CoffeeShop.controllers;

import com.example.CoffeeShop.dto.CoffeeDTO;
import com.example.CoffeeShop.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoffeeController {
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService studentService) {
        this.coffeeService = studentService;
    }

    @GetMapping("/coffee")
    public String getAll(Model model) {
        model.addAttribute("coffee", coffeeService.getAll());
        return "coffee";
    }

    @PostMapping("/coffee")
    public String create(@ModelAttribute("newCoffee") CoffeeDTO coffeeDTO) {
        coffeeService.save(coffeeDTO);
        return "redirect:/coffee";
    }
}

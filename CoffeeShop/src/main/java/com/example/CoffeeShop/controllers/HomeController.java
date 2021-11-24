package com.example.CoffeeShop.controllers;

import com.example.CoffeeShop.models.Role;
import com.example.CoffeeShop.models.User;
import com.example.CoffeeShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class HomeController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public HomeController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/home")
    public String hello() {
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        User userFromDB = userService.getUser(user.getUsername());

        if (userFromDB != null) {
            model.addAttribute("error", "такой пользователь уже есть");
            return "registration";
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);

        return "redirect:/login";
    }
}

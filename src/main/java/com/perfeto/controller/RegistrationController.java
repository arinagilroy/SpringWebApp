package com.perfeto.controller;


import com.perfeto.dao.UserRepo;
import com.perfeto.model.Role;
import com.perfeto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String greeting() {
        return "main";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Model model, User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB != null) {
            model.addAttribute("message", "User exist!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
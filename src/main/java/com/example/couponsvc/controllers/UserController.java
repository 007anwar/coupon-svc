package com.example.couponsvc.controllers;

import com.example.couponsvc.entity.User;
import com.example.couponsvc.repository.UserRepo;
import com.example.couponsvc.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private SecurityService securityService;
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(SecurityService securityService, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.securityService = securityService;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }


    @GetMapping("/showreg")
    public String showRegistrationPage() {
        return "registerUser";
    }

    @PostMapping("/login")
    public String login(String email, String password) {
        boolean login = securityService.login(email, password);
        if (login)
            return "index";
        else
            return "login";
    }

    @PostMapping("/registerUser")
    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepo.save(user);
        return "login";
    }
}
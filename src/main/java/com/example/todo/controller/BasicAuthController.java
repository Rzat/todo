package com.example.todo.controller;


import com.example.todo.domain.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthController {

    @GetMapping("/basicAuth")
    public AuthenticationBean authenticate() {
        return new AuthenticationBean("You are Authenticated");
    }
}

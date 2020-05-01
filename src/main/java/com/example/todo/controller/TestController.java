package com.example.todo.controller;

import com.example.todo.domain.HellowWorldBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {


    public String helloWorld() {
        return "Hello";
    }

    @GetMapping("/hello")
    public ResponseEntity<Object> hellowWorld() {
        String hellow = "Hello";
        return new ResponseEntity<>(hellow, HttpStatus.OK);
    }

    @GetMapping("/helloBean")
    public HellowWorldBean hellowWorldBean() {
        return new HellowWorldBean("Hello Bean");
        // throw new RuntimeException("Some Error has occurred");
    }

    @GetMapping("/helloBean/{name}")
    public HellowWorldBean hellowWorldBeanPath(@PathVariable String name) {
        return new HellowWorldBean(name);
        // throw new RuntimeException("Some Error has occurred");
    }
}

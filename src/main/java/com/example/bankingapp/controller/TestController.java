package com.example.bankingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @GetMapping("test")
    public String myFirstMethod(){

        return "Learning spring-boot!!";
    }

}

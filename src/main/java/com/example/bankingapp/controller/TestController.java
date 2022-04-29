package com.example.bankingapp.controller;

import com.example.bankingapp.dto.InsuranceRequest;
import com.example.bankingapp.dto.UserDetails;
import com.example.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("product-details/{productName}")
    public String myFirstMethod(@PathVariable String productName) {

        return testService.fetchProductDetails(productName);

    }

    @PostMapping("insurance")
    public String insuranceDetails(@RequestBody InsuranceRequest insuranceRequest){

        return testService.insuranceDetail(insuranceRequest);
    }

    @GetMapping("get-user-details/{userId}")
    public UserDetails fetchUserDetails(@PathVariable int userId){
        return  testService.getUserDetails(userId);
    }
}



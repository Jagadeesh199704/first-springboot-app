package com.example.bankingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
    // endpoint
    @GetMapping("test")
    public String myFirstMethod(){

        return "Learning spring-boot!!";
    }

     @GetMapping("num/{num1}/{num2}")//path variable
    public int myFirstMethod(@PathVariable int num1, @PathVariable int num2){
        try{
            return num1+ num2;
        }catch (NumberFormatException d){
            throw new NullPointerException("Number and string cannot be added");
        }
    }

    @GetMapping("product-details/{productName}")
    public String myFirstMethod(@PathVariable String productName){
        switch (productName){
            case "Washing Machine":
                return electronicsDeatils();
            case  "LED TV":
                return electronicsDeatil();
            default:
                return "No Products Found!!!";
        }
    }

    public String electronicsDeatils(){
        return "Samsung Washing Machine Model No.WW61, Sl.No. 1254321SA45";

    }

    public String electronicsDeatil(){
        return "LG LED TV Model:LG001, Sl.No: 12254, Price: 25000";
    }

}



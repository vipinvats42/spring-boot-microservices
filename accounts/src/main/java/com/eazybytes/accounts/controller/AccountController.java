package com.eazybytes.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AccountController{

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello vipin from Account Service!";
    }

}
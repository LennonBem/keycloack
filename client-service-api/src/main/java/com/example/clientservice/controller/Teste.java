package com.example.clientservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teste")
public class Teste {

    @GetMapping("/hello")
    public String teste() {
        return "Hello World";
    }
}

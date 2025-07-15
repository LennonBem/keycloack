package com.example.clientservice.controller;

import com.example.clientservice.client.ApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client")
public class Teste {

    final private ApiClient apiClient;

    public Teste(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    @GetMapping("/private")
    public Object callPrivate() {
        Object response = apiClient.chamadaEndpointPrivado();
        return response ;
    }
}

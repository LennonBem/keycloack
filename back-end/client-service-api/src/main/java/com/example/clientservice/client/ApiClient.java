package com.example.clientservice.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiClient {

    @Value("${baseUrl}")
    private String baseUrl;

    private final WebClient webClient;

    public ApiClient(WebClient webClient) {
        this.webClient = webClient;
    }


    public String chamadaEndpointPrivado() {
        String resp =  webClient.get()
                .uri(baseUrl +"/resources/private")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(webClient.head());

       return resp;
    }

}

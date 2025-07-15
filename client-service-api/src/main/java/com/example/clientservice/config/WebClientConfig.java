package com.example.clientservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    private final OAuth2AuthorizedClientManager authorizedClientManager;

    public WebClientConfig(OAuth2AuthorizedClientManager authorizedClientManager) {
        this.authorizedClientManager = authorizedClientManager;
    }


    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .filter(oauth2AuthenticationFilter())
                .build();
    }


    private ExchangeFilterFunction oauth2AuthenticationFilter() {
        return (request, next) -> {
            OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
                    .withClientRegistrationId("keycloak-client")
                    .principal("api-client") // pode ser qualquer string
                    .build();

            OAuth2AuthorizedClient client = authorizedClientManager.authorize(authorizeRequest);

            if (client == null) {
                return Mono.error(new IllegalStateException("Não foi possível autorizar o cliente"));
            }

            String token = client.getAccessToken().getTokenValue();

            ClientRequest filteredRequest = ClientRequest.from(request)
                    .header("Authorization", "Bearer " + token)
                    .build();

            return next.exchange(filteredRequest);
        };
    }
}

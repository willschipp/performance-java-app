package com.example.performance.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono; 

@Service
@Profile("client")
@Slf4j
public class PerformanceClient {
    
    @Autowired
    WebClient webClient;

    @Bean
    public WebClient webClient() {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
            .build();
        return WebClient.builder()
            .exchangeStrategies(strategies)
            .build();
    }

    public void sendRequest() throws Exception {
        log.info("enter");
        //use a webclient to send a request
        String body = webClient.get()
            .uri("/news")
            .exchangeToMono(handler -> {
                return handler.bodyToMono(String.class);
            }).block();
        log.info(body);
        // });
        log.info("exit");
    }
}

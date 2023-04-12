package com.example.performance.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Profile("client")
@Slf4j
public class PerformanceClient {
    
    @Autowired
    WebClient webClient;

    public void sendRequest() throws Exception {
        log.info("enter");
        //use a webclient to send a request
        webClient.get()
            .uri("/news")
            .exchangeToMono(response -> {});
        // });
        log.info("exit");
    }
}

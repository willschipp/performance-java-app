package com.example.performance.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

public class PerformanceClientIT {
    
    WebClient webClient;

    @BeforeEach
    public void setup() throws Exception {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
            .build();        
        webClient = WebClient.builder()
        .exchangeStrategies(strategies)
        .baseUrl("https://www.bbc.com/")
        .build();            
    }


    @Test
    public void test_sendRequest() throws Exception {
        // WebClient webClient = WebClient.create("https://www.bbc.com/");
        //instantiate
        PerformanceClient performanceClient = new PerformanceClient();
        ReflectionTestUtils.setField(performanceClient, "webClient",webClient);
        //invoke
        performanceClient.sendRequest();
        //wait
        // Thread.sleep(10 * 1000);

    }
}

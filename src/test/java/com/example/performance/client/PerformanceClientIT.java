package com.example.performance.client;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

public class PerformanceClientIT {
    

    @Test
    public void test_sendRequest() throws Exception {
        WebClient webClient = WebClient.create("https://www.bbc.com/");
        //instantiate
        PerformanceClient performanceClient = new PerformanceClient();
        ReflectionTestUtils.setField(performanceClient, "webClient",webClient);
        //invoke
        performanceClient.sendRequest();
        //wait
        Thread.sleep(10 * 1000);

    }
}

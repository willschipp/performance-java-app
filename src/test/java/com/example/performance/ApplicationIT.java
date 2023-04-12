package com.example.performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties={
    "spring.cloud.config.enabled=false"
})
@ActiveProfiles("test")
public class ApplicationIT {
    
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test_startup() throws Exception {
        assertTrue(applicationContext.getBeanDefinitionCount() > 0);
    }

}

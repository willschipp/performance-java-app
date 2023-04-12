package com.example.performance.loader;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.performance.model.PersonRepository;

@SpringBootTest(properties={
    "spring.cloud.config.enabled=false"
})
@ActiveProfiles("test")
public class DataLoaderIT {
   
    
    @Autowired
    DataLoader dataLoader;

    @Autowired
    PersonRepository personRepository;

    @Test
    public void test_load() throws Exception {
        long beforeCount = personRepository.count();
        dataLoader.load();
        //check again
        long afterCount = personRepository.count();
        //validate
        assertTrue(afterCount > beforeCount);
    }
}

package com.example.performance.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties={
    "spring.cloud.config.enabled=false"
})
@AutoConfigureMockMvc
public class PersonRepositoryIT {
    
    @Autowired
    MockMvc mvc;

    @Test
    public void test_Get() throws Exception {
        mvc.perform(get("/persons").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}

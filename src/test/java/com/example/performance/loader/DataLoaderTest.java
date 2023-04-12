package com.example.performance.loader;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.performance.model.PersonRepository;

public class DataLoaderTest {
    

    @Test
    public void test_load() {
        PersonRepository personRepository = mock(PersonRepository.class);
        //setup
        DataLoader dataLoader = new DataLoader();
        ReflectionTestUtils.setField(dataLoader, "personRepository", personRepository);
        //set the value
        ReflectionTestUtils.setField(dataLoader, "counter", 10);
        //invoke
        dataLoader.load();
        //check
        verify(personRepository,atLeastOnce()).saveAll(anyList());
    }
}

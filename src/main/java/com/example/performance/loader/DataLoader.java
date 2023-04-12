package com.example.performance.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.performance.model.Person;
import com.example.performance.model.PersonRepository;

@Service
public class DataLoader {
    
    @Value("${model-count:100}")
    private int counter;

    @Autowired
    PersonRepository personRepository;

    public void load() {
        //build a set of models
        List<Person> persons = new ArrayList<>();
        //commit
        for (int i=0;i<counter;i++) {
            Person person = new Person();
            person.setFirstName("john");
            person.setLastName("doe" + i);
            //add to the collection
            persons.add(person);
        } //end for
        //now store
        personRepository.saveAll(persons);
    }

}

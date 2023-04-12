package com.example.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import com.example.performance.loader.DataLoader;

@SpringBootApplication
public class Application implements ApplicationRunner {
    

    public static void main(String... args) {
        SpringApplication.run(Application.class,args);
    }


    @Autowired
    Environment environment;

    @Autowired
    DataLoader dataLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (environment.acceptsProfiles(Profiles.of("default"))) {
            dataLoader.load();
        } //end if
    }
}

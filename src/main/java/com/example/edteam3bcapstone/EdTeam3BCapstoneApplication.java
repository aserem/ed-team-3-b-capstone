package com.example.edteam3bcapstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class EdTeam3BCapstoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdTeam3BCapstoneApplication.class, args);
    }

}
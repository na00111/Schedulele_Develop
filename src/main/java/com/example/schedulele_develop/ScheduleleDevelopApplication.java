package com.example.schedulele_develop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ScheduleleDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleleDevelopApplication.class, args);
    }

}

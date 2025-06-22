package com.moveo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MoveoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoveoApplication.class, args);
    }

}

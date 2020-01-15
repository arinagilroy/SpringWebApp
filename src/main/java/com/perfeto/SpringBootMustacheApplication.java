package com.perfeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringBootMustacheApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMustacheApplication.class, args);
    }
}
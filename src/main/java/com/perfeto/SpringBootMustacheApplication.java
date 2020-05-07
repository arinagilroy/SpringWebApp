package com.perfeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Remove SecurityAutoConfiguration.class for enable login
 */

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootMustacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMustacheApplication.class, args);
    }
}
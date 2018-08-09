package com.imie.unittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.imie.unittest")
public class UnitTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitTestApplication.class, args);
    }
}

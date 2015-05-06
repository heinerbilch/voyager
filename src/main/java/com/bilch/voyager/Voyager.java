package com.bilch.voyager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Voyager {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Voyager.class, args);
    }

}

package com.ltudm.daltudmlastver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DaltudmLastVerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaltudmLastVerApplication.class, args);
    }

}

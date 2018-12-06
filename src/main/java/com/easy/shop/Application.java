package com.easy.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        System.out.println("test1");
        SpringApplication.run(Application.class);
    }

}

package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author qi_guai
 */
@Slf4j
@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        log.info("==============================start==============================");
        SpringApplication.run(JpaDemoApplication.class, args);
        log.info("==============================success==============================");

    }

}

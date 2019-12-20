package com.oupu.pss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.oupu.pss.dao")
@SpringBootApplication
public class PssApplication {

    public static void main(String[] args) {
        SpringApplication.run(PssApplication.class, args);
    }

}

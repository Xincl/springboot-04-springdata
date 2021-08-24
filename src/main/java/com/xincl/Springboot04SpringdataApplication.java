package com.xincl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.xincl.mapper")
@SpringBootApplication
public class Springboot04SpringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04SpringdataApplication.class, args);
    }

}

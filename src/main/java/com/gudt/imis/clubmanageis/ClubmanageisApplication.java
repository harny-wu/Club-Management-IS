package com.gudt.imis.clubmanageis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.gudt.imis.clubmanageis.dao")
public class ClubmanageisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubmanageisApplication.class, args);
    }

}

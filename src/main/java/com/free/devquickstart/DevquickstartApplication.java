package com.free.devquickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.free.devquickstart.dao")
public class DevquickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevquickstartApplication.class, args);
    }

}

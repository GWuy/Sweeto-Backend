package com.gwuy.sweeto.api;

import com.intern.hub.library.common.annotation.EnableGlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGlobalExceptionHandler
public class SweetoApplication {
    static void main(String[] args) {
        SpringApplication.run(SweetoApplication.class, args);
    }
}

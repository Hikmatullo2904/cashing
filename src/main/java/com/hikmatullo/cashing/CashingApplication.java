package com.hikmatullo.cashing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableCaching
@Import(CacheConfig.class)
public class CashingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashingApplication.class, args);
    }

}

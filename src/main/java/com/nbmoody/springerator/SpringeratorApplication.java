package com.nbmoody.springerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// Using the spring-boot-starter-data-redis package, along with the spring-boot-starter-cache package,
// the @EnabledCaching configured caching for use in the application. The RedisCacheConfig.java class holds the Bean
// that does more granular configuration.
@SpringBootApplication
@EnableCaching 
public class SpringeratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringeratorApplication.class, args);
    }
}

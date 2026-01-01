package com.nbmoody.springerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCaching // Using the spring-boot-starter-data-redis package, this configured caching for use in the application.
public class SpringeratorApplication {
    
    Logger logger = LoggerFactory.getLogger(SpringeratorApplication.class);

    public static void main(String[] args) {
        logger.info("Starting the application...")
        SpringApplication.run(SpringeratorApplication.class, args);
    }
}

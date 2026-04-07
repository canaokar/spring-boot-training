package com.training.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Lab 04 application.
 *
 * Notice this class ONLY has @SpringBootApplication and main().
 * In earlier labs, we put controller logic right here. Now the
 * controller lives in its own class, in its own package.
 *
 * This class is PRE-BUILT - no changes needed here.
 */
@SpringBootApplication
public class Lab04LayeredArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab04LayeredArchitectureApplication.class, args);
    }
}

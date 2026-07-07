package com.medsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clinical Data Processor Application
 *
 * This is the main entry point of the MedSync application.
 * It bootstraps the Spring Boot framework and starts the embedded server.
 *
 * Responsibilities:
 * - Initializes the Spring Boot application context.
 * - Scans for Spring components (Controllers, Services, Repositories).
 * - Starts the embedded web server (Tomcat).
 * - Makes REST APIs available for processing patient vital signs.
 */
@SpringBootApplication
public class ClinicalDataProcessorApplication {
    /**
     * Main method of the application.
     *
     * This method launches the Spring Boot application and initializes
     * all required components, including Controllers, Services,
     * Repositories, and the H2 database connection.
     *
     * @param args Command-line arguments passed during application startup.
     */
    public static void main(String[] args) {
        SpringApplication.run(ClinicalDataProcessorApplication.class, args);
    }
}
// MainClass
// Description: Serves as the entrypoint for the program and launches the SpringBoot Application
// Inputs:
// Outputs: Initializes a worker or a coordinator node
//
// Authors: Adam Berry
// Created On: 2026-6-1

package crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/*
 * The main entry point for the application
 */
@SpringBootApplication
@RestController
public class MainClass {
    public static void main(String[] args) {
        System.out.println("The crawler container initialized correctly");

		SpringApplication.run(MainClass.class, args);
    }
}

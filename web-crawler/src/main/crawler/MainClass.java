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

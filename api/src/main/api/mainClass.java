package api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@SpringBootApplication
public class mainClass {
	@GetMapping("/")
	public String home() {
		String htmlResponse = "<html><body><h1>Hello, World!</h1></body></html>";
		return htmlResponse;
	}

    public static void main(String[] args) {
		SpringApplication.run(mainClass.class, args);
    }
}

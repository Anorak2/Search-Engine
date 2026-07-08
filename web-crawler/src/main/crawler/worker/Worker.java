package crawler.worker;

import crawler.Config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Profile("worker")
public class Worker {
	private Config config;

	@GetMapping("/")
	public String home() {
		return "Hello World!";
	}
}

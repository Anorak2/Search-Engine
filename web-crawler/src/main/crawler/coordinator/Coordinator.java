// Coordinator Node
// Description: Assigns work to worker nodes, enforces certain politeness constraints, stores returned data to the database
// Inputs: Config values, PageInformation
// Outputs: Data to database, URLs to worker nodes
//
// Authors: Adam Berry
// Created On: 2026-6-1

package crawler.coordinator;

import crawler.Config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Profile("coordinator")
public class Coordinator {
	private Config config;

	@GetMapping("/")
	public String home() {
		return "Hello World!";
	}

}

package crawler;

import crawler.coordinator.Coordinator;
import crawler.worker.Worker;

/*
 * The main entry point for the application
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("The crawler container initialized correctly");
		Config configurator = Config.getInstance();

		if(configurator.nodeType.equals("coordinator")){
			Coordinator node = new Coordinator();

		}
		else if(configurator.nodeType.equals("worker")){
			Worker node = new Worker();

		}
		else {
			System.out.println("invalid NODE_TYPE");
			System.out.println(configurator.nodeType);
		}
    }
}

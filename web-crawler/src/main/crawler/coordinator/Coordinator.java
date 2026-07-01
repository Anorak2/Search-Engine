package crawler.coordinator;

import java.sql.*;
import crawler.Config;

public class Coordinator {
	private Config config;

	public Coordinator(){
		this.config = Config.getInstance();
	}

	public void run(){
		return;
	}


	private void getDatabase(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(config.dbUrl, config.dbUsername, config.dbPassword);
			System.out.println("Connection Established successfully");
		} catch (Exception e) {
			System.out.println("Connection to database failed");
		}
	}
}

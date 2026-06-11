package com.gecko.coordinator;

import java.sql.*;

import com.gecko.Config.Config;

public class Coordinator {
	private Config config;

	public Coordinator(){
		this.config = Config.getInstance();
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

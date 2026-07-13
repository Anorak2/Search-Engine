// Config
// Description: Holds all environment variables and global configuration values
// Inputs: the .env variables passed to docker
// Outputs:
//
// Authors: Adam Berry
// Created On: 2026-6-1


package crawler;

public class Config {
	public String appEnv;
	public String debugLevel;
	public String nodeType;
	public String dbUsername;
	public String dbPassword;
	public String dbUrl;

	public String coordinatorLocation;

	private static volatile Config obj = null;

	private Config(){
		this.appEnv      = System.getenv("APP_ENV");
		this.debugLevel  = System.getenv("DEBUG");
		this.nodeType    = System.getenv("NODE_TYPE");
		this.coordinatorLocation = System.getenv("COORD_LOCATION");
		this.dbUsername  = System.getenv("DB_USER");
		this.dbPassword  = System.getenv("DB_PASSWORD");
		this.dbUrl      = System.getenv("DB_URL");
	}

	public static Config getInstance() {
        if (obj == null) {
			// Thread safe just in case
            synchronized (Config.class) {
				// Check again in case multiple threads reached at the same time
                if (obj == null){
                    obj = new Config();
				}
            }
        }
        return obj;
    }
}

package com.gecko.Config;

/*
 * A singleton class for holding global configuration values
 */
public class Config {
	public String appEnv;
	public String debugLevel;
	public String nodeType;
	public String cordLocation;

	private static volatile Config obj = null;

	private Config(){
		this.appEnv = System.getenv("APP_ENV");
		this.debugLevel = System.getenv("DEBUG");
		this.nodeType = System.getenv("NODE_TYPE");
		this.cordLocation = System.getenv("COORD_LOCATION");
	}

	public static Config getInstance() {
        if (obj == null) {
			// just to be sure it is thread safe
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

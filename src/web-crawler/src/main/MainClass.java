import com.gecko.Config.Config;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("The crawler container initialized correctly");
		Config configurator = Config.getInstance();
		System.out.println(configurator.appEnv);
    }
}

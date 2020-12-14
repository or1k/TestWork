package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "\\src\\main\\resources\\config.properties";
    private  String userName;
    private  String url;
    private  String browser;
    private  int explicityWait;
    private  int implicityWait;


    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }


    private void loadData() {

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }


        userName = prop.getProperty("test.userName");
        url = prop.getProperty("test.URL");
        explicityWait = Integer.parseInt(prop.getProperty("test.explicityWait"));
        implicityWait = Integer.parseInt(prop.getProperty("test.implicityWait"));
        browser = prop.getProperty("test.browser");
    }

    public String getUrl() {
        return url;
    }

    public int getExplicityWait() {
        return explicityWait;
    }

    public int getImplicityWait() {
        return implicityWait;
    }

    public String getBrowser() {
        return browser;
    }
}

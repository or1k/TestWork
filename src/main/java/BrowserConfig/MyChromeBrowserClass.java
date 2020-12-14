package BrowserConfig;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class MyChromeBrowserClass {

    public ChromeDriver chrome() {
        String chromepath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromepath);
//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--window-size=500,1080");
//        return new ChromeDriver(option);
        return new ChromeDriver();
    }

    public FirefoxDriver firefox() {
        String firefoxpath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", firefoxpath);
        return new FirefoxDriver();
    }


}
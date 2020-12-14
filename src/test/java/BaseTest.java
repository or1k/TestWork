import BrowserConfig.MyChromeBrowserClass;
import Pages.*;
import Utils.PropertyManager;
import Utils.Uttils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected final Logger logger = LogManager.getLogger();

    WebDriver driver;
    CarPage carPage;
    Uttils uttils;


    public void setup() {
        if (PropertyManager.getInstance().getBrowser().equals("chrome")) {
            driver = new MyChromeBrowserClass().chrome();
        }
        if (PropertyManager.getInstance().getBrowser().equals("firefox")) {
            driver = new MyChromeBrowserClass().firefox();
        }


        String chromepath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromepath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(PropertyManager.getInstance().getImplicityWait(), TimeUnit.SECONDS);
        carPage = new CarPage(driver);
        uttils = new Uttils();
        ThreadContext.put("className", getClass().getName());
    }

    /**
     * Method that add cookie after opened test url
     *
     * @throws MalformedURLException
     */
    protected void addCookie() throws MalformedURLException {
        Cookie cookie = new Cookie.Builder("cookieBarSeen", "true")
                .domain(".olx.ua")
                .path("/")
                .build();
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }

}

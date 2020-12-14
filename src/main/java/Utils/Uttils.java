package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.testng.Assert.fail;

public class Uttils {
    protected final Logger logger = LogManager.getLogger();
    JavascriptExecutor js;


    public void waitForPresent (WebDriver driver, String xPathLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyManager.getInstance().getExplicityWait()));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathLocator)));
    }

    public void waitForElementInvisible (WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyManager.getInstance().getExplicityWait()));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilElementIsVisibility (WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyManager.getInstance().getExplicityWait()));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsClickable (WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyManager.getInstance().getExplicityWait()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilElementIsClickable (WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyManager.getInstance().getExplicityWait()));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitUntilPageLoaded (WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public void scrollPage (WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }



    public boolean isExist(ArrayList<String> list){
        for (String s : list){
            if (list.contains(s)){
                logger.info(s + " found");
                return true;
            }
            else {
                logger.info(s + " not found");
                return false;
            }
        }
        return false;
    }
}

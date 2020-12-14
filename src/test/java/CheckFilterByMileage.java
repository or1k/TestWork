import Utils.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckFilterByMileage extends BaseTest{
    private final Logger logger = LogManager.getLogger();

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void testFilterMileage(){
        /**
         * TestData
         */
        String url = PropertyManager.getInstance().getUrl();
        int waitTime = PropertyManager.getInstance().getExplicityWait();


        /**
         * Test
         */
        driver.get(url);
        logger.info("Open url :" + url);

            carPage.getMileageFromField().click();
            uttils.waitUntilElementIsVisibility(driver, carPage.getActiveField());
            carPage.getActiveField().sendKeys("100000");
            logger.info("Insert first value by sendKeys = 100000");
            carPage.getActiveField().sendKeys(Keys.ENTER);

            uttils.waitUntilElementIsVisibility(driver, carPage.getMileageToButton());
            carPage.getMileageToButton().click();


            uttils.waitUntilElementIsClickable(driver, "//div[@class='filter-item filter-item-to rel numeric-item filterActive']//a[@data-name='70 000']");
            carPage.getMaileAgeList().get(4).click();
            logger.info("Pick 4 value by list = 175500");
            logger.info("\n");

    }


    @AfterMethod()
    public void clear(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.info(result.getThrowable());
            logger.info("Price field accepted not only digits" + "\n");
        }
    }
}

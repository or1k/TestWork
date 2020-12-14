import Utils.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckValidationPriceField extends BaseTest {
    private final Logger logger = LogManager.getLogger();

    @BeforeClass
    public void setup() {
        super.setup();

    }

    @Test
    public void checkValidation() {
        /**
         * TestData
         */
        String url = PropertyManager.getInstance().getUrl();
        int testValue = 123;


        /**
         * Test
         */
        driver.get(url);
        logger.info("Open url: " + url);
        carPage.getPriceFromField().click();
        carPage.getActiveField().sendKeys(testValue + "w@");
        uttils.waitForElementInvisible(driver, carPage.getLabelAfterInput());
        Assert.assertEquals(carPage.getPriceFromField().getText(), testValue + " грн.");
        logger.info("Only digits in price field");

    }

    @AfterMethod()
    public void clear(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.info(result.getThrowable());
            logger.info("Price field accepted not only digits" + "\n");
        }
    }


}

import Utils.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckCheckboxesInTransmissionList extends BaseTest {
    private final Logger logger = LogManager.getLogger();

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void testCheckCheckboxTransmission() throws InterruptedException {
        /**
         * TestData
         */
        String url = PropertyManager.getInstance().getUrl();


        /**
         * Test
         */
        driver.get(url);
        logger.info("open url: " + url);


        /**
         * Check default status
         */
        carPage.getTransmisionField().click();
        Assert.assertEquals("true", carPage.getTransmissionCheckboxStatus().get(0).getAttribute("checked"));
        logger.info("default value is true");
        logger.info("\n");


        /**
         * Check default status
         */
        carPage.getTransmissionList().get(2).click();
        logger.info("Pick automatic");
        Assert.assertNull(carPage.getTransmissionCheckboxStatus().get(0).getAttribute("checked"));
        logger.info("First value in list is not checked");
        logger.info("\n");

    }

    @AfterMethod()
    public void clear(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.info(result.getThrowable());

        }
    }


}

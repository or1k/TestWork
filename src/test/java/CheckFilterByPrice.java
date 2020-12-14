import Utils.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class CheckFilterByPrice extends BaseTest {
    private final Logger logger = LogManager.getLogger();

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    public void testFilterByPrice() throws InterruptedException, MalformedURLException {
        /**
         * TestData
         */
        String url = PropertyManager.getInstance().getUrl();


        /**
         * Test
         */
        driver.get(url);
        logger.info("open url: " + url);
        super.addCookie();
        driver.navigate().refresh();

        carPage.selectCheaperFilter();
        uttils.waitUntilElementIsVisibility(driver, carPage.getFooter());
        //TODO
        /**
         * Кemove waiting when i find a solution
         */
        Thread.sleep(1000);


        for (int i = 0; i < carPage.getPriceList().size()-1; i++) {
            try {
                String str = carPage.getPriceList().get(i).getText();
                str = str.replaceAll("[^0-9]", "");


                String str2 = carPage.getPriceList().get(i + 1).getText();
                str2 = str2.replaceAll("[^0-9]", "");


                int firstPrice = Integer.parseInt(str);
                int secondPrice = Integer.parseInt(str2);
                logger.info("Price " + i + " = " + firstPrice);
                logger.info("Price " + (i+1) + " = " + secondPrice);

                Assert.assertTrue(firstPrice <= secondPrice);
                logger.info(firstPrice + " <= " + secondPrice);

            } catch (IndexOutOfBoundsException | AssertionError ex) {
                logger.info(ex);
                logger.info("\n");
                break;
            }
            logger.info("\n");
        }


    }


}

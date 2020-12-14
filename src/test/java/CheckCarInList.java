import Utils.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.fail;

public class CheckCarInList extends BaseTest{


    @BeforeClass
    @Override
    public void setup() {
        super.setup();
    }



    @Test
    public void testCheckCarInList(){
        /**
         * TestData
         */
        String url = PropertyManager.getInstance().getUrl();
        ArrayList<String> carList = new ArrayList<>();
        int waitingTime = PropertyManager.getInstance().getExplicityWait();

        ArrayList<String> catNames = new ArrayList<>();
        catNames.add("BMN");
        catNames.add("Lexus");

        /**
         * Test
         */
        driver.get(url);
        logger.info("Open url :" + url);

        carPage.getMarkaField().click();
        uttils.waitForPresent(driver, "//a[@class='tdnone block c27 brbott-4 category-choose category_choose1133 search-choose']");

        //add to array all car list from site
        for (int i = 0; i < carPage.getCarList().size(); i++) {
            carList.add(carPage.getCarList().get(i).getText());
        }

        //looking expected cars in an array
        Assert.assertTrue(uttils.isExist(catNames));
        logger.info("\n");

    }

    @AfterMethod()
    public void clear(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            logger.info(result.getThrowable() + "\n");
        }
    }


}

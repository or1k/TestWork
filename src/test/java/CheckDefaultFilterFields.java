
import Utils.PropertyManager;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CheckDefaultFilterFields extends BaseTest {

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
    }


    @Test
    public void testDefauldFieldsValues() {
        /**
         * TestData
         */
        String url = PropertyManager.getInstance().getUrl();


        /**
         * Test
         */
        driver.get(url);
        logger.info("Open url: " + url);
            Assert.assertEquals(carPage.getPriceFromField().getText(), "Цена от (грн.)");
            Assert.assertEquals(carPage.getPriceToField().getText(), "Цена до (грн.)");
            Assert.assertEquals(carPage.getYearFromField().getText(), "Год выпуска от");
            Assert.assertEquals(carPage.getYearToField().getText(), "Год выпуска до");
            Assert.assertEquals(carPage.getMileageFromField().getText(), "Пробег от");
            Assert.assertEquals(carPage.getMileageToField().getText(), "Пробег до");
            Assert.assertEquals(carPage.getEngineFromField().getText(), "Объем двигателя от");
            Assert.assertEquals(carPage.getEngineToField().getText(), "Объем двигателя до");
            Assert.assertEquals(carPage.getAreaField().getText(), "Район");
            Assert.assertEquals(carPage.getCarTypeField().getText(), "Тип кузова");
            Assert.assertEquals(carPage.getCarColorField().getText(), "Цвет");
            Assert.assertEquals(carPage.getCarConditionField().getText(), "Состояние машины");
            Assert.assertEquals(carPage.getCarClearedField().getText(), "Растаможена");
            Assert.assertEquals(carPage.getFuelTypeField().getText(), "Вид топлива");
            Assert.assertEquals(carPage.getTransmisionField().getText(), "Коробка передач");
            Assert.assertEquals(carPage.getCarOptionField().getText(), "Доп. опции");
            logger.info("All fields are set by default.");
    }

    @AfterMethod()
    public void clear(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            logger.info(result.getThrowable() + "\n");
        }
    }

}

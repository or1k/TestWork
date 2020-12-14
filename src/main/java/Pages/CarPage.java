package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarPage {
    public WebDriver driver;


    public CarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//div[contains(@class, 'filter-item filter-item-from rel numeric-item price')]//span[@class='header block']")
    private WebElement priceFromField;

    @FindBy(xpath = "//label[@class='num-input block rel']/input")
    private WebElement activeField;

    @FindBy(xpath = "//div[contains(@class, 'filter-item filter-item-to rel numeric-item price')]//span[@class='header block']")
    private WebElement priceToField;

    @FindBy(xpath = "//ul[@id='param-grid-3']//div[@class='filter-item filter-item-from rel numeric-item  ']//span[@class='header block']")
    private WebElement yearFromField;

    @FindBy(xpath = "//ul[@id='param-grid-3']//div[@class='filter-item filter-item-to rel numeric-item  ']//span[@class='header block']")
    private WebElement yearToField;

    @FindBy(xpath = "//ul[@id='param-grid-4']//div[@class='filter-item filter-item-from rel numeric-item  ']//span[@class='header block']")
    private WebElement mileageFromField;

    @FindBy(xpath = "//ul[@id='param-grid-4']//div[@class='filter-item filter-item-to rel numeric-item  ']//span[@class='header block']")
    private WebElement mileageToField;

    @FindBy(xpath = "//ul[@id='param-grid-4']//div[@class='filter-item filter-item-to rel numeric-item']//span[@class='header block']")
    private WebElement mileageToButton;

    @FindBy(xpath = "//div[@class='filter-item filter-item-to rel numeric-item filterActive']//li")
    private List <WebElement> maileAgeList;

    @FindBy(xpath = "//ul[@id='param-grid-5']//div[@class='filter-item filter-item-from rel numeric-item  ']//span[@class='header block']")
    private WebElement engineFromField;

    @FindBy(xpath = "//ul[@id='param-grid-5']//div[@class='filter-item filter-item-to rel numeric-item  ']//span[@class='header block']")
    private WebElement engineToField;

    @FindBy(xpath = "//li[@id='param_district']//span[1]")
    private WebElement areaField;

    @FindBy(xpath = "//li[@data-key='car_body']//span[1]")
    private WebElement carTypeField;

    @FindBy(xpath = "//li[@data-key='fuel_type']//span[1]")
    private WebElement fuelTypeField;

    @FindBy(xpath = "//li[@data-key='color']//span[1]")
    private WebElement carColorField;

    @FindBy(xpath = "//li[@data-key='transmission_type']//span[1]")
    private WebElement transmisionField;

    @FindBy(xpath = "//li[@data-key='condition']//span[1]")
    private WebElement carConditionField;

    @FindBy(xpath = "//li[@data-key='car_option']//span[1]")
    private WebElement carOptionField;

    @FindBy(xpath = "//li[@data-key='cleared_customs']//span[1]")
    private WebElement carClearedField;

    @FindBy(xpath = "//li[@id='param_subcat']//span[@class='3rd-category-choose-label header block']")
    private WebElement markaField;

    @FindBy(xpath = "//ul[@class='small suggestinput bgfff lheight20 br-3 abs subcategories binded']/li/a")
    private List<WebElement> carList;

    @FindBy(xpath = "//*[@id='param_price']/div/div[1]/label")
    private WebElement labelAfterInput;

    @FindBy(xpath = "//dl[@id='targetorder-select-gallery']")
    private WebElement cheepFilterButton;

    @FindBy(xpath = "//dl[@id='targetorder-select-gallery']//li[2]")
    private WebElement cheapestSelect;

    @FindBy(xpath = "//div[@class='hasPromoted section clr']/h2")
    private WebElement h2Title;

    @FindBy(xpath = "//table[@id='offers_table']//p[@class='price']")
    private List <WebElement> priceList;

    @FindBy(xpath = "//ul[@class='small suggestinput bgfff lheight20 br-3 abs select binded']//label")
    private List <WebElement> transmissionList;

    @FindBy(xpath = "//ul[@class='small suggestinput bgfff lheight20 br-3 abs select binded']//label/input")
    private List <WebElement> transmissionCheckboxStatus;

    @FindBy(xpath = "//section[@id='body-container']//table[2]//tbody")
    private WebElement footer;



    public void selectCheaperFilter(){
        getCheepFilterButton().click();
        getCheapestSelect().click();
    }

    public WebElement getPriceFromField() {
        return priceFromField;
    }

    public WebElement getPriceToField() {
        return priceToField;
    }

    public WebElement getYearFromField() {
        return yearFromField;
    }

    public WebElement getYearToField() {
        return yearToField;
    }

    public WebElement getMileageFromField() {
        return mileageFromField;
    }

    public WebElement getMileageToField() {
        return mileageToField;
    }

    public WebElement getEngineFromField() {
        return engineFromField;
    }

    public WebElement getEngineToField() {
        return engineToField;
    }

    public WebElement getAreaField() {
        return areaField;
    }

    public WebElement getCarTypeField() {
        return carTypeField;
    }

    public WebElement getFuelTypeField() {
        return fuelTypeField;
    }

    public WebElement getCarColorField() {
        return carColorField;
    }

    public WebElement getTransmisionField() {
        return transmisionField;
    }

    public WebElement getCarConditionField() {
        return carConditionField;
    }

    public WebElement getCarOptionField() {
        return carOptionField;
    }

    public WebElement getCarClearedField() {
        return carClearedField;
    }

    public WebElement getMarkaField() {
        return markaField;
    }

    public List<WebElement> getCarList() {
        return carList;
    }

    public WebElement getActiveField() {
        return activeField;
    }

    public WebElement getLabelAfterInput() {
        return labelAfterInput;
    }

    public List<WebElement> getMaileAgeList() {
        return maileAgeList;
    }

    public WebElement getMileageToButton() {
        return mileageToButton;
    }

    public WebElement getCheepFilterButton() {
        return cheepFilterButton;
    }

    public List<WebElement> getPriceList() {
        return priceList;
    }

    public List<WebElement> getTransmissionList() {
        return transmissionList;
    }

    public List<WebElement> getTransmissionCheckboxStatus() {
        return transmissionCheckboxStatus;
    }

    public WebElement getCheapestSelect() {
        return cheapestSelect;
    }

    public WebElement getFooter() {
        return footer;
    }
}

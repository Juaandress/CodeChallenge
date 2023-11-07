package tasks;

import interactions.BrowserInteractions;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;

import static core.WebDriverSingleton.getDriver;
import static enums.Timeouts.TIMEOUT_10_SECONDS;
import static enums.Timeouts.TIMEOUT_5_SECONDS;

public class GoogleTasks {
    private WebDriver driver;
    public GoogleTasks(WebDriver driver) {
        this.driver = driver;
    }
    private BrowserInteractions browserInteractions;
    private GooglePage googlePage = new GooglePage(getDriver());


    public void clickOnSearchBox() {
//        browserInteractions.waitForElementToBeClickable(googlePage.getSearchBox(), TIMEOUT_10_SECONDS);
        browserInteractions.clickOn(getDriver(), googlePage.getSearchBox());
    }


    public void searchForItem(String product) {
        browserInteractions.waitForElementToBeClickable(googlePage.getSearchBox(), TIMEOUT_10_SECONDS);
        browserInteractions.sendKeys(product, TIMEOUT_5_SECONDS, googlePage.getSearchBox());
    }


    public void saveGoogleTemperatureInAnObject() {
        browserInteractions.waitForPageToLoad(getDriver(), TIMEOUT_5_SECONDS);
        Integer temperatureFromGoogle = Integer.parseInt(googlePage.getTemperatureNumber().getText());
//        setSessionVariable(TEMPERATURE_FROM_GOOGLE).to(temperatureFromGoogle);
    }
}

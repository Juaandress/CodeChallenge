package web.tasks;

import net.thucydides.core.annotations.Steps;
import web.interactions.AssertionInteractions;
import web.interactions.BrowserInteractions;
import web.userinterfaces.GooglePage;

import static net.serenitybdd.core.Serenity.setSessionVariable;
import static web.enums.SerenityVariables.TEMPERATURE_FROM_GOOGLE;
import static web.enums.Timeouts.TIMEOUT_10_SECONDS;
import static web.enums.Timeouts.TIMEOUT_5_SECONDS;
import static web.enums.endpoints.GOOGLE_SEARCH;

public class GoogleTasks extends GooglePage {

    @Steps
    AssertionInteractions assertions;
    @Steps
    private BrowserInteractions browserInteractions;

    public void clickOnSearchBox() {
        browserInteractions.waitForElementToBeClickable(getSearchBox());
        browserInteractions.clickOn(getSearchBox());
    }


    public void goToGoogleSearchPage() {
        getDriver().get(GOOGLE_SEARCH.getURL());
    }

    public void searchForItem(String product) {
        browserInteractions.waitForElementToBeClickable(getSearchBox(), TIMEOUT_10_SECONDS);
        browserInteractions.sendKeys(product, TIMEOUT_5_SECONDS, getSearchBox());
    }


    public void saveGoogleTemperatureInAnObject() {
        browserInteractions.waitForPageToLoad(getDriver(), TIMEOUT_5_SECONDS);
        Integer temperatureFromGoogle = Integer.parseInt(getTemperatureNumber().getText());
        setSessionVariable(TEMPERATURE_FROM_GOOGLE).to(temperatureFromGoogle);
    }
}

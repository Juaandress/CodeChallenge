package stepdefinitions;

import interactions.BrowserInteractions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.GooglePage;
import tasks.GoogleTasks;
import tasks.OpenWeatherAPITasks;

import java.util.List;

import static core.WebDriverSingleton.getDriver;

public class GoogleSteps {
    GooglePage googlePage = new GooglePage(getDriver());

    GoogleTasks googleTasks = new GoogleTasks(getDriver());

    public GoogleSteps(GoogleTasks googleTasks) {
        this.googleTasks = googleTasks;
    }
    BrowserInteractions browserInteractions;
    OpenWeatherAPITasks openWeatherAPITasks;

    @And("I Enter the text {string} in the Search bar and submit")
    public void iEnterTheTextInTheSearchBarAndSubmit(String location) {
        googleTasks.clickOnSearchBox();
        googleTasks.searchForItem(location);
        List<WebElement> searchButton = googlePage.getSearchButton();
        WebElement element = searchButton.get(0);
        browserInteractions.clickOn(getDriver(), element);
    }

    @And("I save the Temperature in the selected location from the results and store the value in an object")
    public void iSaveTheTemperatureInTheSelectedLocationFromTheResultsAndStoreTheValueInAnObject() {
        googleTasks.saveGoogleTemperatureInAnObject();
    }

    @Then("I validate the temperature difference between the results in fourth and fifth steps")
    public void iValidateTheTemperatureDifferenceBetweenTheResultsInFourthAndFifthSteps() {
        openWeatherAPITasks.validateTemperatureDifferenceBetweenGoogleAndOpenWeatherApi();
    }
}

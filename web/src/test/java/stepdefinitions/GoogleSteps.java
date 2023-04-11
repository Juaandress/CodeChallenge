package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;
import web.interactions.BrowserInteractions;
import web.tasks.GoogleTasks;
import web.tasks.OpenWeatherAPITasks;
import web.userinterfaces.GooglePage;

import java.util.List;

public class GoogleSteps extends GooglePage {

    @Steps
    private GoogleTasks googleTasks;

    @Steps
    BrowserInteractions browserInteractions;

    @Steps
    OpenWeatherAPITasks openWeatherAPITasks;

    @Given("I am in Google Search Page")
    public void iGoToGoogleSearchPage() {
        googleTasks.goToGoogleSearchPage();
    }

    @And("I Enter the text {string} in the Search bar and submit")
    public void iEnterTheTextInTheSearchBarAndSubmit(String location) {
        googleTasks.clickOnSearchBox();
        googleTasks.searchForItem(location);
        List<WebElement> searchButton = getSearchButton();
        googleTasks.clickOn(searchButton.get(0));
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

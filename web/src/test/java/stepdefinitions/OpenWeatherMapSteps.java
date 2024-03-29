package stepdefinitions;

import io.cucumber.java.en.And;
import interactions.BrowserInteractions;
import tasks.OpenWeatherAPITasks;

public class OpenWeatherMapSteps {

    String API_KEY = "90886e893ae698f74a476657e513b4ff";

    OpenWeatherAPITasks openWeatherAPITasks;


    BrowserInteractions browserInteractions;

    @And("I go to OpenWeatherMap Page")
    public void iGoToOpenWeatherMapPage() {
        openWeatherAPITasks.goToOpenWeatherPage();
    }


    @And("^I Make a call to the OpenWeatherMap API to retrieve weather data for ([^\"]*)$")
    public void iMakeACallToTheOpenWeatherMapAPIToRetrieveWeatherDataFor(String location) {
//        browserInteractions.waitForPageToLoad(browserInteractions.getDriver(), Timeouts.TIMEOUT_10_SECONDS);
        openWeatherAPITasks.getTemperatureFromOpenWeatherAPI(location, API_KEY);
    }
}



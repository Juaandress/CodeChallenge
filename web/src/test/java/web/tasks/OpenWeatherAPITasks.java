package web.tasks;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import web.interactions.AssertionInteractions;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static web.enums.Errors.DIFFERENCE_MESSAGE;
import static web.enums.SerenityVariables.TEMPERATURE_FROM_API;
import static web.enums.SerenityVariables.TEMPERATURE_FROM_GOOGLE;
import static web.enums.endpoints.API_URL;
import static web.enums.endpoints.OPEN_WEATHER;

public class OpenWeatherAPITasks {

    @Steps
    AssertionInteractions assertions;

    public void goToOpenWeatherPage() {
        getDriver().get(OPEN_WEATHER.getURL());

    }

    public Response getTemperature(String location, String apiKey) {

        return given()
                .queryParam("q", location)
                .queryParam("appid", apiKey)
                .when()
                .get(API_URL.getURL());
    }

    private Double getTemperatureInCelsiusFromApiLocation(String location, String apiKey) {
        Response response = getTemperature(location, apiKey);
        JsonPath jsonPath = response.jsonPath();
        double temperatureInKelvin = jsonPath.getDouble("main.temp");
        return (temperatureInKelvin - 273.15);
    }

    public void getTemperatureFromOpenWeatherAPI(String location, String apiKey) {
        setSessionVariable(TEMPERATURE_FROM_API).to(getTemperatureInCelsiusFromApiLocation(location, apiKey));
    }

    public void validateTemperatureDifferenceBetweenGoogleAndOpenWeatherApi() {
        Double temperatureFromOpenWeatherAPI = Serenity.sessionVariableCalled(TEMPERATURE_FROM_API);
        int temperatureFromApiInteger = temperatureFromOpenWeatherAPI.intValue();
        int temperatureFromGoogleWebInterfaz = Serenity.sessionVariableCalled(TEMPERATURE_FROM_GOOGLE);
        assertions.validateDifference(temperatureFromGoogleWebInterfaz, temperatureFromApiInteger, DIFFERENCE_MESSAGE);

    }
}

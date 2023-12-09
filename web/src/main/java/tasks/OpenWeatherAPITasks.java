package tasks;

import interactions.AssertionInteractions;

import static core.WebDriverSingleton.getDriver;
import static enums.endpoints.OPEN_WEATHER;

public class OpenWeatherAPITasks {


    AssertionInteractions assertions = new AssertionInteractions();

    public void goToOpenWeatherPage() {
        getDriver().get(OPEN_WEATHER.getURL());

    }

//TODO: Do another implementation with Rest Assured for these methods
//    public Response getTemperature(String location, String apiKey) {
//
//        return given()
//                .queryParam("q", location)
//                .queryParam("appid", apiKey)
//                .when()
//                .get(API_URL.getURL());
//    }

//    private Double getTemperatureInCelsiusFromApiLocation(String location, String apiKey) {
//        Response response = getTemperature(location, apiKey);
//        JsonPath jsonPath = response.jsonPath();
//        double temperatureInKelvin = jsonPath.getDouble("main.temp");
//        return (temperatureInKelvin - 273.15);
//    }

    public void getTemperatureFromOpenWeatherAPI(String location, String apiKey) {
        //TODO: Update this setSessionVariable with another way of handle session variables
//        setSessionVariable(TEMPERATURE_FROM_API).to(getTemperatureInCelsiusFromApiLocation(location, apiKey));
    }

    public void validateTemperatureDifferenceBetweenGoogleAndOpenWeatherApi() {
//        Double temperatureFromOpenWeatherAPI = sessionVariableCalled(TEMPERATURE_FROM_API);
//        int temperatureFromApiInteger = temperatureFromOpenWeatherAPI.intValue();
//        int temperatureFromGoogleWebInterfaz = sessionVariableCalled(TEMPERATURE_FROM_GOOGLE);
//        assertions.validateDifference(temperatureFromGoogleWebInterfaz, temperatureFromApiInteger, DIFFERENCE_MESSAGE);

    }
}

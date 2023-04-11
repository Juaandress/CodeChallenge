Feature: Google Search

  @GoogleSearch
  Scenario Outline: searches for Weather conditions for a specific location
    Given I am in Google Search Page
    When I Enter the text "Weather in <location>" in the Search bar and submit
    And I save the Temperature in the selected location from the results and store the value in an object
    And I go to OpenWeatherMap Page
    And I Make a call to the OpenWeatherMap API to retrieve weather data for <location>
    Then I validate the temperature difference between the results in fourth and fifth steps
    Examples:
      | location      |
      | San Francisco |
      | California    |
      | Colorado      |
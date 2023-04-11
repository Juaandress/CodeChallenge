package web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum endpoints {

    GOOGLE_SEARCH("https://www.google.com"),
    OPEN_WEATHER("https://api.openweathermap.org/"),
    API_URL("https://api.openweathermap.org/data/2.5/weather");

    private final String URL;
}


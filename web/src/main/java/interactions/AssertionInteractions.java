package interactions;


import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import enums.Errors;

@Log
public class AssertionInteractions {


    public void validateDifference(int temperatureFromWeb, int temperaturaFromAPI, Errors errorMessage) {
        Assertions.assertThat(temperatureFromWeb).isEqualTo(temperaturaFromAPI)
                .withFailMessage(errorMessage.getErrorMessage() + " %s", temperatureFromWeb - temperaturaFromAPI);
    }
}

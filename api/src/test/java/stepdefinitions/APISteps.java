package stepdefinitions;

import io.cucumber.java.en.*;

public class APISteps {
    @Given("^I send a GET request to the endpoint$")
    public void sendGETRequest(){

    }

    @Then("^I get a list of (\\d+) users$")
    public void validateListOfUsers(int expectedUserSize){
        
    }
}

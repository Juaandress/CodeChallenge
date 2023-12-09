package stepdefinitions;

import interactions.BrowserInteractions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static core.WebDriverSingleton.getDriver;

public class CommonSteps {

    BrowserInteractions browserInteractions = new BrowserInteractions();

    @Given("I go to page: {string} using {string} browser")
    public void iGoToPage(String pageName, String browser) {
        System.setProperty("webdriver.type", browser);
        getDriver(browser).manage().window().maximize();
        getDriver(browser).get(pageName);
    }

    @Given("I go to page: {string}")
    public void iGoToPage(String pageName) {
        getDriver(null).manage().window().maximize();
        getDriver(null).get(pageName);
    }

    @Then("I validate title of the page is {string}")
    public void iValidateTitleOfThePageIs(String page) {
        browserInteractions.validateTitleOfThePage(page);
    }
}



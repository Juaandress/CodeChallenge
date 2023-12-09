package stepdefinitions.hooks;

import io.cucumber.java.After;

import static core.WebDriverSingleton.quitDriver;

public class AfterTestHook {

    @After
    public static void tearDown() {
        // Close the WebDriver to free up resources
        quitDriver();
    }
}

package core;

import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriver driver = null;

    private WebDriverSingleton() {
        // This is a private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = WebDriverSetup.initializeDriver(null);
        }
        return driver;
    }

    public static WebDriver getDriver(String browserType) {
        if (driver == null) {
            driver = WebDriverSetup.initializeDriver(browserType);
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // This is set to null after quitting to indicate it's no longer in use
        }
    }
}

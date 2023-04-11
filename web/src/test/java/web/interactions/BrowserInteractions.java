package web.interactions;

import lombok.extern.java.Log;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.enums.Timeouts;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static web.enums.Timeouts.TIMEOUT_30_SECONDS;

@Log
public class BrowserInteractions extends PageObject {

    public void waitForElementToBeClickable(WebElement element, Timeouts timeOut) {
        try {
            withTimeoutOf(Duration.ofSeconds(timeOut.getSeconds())).waitFor(elementToBeClickable(element));
        } catch (Exception e) {
            log.info(String.format("Cannot wait, with message: %s", e.getMessage()));
        }
    }

    public void waitForPageToLoad(WebDriver driver, Timeouts timeOut) {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut.getSeconds()));
        } catch (Exception e) {
            log.info(String.format("Cannot wait, with message: %s", e.getMessage()));
        }
    }


    public void sendKeys(String keys, Timeouts timeOut, WebElement webElement) {
        waitForElementToBeClickable(webElement, timeOut);
        clickOn(webElement);
        webElement.sendKeys(keys);
    }

    public void waitForElementToBeClickable(WebElement element) {
        (new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT_30_SECONDS.getSeconds()))).until(ExpectedConditions.elementToBeClickable(element));
    }
}

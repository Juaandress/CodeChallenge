package interactions;

import enums.Timeouts;
import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.WebDriverSingleton.getDriver;
import static java.time.Duration.ofSeconds;
@Log
public class BrowserInteractions {


    public void clickOn(WebDriver driver, WebElement element) {
        element.click();
    }

    public void waitForElementToBeClickable(WebElement element, Timeouts timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeOut.getSeconds()));
            wait.until(ExpectedConditions.elementToBeClickable(element));


        } catch (Exception e) {
            log.info(String.format("Cannot wait, with message: %s", e.getMessage()));
        }
    }

    public void waitForPageToLoad(WebDriver driver, Timeouts timeOut) {
        try {
            driver.manage().timeouts().pageLoadTimeout(ofSeconds(timeOut.getSeconds()));
        } catch (Exception e) {
            log.info(String.format("Cannot wait, with message: %s", e.getMessage()));
        }
    }


    public void sendKeys(String keys, Timeouts timeOut, WebElement webElement) {
        waitForElementToBeClickable(webElement, timeOut);
//        clickOn(webElement);
        webElement.sendKeys(keys);
    }

    public void hoverOn(WebElement solutionsHeader) {
        Actions action = new Actions(getDriver());
        action.moveToElement(solutionsHeader).perform();
    }


    public void validateTitleOfThePage(String page) {
        waitForPageToLoad(getDriver(), Timeouts.TIMEOUT_10_SECONDS);
        String titleOfThePage = getDriver().getTitle();

        Assertions.assertThat(titleOfThePage.equals(page))
                .describedAs(String.format("Title was expected to be %s, but it was %s",page, getDriver().getTitle()))
                .isTrue();
    }

    public void scrollToElement(WebElement element){
        Actions action = new Actions(getDriver());
        action.scrollToElement(element);
    }
}

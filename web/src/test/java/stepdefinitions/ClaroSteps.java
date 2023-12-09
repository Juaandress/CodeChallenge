package stepdefinitions;

import enums.Timeouts;
import interactions.BrowserInteractions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.ClaroPage;

import static core.WebDriverSingleton.getDriver;

public class ClaroSteps {

    ClaroPage claroPage = new ClaroPage(getDriver());
    BrowserInteractions browserInteractions = new BrowserInteractions();
    @When("I click on Accept All Cookies")
    public void iClickOnAcceptAllCookies() {
        browserInteractions.waitForPageToLoad(getDriver(), Timeouts.TIMEOUT_10_SECONDS);
        browserInteractions.clickOn(getDriver(), claroPage.getAcceptAllCookies());
    }

    @And("I hover the Solutions Header Section")
    public void iHoverTheSolutionHeaderSection(){
        browserInteractions.waitForElementToBeClickable(claroPage.getSolutionsHeader(), Timeouts.TIMEOUT_10_SECONDS);
        WebElement solutionsHeader = claroPage.getSolutionsHeader();
        browserInteractions.hoverOn(solutionsHeader);
    }

    @And("I click on MPLS button")
    public void iClickOnMPLSButton() {
        browserInteractions.waitForElementToBeClickable(claroPage.getMPLSButton(), Timeouts.TIMEOUT_10_SECONDS);
        claroPage.getMPLSButton().click();
    }


    @And("I scroll to Contact US section")
    public void iScrollToContactUSSection() {
        browserInteractions.waitForPageToLoad(getDriver(), Timeouts.TIMEOUT_10_SECONDS);
        browserInteractions.scrollToElement(claroPage.getContactUsSection());
    }


    @When("I load the user information:")
    public void iLoadTheUserInformation(DataTable dataTable) {

    }


    @And("I check the By submitting my info checkbox")
    public void iCheckTheBySubmittingMyInfoCheckbox() {
    }



}

package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.PageFactory;

public class CommonSteps extends PageObject {

    @Before
    public void setUp() {
        PageFactory.initElements(getDriver(), this);
    }

    @After
    public void tearDown() {
        getDriver().quit();
    }


}



package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.thucydides.core.pages.PageObject;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = {"src/test/resources/features"}
        , glue = {"stepdefinitions"}
        , tags = "@GoogleSearch"
)
public class Runner extends PageObject {
}


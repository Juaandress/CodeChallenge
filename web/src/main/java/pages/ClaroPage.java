package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ClaroPage extends BasePage {

    public ClaroPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "div > #onetrust-accept-btn-handler ")
    private WebElement acceptAllCookies;

    @FindBy(css = "div.text-block-3")
    private WebElement solutionsHeader;

    @FindBy(css = "#w-dropdown-list-1 div.div-menu > div:nth-child(2) > div > div > div > div:nth-child(10) > a ")
    private WebElement MPLSButton;

    @FindBy(id = "contactus")
    private WebElement contactUsSection;

    @FindBy(css = "p.first_name > input")
    private WebElement firstName;

}

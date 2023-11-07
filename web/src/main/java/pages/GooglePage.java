package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".gLFyf#APjFqb")
    private WebElement searchBox;

    @FindBy(id = "wob_tm")
    private WebElement temperatureNumber;

    @FindBy(css = ".gNO89b[name*=btnK]")
    private List<WebElement> searchButton;

    @FindBy(css = ".lnXdpd[alt*=\"Google\"]")
    private WebElement googleLogo;


}

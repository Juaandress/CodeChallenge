package web.userinterfaces;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class GooglePage extends PageObject {

    @FindBy(css = ".gLFyf#APjFqb")
    private WebElement searchBox;

    @FindBy(id = "wob_tm")
    private WebElement temperatureNumber;

    @FindBy(css = ".gNO89b[name*=btnK]")
    private List<WebElement> searchButton;

    @FindBy(css = ".lnXdpd[alt*=\"Google\"]")
    private WebElement googleLogo;
}

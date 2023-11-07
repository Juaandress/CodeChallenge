package core;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class WebDriverSetup {

    public static WebDriver initializeDriver(String browserType) {
        WebDriver driver = null;
        Properties webdriverType = new Properties();
        InputStream input = null;

        try {
            if (browserType == null || browserType.isEmpty()) {
                input = new FileInputStream("src/main/resources/configurationFiles/configuration.properties");
                webdriverType.load(input);
                browserType = webdriverType.getProperty("webdriver.type");
            }

            System.setProperty("webdriver.http.factory", "jdk-http-client");
            ChromeOptions chromeOptions = new ChromeOptions();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            EdgeOptions edgeOptions = new EdgeOptions();

//            String remoteAllowOrigins = "--remote-allow-origins=*";
//
//            chromeOptions.addArguments(remoteAllowOrigins);
//            firefoxOptions.addArguments(remoteAllowOrigins);
//            edgeOptions.addArguments(remoteAllowOrigins);

            if (browserType != null) {
                switch (browserType.toLowerCase()) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver.exe");
                        driver = new ChromeDriver(chromeOptions);
                        break;
                    case "firefox":
                        System.setProperty("webdriver.gecko.driver", "src/main/resources/webdriver/geckodriver.exe");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "edge":
                        System.setProperty("webdriver.edge.driver", "src/main/resources/webdriver/msedgedriver.exe");
                        driver = new EdgeDriver(edgeOptions);
                        break;
                    default:
                        System.out.println("Unsupported browser type. Please provide valid browser type.");
                }
            } else {
                System.out.println("No browser type provided. Please specify a browser type.");
            }

        } catch (IOException e) {
            log.error("Error reading configuration: {}", e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    log.error("Error reading configuration: {}", e.getMessage());
                }
            }
        }
        return driver;


    }
}
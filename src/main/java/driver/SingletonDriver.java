package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;

public class SingletonDriver {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private SingletonDriver() {
    }

    public static void getWebDriverInstance() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            webDriverThreadLocal.remove();
        });
    }
}

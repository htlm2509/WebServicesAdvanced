package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Optional;

public class SingletonDriver {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private SingletonDriver() {
    }

    public static void getWebDriverInstance(String driverName) {
        switch (driverName.toLowerCase()) {
            case "firefox":
                setFirefoxInstance();
                break;
            case "chrome":
                setChromeInstance();
                break;
            default:
                break;
        }
    }

    private static void setChromeInstance() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        webDriverThreadLocal.set(driver);
    }

    private static void setFirefoxInstance() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("webdriver.firefox.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(firefoxOptions);
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

package cucumber.hooks;

import driver.SingletonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverHooks {

    protected static WebDriver driver;

    @Before
    public void setUpTest() {
        SingletonDriver.getWebDriverInstance("chrome");
        driver = SingletonDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        SingletonDriver.quitDriver();
    }
}

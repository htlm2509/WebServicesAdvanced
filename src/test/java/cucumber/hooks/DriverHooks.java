package cucumber.hooks;

import driver.SingletonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class DriverHooks {

    protected static WebDriver driver;

    @Before
    public void setUpTest() {
        SingletonDriver.getWebDriverInstance();
        driver = SingletonDriver.getDriver();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        SingletonDriver.quitDriver();
    }
}

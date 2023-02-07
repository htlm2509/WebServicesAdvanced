package tests;

import desktop.fragments.DragAndDropPage;
import driver.SingletonDriver;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver driver;

    protected SoftAssertions softAssertions  = new SoftAssertions();

    protected DragAndDropPage dragAndDropPage;

    @BeforeEach
    void setUp() {
        SingletonDriver.getWebDriverInstance();
        driver = SingletonDriver.getDriver();
        driver.manage().deleteAllCookies();

        dragAndDropPage = new DragAndDropPage();
    }

    @AfterEach
    void tearDown() {
        SingletonDriver.quitDriver();
    }
}
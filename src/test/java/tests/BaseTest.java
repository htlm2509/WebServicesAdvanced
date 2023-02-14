package tests;

import constants.Constants;
import desktop.fragments.DragAndDropPage;
import desktop.fragments.HomePage;
import desktop.fragments.NavigationBarComponent;
import driver.SingletonDriver;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver driver;

    protected SoftAssertions softAssertions  = new SoftAssertions();

    protected DragAndDropPage dragAndDropPage;

    protected HomePage homePage;

    protected NavigationBarComponent navigationBar;

    @BeforeEach
    void setUp() {
        SingletonDriver.getWebDriverInstance("firefox");
        driver = SingletonDriver.getDriver();
        driver.manage().deleteAllCookies();

        dragAndDropPage = new DragAndDropPage();
        homePage = new HomePage();
        navigationBar = new NavigationBarComponent();
        driver.navigate().to(Constants.HOME_PAGE_URL);
    }

    @AfterEach
    void tearDown() {
        SingletonDriver.quitDriver();
    }
}
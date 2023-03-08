package junit.bookdepository;

import constants.*;
import desktop.fragments.bookdepository.*;
import driver.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.*;

class NavigationBarTest {

    private WebDriver driver;

    BDNavigationBarComponent navigationBar;

    @BeforeEach
    void setUp() {
        SingletonDriver.getWebDriverInstance("chrome");
        driver = SingletonDriver.getDriver();
        driver.manage().deleteAllCookies();
        driver.get(BDConstants.HOME_PAGE_URL);

        navigationBar = new BDNavigationBarComponent();
    }

    @AfterEach
    void tearDown() {
        SingletonDriver.quitDriver();
    }

    @Test
    void verifyContactUsPageIsOpened() {
        navigationBar.goToContactUsPage();
        assertEquals(BDConstants.CONTACT_US_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    void verifyFreeDeliveryWorldwidePagePageIsOpened() {
        navigationBar.goToFreeDeliveryWorldwidePage();
        assertEquals(BDConstants.FREE_DELIVERY_WORLDWIDE_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    void verifyOrderStatusPageIsOpened() {
        navigationBar.goToOrderStatusPage();
        assertEquals(BDConstants.ORDER_STATUS_PAGE_URL, driver.getCurrentUrl());
    }

    @Test @Disabled ("will return false. cannot proceed to wishlist without account")
    void verifyWishlistPageIsOpened() {
        navigationBar.goToWishlistPage();
        assertEquals(BDConstants.WISHLIST_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    void verifySignInJoinPageUrlPageIsOpened() {
        navigationBar.goToSignInJoinPage();
        assertEquals(BDConstants.SIGN_IN_JOIN_PAGE_URL, driver.getCurrentUrl());
    }
}

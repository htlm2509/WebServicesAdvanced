package tests;

import constants.Constants;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NavigationBarTest extends BaseTest {

    @Test
    void verifyContactUsPageIsOpened() {
        navigationBar.goToContactUsPage();
        assertEquals(Constants.CONTACT_US_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    void verifyFreeDeliveryWorldwidePagePageIsOpened() {
        navigationBar.goToFreeDeliveryWorldwidePage();
        assertEquals(Constants.FREE_DELIVERY_WORLDWIDE_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    void verifyOrderStatusPageIsOpened() {
        navigationBar.goToOrderStatusPage();
        assertEquals(Constants.ORDER_STATUS_PAGE_URL, driver.getCurrentUrl());
    }

    @Test @Disabled ("will return false. cannot proceed to wishlist without account")
    void verifyWishlistPageIsOpened() {
        navigationBar.goToWishlistPage();
        assertEquals(Constants.WISHLIST_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    void verifySignInJoinPageUrlPageIsOpened() {
        navigationBar.goToSignInJoinPage();
        assertEquals(Constants.SIGN_IN_JOIN_PAGE_URL, driver.getCurrentUrl());
    }
}

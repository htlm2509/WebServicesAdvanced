package desktop.fragments;

import abstractpages.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBarComponent extends AbstractFragment {

    @FindBy(xpath = "//div[@class='user-nav']//a[@href='/']")
    WebElement homeIcon;

    @FindBy(xpath = "//div[@class='user-nav']//a[@href='/contactus']")
    WebElement contactUsLink;

    @FindBy(xpath = "//div[@class='user-nav']//a[@href='/help']")
    WebElement helpLink;

    @FindBy(xpath = "//div[@class='user-nav']//a[@href='/help/topic/HelpId/3/Which-countries-do-you-deliver-to#helpContent']")
    WebElement freeDeliveryWorldwideLink;

    @FindBy(xpath = "//div[@class='user-nav']//a[@href='/track']")
    WebElement orderStatusLink;

    @FindBy(xpath = "//div[@class='user-nav']//a[@href='/account/wishlist']")
    WebElement wishlistLink;

    @FindBy(xpath = "//div[@class='user-nav']//a[@href='/account/login/to/account']")
    WebElement signInJoinLink;

    public void goToHomePage() {
        clickButton(homeIcon);
    }

    public void goToContactUsPage() {
        clickButton(contactUsLink);
    }

    public void goToHelpPage() {
        clickButton(helpLink);
    }

    public void goToFreeDeliveryWorldwidePage() {
        clickButton(freeDeliveryWorldwideLink);
    }

    public void goToOrderStatusPage() {
        clickButton(orderStatusLink);
    }

    public void goToWishlistPage() {
        clickButton(wishlistLink);
    }

    public void goToSignInJoinPage() {
        clickButton(signInJoinLink);
    }
}

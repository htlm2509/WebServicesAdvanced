package desktop.fragments;

import abstractpages.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieConsentComponent extends AbstractFragment {

    @FindBy(xpath = "//div[@class='cookie-consent-buttons']//button[@class='btn btn-sm btn-yes']")
    WebElement acceptCookiesButton;

    public void clickAcceptCookiesButton() {
        waitUntilElementIsClickable(acceptCookiesButton);
        clickButton(acceptCookiesButton);
    }
}

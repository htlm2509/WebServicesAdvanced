package desktop.fragments;

import abstractpages.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieConsentComponent extends AbstractFragment {

    @FindBy(xpath = "//div[@class='cookie-consent-buttons']//button[@class='btn btn-sm btn-yes']")
    WebElement acceptCookiesButton;

    public void clickAcceptCookiesButton() {
        if (!SingletonDriver.getDriver()
                .findElements(By.xpath("//div[@class='cookie-consent']"))
                .isEmpty()) {
            clickButton(acceptCookiesButton);
        }
    }
}

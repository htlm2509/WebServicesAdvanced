package desktop.fragments.kruidvat;

import abstractpages.fragment.*;
import driver.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class KRCookieConsent extends AbstractFragment {

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptCookiesButton;

    public void clickAcceptCookiesButton() {
        String cookieConsentModalXpath = "//div[@class='ot-sdk-row']";
        if (!SingletonDriver.getDriver()
                .findElements(By.xpath(cookieConsentModalXpath))
                .isEmpty()) {
            clickButton(acceptCookiesButton);
        }
    }
}

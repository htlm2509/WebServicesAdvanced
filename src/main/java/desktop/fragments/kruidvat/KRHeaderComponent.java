package desktop.fragments.kruidvat;

import abstractpages.fragment.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class KRHeaderComponent extends AbstractFragment {

    @FindBy(xpath = "//input[@class='search-box__input ']")
    WebElement searchField;

    @FindBy(xpath = "//i[@class='icon icon-search']")
    WebElement searchButton;

    @FindBy(xpath = "//i[@class='icon icon-basket']")
    WebElement basketIcon;

    public void enterSearchQuery(String searchQuery) {
        enterTextIntoField(searchField, searchQuery);
    }

    public void clickSearchButton() {
        clickButton(searchButton);
    }

    public void clickBasketIcon() {
        clickButton(basketIcon);
    }
}

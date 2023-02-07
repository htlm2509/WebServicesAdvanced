package desktop.fragments;

import abstractpages.fragment.AbstractFragment;
import abstractpages.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalDialogPage extends AbstractFragment {

    @FindBy(xpath = "//a[@data-default-localized-pattern='Basket / Checkout']")
    private WebElement basketCheckoutButton;

    public void clickBasketCheckoutButton() {
        waitUntilElementIsClickable(basketCheckoutButton);
        clickButton(basketCheckoutButton);
    }
}

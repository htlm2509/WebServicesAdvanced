package desktop.fragments.bookdepository;

import abstractpages.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BDModalDialogPage extends AbstractFragment {

    @FindBy(xpath = "//a[@data-default-localized-pattern='Basket / Checkout']")
    private WebElement basketCheckoutButton;

    public void clickBasketCheckoutButton() {
        waitUntilElementIsClickable(basketCheckoutButton);
        clickButton(basketCheckoutButton);
    }
}

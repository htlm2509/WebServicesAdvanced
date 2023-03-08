package desktop.fragments.bookdepository;

import abstractpages.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BDSearchResultsPage extends AbstractFragment {

    @FindBy(xpath = "//div[@class='book-item']")
    private List<WebElement> listOfBooks;

    public List<WebElement> getListOfBooks() {
        waitUntilPageIsLoaded();
        return new ArrayList<>(listOfBooks);
    }

    public WebElement getBookFromList(String text) {
        return getListOfBooks().stream()
                .filter(book -> book.getText().contains(text))
                .findFirst()
                .orElse(null);
    }

    public void clickAddToBasketByProductName(String name) {
        SingletonDriver.getDriver()
                .findElement(By
                        .xpath("//div[@class='book-item'][.//h3//a[normalize-space(text())='"
                                + name + "']]//a[contains(@class, 'add-to-basket')]"))
                .click();
    }
}

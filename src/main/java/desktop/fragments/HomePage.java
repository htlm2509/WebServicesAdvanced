package desktop.fragments;

import abstractpages.fragment.AbstractFragment;
import abstractpages.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractFragment {

    @FindBy(xpath = "//input[@name='searchTerm']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='header-search-btn']")
    private WebElement searchButton;

    public void enterSearchQuery(String searchQuery) {
        waitUntilPageIsLoaded();
        searchField.sendKeys(searchQuery);
    }

    public void clickSearchButton() {
        clickButton(searchButton);
    }
}
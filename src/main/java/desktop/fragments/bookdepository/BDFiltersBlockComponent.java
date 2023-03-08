package desktop.fragments.bookdepository;

import abstractpages.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BDFiltersBlockComponent extends AbstractFragment {

    @FindBy(xpath = "//select[@name='price']")
    private WebElement priceRangeFilterDropdown;

    @FindBy(xpath = "//select[@name='availability']")
    private WebElement availabilityFilterDropdown;

    @FindBy(xpath = "//select[@name='searchLang']")
    private WebElement languageFilterDropdown;

    @FindBy(xpath = "//select[@name='format']")
    private WebElement formatFilterDropdown;

    @FindBy(xpath = "//button[normalize-space(text())='Refine results']")
    private WebElement refineResultsButton;

    public void selectFromPriceRangeFilterDropdown(String value) {
        selectFromDropdown(priceRangeFilterDropdown, value);
    }
    public void selectFromAvailabilityFilterDropdown(String value) {
        selectFromDropdown(availabilityFilterDropdown, value);
    }
    public void selectFromLanguageFilterDropdown(String value) {
        selectFromDropdown(languageFilterDropdown, value);
    }

    public void selectFromFormatFilterDropdown(String value) {
        selectFromDropdown(formatFilterDropdown, value);
    }

    public void clickRefineResultsButton() {
       waitUntilElementIsClickable(refineResultsButton);
       new Actions(SingletonDriver.getDriver())
               .scrollToElement(formatFilterDropdown)
               .keyDown(Keys.TAB)
               .keyUp(Keys.TAB)
               .keyDown(Keys.ENTER)
               .keyUp(Keys.ENTER)
               .build()
               .perform();
    }
}

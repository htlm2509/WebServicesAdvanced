package abstractpages.fragment;

import driver.SingletonDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WebDriverWaiter;

public abstract class AbstractFragment extends WebDriverWaiter {

    protected AbstractFragment() {
        PageFactory.initElements(SingletonDriver.getDriver(), this);
    }

    protected void selectFromDropdown(WebElement webElement, String text) {
        new Select(webElement).selectByVisibleText(text);
    }

    protected void clickButton(WebElement webElement) {
        webElement.click();
    }

    protected String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    protected String getTextFieldText(WebElement webElement) {
        return webElement.getAttribute("value");
    }

    protected void enterTextIntoField(WebElement webElement, String text) {
        waitUntilElementIsClickable(webElement);
        webElement.sendKeys(text);
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    protected void switchToFrame(WebElement webElement) {
        SingletonDriver.getDriver().switchTo().frame(webElement);
    }

    protected void switchToDefaultContent() {
        SingletonDriver.getDriver().switchTo().defaultContent();
    }
}

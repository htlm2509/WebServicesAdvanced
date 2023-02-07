package utils;

import driver.SingletonDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.SingletonDriver.getDriver;

public class WebDriverWaiter {

    protected WebDriverWait wait;

    public WebDriverWaiter() {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    }

    public void waitUntilPageIsLoaded() {
        new WebDriverWait(SingletonDriver.getDriver(), Duration.ofSeconds(5)).until(CustomConditions.jQueryAJAXsCompleted());
    }

    public void waitUntilElementIsVisible(WebElement webElement) {
        new WebDriverWait(SingletonDriver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementIsClickable(WebElement webElement) {
        new WebDriverWait(SingletonDriver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}

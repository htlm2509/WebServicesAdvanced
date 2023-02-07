package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    private void stringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
        return driver -> {
            assert driver != null;
            return (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return (window.jQuery != null) && (jQuery.active == 0);");
        };
    }
}
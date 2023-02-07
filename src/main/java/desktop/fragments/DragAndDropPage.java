package desktop.fragments;

import abstractpages.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends AbstractFragment {

    @FindBy(xpath = "//div[@id='draggable']")
    WebElement elementToDrag;

    @FindBy(xpath = "//div[@id='droppable']")
    WebElement placeToDrop;

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    WebElement demoFrame;

    public WebElement getDemoFrame() {
        return demoFrame;
    }

    public String getPlaceToDropElementText() {
        return getElementText(placeToDrop);
    }

    public void dragAndDrop() {
        waitUntilElementIsClickable(elementToDrag);
        new Actions(SingletonDriver.getDriver())
                .clickAndHold(elementToDrag)
                .moveToElement(placeToDrop)
                .release(placeToDrop)
                .build()
                .perform();
    }
}

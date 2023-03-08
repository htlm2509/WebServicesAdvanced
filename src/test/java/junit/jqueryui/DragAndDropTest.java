package junit.jqueryui;

import desktop.fragments.jqueryui.*;
import driver.*;
import junit.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static org.assertj.core.api.Assertions.assertThat;

class DragAndDropTest {

    private WebDriver driver;

    JQDragAndDropPage page;

    @BeforeEach
    void setUp() {
        SingletonDriver.getWebDriverInstance("chrome");
        driver = SingletonDriver.getDriver();
        driver.manage().deleteAllCookies();

        page = new JQDragAndDropPage();
    }

    @AfterEach
    void tearDown() {
        SingletonDriver.quitDriver();
    }

    @Test
    void verifyDragAndDrop() {
        driver.navigate().to("https://jqueryui.com/droppable/");
        driver.switchTo().frame(page.getDemoFrame());
        page.dragAndDrop();
        assertThat(page.getPlaceToDropElementText())
                .as("Unexpected element text")
                .isEqualTo("Dropped!");
    }
}

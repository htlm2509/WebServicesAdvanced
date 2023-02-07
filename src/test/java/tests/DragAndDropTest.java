package tests;

import org.junit.jupiter.api.Test;

class DragAndDropTest extends BaseTest {

    @Test
    void verifyDragAndDrop() {
        driver.navigate().to("https://jqueryui.com/droppable/");
        driver.switchTo().frame(dragAndDropPage.getDemoFrame());
        dragAndDropPage.dragAndDrop();
        softAssertions.assertThat(dragAndDropPage.getPlaceToDropElementText())
                .as("Unexpected element text")
                .isEqualTo("Dropped!");
        softAssertions.assertAll();
    }
}

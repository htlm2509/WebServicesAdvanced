package tests;

import constants.Constants;
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

    @Test
    void verifyBookDepositoryHomePageIsOpened() {
        driver.navigate().to(Constants.HOME_PAGE_URL);
        softAssertions.assertThat(driver.getCurrentUrl())
                .as("Unexpected URL")
                .isEqualTo("https://www.bookdepository.com/");
        softAssertions.assertAll();
    }
}

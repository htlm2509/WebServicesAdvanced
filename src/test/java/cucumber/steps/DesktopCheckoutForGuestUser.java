package cucumber.steps;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DesktopCheckoutForGuestUser extends BaseSteps {

    @Given("I am an anonymous customer with clear cookies")
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @When("I open the {string}")
    public void openHomePage(String string) {
        driver.navigate().to(createSiteUrlsMap().get(string));
        cookieConsent.clickAcceptCookiesButton();
    }

    @But("I search for {string}")
    public void enterSearchQuery(String query) {
        bookDepositoryHomePage.enterSearchQuery(query);
        bookDepositoryHomePage.clickSearchButton();
    }

    @But("I am redirected to a {string}")
    public void verifyRedirectedToSearchResultsPage(String page) {
        assertThat(getPageByName(page).checkUrl())
                .as("Not matched")
                .isTrue();
    }

    @But("Search results contain the following products")
    public void searchResultsVerification(DataTable dataTable) {
        List<String> productTitles = dataTable.asList();

        for (String product:
             productTitles) {
            assertThat(bookDepositorySearchResultsPage.getBookFromList(product))
                    .as("The following book is not found: " + product)
                    .isNotNull();
        }
    }

    @But("I apply the following search filters")
    public void filterSearchResults(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        filtersBlock.selectFromAvailabilityFilterDropdown(data.get("Availability"));
        filtersBlock.selectFromPriceRangeFilterDropdown(data.get("Price range"));
        filtersBlock.selectFromLanguageFilterDropdown(data.get("Language"));
        filtersBlock.selectFromFormatFilterDropdown(data.get("Format"));
        filtersBlock.clickRefineResultsButton();
    }

    @Then("Search results contain only the following products")
    public void verifyFilteringResults(DataTable dataTable) {
        List<String> productTitles = dataTable.asList();
        List<WebElement> books = bookDepositorySearchResultsPage.getListOfBooks();
        assertThat(books)
                .as("1234")
                .hasSize(4);
    }

    @When("I click Add to basket button for product with name {string}")
    public void clickAddToBasketButton(String name) {
        bookDepositorySearchResultsPage.clickAddToBasketByProductName(name);
    }

    @But("I select BasketCheckout in basket pop-up")
    public void clickBasketCheckout() {
        modalDialogPage.clickBasketCheckoutButton();
    }

    @Then("I am redirected to the {string}")
    public void verifyRedirectedToBasketPage(String page) {
        assertThat(getPageByName(page).checkUrl())
                .as("Not matched")
                .isTrue();
    }

    @But("Basket order summary is as following:")
    public void verifyBasketOrderSummary(@Transpose DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        softAssertions.assertThat(basketPage.getOrderTotal())
                .as("Unexpected order order Total value")
                .isEqualTo(data.get("Total"));
        softAssertions.assertThat(basketPage.getDeliveryCost())
                .as("Unexpected order Delivery value")
                .isEqualTo(data.get("Delivery cost"));
        softAssertions.assertAll();
    }

    @When("I click Checkout button on Basket page")
    public void clickCheckoutButton() {
        basketPage.clickCheckoutButton();
    }

    @Then("I am redirected to the {string} page")
    public void verifyRedirectedToCheckoutPage(String page) {
        assertThat(getPageByName(page).checkUrl())
                .as("Not matched")
                .isTrue();
    }

    @When("I click Buy Now button")
    public void clickBuyNowButton() {
        paymentPage.clickBuyNowButton();
    }

    @Then("The following validation error messages are displayed on Delivery Address form:")
    public void verifyDeliveryAddressValidationErrorsPresence(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        Map<String, Boolean> validationStatuses = new HashMap<>();
        validationStatuses
                .put(paymentPage.getEmailValidationError(), paymentPage.isEmailValidationErrorDisplayed());
        validationStatuses
                .put(paymentPage.getFullNameValidationError(), paymentPage.isFullNameValidationErrorDisplayed());
        validationStatuses
                .put(paymentPage.getAddressLineOneValidationError(), paymentPage.isAddressLineOneValidationErrorDisplayed());
        validationStatuses
                .put(paymentPage.getTownCityValidationError(), paymentPage.isTownCityValidationErrorDisplayed());
        validationStatuses
                .put(paymentPage.getPostcodeZipValidationError(), paymentPage.isPostcodeZipValidationErrorDisplayed());

        softAssertions.assertThat(validationStatuses.get(data.get("Email address")))
                .as("Email validation error message is not displayed")
                .isTrue();
        softAssertions.assertThat(validationStatuses.get(data.get("Full name")))
                .as("Full name validation error message is not displayed")
                .isTrue();
        softAssertions.assertThat(validationStatuses.get(data.get("Address line 1")))
                .as("Address line 1 validation error message is not displayed")
                .isTrue();
        softAssertions.assertThat(validationStatuses.get(data.get("Town/City")))
                .as("Town/City validation error message is not displayed")
                .isTrue();
        softAssertions.assertThat(validationStatuses.get(data.get("Postcode/ZIP")))
                .as("Postcode/ZIP validation error message is not displayed")
                .isTrue();
        softAssertions.assertAll();
    }

    @And("The following validation error messages are displayed on Payment form:")
    public void verifyPaymentDataValidationErrorsPresence(String validationError) {
        List<String> validationErrors = Arrays.stream(validationError
                        .split(","))
                .collect(Collectors.toList());

        for (String error :
                validationErrors) {
            assertThat(paymentPage.getPaymentDataValidationErrors())
                    .as("The following validation error is not displayed: " + error)
                    .contains(error);
            softAssertions.assertAll();
        }
    }

    @But("Checkout order summary is as following:")
    public void verifyCheckoutOrderSummaryValues(@Transpose DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        softAssertions.assertThat(paymentPage.getOrderSubTotal())
                .as("Unexpected order Sub-Total value")
                .isEqualTo(data.get("Sub-total"));
        softAssertions.assertThat(paymentPage.getOrderTotal())
                .as("Unexpected order Total value")
                .isEqualTo(data.get("Total"));
//        softAssertions.assertThat(paymentPage.getOrderTax())
//                .as("Unexpected order VAT value")
//                .isEqualTo(data.get("VAT"));
        softAssertions.assertThat(paymentPage.getDeliveryCost())
                .as("Unexpected order Delivery value")
                .isEqualTo(data.get("Delivery"));
        softAssertions.assertAll();
    }

    @But("I checkout as a new customer with email {string}")
    public void enterEmailAddress(String email) {
        paymentPage.enterEmailAddress(email);
    }

    @When("I fill delivery address information manually:")
    public void provideShipmentData(@Transpose DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        paymentPage.enterFullName(data.get("Full name"));
        paymentPage.enterAddressOne(data.get("Address line 1"));
        paymentPage.enterAddressTwo(data.get("Address line 2"));
        paymentPage.enterTownCity(data.get("Town/City"));
        paymentPage.enterCountryState(data.get("County/State"));
        paymentPage.enterPostcodeZip(data.get("Postcode"));
        paymentPage.selectFromDeliveryCountryDropdown(data.get("Delivery country"));
    }

    @Then("there is no validation error messages displayed on Delivery Address form")
    public void verifyNoValidationErrorMessagesDisplayed() {
        softAssertions.assertThat(paymentPage.isEmailValidationErrorDisplayed())
                .as("Email field validation error message is displayed")
                .isFalse();
        softAssertions.assertThat(paymentPage.isFullNameValidationErrorDisplayed())
                .as("Full name field validation error message is displayed")
                .isFalse();
        softAssertions.assertThat(paymentPage.isAddressLineOneValidationErrorDisplayed())
                .as("Address line 1 field validation error message is displayed")
                .isFalse();
        softAssertions.assertThat(paymentPage.isTownCityValidationErrorDisplayed())
                .as("Town/City field validation error message is displayed")
                .isFalse();
        softAssertions.assertThat(paymentPage.isPostcodeZipValidationErrorDisplayed())
                .as("Postcode/ZIP field validation error message is displayed")
                .isFalse();
        softAssertions.assertAll();
    }

    @When("I enter my card details")
    public void enterPaymentData(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        driver.switchTo().frame(paymentPage.getCardNumberFrame());
        paymentPage.enterCardNumber(data.get("Card number"));
        driver.switchTo().defaultContent();

        driver.switchTo().frame(paymentPage.getExpirationDateFrame());
        paymentPage.enterExpiryDate(data.get("Expiry date (MM/YY)"));
        driver.switchTo().defaultContent();

        driver.switchTo().frame(paymentPage.getCvvFrame());
        paymentPage.enterCvv(data.get("CVV"));
    }
}

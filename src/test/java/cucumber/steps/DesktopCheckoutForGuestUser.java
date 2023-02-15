package cucumber.steps;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.*;
import org.assertj.core.api.SoftAssertions;
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
        driver.navigate().to(getPageByName(string).getPageUrl());
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
    public void searchResultsVerification(List<String> productTitles) {
        for (String product:
             productTitles) {
            assertThat(bookDepositorySearchResultsPage.getBookFromList(product))
                    .as("The following book is not found: %s", product)
                    .isNotNull();
        }
    }

    @But("I apply the following search filters")
    public void filterSearchResults(Map<String, String> data) {
        filtersBlock.selectFromAvailabilityFilterDropdown(data.get("Availability"));
        filtersBlock.selectFromPriceRangeFilterDropdown(data.get("Price range"));
        filtersBlock.selectFromLanguageFilterDropdown(data.get("Language"));
        filtersBlock.selectFromFormatFilterDropdown(data.get("Format"));
        filtersBlock.clickRefineResultsButton();
    }

    @Then("Search results contain only the following products")
    public void verifyFilteringResults(List<String> productTitles) {
        List<WebElement> books = bookDepositorySearchResultsPage.getListOfBooks();

        for (String title:
             productTitles) {
            assertThat(bookDepositorySearchResultsPage.getBookFromList(title))
                    .as("The following book was not found: %s", title)
                    .isNotNull();
        }

        assertThat(productTitles)
                .as("Mismatched size")
                .hasSameSizeAs(books);
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
    public void verifyBasketOrderSummary(@Transpose Map<String, String> data) {
        SoftAssertions softAssertions = new SoftAssertions();

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
    public void verifyDeliveryAddressValidationErrorsPresence(List<Map<String, String>> data) {
        SoftAssertions softly = new SoftAssertions();

        data.forEach(error -> softly.assertThat(paymentPage.isValidationErrorMessageDisplayed(error.get("Form field name")))
                        .as("%s error message is not displayed: ", error.get("Form field name"))
                        .isTrue());

        for (Map<String, String> errors:
             data) {
            softly.assertThat(paymentPage.getValidationErrorText(errors.get("Form field name")))
                    .as("Value mismatch")
                    .isEqualTo(errors.get("Validation error message"));
        }
    }

    @And("The following validation error messages are displayed on Payment form:")
    public void verifyPaymentDataValidationErrorsPresence(String validationError) {
        List<String> validationErrors = Arrays.stream(validationError
                        .split(","))
                .collect(Collectors.toList());

        for (String error :
                validationErrors) {
            assertThat(paymentPage.getPaymentDataValidationErrors())
                    .as("%s validation error is not displayed: ", error)
                    .contains(error.trim());
        }
    }

    @But("Checkout order summary is as following:")
    public void verifyCheckoutOrderSummaryValues(@Transpose Map<String, String> data) {
        SoftAssertions softAssertions = new SoftAssertions();

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
    public void provideShipmentData(@Transpose Map<String, String> data) {
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
        SoftAssertions softly = new SoftAssertions();

        List<String> errors = new ArrayList<>();
        errors.add("Email address");
        errors.add("Full name");
        errors.add("Address line 1");
        errors.add("Town/City");
        errors.add("Postcode/ZIP");

        for (String error :
                errors) {
            softly.assertThat(paymentPage.isValidationErrorMessageDisplayed(error))
                    .as("%s validation error message is displayed", error)
                    .isFalse();
        }
    }

    @When("I enter my card details")
    public void enterPaymentData(Map<String, String> data) {
        paymentPage.enterCardNumber(data.get("Card number"));
        paymentPage.enterExpiryDate(data.get("Expiry date (MM/YY)"));
        paymentPage.enterCvv(data.get("CVV"));
    }
}

package desktop.fragments;

import abstractpages.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends AbstractFragment {

    @FindBy(xpath = "//input[@name='emailAddress']")
    private static WebElement emailField;

    @FindBy(xpath = "//input[@name='delivery-fullName']")
    private static WebElement fullNameField;

    @FindBy(xpath = "//select[@id='delivery-CountryDropdown']")
    private static WebElement deliveryCountryDropdown;

    @FindBy(xpath = "//input[@name='delivery-addressLine1']")
    private static WebElement addressLineFieldOne;

    @FindBy(xpath = "//input[@name='delivery-addressLine2']")
    private static WebElement addressLineFieldTwo;

    @FindBy(xpath = "//input[@name='delivery-city']")
    private static WebElement townCityField;

    @FindBy(xpath = "//input[@name='delivery-county']")
    private static WebElement countryStateField;

    @FindBy(xpath = "//input[@name='delivery-postCode']")
    private static WebElement postcodeZipField;

    @FindBy(xpath = "//iframe[@name='braintree-hosted-field-number']")
    private static WebElement cardNumberFrame;

    @FindBy(xpath = "//iframe[@name='braintree-hosted-field-expirationDate']")
    private static WebElement expirationDateFrame;

    @FindBy(xpath = "//iframe[@name='braintree-hosted-field-number']")
    private static WebElement cvvFrame;

    @FindBy(xpath = "//input[@name='credit-card-number']")
    private static WebElement cardNumberField;

    @FindBy(xpath = "//input[@name='expiration']")
    private static WebElement expiryDateField;

    @FindBy(xpath = "//input[@name='cvv']")
    private static WebElement cvvField;

    @FindBy(xpath = "//dd[@class='text-right'][@aria-hidden='true']")
    private static WebElement orderSubTotal;

    @FindBy(xpath = "//dd[@class='text-right total-price']")
    private static WebElement orderTotal;

    @FindBy(xpath = "//dd[@class='text-right total-tax']")
    private static WebElement orderTax;

    @FindBy(xpath = "//div[@aria-label='Delivery FREE']//dd[@class='text-right']")
    private static WebElement delivery;

    @FindBy(xpath = "//div[@id='email-errors']")
    private static WebElement emailValidationError;

    @FindBy(xpath = "//div[@id='delivery-fullName-errors']")
    private static WebElement fullNameValidationError;

    @FindBy(xpath = "//div[@id='delivery-addressLine1-errors']")
    private static WebElement addressLineOneValidationError;

    @FindBy(xpath = "//div[@id='delivery-city-errors']")
    private static WebElement townCityValidationError;

    @FindBy(xpath = "//div[@id='delivery-postCode-errors']")
    private static WebElement postcodeZipValidationError;

    @FindBy(xpath = "//div[@class='buynow-error-msg']")
    private static WebElement paymentDataValidationErrors;

    @FindBy(xpath = "//input[@name='manualEntryButton']")
    private static WebElement enterAddressManuallyButton;

    @FindBy(xpath = "//button[@id='buyNowButton']")
    private static WebElement buyNowButton;

    public void enterEmailAddress(String email) {
        enterTextIntoField(emailField, email);
    }

    public void enterFullName(String fullName) {
        enterTextIntoField(fullNameField, fullName);
    }

    public void enterAddressOne(String address) {
        enterTextIntoField(addressLineFieldOne, address);
    }

    public void enterAddressTwo(String address) {
        enterTextIntoField(addressLineFieldTwo, address);
    }

    public void enterTownCity(String townCity) {
        enterTextIntoField(townCityField, townCity);
    }

    public void enterCountryState(String countryState) {
        enterTextIntoField(countryStateField, countryState);
    }

    public void enterPostcodeZip(String postcodeZip) {
        enterTextIntoField(postcodeZipField, postcodeZip);
    }

    public void enterCardNumber(String cardNumber) {
        enterTextIntoField(cardNumberField, cardNumber);
    }

    public void enterExpiryDate(String expiryDate) {
        enterTextIntoField(expiryDateField, expiryDate);
    }

    public void enterCvv(String cvv) {
        enterTextIntoField(cvvField, cvv);
    }

    public void selectFromDeliveryCountryDropdown(String country) {
        selectFromDropdown(deliveryCountryDropdown, country);
    }

    /*
    public void selectFromDeliveryCountryDropdown(String country) {
        JavascriptExecutor jse = (JavascriptExecutor) SingletonDriver.getDriver();
        jse.executeScript("arguments[0].text='" + country + "'", deliveryCountryDropdown);
    }
    */

    public String getEmailAddressValue() {
        return getTextFieldText(emailField);
    }

    public WebElement getCardNumberFrame() {
        return cardNumberFrame;
    }

    public WebElement getExpirationDateFrame() {
        return expirationDateFrame;
    }

    public WebElement getCvvFrame() {
        return cvvFrame;
    }

    public String getOrderTotal() {
        return getElementText(orderTotal);
    }

    public String getOrderSubTotal() {
        return getElementText(orderSubTotal);
    }

    public String getOrderTax() {
        return getElementText(orderTax);
    }

    public String getDeliveryCost() {
        return getElementText(delivery);
    }

    public boolean isEmailValidationErrorDisplayed () {
       return isElementDisplayed(emailValidationError);
    }

    public boolean isFullNameValidationErrorDisplayed () {
       return isElementDisplayed(fullNameValidationError);
    }

    public boolean isAddressLineOneValidationErrorDisplayed () {
       return isElementDisplayed(addressLineOneValidationError);
    }

    public boolean isTownCityValidationErrorDisplayed () {
       return isElementDisplayed(townCityValidationError);
    }

    public boolean isPostcodeZipValidationErrorDisplayed () {
       return isElementDisplayed(postcodeZipValidationError);
    }

    public boolean isPaymentDataValidationErrorDisplayed () {
       return isElementDisplayed(paymentDataValidationErrors);
    }

    public String getFullNameValidationError() {
        return getElementText(fullNameValidationError);
    }

    public String getEmailValidationError() {
        return getElementText(emailValidationError);
    }

    public String getAddressLineOneValidationError() {
        return getElementText(addressLineOneValidationError);
    }

    public String getTownCityValidationError() {
        return getElementText(townCityValidationError);
    }

    public String getPostcodeZipValidationError() {
        return getElementText(postcodeZipValidationError);
    }

    public String getPaymentDataValidationErrors() {
        return getElementText(paymentDataValidationErrors);
    }

    public void clickEnterAddressManuallyButton() {
        clickButton(enterAddressManuallyButton);
    }

    public void clickBuyNowButton() {
        clickButton(buyNowButton);
    }
}

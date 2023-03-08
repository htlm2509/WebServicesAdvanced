package desktop.fragments.bookdepository;

import abstractpages.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class BDPaymentPage extends AbstractFragment {

    @FindBy(xpath = "//input[@name='emailAddress']")
    private static WebElement emailField;

    @FindBy(xpath = "//input[@name='delivery-fullName']")
    private static WebElement fullNameField;

    @FindBy(xpath = "//span[@name='deliveryCountry']")
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

    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-number']")
    private static WebElement cardNumberFrame;

    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-expirationDate']")
    private static WebElement expirationDateFrame;

    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-cvv']")
    private static WebElement cvvFrame;

    @FindBy(xpath = "//input[@id='credit-card-number']")
    private static WebElement cardNumberField;

    @FindBy(xpath = "//input[@id='expiration']")
    private static WebElement expiryDateField;

    @FindBy(xpath = "//input[@id='cvv']")
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
        switchToFrame(cardNumberFrame);
        enterTextIntoField(cardNumberField, cardNumber);
        switchToDefaultContent();
    }

    public void enterExpiryDate(String expiryDate) {
        switchToFrame(expirationDateFrame);
        enterTextIntoField(expiryDateField, expiryDate);
        switchToDefaultContent();
    }

    public void enterCvv(String cvv) {
        switchToFrame(cvvFrame);
        enterTextIntoField(cvvField, cvv);
        switchToDefaultContent();
    }

    public void selectFromDeliveryCountryDropdown(String name) {
        JavascriptExecutor jse = (JavascriptExecutor) SingletonDriver.getDriver();
        jse.executeScript("arguments[0].click();", deliveryCountryDropdown);
        WebElement countryName = SingletonDriver.getDriver()
                .findElement(By.xpath("//a[text()='" + name + "']"));
        clickButton(countryName);
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

    private boolean isEmailValidationErrorDisplayed () {
       return isElementDisplayed(emailValidationError);
    }

    private boolean isFullNameValidationErrorDisplayed () {
       return isElementDisplayed(fullNameValidationError);
    }

    private boolean isAddressLineOneValidationErrorDisplayed () {
       return isElementDisplayed(addressLineOneValidationError);
    }

    private boolean isTownCityValidationErrorDisplayed () {
       return isElementDisplayed(townCityValidationError);
    }

    private boolean isPostcodeZipValidationErrorDisplayed () {
       return isElementDisplayed(postcodeZipValidationError);
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

    public void clickBuyNowButton() {
        clickButton(buyNowButton);
    }

    public Boolean isValidationErrorMessageDisplayed(String error) {
        switch (error) {
            case "Email address":
                return isEmailValidationErrorDisplayed();
            case "Full name":
                return isFullNameValidationErrorDisplayed();
            case "Address line 1":
                return isAddressLineOneValidationErrorDisplayed();
            case "Town/City":
                return isTownCityValidationErrorDisplayed();
            case "Postcode/ZIP":
                return isPostcodeZipValidationErrorDisplayed();
            default:
                throw new IllegalArgumentException("No such error message");
        }
    }

    public String getDeliveryDataValidationErrorText(String error) {
        switch (error) {
            case "Email address":
                return getEmailValidationError();
            case "Full name":
                return getFullNameValidationError();
            case "Address line 1":
                return getAddressLineOneValidationError();
            case "Town/City":
                return getTownCityValidationError();
            case "Postcode/ZIP":
                return getPostcodeZipValidationError();
            default:
                throw new IllegalArgumentException("No such error message");
        }
    }
}

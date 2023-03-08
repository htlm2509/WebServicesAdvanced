package cucumber.steps.api;

import api.requests.*;
import api.responses.*;
import constants.*;
import desktop.fragments.kruidvat.*;
import driver.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.restassured.response.*;
import org.assertj.core.api.*;
import org.openqa.selenium.*;

import java.io.*;
import java.util.*;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class ApiAddProductToCart {
    private final WebDriver driver = SingletonDriver.getDriver();

    private final KRCookieConsent krCookieConsent = new KRCookieConsent();

    private final KRHeaderComponent krHeaderComponent = new KRHeaderComponent();

    private final KRCart krCart = new KRCart();

    private final Map<String, Object> storage = new HashMap<>();

    @Given("I have created the cart via API")
    public void createCart() {
        Settings.applySettings(Settings.setBaseUri(KRConstants.BASE_URL));

        Response response = given()
                .when().post(KRConstants.POST_CART_ENDPOINT)
                .then().statusCode(201)
                .extract().response();

        CartCreatedResponse cartCreatedResponse = response.as(CartCreatedResponse.class);
        storage.put("guid", cartCreatedResponse.getGuid());
    }

    @But("I have added the following products of corresponding quantity to the cart via API")
    public void addProductToCart(@Transpose Map<String, String> data) {
        SoftAssertions softly = new SoftAssertions();
        File schema = new File("src/test/resources/jsonschemas/CartProductAddedSchema.json");

        Response response = given().pathParam("guid", storage.get("guid"))
                .body(ProductRequest.builder()
                        .product(new ProductRequest.Product(data.get("Code")))
                        .quantity(Integer.valueOf(data.get("Quantity")))
                        .build())
                .when().post(KRConstants.POST_PRODUCT_TO_CART)
                .then().statusCode(200)
                .assertThat().body(matchesJsonSchema(schema))
                .extract().response();

        CartProductAddedResponse cartProductAddedResponse = response.as(CartProductAddedResponse.class);

        softly.assertThat(cartProductAddedResponse.getQuantity())
                .as("Unexpected product quantity")
                .isEqualTo(1);
        softly.assertThat(cartProductAddedResponse.getEntry().getProduct().getCode())
                .as("Incorrect product code")
                .isEqualTo(data.get("Code"));
        softly.assertAll();
    }

    @When("I authenticate to the web application by adding kvn-cart cookie with guid value")
    public void sendCookie() {
        driver.get(KRConstants.BASE_URL);
        driver.manage().addCookie(new Cookie("kvn-cart", (String) storage.get("guid")));
        driver.navigate().refresh();
    }

    @But("I navigate to Cart page via UI")
    public void openCart() {
        krCookieConsent.clickAcceptCookiesButton();
        krHeaderComponent.clickBasketIcon();
    }

    @Then("I should see the expected product of corresponding quantity in the Cart via UI")
    public void verifyCartContents(@Transpose Map<String, String> data) {
        SoftAssertions softly = new SoftAssertions();
        KRCartProduct product = krCart.getProduct(data.get("Name"));

        softly.assertThat(product)
                .as("Product %s is not found", data.get("Name"))
                .isNotNull();
        softly.assertThat(product.getQuantityDropdown().getText())
                .as("Unexpected product quantity")
                .isEqualTo(data.get("Quantity"));
        softly.assertAll();
    }
}

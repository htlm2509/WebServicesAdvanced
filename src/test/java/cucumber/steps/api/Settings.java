package cucumber.steps.api;

import io.restassured.*;
import io.restassured.builder.*;
import io.restassured.http.*;
import io.restassured.specification.*;

public class Settings {

    private Settings() {
        throw new IllegalStateException("Utility class");
    }
    public static RequestSpecification setBaseUri(String uri) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static void applySettings(RequestSpecification endpoint) {
        RestAssured.requestSpecification = endpoint;
    }
}

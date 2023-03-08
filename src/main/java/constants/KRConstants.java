package constants;

public class KRConstants {

    public static final String BASE_URL = "https://www.kruidvat.nl";

    public static final String POST_CART_ENDPOINT = "/api/v2/kvn/users/anonymous/carts";

    public static final String POST_PRODUCT_TO_CART = "/api/v2/kvn/users/anonymous/carts/{guid}/entries";

    private KRConstants() {
    }
}

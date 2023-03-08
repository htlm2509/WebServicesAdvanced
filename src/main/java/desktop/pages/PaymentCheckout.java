package desktop.pages;

import abstractpages.page.AbstractPage;
import constants.BDConstants;

public class PaymentCheckout extends AbstractPage {

    private static final String URL_PATTERN = ".*/payment.*";

    public PaymentCheckout() {
        setPageUrlPattern(URL_PATTERN);
        setPageUrl(BDConstants.PAYMENT_CHECKOUT_PAGE);
    }
}

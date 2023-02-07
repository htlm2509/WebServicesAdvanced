package desktop.pages;

import abstractpages.page.AbstractPage;

public class PaymentCheckout extends AbstractPage {

    private static final String URL_PATTERN = ".*/payment.*";

    public PaymentCheckout() {
        setPageUrlPattern(URL_PATTERN);
    }
}

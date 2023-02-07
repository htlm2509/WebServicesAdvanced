package desktop.pages;

import abstractpages.page.AbstractPage;

public class Basket extends AbstractPage {

    private static final String URL_PATTERN = ".*/basket";

    public Basket() {
        setPageUrlPattern(URL_PATTERN);
    }
}

package desktop.pages;

import abstractpages.page.AbstractPage;

public class SearchResults extends AbstractPage {

    private static final String URL_PATTERN = ".*/search?.*";

    public SearchResults() {
        setPageUrlPattern(URL_PATTERN);
    }
}

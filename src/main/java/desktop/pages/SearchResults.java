package desktop.pages;

import abstractpages.page.AbstractPage;
import constants.Constants;

public class SearchResults extends AbstractPage {

    private static final String URL_PATTERN = ".*/search?.*";

    public SearchResults() {
        setPageUrlPattern(URL_PATTERN);
        setPageUrl(Constants.SEARCH_RESULTS_PAGE);
    }
}

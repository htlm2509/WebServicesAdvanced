package desktop.pages;

import abstractpages.page.AbstractPage;
import constants.BDConstants;

public class SearchResults extends AbstractPage {

    private static final String URL_PATTERN = ".*/search?.*";

    public SearchResults() {
        setPageUrlPattern(URL_PATTERN);
        setPageUrl(BDConstants.SEARCH_RESULTS_PAGE);
    }
}

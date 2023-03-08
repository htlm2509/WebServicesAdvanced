package cucumber.steps.desktop;

import abstractpages.page.AbstractPage;
import desktop.fragments.bookdepository.*;
import desktop.pages.Basket;
import desktop.pages.Home;
import desktop.pages.PaymentCheckout;
import desktop.pages.SearchResults;
import driver.SingletonDriver;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {

    private static final Map<String, AbstractPage> pageNameToObjectMap = new HashMap<>();

    public BaseSteps() {
        pageNameToObjectMap.put("Search page", new SearchResults());
        pageNameToObjectMap.put("Checkout", new PaymentCheckout());
        pageNameToObjectMap.put("Basket page", new Basket());
        pageNameToObjectMap.put("Initial home page", new Home());
    }

    protected WebDriver driver = SingletonDriver.getDriver();

    protected BDHomePage bookDepositoryHomePage = new BDHomePage();

    protected BDSearchResultsPage bookDepositorySearchResultsPage = new BDSearchResultsPage();

    protected BDModalDialogPage modalDialogPage = new BDModalDialogPage();

    protected BDBasketPage basketPage = new BDBasketPage();
    protected BDPaymentPage paymentPage = new BDPaymentPage();

    protected BDFiltersBlockComponent filtersBlock = new BDFiltersBlockComponent();

    protected BDCookieConsentComponent cookieConsent = new BDCookieConsentComponent();

    public AbstractPage getPageByName(String name) {
        return pageNameToObjectMap.get(name);
    }
}


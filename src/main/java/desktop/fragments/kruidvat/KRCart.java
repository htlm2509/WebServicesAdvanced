package desktop.fragments.kruidvat;

import abstractpages.fragment.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

public class KRCart extends AbstractFragment {

    @FindBy(xpath = "//div[@class='product-summary__row ']")
    private List<WebElement> listOfProducts;

    private KRCartProduct product;

    public List<WebElement> getListOfProducts() {
        return new ArrayList<>(listOfProducts);
    }

    public KRCartProduct getProduct(String productName) {

        for (WebElement p:
             getListOfProducts()) {
            String name = p
                    .findElement(By.xpath("//div[@class='product-summary__description-name']"))
                    .getText()
                    .toLowerCase();
            WebElement quantityDropdown = p
                    .findElement(By.xpath("//div[@class='select__wrapper']"));
            if (Objects.equals(productName.toLowerCase(), name)) {
                product = new KRCartProduct(name, quantityDropdown);
            }
        }
        return product;
    }
}

package desktop.fragments.kruidvat;

import org.openqa.selenium.*;

public class KRCartProduct {

    private String name;

    private WebElement quantityDropdown;

    public KRCartProduct() {
    }

    public KRCartProduct(String name, WebElement quantityDropdown) {
        this.name = name;
        this.quantityDropdown = quantityDropdown;
    }

    public String getName() {
        return name;
    }

    public WebElement getQuantityDropdown() {
        return quantityDropdown;
    }
}

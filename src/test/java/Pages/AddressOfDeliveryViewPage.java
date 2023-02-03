package Pages;

import base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressOfDeliveryViewPage extends BasePage<AddressOfDeliveryViewPage> {
    protected AddressOfDeliveryViewPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private By pickUpBtn = By.xpath("//li[contains(@*,'pickup')]");
    private By chooseStoreField = By.xpath("//div[@data-marker='Stores']");
    private By kosmopolitShopAddressBtn = By.id("react-select-5-option-1");
    private By toShoppingBtn = By.xpath("//button[@*='To shopping']");

    public AddressOfDeliveryViewPage pickUpButton() {
        waitForVisibilityOf(pickUpBtn);
        click(pickUpBtn);
        return this;
    }

    public AddressOfDeliveryViewPage chooseStoreButton() {
        waitForVisibilityOf(chooseStoreField);
        click(chooseStoreField);
        return this;
    }

    public AddressOfDeliveryViewPage kosmopolitShopAddress() {
        click(kosmopolitShopAddressBtn);
        return this;
    }

    public AddressOfDeliveryViewPage toShoppingButton() {
        click(toShoppingBtn);
        return this;
    }
}

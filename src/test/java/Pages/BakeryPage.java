package Pages;

import base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class BakeryPage extends BasePage<BakeryPage> {
    public BakeryPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public static final String CATEGORY_TITLE = "//span[contains(@*,'CategoryCard__title')][text()=\"%s\"]";
    public static final String LIST_OF_BREADS = "//a[@data-testid='product-tile']";

    public static final String PRICE = "//div[@data-marker='Discounted Price']";

    public BakeryPage optionalCategoryList(String option) {
        sleep();
        click(By.xpath(String.format(CATEGORY_TITLE, option)));
        return this;
    }

    public String getPrice(WebElement s) {
        waitForVisibilityOf(By.xpath(PRICE));
        return s.findElement(By.xpath(PRICE)).getText();

    }

    public List<WebElement> listOfBreads() {
        waitForVisibilityOf(By.xpath(LIST_OF_BREADS));
        return driver.findElements(By.xpath(LIST_OF_BREADS));
    }

    public List<String> price(List<WebElement> elements) {
        return elements.stream().filter(s -> s.getText().contains("Рум'янець Молочний")).
                map(s -> getPrice(s)).collect(Collectors.toList());
    }
}
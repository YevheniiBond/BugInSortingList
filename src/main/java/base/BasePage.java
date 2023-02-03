package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static org.testng.Assert.fail;

public class BasePage<T> {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;

    protected BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    @SuppressWarnings("unchecked")
public T openUrl(String url) {
        driver.get(url);
        return (T) this;
    }

    protected void type(String text, By element) {
        find(element).sendKeys(text);

    }

    protected void click(By element) {
        find(element).click();
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected String getText(By element) {
        return find(element).getText();
    }


    public List<WebElement> waitUntilElementsToBeClickable(String locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            return driver.findElements(By.xpath(locator));
        } catch (WebDriverException e) {
            log.error("No clickable elements: " + locator);
            fail("No clickable elements: " + locator);
            return null;
        }
    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    protected void waitUntilElementTobeClickble(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.elementToBeClickable(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException ignored) {
            }
            attempts++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);

    }

    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

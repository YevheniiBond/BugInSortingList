package tests;

import Pages.HeroKuappPage;
import base.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class fluentWaitTest extends TestInit {


    @Test
    public void fluentWaitTest() {
        HeroKuappPage hero = new HeroKuappPage(driver, log);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        hero.startButton();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {


            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4"));}});
            }
    }
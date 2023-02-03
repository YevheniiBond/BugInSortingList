package Pages;


import base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeroKuappPage extends BasePage {
    public HeroKuappPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private By startBtn = By.id("start");
    private By helloText = By.xpath("//div[@id='finish']/h4");

    public HeroKuappPage startButton() {
        click(startBtn);
        return this;
    }
}
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        switch (browser) {

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "chrome":
                driver = new ChromeDriver();
                break;

            default:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
            return driver;
    }
}
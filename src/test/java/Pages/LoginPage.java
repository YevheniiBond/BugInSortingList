package Pages;

import base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;


public class LoginPage extends BasePage<LoginPage> {
    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private static final String URL = "https://megamarket.zakaz.ua/uk/";
    private By emailField = By.id("login-data");
    private By passwordField =By.id("login-password");
    private By chooseAddressBtn  = By.xpath("//div[@*='Address']");
    private By signInButton = By.xpath("//form[*]//button[@*='Sign in']");
    private By enterButton = By.xpath("//button[@data-testid='sign_in_button']");
    private By accountButton = By.xpath("//button[@data-testid='Account Button']");
    private By errorMessage = By.xpath("//div[@class='jsx-3502377352 login__error']");

    private  By addressOfPickUpTxt = By.xpath("//span[contains(@*,'AddressButton__label')]");

    public static final String BAKERY = "//li[@title='%s']";

    public LoginPage bakeryBtn(String bakery){
        waitForVisibilityOf(By.xpath(String.format(BAKERY, bakery)));
        click(By.xpath(String.format(BAKERY, bakery)));
        return this;
    }

    public LoginPage openLogInPage(){
        log.info("URL of MegaMarket is open ");
        openUrl(URL);
        return this;
    }

    public LoginPage enter(){
        log.info("account enter button is clicked ");
        click(enterButton);
        return this;
    }

    public AddressOfDeliveryViewPage chooseAddressButton(){
        log.info("click on choose address button");
        waitForVisibilityOf(chooseAddressBtn);
        click(chooseAddressBtn);
        return new AddressOfDeliveryViewPage(driver, log);
    }

    public LoginPage fillUpEmailAndPassword(String email, String password){
        waitForVisibilityOf(emailField);
        type(email, emailField);
        type(password, passwordField);
        log.info("email and password are filled up");
        return this;
    }

    public LoginPage pushSingInButton(){
        log.info("sing in button is clicked");
        click(signInButton);
        return this;
    }

    public boolean isCorrectProfileLoaded(String correctProfileName){
        log.info("user account button is displayed");
        waitForVisibilityOf(accountButton);
       if (getText(accountButton).equals(correctProfileName)){
           return true;
       }
       return false;
    }

    public boolean errorMessageIsPresent(String error){
        log.info("error of enter is present");
        waitForVisibilityOf(errorMessage);
        if(getText(errorMessage).contains(error)){
            return true;
        }
        return false;
    }

    public boolean addressOfPickUpTxt(String address) {

        waitForVisibilityOf(addressOfPickUpTxt);

        if (getText(addressOfPickUpTxt).contains(address)){
            log.info("The address is correct!");
            return true;
        }
            log.info("You choose wrong address!!!");
            return false;
    }
}
package stepDefinition;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class stepDefinition {

        WebDriver driver = new FirefoxDriver();
         protected Logger log ;
        LoginPage loginPage = new LoginPage(driver, log);
        String correctProfileName = "Акаунт";
        @Given("^User is on landing page$")
        public void user_is_on_landing_page() throws Throwable {
                loginPage.openLogInPage();
                log.info("User on MegaMarket home page");
        }

        @When("User clicking on Enter button")
        public void user_clicking_on_Enter_button() throws Throwable {
                loginPage.enter();
                log.info("User in login pop up");
        }

        @When("^User login into pop up with \"(.*)\" and password \"(.*)\"$")
        public void user_login_into_pop_up_with_something_and_password_something(String email, String password) throws Throwable {
                loginPage.fillUpEmailAndPassword(email, password);
                log.info("User input name and password");
        }

        @And("User press confirm button")
        public void User_press_confirm_button() throws Throwable {
                loginPage.pushSingInButton();
                log.info("Account button is displayed");
        }

        @Then("Account button is present")
        public void account_button_is_present() throws Throwable {
                Assert.assertTrue(loginPage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected!");
                log.info("User is successfully login!!! ");
        }


}
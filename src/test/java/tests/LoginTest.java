package tests;

import Pages.LoginPageHelper;
import base.CsvDataProvider;
import base.TestInit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends TestInit {

    @Test
    public void positiveLoginTest() {
        LoginPageHelper loginPage = new LoginPageHelper(driver, log);

        String expectedPageTitle = "МегаМаркет інтернет магазин - доставка товарів в Києві додому";
        String correctProfileName = "Акаунт";

        loginPage
                .openLogInPage()
                .enter()
                .fillUpEmailAndPassword("+380665631180", "StrongPa$$word123")
                .pushSingInButton();
        String actualTitle = loginPage.getTitle();

        Assert.assertTrue(expectedPageTitle.equals(actualTitle),
                "Page title is not expected.\nExpected: " + expectedPageTitle + "\nActual: " + actualTitle);
        Assert.assertTrue(loginPage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected!");
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void negativeLogInTest(Map<String, String> testData) {

        LoginPageHelper loginPage = new LoginPageHelper(driver, log);
        String error = "невірні.";
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        log.info("Test №:  " + testNumber + "  for" + description + "Where\nEmail: " + email + "\nPassword: " + password);

        loginPage
                .openLogInPage()
                .enter()
                .fillUpEmailAndPassword(email, password)
                .pushSingInButton();

        Assert.assertTrue(loginPage.errorMessageIsPresent(error), "error is not present!");
    }
}
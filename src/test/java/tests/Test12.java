package tests;

import Pages.BakeryPage;
import Pages.LoginPageHelper;
import base.TestInit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataProviderCredentials;

import java.util.List;
import java.util.stream.Collectors;

//import static Pages.BakeryPage.getPrice;
import static java.lang.Thread.sleep;

public class Test12 extends TestInit {

    @Test(dataProvider = "inputDetails", dataProviderClass = DataProviderCredentials.class)

    public void test12(String bakery, String goods) {
        LoginPageHelper loginPage = new LoginPageHelper(driver, log);
        BakeryPage bakeryPage = new BakeryPage(driver, log);


        loginPage
                .openLogInPage()
                .bakeryBtn(bakery);
        bakeryPage.optionalCategoryList(goods);
        bakeryPage.price(bakeryPage.listOfBreads())
                .forEach(a-> System.out.println(a));

//        Assert.assertEquals();
    }
}
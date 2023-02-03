package tests;

import Pages.LoginPageHelper;
import base.TestInit;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChangeLocationTest extends TestInit {

    @Parameters
    @Test
    public void changeLocationTest() {
        LoginPageHelper loginPage = new LoginPageHelper(driver, log);
        String address = "Вадима Гетьмана";


        loginPage
                .openLogInPage()
                .chooseAddressButton()
                .pickUpButton()
                .chooseStoreButton()
                .kosmopolitShopAddress()
                .toShoppingButton();

        Assert.assertTrue(loginPage.addressOfPickUpTxt(address), "Its wrong address!");
    }
}

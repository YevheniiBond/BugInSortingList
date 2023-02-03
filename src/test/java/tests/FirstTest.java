package tests;

import base.TestInit;
import org.testng.annotations.Test;

public class FirstTest extends TestInit {

    @Test
    public void firstTestMethod(){

        driver.get(CONSTRUCTION_AND_RENOVATION);
        System.out.println("Epicentr Opened.Test passed!");
    }
}
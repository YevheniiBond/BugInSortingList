package tests;

import base.TestInit;
import org.testng.annotations.Test;

public class SecondTest extends TestInit {

    @Test
    public void secondTestMethod(){
        driver.get(CONSTRUCTION_AND_RENOVATION);
        System.out.println("Collection of product is opened.Test passed!");

    }
}
package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;


public class TestInit {
    protected WebDriver driver;
    protected Logger log;
    protected final String CONSTRUCTION_AND_RENOVATION = "https://epicentrk.ua/ua/shop/stroitelstvo-i-remont/";


    @BeforeClass
    protected void  setUpClass(ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
    }

    @Parameters({"browser"} )
    @BeforeMethod
    public void methodOpenUrl(@Optional("chrome") String browser) {
        log.info("Method set up");
        driver = BrowserFactory.getDriver(browser);
    }

    @AfterMethod
    public void methodTearDown() {
        driver.quit();
    }
}

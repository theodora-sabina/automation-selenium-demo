package tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driver.BrowserType;
import driver.DriverInstance;

public class TestBase {

   protected DriverInstance driver;

   private static final String SERVER_ADDRESS = "http://localhost:4444/wd/hub";

   @BeforeClass
    public void setUp() throws MalformedURLException {
       getBrowser(BrowserType.CHROME);
   }

   @AfterClass
    public void quitBrowser(){
        if(driver != null){
            driver.quit();
        }
    }

    public DriverInstance getBrowser(BrowserType browser) throws MalformedURLException {
        driver = new DriverInstance(SERVER_ADDRESS, browser);
        driver.manage().window().maximize();
        return driver;
    }
}

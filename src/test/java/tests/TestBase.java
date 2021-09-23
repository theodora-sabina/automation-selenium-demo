package tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import driver.BrowserType;
import driver.DriverInstance;
import pages.StartPage;

public class TestBase {

    protected static final String SERVER_ADDRESS = "http://localhost:4444/wd/hub";
    protected static final String BASE_URL = "https://github.com/";

    protected DriverInstance driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        driver = getNewBrowser(BrowserType.CHROME);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        quitBrowser();
    }

    /** initialize browser and return a new DriverInstance instance
     *
     * @param browserType the {@link BrowserType} enum for desired browser
     * @return new {@link DriverInstance} instance using the selected browser
     * @throws MalformedURLException if Selenium Server address is malformed */
    protected DriverInstance getNewBrowser(BrowserType browserType) throws MalformedURLException {
        DriverInstance newDriver = new DriverInstance(SERVER_ADDRESS, browserType);
        newDriver.manage().window().maximize();
        return newDriver;
    }

    /** quit browser instance*/
    protected void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** Navigate to Start page
     * @return {@link StartPage} instance*/
    public StartPage goToStartPage(){
        driver.get(BASE_URL);
        return new StartPage(driver);
    }
}

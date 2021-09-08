package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewRepositoryPage;
import pages.StartPage;

public class ImplicitWaitTest extends TestBase {

    @Test
    public void implicitWaitTest(){

        StartPage startPage = goToStartPage();
        LoginPage loginPage = startPage.goToLogIn();
        loginPage.logIn();

        //IMPLICIT WAITS
        //wait for a certain measure of time before throwing an exception
        //stays in place as long as the driver instance is alive
        //sets the timeout for every command
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("div.js-repos-container a[href='/new']")).click();
        NewRepositoryPage newRepoPage = new NewRepositoryPage(driver);
        newRepoPage.fillRepositoryFields();
    }
}

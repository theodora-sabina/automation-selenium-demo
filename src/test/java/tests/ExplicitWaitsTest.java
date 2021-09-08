package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewRepositoryPage;
import pages.StartPage;

public class ExplicitWaitsTest extends TestBase{

    @Test
    public void explicitWaitTest(){

        StartPage startPage = goToStartPage();
        LoginPage loginPage = startPage.goToLogIn();
        loginPage.logIn();

        //EXPLICIT WAITS
        //wait until a certain condition is fulfilled before proceeding with executing the code, or before throwing an exception
        //applies for specific elements
        //instructs driver to wait for 1 second before throwing a NoSuchElementException
        //if it finds the button before 1 sec, it will return immediately, otherwise it will throw TimeOutException
        //doesn't have to wait for an entire second
        WebDriverWait wait = new WebDriverWait(driver,1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.js-repos-container a[href='/new']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.js-repos-container a[href='/new']")));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.js-repos-container a[href='/new']"), 2));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div.js-repos-container a[href='/new']"), 1));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("div.js-repos-container a[href='/new']"), 3));

        driver.findElement(By.cssSelector("div.js-repos-container a[href='/new']")).click();
        NewRepositoryPage newRepoPage = new NewRepositoryPage(driver);

        wait.until(ExpectedConditions.urlContains("/new"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("form input[type='checkbox']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.application-main")));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#repository-owner"), "theodora-sabina"));

        newRepoPage.fillRepositoryFields();
    }
}

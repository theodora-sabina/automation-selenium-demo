package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewRepositoryPage;
import pages.StartPage;

public class ThreadSleepTest extends TestBase {

    @Test
    public void createRepo() throws InterruptedException {

        StartPage startPage = goToStartPage();
        LoginPage loginPage = startPage.goToLogIn();
        loginPage.logIn();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.js-repos-container a[href='/new']")).click();
        Thread.sleep(1000);
        NewRepositoryPage newRepoPage = new NewRepositoryPage(driver);
        newRepoPage.fillRepositoryFields();
    }
}

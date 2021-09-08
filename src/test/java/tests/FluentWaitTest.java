package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewRepositoryPage;
import pages.StartPage;

public class FluentWaitTest extends TestBase {

    @Test
    public void fluentWaitTest(){

        StartPage startPage = goToStartPage();
        LoginPage loginPage = startPage.goToLogIn();
        loginPage.logIn();

        //FLUENT WAIT -> RAW form
        //looks for a web element repeatedly at regular intervals until timeout happens or until the object is found.

        FluentWait waitFluent = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement newButtoon = (WebElement) waitFluent.until((new Function<WebDriver,WebElement>()
        {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(By.cssSelector("div.js-repos-container a[href='/new']"));
            }
        }));
        WebElement newButton = (WebElement) waitFluent.until(wd -> driver.findElement(By.cssSelector("div.js-repos-container a[href='/new']")));

        //FluentWait
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        //Lambda expression
        wait.until(((Function<WebDriver, WebElement>) driver ->
                driver.findElement(By.cssSelector("div.js-repos-container a[href='/new']"))));

        //Simplified form
        WebElement newButtonElement = (WebElement) wait.until(wd -> driver.findElement(By.cssSelector("div.js-repos-container a[href='/new']")));
        newButtonElement.click();
        //Extension of fluent wait
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3, 2000); //extension of fluent wait
        WebElement newButtonElem = webDriverWait
                .until(wd -> driver.findElement(By.cssSelector("form[id='new_repository']")));

        NewRepositoryPage newRepoPage = new NewRepositoryPage(driver);
        newButtonElem.click();
        newRepoPage.fillRepositoryFields();
    }
}

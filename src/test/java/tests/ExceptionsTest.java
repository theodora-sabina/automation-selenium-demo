package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.StartPage;


public class ExceptionsTest extends TestBase {

    @Test
    public void exceptionsTest() {

        StartPage startPage =  goToStartPage();

        // NoSuchElementException - web driver is not able to locate the elements at runtime
        driver.findElement(By.cssSelector("title.title"));
        LoginPage loginPage = startPage.goToLogIn();

        // InvalidSelectorException: invalid selector: No selector specified
        driver.findElement(By.cssSelector(""));
        loginPage.logIn();

        // Timeout exception
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Continue']")));
        WebElement continueButton =  driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        //NoAlertPresentException: no such alert
        driver.switchTo().alert().accept();

        //ElementNotInteractableException: element not interactable
        driver.findElement(By.cssSelector("input.js-site-search-type-field")).sendKeys("something");

        //NoSuchSessionException: Session ID is null, when quiting the driver session
        driver.quit();
        driver.findElement(By.cssSelector("input.js-site-search-type-field")).click();

        //StaleElementReferenceException - The referenced element is no longer present on the DOM page
        continueButton.click();

    }
}

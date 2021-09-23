package tests;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void actionsTest() throws InterruptedException {

        goToStartPage();
        //ACTIONS LIBRARY
        testActions();
        //WINDOW HANDLER
        switchFocusFromCurrentWindow();

        System.out.println("ceva");
    }

    public void switchFocusFromCurrentWindow() {
        //Get current window handle
        String mainWindow = driver.getWindowHandle();
        // Get all window handles
        Iterator<String> iterator = driver.getWindowHandles().iterator();

        //Iterate through all handles
        while(iterator.hasNext()) {
            String browserWindow = iterator.next();
            if (!browserWindow.equals(mainWindow)) {
                //switch to new window
                driver.switchTo().window(browserWindow);
                break;
            }
        }
    }

    public void testActions() throws InterruptedException {
        //Use actions library
        Actions action = new Actions(driver);

        //hover over
        WebElement whyGitHub = driver.findElements(By.cssSelector("summary.HeaderMenu-summary")).get(0);
        action.moveToElement(whyGitHub)
                .build()
                .perform();

        Thread.sleep(3000);

        //double click
        WebElement title =  driver.findElement(By.cssSelector("h1.h1-mktg"));
        action.doubleClick(title)
                .perform();

        //click and hold
        WebElement headerBar = driver.findElement(By.cssSelector("header.header-logged-out"));
        action.clickAndHold().perform();


        //new tab
        WebElement teamTab = driver.findElement(By.cssSelector("a[href='/team']"));
        teamTab.sendKeys(Keys.chord(Keys.COMMAND,"t", Keys.ENTER));

        //keyDown, keyUp
        WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Search GitHub']"));
        action.moveToElement(searchInput)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
    }
}

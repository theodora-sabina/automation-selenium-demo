package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectTest extends TestBase {

    @Test
    public void register(){
        driver.get("http://demo.guru99.com/test/newtours/register.php");
        //Select web element
        Select country = new Select(driver.findElement(By.cssSelector("select[name='country']")));
        System.out.println("Country options are: " + country.getOptions());
        country.selectByValue("CANADA");
        System.out.println("Selected option by value: " + country.getFirstSelectedOption().getText());
        country.selectByVisibleText("CHILE");
        System.out.println("Selected option by text: " + country.getFirstSelectedOption().getText());
        country.selectByIndex(7);
        System.out.println("Selected option by index: " + country.getFirstSelectedOption().getText());

        List<WebElement> options = country.getOptions();
        for(WebElement option : options){
            if("ARGENTINA".equalsIgnoreCase(option.getAttribute("value"))){
                System.out.println(option.getText());
            }
        }
    }
}

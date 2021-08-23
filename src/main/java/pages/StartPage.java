package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverInstance;

public class StartPage extends BasePage{

    @FindBy(css = "a[href='/login']")
    private WebElement loginButton;

    public StartPage(DriverInstance driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToLogin(){
        loginButton.click();
    }
}

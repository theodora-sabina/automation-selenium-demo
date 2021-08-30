package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverInstance;

public class StartPage extends BasePage{

    @FindBy(css = "a[href='/login']")
    private WebElement loginButton;

    /** Constructor for {@link StartPage}
     *
     * @param driver instance to use */
    public StartPage(DriverInstance driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** Navigate to login page
     *
     * @return  {@link LoginPage instance} */
    public LoginPage goToLogIn(){
        loginButton.click();
        return new LoginPage(driver);
    }
}

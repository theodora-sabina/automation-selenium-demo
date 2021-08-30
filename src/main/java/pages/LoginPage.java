package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverInstance;

public class LoginPage extends BasePage{

    @FindBy(id = "login_field")
    private WebElement loginInput;

    @FindBy(css = "input#password")
    private WebElement passwordInput;

    @FindBy(name = "commit")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(.,'Create an account')]")
    private WebElement createAccount;

    /** Constructor for {@link LoginPage}
     *
     * @param driver instance to use */
    public LoginPage(DriverInstance driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** Log in to account
     *
     * @return {@link LoginPage} instance */
    public LoginPage logIn(){
        loginInput.sendKeys("theodora-sabina");
        passwordInput.sendKeys("githubpass1!");
        submitButton.click();
        return this;
    }
}

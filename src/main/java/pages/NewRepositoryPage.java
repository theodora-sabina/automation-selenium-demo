package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverInstance;
import widgets.HeaderBar;

public class NewRepositoryPage extends HeaderBar {

    @FindBy(css="input#repository_name")
    WebElement repositoryName;
    @FindBy(css="input[name='repository[description]']")
    WebElement repositoryDescription;
    @FindBy(css="input[name='repository[visibility]']")//radio button ->same name
    List<WebElement> repositoryAccessType;
    @FindBy(css="#repository_gitignore_template_toggle")
    WebElement addGitignore;
    @FindBy(xpath="//button[contains(.,'Create repository')]")
    WebElement submitButton;
    @FindBy(css="input[type='radio'][value='public']")
    WebElement publicVisibility;
    @FindBy(css="input[type='radio'][value='private']")
    WebElement privateVisibility;

    /** Constructor for {@link NewRepositoryPage}
     *
     * @param driver instance to use */
    public NewRepositoryPage(DriverInstance driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillRepositoryFields(){

        //Input text field  -> type text
        //Send input text
        repositoryName.sendKeys("Test");
        //Clear text
        repositoryName.clear();
        repositoryName.sendKeys("test-repo");
        repositoryDescription.sendKeys("test repo description");
        //Web element methods
        System.out.println("Value attribute is: " + repositoryDescription.getAttribute("value"));
        System.out.println("Tag name attribute is: " + repositoryDescription.getTagName());
        System.out.println("Height is: " + repositoryName.getCssValue("height"));

        //Radio button -> input type radio
        repositoryAccessType.get(0).click();
        //Get the first element in the list and verify checked attribute
        System.out.println("Private repository is: "); repositoryAccessType.get(0).getAttribute("checked");
        //Get the second element in the list and check value attribute
        System.out.println("Public repository access type has value: " + repositoryAccessType.get(1).getAttribute("value"));

        //Other webElements built-in methods
        System.out.println("Is enabled: " + publicVisibility.isEnabled());  // can you click it?
        System.out.println("Is displayed: " + publicVisibility.isDisplayed()); //is it visible?
        System.out.println("Is selected: " + publicVisibility.isSelected());  //is it selected?

        //Checkbox -> input type checkbox
        addGitignore.click();
        System.out.println("Is selected: " + addGitignore.isSelected());
        System.out.println("Is enabled: " + addGitignore.isEnabled());
        System.out.println("Is displayed: " + addGitignore.isDisplayed());

        System.out.println("blabla");
     //   submitButton.submit();
    }
}

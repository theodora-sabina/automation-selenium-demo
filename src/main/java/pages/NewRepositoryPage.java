package pages;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverInstance;
import widgets.HeaderBar;

public class NewRepositoryPage extends HeaderBar {

    private static final Logger LOG = LogManager.getLogger(NewRepositoryPage.class);

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

        LOG.info("Value attribute is: {} ", repositoryDescription.getAttribute("value"));
        LOG.info("Tag name attribute is: {} ",  repositoryDescription.getTagName());
        LOG.info("Height is: {} ", repositoryName.getCssValue("height"));

        //Radio button -> input type radio
        repositoryAccessType.get(0).click();
        //Get the first element in the list and verify checked attribute
        LOG.info("Private repository is: "); repositoryAccessType.get(0).getAttribute("checked");
        //Get the second element in the list and check value attribute
        LOG.info("Public repository access type has value: {}" , repositoryAccessType.get(1).getAttribute("value"));

        //Other webElements built-in methods
        LOG.info("Is enabled: {}" , publicVisibility.isEnabled());  // can you click it?
        LOG.info("Is displayed: {}", publicVisibility.isDisplayed()); //is it visible?
        LOG.info("Is selected: {}",  publicVisibility.isSelected());  //is it selected?

        //Checkbox -> input type checkbox
        addGitignore.click();
        LOG.info("Is selected: {}" , addGitignore.isSelected());
        LOG.info("Is enabled: {}",  addGitignore.isEnabled());
        LOG.info("Is displayed: {}",  addGitignore.isDisplayed());

     //   submitButton.submit();
    }
}

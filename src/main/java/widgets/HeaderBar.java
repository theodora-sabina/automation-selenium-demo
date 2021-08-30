package widgets;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverInstance;

public class HeaderBar {

    protected DriverInstance driver;

    private static final String HEADER_WRAPPER_CSS = "header[class*='Header']"; //contains

    @FindBy(css = "notification-indicator[data-test-selector$='indicator']") //ends with
    WebElement notificationButton;
    @FindBy(css = "summary[aria-label^='Create new']") //starts with
    WebElement createNewButton;
    @FindBy(css = "summary[class='Header-link'][aria-label='View profile and more']")//multiple attributes
    WebElement viewProfileButton;
    @FindBy(css = "details:not([class*='js-feature-preview-indicator-container']) details-menu.dropdown-menu-sw a.dropdown-item")//not attribute ; direct child
    List<WebElement> createNewItems;

    /** Constructor for {@link HeaderBar}
     *
     * @param driver instance to use */
    public HeaderBar(DriverInstance driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

package pages;

import driver.DriverInstance;

public class BasePage {

    protected DriverInstance driver;

    /** Constructor for {@link BasePage} */
    public BasePage(DriverInstance driver) {
        this.driver = driver;
    }
}

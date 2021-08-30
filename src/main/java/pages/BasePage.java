package pages;

import driver.DriverInstance;

public class BasePage {

    protected DriverInstance driver;

    /** Constructor for {@link BasePage}
     *
     * @param driver instance to use */
    public BasePage(DriverInstance driver) {
        this.driver = driver;
    }
}

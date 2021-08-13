package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import driver.BrowserType;
import driver.DriverInstance;

public class TestDemo {

    @Test
    public void test() throws MalformedURLException {
        DriverInstance driver = new DriverInstance(new URL("http://localhost:4444/wd/hub"), BrowserType.CHROME);
        driver.get("https://github.com/");
    }
}

package tests;

import org.testng.annotations.Test;

import pages.StartPage;

public class TestDemo extends TestBase {

    @Test
    public void test() {
        driver.get("https://github.com/");
        StartPage startPage = new StartPage(driver);
        startPage.goToLogin();

        System.out.println("blabla");
    }
}

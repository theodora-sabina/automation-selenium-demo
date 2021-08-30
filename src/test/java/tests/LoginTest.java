package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.StartPage;

public class LoginTest extends TestBase {

    @Test
    public void login(){

       StartPage startPage = goToStartPage();
       LoginPage loginPage = startPage.goToLogIn();
       loginPage.logIn();

    }
}

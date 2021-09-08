package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.StartPage;

public class NavigationTest extends TestBase{

    @Test
    public void navigationTest() throws InterruptedException {

        StartPage startPage = goToStartPage();
        LoginPage loginPage = startPage.goToLogIn();
        loginPage.logIn();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='/theodora-sabina/automation-selenium-demo']")).click();

        //CSS
        //Header
        driver.findElement(By.cssSelector("header"));//tag name

        //Code tab
        driver.findElement(By.cssSelector("#code-tab"));  //id value
        driver.findElement(By.cssSelector("a#code-tab"));  //tag and id

        //Home button
        driver.findElement(By.cssSelector("a.Header-link"));//class value
        driver.findElement(By.cssSelector("a[class='Header-link ']"));//tag and class
        //Header
        driver.findElement(By.cssSelector("header.Header.Details"));//multiple classes

        //Search input
        driver.findElement(By.cssSelector("*[name='q']"));//name value
        driver.findElement(By.cssSelector("input[name='q']"));//tag and name

        //Header
        driver.findElement(By.cssSelector("[aria-label]"));//attribute name
        driver.findElement(By.cssSelector("[aria-label ='Homepage ']"));//attribute value
        driver.findElement(By.cssSelector("[class='Header-link'][aria-label='View profile and more']"));//multiple attributes
        driver.findElement(By.cssSelector("a[aria-label ='Homepage ']"));//tag and attribute
        driver.findElement(By.cssSelector("a[class^='Header']"));//attribute value start with
        driver.findElement(By.cssSelector("a[class*='Header']"));//attribute value contains
        driver.findElement(By.cssSelector("a[class$='link ']"));//attribute value ends with

        //CSS combinators
        //Descendant selector
        driver.findElement(By.cssSelector("header div"));//all the a tags found inside header
        //Child selector
        driver.findElement(By.cssSelector("header > div"));//all the divs, direct children of header
        //Adjacent sibling selector
        driver.findElement(By.cssSelector("header + div "));//selects all divs that are directly after header
        //General Sibling selector
        driver.findElement(By.cssSelector("header ~ div"));//selects all div that are next siblings of header

        //Dynamic elements
        driver.findElement(By.cssSelector("li:first-child"));//selects li elements that are first child of its parent; all li elements that are first child
        driver.findElement(By.cssSelector("ul > :first-child"));//first child element of every ul
        driver.findElement(By.cssSelector("li:first-of-type"));//first li element of it's parent; every element that is first li element of its parent
        driver.findElement(By.cssSelector("header:last-child"));//selects header elements that are the last child of its parent
        driver.findElement(By.cssSelector("header:last-of-type"));//selects last header child element of its parent
        driver.findElement(By.cssSelector("li:nth-child(3)"));//every li element that is the 3rd child of its parent / it is an li and is the 3rd element
        driver.findElement(By.cssSelector("li:nth-of-type(2)"));//second li child of its parent

        //XPath
        //Header
        driver.findElement(By.xpath("//header"));//tag name
        //Code tab
        driver.findElement(By.xpath("//*[@id='code-tab']"));//id
        //Home button
        driver.findElement(By.xpath("//*[@class='Header-link ']"));//class
        //Search input
        driver.findElement(By.xpath("//*[@name='q']"));//name
        //Home button
        driver.findElement(By.xpath("//*[@aria-label='Homepage ']")); // attribute
        driver.findElement(By.xpath("//a[@aria-label='Homepage ']"));// attribute and tag
        driver.findElement(By.xpath("//*[starts-with(@class, 'Header')]"));//attribute value start with
        driver.findElement(By.xpath("//*[contains(@class, 'Header')]"));//attribute value contains
   //     driver.findElement(By.xpath("//*[ends-with(@href, 'com')]"));//attribute value ends with//might not work with browser version
        driver.findElement(By.xpath("//*[@class='Header-link' and @aria-label='View profile and more']"));//multiple attributes


        //Absolute path - starting with root node
        driver.findElement(By.xpath("/html/body/div[1]/header"));

        //Relative path - path relative to the current node
        driver.findElement(By.xpath("//header//a")); //all the anchor tag that are children of header -> descendant element
        driver.findElement(By.xpath("//header/div"));//all the divs that are direct children of header -> direct child element
        driver.findElement(By.xpath("//header/div/a[1]"));//selects first a tag element, child of div(child of header)
        //    /div ->selects root element -> / absolute location path
        //    //div ->selects all divs no matter where they are in the DOM
        //   // -> selects from the current node

        driver.findElement(By.xpath("//nav//a[@href='/issues']")); //selects all anchor tags that are descendant of nav element, no matter where they are under the nav elem
        driver.findElement(By.xpath("//nav/*")); //selects all child elements of nav
        driver.findElement(By.xpath("//nav/a[@*]")); //selects all anchor tags that have any kind of attribute
        driver.findElement(By.xpath("//a[@href='/issues']/..")); //selects the parent of issues element -> go up a level
        driver.findElement(By.xpath("//a[@href='/issues']/.")); //selects current element

        //Dynamic elements
        driver.findElement(By.xpath("//header//a[2]"));
        driver.findElement(By.xpath("//header[last()]"));//selects last header element
        driver.findElement(By.xpath("//nav/a[last()-4]")); //selects the forth to last anchor element that is child of nav
        driver.findElement(By.xpath("//nav/a[position()=4]"));//selects the 4th a tag, direct child of nav
    }
}

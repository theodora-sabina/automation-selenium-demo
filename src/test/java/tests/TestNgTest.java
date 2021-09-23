package tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgTest extends TestBase{

    @BeforeClass
    public void beforeClass(){
        System.out.println("This is before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method");
    }

    @Test(description = "test 1", dependsOnGroups = "Smoke test")
    public void test1(){
        System.out.println("This is the first test");
    }

    @Test(description = "test 2")
    public void test2(Method testMethod){
        System.out.println("This is second test" );
    }

    @Test( timeOut = 5000, alwaysRun = true)
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("This is the third test");
    }

    @Test(description = "test 4", groups = "Smoke test")
    public void test4(){
        System.out.println("This is the 4th test" );
    }

    @Test(description = "test 5", groups = "Smoke test")
    public void test5(){
        System.out.println("This is the 5th test" );
    }

    @Test(description = "test 6")
    public void test6(){
        System.out.println("This is the 6th test" );
    }

}

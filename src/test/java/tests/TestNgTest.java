package tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class TestNgTest extends TestBase{

    @Test(description = "test 1", dependsOnGroups = "Smoke test")
    public void test1(){
        System.out.println("This is the first test");
    }

    @Test(description = "test 2", enabled = false)
    public void test2(Method testMethod){
        System.out.println("This is " );
    }

    @Test( timeOut = 500, alwaysRun = true)
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

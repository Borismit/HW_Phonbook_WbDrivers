package tests;

import org.testng.annotations.Test;

public class SmokeTest extends TestBase{
    //@BeforeMethod (alwaysRun = true)


    @Test (groups = {"web"})
    public void smokeTest(){
        System.out.println("Im Smoke Test ");
    }
}

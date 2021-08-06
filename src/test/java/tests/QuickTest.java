package tests;

import org.testng.annotations.Test;

public class QuickTest extends TestBase{


    @Test(groups = {"web","rest"})
    public void quicktest(){
        System.out.println("Im Quick test");
    }
}

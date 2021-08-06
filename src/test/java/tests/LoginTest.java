package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

@BeforeMethod
public void precondition(){
    if(app.userHelper().isLogged()){
        app.userHelper().logout();
    }
}



    @Test
    public void loginTestPositiveNewContact(){
      app.userHelper().click(By.xpath("//a[.='LOGIN']"));
        //app.userHelper().click(By.xpath(""));
        app.userHelper().type(By.xpath("//input[@placeholder='Email']"),"noa@gmail.com");
        app.userHelper().type(By.xpath("//input[@placeholder='Password']"),"Nnoa12345$");
        app.userHelper().click(By.xpath("//button[.=' Login']"));
        app.userHelper().pause(2000);
     /*   String loginNC=getText(By.xpath("//div//h1[.=' No Contacts here!']"));
        Assert.assertEquals(loginNC,"No Contacts here!");*/

        String loginS = app.userHelper().getText(By.xpath("//a[.='ADD']"));

        Assert.assertEquals(loginS,"ADD");

    }

    @Test
    public void loginTestWithWrongPassword(){
        User user= new User().withEmail("noa@gmail.com").withPassword("Nnoa12345");//через "." выбираем только те поля, которые нам надо заполнить
        app.userHelper().openLoginRegForm();
        app.userHelper().fillLoginRegForm(user);//в классе UserHelper создадим метод fillLoginForm(User user)
        app.userHelper().clickLoginButton();
       // app.userHelper().pause(5000);//метод pause() хранится в HelperBase, куда мы достаём через его ребёнка userHalper
        app.userHelper().acceptAlert();
        Assert.assertFalse(app.userHelper().isLogged());//если после логина появляется кнопка SignOut (узнаём её по тексту на ней), значит мы залогинились

    }
}

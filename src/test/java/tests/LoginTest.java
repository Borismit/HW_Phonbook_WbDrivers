package tests;

import manager.MyDataProvider;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//
//

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
    @Test
    public void loginTestBase(){
        User user= new User()
                .withEmail("noa@gmail.com")
                .withPassword("Nnoa12345$");

        app.userHelper().openLoginRegForm();
        app.userHelper().fillLoginRegForm(user);
        app.userHelper().clickLoginButton();

        Assert.assertTrue(app.userHelper().isLogged());

    }
    @DataProvider//предоставит тестовые данные
    //напишем метод, который создаёт коллекцию и наполняет её
    public Iterator<Object[] > validDataLogin()//Iterator проходит по коллекции и вычитывает из неё данные
    {
        List<Object[]> list= new ArrayList<>();//список List с коллекцией объектов
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});//добавляем объект массива из двух стрингов
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});

        return list.iterator();
    }


    @Test(dataProvider = "validDataLogin")//тестовые данные берём из метода validDataLogin из этого же класса
    public void loginTestDataProvider(String email, String password)//вычитываем два значения стрингов
    {
        User user= new User()
                .withEmail(email)
                .withPassword(password);
        app.userHelper().openLoginRegForm();
        app.userHelper().fillLoginRegForm(user);
        app.userHelper().clickLoginButton();
        app.userHelper().pause(2000);
        Assert.assertTrue(app.userHelper().isLogged());

    }
    @Test(dataProvider = "validLoginDataClassDP", dataProviderClass = MyDataProvider.class)//тестовые данные берём из метода validLoginDataClassDP из специально созданного класса MyDataProvider
    public void loginTestDataProviderClass(String email, String password){
        User user= new User()
                .withEmail(email)
                .withPassword(password);
        app.userHelper().openLoginRegForm();
        app.userHelper().fillLoginRegForm(user);
        app.userHelper().clickLoginButton();
        app.userHelper().pause(2000);
        Assert.assertTrue(app.userHelper().isLogged());

    }
    @Test(dataProvider = "dataFileCSV", dataProviderClass = MyDataProvider.class)//тестовые данные берём из метода dataFileCSV из специально созданного класса MyDataProvider
    public void loginTestDP_CSV(User user){


        app.userHelper().openLoginRegForm();
        app.userHelper().fillLoginRegForm(user);
        app.userHelper().clickLoginButton();

        Assert.assertTrue(app.userHelper().isLogged());

    }

}

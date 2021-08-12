package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }
    }

    @Test
    public void removeOneContact(){
        app.contact().removeOneContact();

    }

    @Test
    public void removeAllContacts(){
        app.contact().removeAllContacts();
    }
}

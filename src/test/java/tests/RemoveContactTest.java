package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));


//           if(!app.contact().sizeContact()){
//          //  if(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()=0){
//
//               int i = (int)((System.currentTimeMillis())/1000)%3600;
//
//               Contact contact = Contact.builder()
//                       .name("Contact")
//                       .lastname("Add")
//                       .email("add"+i+"@mail.com")
//                       .phone("123456"+i)
//                       .address("Haifa")
//                       .description("friend")
//                       .build();
//               app.contact().openFormContact();
//               app.contact().fillFormContact(contact);
//               app.contact().saveContact();
//           }
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

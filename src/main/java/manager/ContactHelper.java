package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ContactHelper extends HelperBase{
//генерируем конструктор супекласс (alt +enter)
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openFormContact() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void saveContact() {
        click(By.xpath("//button[.='Save']"));
    }

    public void fillFormContact(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastname());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public boolean isContactAdded(String phone) {
        List<WebElement> contacts = wd.findElements(By.xpath("//h3"));
        for (WebElement el:contacts) {
            if(el.getText().contains(phone)){
                System.out.print(el.getText());
                return true;
            }

        }

        return false;
    }

    public void removeOneContact() {


        if(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() == 0) //если список пустой, добавим контакт
        {
            addContactTestBase();
        }
            WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
            contact.click();
            click(By.xpath("//button[.='Remove']"));

    }

    public void removeAllContacts() {
        // List<WebElement> contacts = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
//        for (WebElement el:contacts) {
//            el.click();//здесь при удалении второго элемента (на втором кругу) падает, т. к. после первого
                         //удаления картинка перерисоывается и ранее найденая ссылка из-за удаления элемента теряется
//            click(By.xpath("//button[.='Remove']"));
//        }

        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0)//метод работает, т. к. после каждой перерисовки
                                                                                      //картинки вновь происходит поиск элемента по локатору
        {
            removeOneContact();
            pause(2000);
        }
    }

    public void addContactTestBase() {

          int i = (int)((System.currentTimeMillis())/1000)%3600;

           Contact contact = Contact.builder()
                 .name("Contact")
                  .lastname("Add")
                   .email("add"+i+"@mail.com")
                    .phone("123456"+i)
                  .address("Haifa")
                   .description("friend")
                    .build();

           openFormContact();
           fillFormContact(contact);
           saveContact();
            Assert.assertTrue(isContactAdded(contact.getPhone()));

    }


//     public boolean sizeContact(){ return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()>0; }

}

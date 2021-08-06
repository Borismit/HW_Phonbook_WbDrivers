package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;
    //сгенерируем конструктор: Ganerate->constractor->wd:WebDraiver,
    //который даёт классу HelperBase, как родителю, диктовать каким образом создавать экземпляры дочерних классов
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }//это конструктор

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    //метод, который будет вычитывать текст из элемента и возвращать
    public String getText(By locator) {
        return wd.findElement(locator).getText();
    }
    //пишем метод pause(), чтобы хватило времени отрисовать картинку
    public void pause(int millise) {
        try {
            Thread.sleep(millise);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

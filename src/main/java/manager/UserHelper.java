package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{
    //передадим (создадим) конструктор от суперкласса HelperBase, чтобы HelperBase стал его наследником: ставим курсор на строчку HelperBase->alt+enter-> Grate constractor ...
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegForm() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void fillLoginRegForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void clickLoginButton() {
        click(By.xpath("//button[1]"));
    }

    public void acceptAlert() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());//будет ждать до 10 сек. пока не появится alert
        wd.switchTo().alert().accept();//переключается на предыдущую страницу, т. е. на alert(), потом делает accept(), т. е. нажим. кн. ОК
    }

    public boolean isLogged()
//проверяем есть ли кнопка LOGIN, если есть, то вернётся true, если нет, то falls
    {
        return wd.findElements(By.xpath("//button[text()='Sign Out']")).size()>0;//если размер списка findElements >0, то элемент (кнопка) LOGIN есть,
                                                                                 //если <0, то её нет и вернётся не ошибка а falls
    }

    public void logout() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//button[text()='Sign Out']"))));
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void login(User user) {
        openLoginRegForm();
        fillLoginRegForm(user);
        clickLoginButton();
        pause(1000);

    }
}

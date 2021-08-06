package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AppManager {
    WebDriver wd;
    UserHelper userHelper;
    String browser;

    //генерируем конструктор, который принимает стринг браузер: клик правой ->Generete...->constructor->browser:String
    public AppManager(String browser) {
        this.browser = browser;
    }

    public void start() //проверяем какой наш браузер
        {
        //если BrowserType.CHROME, то наш браузер CHROME
        if(browser.equals(BrowserType.CHROME))
        {
            wd = new ChromeDriver();//наш браузер CHROME
        } else if (browser.equals(BrowserType.FIREFOX))//иначе
        {
            wd= new FirefoxDriver();//наш браузер FIREFOX
        }

        //wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        userHelper =new UserHelper(wd);//инициализируем userHalper




    }
    public void stop(){
        wd.quit();
    }
    //сгенерируем гетер по полю UserHalper, чтобы метод (поле) UserHalper был доступен (потом getUserHalper переименуем для краткости в userHalper ) его наследникам
    public UserHelper userHelper() {
        return userHelper;
    }
}

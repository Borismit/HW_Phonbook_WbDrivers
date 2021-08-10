package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AppManager {
   //WebDriver wd;
   EventFiringWebDriver wd;//это какбы обёртка для прослушивания Event-ом событий Listener-ом (MyListener)
    UserHelper userHelper;
    String browser;

    //генерируем конструктор, который принимает стринг браузер: клик правой ->Generete...->constructor->browser:String
    public AppManager(String browser) { this.browser = browser; }
    Logger logger = LoggerFactory.getLogger(AppManager.class);
    public void start() //проверяем какой наш браузер
        {
        //если BrowserType.CHROME, то наш браузер CHROME
        if(browser.equals(BrowserType.CHROME))
            if(browser.equals(BrowserType.CHROME)){
                wd = new EventFiringWebDriver(new ChromeDriver());//EventFiringWebDriver - это обёртка
                logger.info("Start in browser CHROME");//если отработала предыдущая строка, то логер запишет, что стартовал браузер CHROME
            }else if (browser.equals(BrowserType.FIREFOX)){
                wd= new EventFiringWebDriver(new FirefoxDriver());//EventFiringWebDriver - это обёртка - это обёртка
                logger.info("Start in browser FIREFOX");
            }
            wd.register(new MyListener());//регестрируем тот Listener, который описали в классе MyListener

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

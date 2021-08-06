package tests;

import manager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

   protected static AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));//если в консоле не указан браузер, то запустится, указанный здесь, BrowserType.CHROME,
                                                                                                           //если указан, то подставится сюда по ключу key "browser"
    @BeforeSuite(alwaysRun = true)//чтобы всегда запускался метод, а значит и браузер, поставим сюда alwaysRun = true
    public void init() {
       app.start();
    }


    @AfterSuite(alwaysRun = true)//чтобы всегда запускался метод, а значит закрывался браузер, поставим сюда alwaysRun = true
    public void tearDown() {
       app.stop();
    }


    }




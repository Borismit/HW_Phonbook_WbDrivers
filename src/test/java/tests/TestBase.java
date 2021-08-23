package tests;

import manager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

   protected static AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));//если в консоле не указан браузер, то запустится, указанный здесь, BrowserType.CHROME, если указан, то подставится сюда по ключу key "browser"


   Logger logger= LoggerFactory.getLogger(TestBase.class);//создадим логер в классе TestBase

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m,Object[] p){
        logger.info("Start method -->"+m.getName() );
        logger.info("Test Start with Data -->"+ Arrays.asList(p) );
        logger.info( "==================================================================");
    }
    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m){
        logger.info("End of method -->"+m.getName());
    }

    @BeforeSuite(alwaysRun = true)//чтобы всегда запускался метод, а значит и браузер, поставим сюда alwaysRun = true
    public void init() {
        app.start();
    }


    @AfterSuite(alwaysRun = true)//чтобы всегда запускался метод, а значит закрывался браузер, поставим сюда alwaysRun = true
    public void tearDown() {
        app.stop();
    }


    }




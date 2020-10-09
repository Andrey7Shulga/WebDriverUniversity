package bigtraining.tests;

import bigtraining.components.Helper;
import bigtraining.listeners.WebDriverListener;
import bigtraining.pages.ContactUs;
import bigtraining.pages.DropD_CheckB_RadioB;
import bigtraining.pages.ToDoList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Helper hp;
    protected ContactUs cu;
    protected ToDoList tdl;
    protected DropD_CheckB_RadioB dcr;


    protected final String url = "http://webdriveruniversity.com/index.html";


    @BeforeClass
    public void setUP () {

        ///Log4J configuration
        BasicConfigurator.configure();

        hp = new Helper(driver, wait);
        cu = new ContactUs(driver, wait);
        tdl = new ToDoList(driver, wait);
        dcr = new DropD_CheckB_RadioB(wait);

    }

    @BeforeTest
    public void beforeTest() {

        //WebDriver setup
        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true);
//        driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);

        //WebListener setup
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new WebDriverListener());
        driver = eventFiringWebDriver;

        driver.get(url);

    }

    @AfterTest
    public void afterTest() {

        if(driver != null) {
            driver.quit();
        }
    }


    @AfterClass
    public void afterClass () {

        if(driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

}

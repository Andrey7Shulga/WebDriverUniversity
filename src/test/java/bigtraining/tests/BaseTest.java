package bigtraining.tests;

import bigtraining.components.Helper;
import bigtraining.components.Menu;
import bigtraining.listeners.WebDriverListener;
import bigtraining.pages.ButtonClick;
import bigtraining.pages.ContactUs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

//    protected static WebDriver driver;
//    protected static WebDriverWait wait;
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Helper hp;
    protected Menu mn;
    protected ContactUs cu;
    protected ButtonClick bc;

    private final int implicitTime = 5;
    private final int timeout = 10;

    protected final String url = "http://webdriveruniversity.com/index.html";


    @BeforeClass
    public void setUP () {

        ///Log4J configuration
        BasicConfigurator.configure();





        hp = new Helper(driver, wait);
        mn = new Menu(driver, wait);
        cu = new ContactUs(driver, wait);
        bc = new ButtonClick(driver, wait);


    }

    @BeforeTest
    public void beforeTest() {

        //WebDriver setup
        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true);
//        driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, timeout);

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

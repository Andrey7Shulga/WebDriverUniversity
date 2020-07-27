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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    static WebDriver driver;
    static WebDriverWait wait;
    private int implicitTime = 5;
    private int timeout = 10;

    @BeforeClass
    public void beforeTest () {

        ///Log4J configuration
        BasicConfigurator.configure();

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


    }

    @AfterClass
    public void afterClass () {

        if(driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }




}

package bigtraining.tests;

import bigtraining.components.Helper;
import bigtraining.components.JSExecutor;
import bigtraining.listeners.WebDriverListener;
import bigtraining.pages.*;
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
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Helper hp;
    protected JSExecutor jsExecutor;

    protected ContactUs cu;
    protected ToDoList tdl;
    protected DropD_CheckB_RadioB dcr;
    protected DatePicker dp;
    protected AccordionTextAffects ata;
    protected AutocompleteTextfield actf;





    protected final String url = "http://webdriveruniversity.com/index.html";
//    protected final String url = "https://www.youtube.com/";


    @BeforeClass
    public void setUP () {

        ///Log4J configuration
        BasicConfigurator.configure();

        hp = new Helper(driver, wait);
        jsExecutor = new JSExecutor(driver, wait);
        cu = new ContactUs(driver, wait);
        tdl = new ToDoList(driver, wait);
        dcr = new DropD_CheckB_RadioB(wait);
        dp = new DatePicker(driver, wait);
        ata = new AccordionTextAffects(driver, wait);
        actf = new AutocompleteTextfield(wait);

    }

    @BeforeTest
    public void beforeTest() {

        //WebDriver setup
        WebDriverManager.chromedriver().setup();

        //driver options
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true);
//
//        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS); //ignore and dismiss unexpected alert window
//
//        chromeOptions.setExperimentalOption(
//        "excludeSwitches", Arrays.asList("disable-popup-blocking")); //close all the popup windows

//        driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 12);

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

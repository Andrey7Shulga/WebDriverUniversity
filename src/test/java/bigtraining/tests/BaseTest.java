package bigtraining.tests;

import bigtraining.components.Helper;
import bigtraining.components.JSExecutor;
import bigtraining.listeners.WebDriverListener;
import bigtraining.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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
    protected FileUpload fu;

    protected final String url = "http://webdriveruniversity.com/index.html";

    @BeforeClass
    public void beforeClass() {
        //WebDriver setup
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        ///Log4J configuration
        BasicConfigurator.configure();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 12);

        //WebListener setup
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new WebDriverListener());
        driver = eventFiringWebDriver;

        hp = new Helper(driver, wait);
        jsExecutor = new JSExecutor(driver, wait);
        cu = new ContactUs(driver, wait);
        tdl = new ToDoList(driver, wait);
        dcr = new DropD_CheckB_RadioB(driver, wait);
        dp = new DatePicker(driver, wait);
        ata = new AccordionTextAffects(wait);
        actf = new AutocompleteTextfield(wait);
        fu = new FileUpload();

        driver.get(url);
    }

    @AfterMethod
    public void afterMethod() {
        if(driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    @AfterClass
    public void afterClass () {
        if(driver != null) {
            driver.quit();
        }
    }
}
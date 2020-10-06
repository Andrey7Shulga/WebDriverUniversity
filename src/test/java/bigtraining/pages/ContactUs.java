package bigtraining.pages;

import bigtraining.components.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class ContactUs {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    private final String fnameXpath = "//*[@name='first_name']";
    private final String lnameXpath = "//*[@name='last_name']";
    private final String emailXpath = "//*[@name='email']";
    private final String commentsXpath = "//*[@name='message']";
    private final String fnameValue = "Chris";
    private final String lnameValue = "Boil";
    private final String emailValue = "1@hotmail.com";
    private final String commentsValue = "Hello, World";
    private final String atribute = "value";

    public static final String tabname = "WebDriver | Contact Us";
    public static final String resetButtonXpath = "//*[@type='reset']";
    public static final String submitButtonXpath = "//*[@type='submit']";
    public static final String validMessageXpath = "//div[@id='contact_reply']/h1";


    public ContactUs(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

    }


    public void typeData () {

        setValue(fnameXpath, fnameValue);
        setValue(lnameXpath, lnameValue);
        setValue(emailXpath, emailValue);
        setValue(commentsXpath, commentsValue);

    }

    public void typeDataProvider (String fnameValue, String lnameValue, String emailValue, String commentsValue) {

        setValue(fnameXpath, fnameValue);
        setValue(lnameXpath, lnameValue);
        setValue(emailXpath, emailValue);
        setValue(commentsXpath, commentsValue);

    }

    public void validateInputData () {

        assertEquals(getAttribute(fnameXpath, atribute), fnameValue);
        assertEquals(getAttribute(lnameXpath, atribute), lnameValue);
        assertEquals(getAttribute(emailXpath, atribute), emailValue);
        assertEquals(getAttribute(commentsXpath, atribute), commentsValue);

    }

    public void validateResetOption () {

        assertEquals(getAttribute(fnameXpath, atribute), "");
        assertEquals(getAttribute(lnameXpath, atribute), "");
        assertEquals(getAttribute(emailXpath, atribute), "");
        assertEquals(getAttribute(commentsXpath, atribute), "");

    }


    public void setValue (String xpath, String val) {
        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.clear();
        element.sendKeys(val);

    }


    public String getAttribute (String xpath, String atr) {

        element = driver.findElement(By.xpath(xpath));
        return element.getAttribute(atr);
    }


}

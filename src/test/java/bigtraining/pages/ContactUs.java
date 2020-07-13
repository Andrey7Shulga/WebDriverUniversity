package bigtraining.pages;

import bigtraining.components.Helper;
import bigtraining.components.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class ContactUs {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    private Helper hp;

    private String fnameXpath = "//*[@name='first_name']";
    private String lnameXpath = "//*[@name='last_name']";
    private String emailXpath = "//*[@name='email']";
    private String commentsXpath = "//*[@name='message']";
    private String resetButton = "//*[@type='reset']";
    private String submitButton = "//*[@type='submit']";
    private String validMessageXpath = "//div[@id='contact_reply']/h1";


    private String fnameValue = "Chris";
    private String lnameValue = "Boil";
    private String emailValue = "1@hotmail.com";
    private String commentsValue = "Hello, World";

    private String atribute = "value";


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

        assertEquals(getAtribute(fnameXpath, atribute), fnameValue);
        assertEquals(getAtribute(lnameXpath, atribute), lnameValue);
        assertEquals(getAtribute(emailXpath, atribute), emailValue);
        assertEquals(getAtribute(commentsXpath, atribute), commentsValue);

    }

    public void validateResetOption () {

        assertEquals(getAtribute(fnameXpath, atribute), "");
        assertEquals(getAtribute(lnameXpath, atribute), "");
        assertEquals(getAtribute(emailXpath, atribute), "");
        assertEquals(getAtribute(commentsXpath, atribute), "");

    }

    public void clickOnResetButton() {
        click(resetButton);
    }

    public void clickOnSubmitButton() {
        click(submitButton);
    }


    public void setValue (String xpath, String val) {
        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.clear();
        element.sendKeys(val);

    }

    public String getTextFromValidMessage() {

//        element = driver.findElement(By.xpath(xpath));
        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(validMessageXpath)));
        return element.getText();
    }

    public String getAtribute (String xpath, String atr) {

        element = driver.findElement(By.xpath(xpath));
        return element.getAttribute(atr);
    }

    public void click(String xpath) {

        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.click();

    }




}

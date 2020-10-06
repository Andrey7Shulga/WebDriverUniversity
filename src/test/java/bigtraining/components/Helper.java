package bigtraining.components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class Helper {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;


    public Helper(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

    }

    public Helper() {
    }

    public void submit() {

    }


    public void sendKeys(CharSequence... charSequences) {

    }

    public void clear() {

    }

    public String getTagName() {
        return null;
    }

    public String getAttribute(String s) {
        return null;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return false;
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return null;
    }

    public Rectangle getRect() {
        return null;
    }

    public String getCssValue(String s) {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    public boolean switchToTab(String tabName){

//        log.debug("Switch to {} tab",tabName);
//        ArrayList<String> tab = new ArrayList(driver.getWindowHandles());
//        ArrayList<String> tabList = new ArrayList();
        ArrayList<String> tab = new ArrayList(driver.getWindowHandles());
        ArrayList<String> tabList = new ArrayList();

        for (int i=0; i<tab.size(); i++){

            tabList.add(i, driver.switchTo().window(tab.get(i)).getTitle());
            driver.switchTo().window(tab.get(0));

            if(tabList.get(i).equals(tabName)){
                driver.switchTo().window(tab.get(i));
                return true;
            }
        }
        return false;
    }


    public void messagePageHandling(String message, String messageTwo) {

//        up to two strings error
        String errorPageXpath = "//body/br";

        int size;
        List<WebElement> errorPage = driver.findElements(By.xpath(errorPageXpath));

        if (errorPage != null) {
             size = errorPage.size();

            if (size == 2) {

                assertTrue(bodyGetTextToCompare(message));
                assertTrue(bodyGetTextToCompare(messageTwo));

            } else if (size == 1) {

                assertTrue(bodyGetTextToCompare(message));

            }

        } else  {

            assertTrue(bodyGetTextToCompare(message));

        }


    }

    public String getTextFromElement (String elementXpath) {

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return element.getText();

    }

    public boolean bodyGetTextToCompare(String text) {

        element = driver.findElement(By.tagName("body"));
        return element.getText().contains(text);

    }


    public void clickElement(String elementXpath) {

        element = driver.findElement(By.xpath(elementXpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    public void actionMoveAndClickElement(String xPath) {

        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));

        actions.moveToElement(element, 50, 20);
        actions.click();
        actions.build().perform();

    }

    public void setValue (String xpath, String val) {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.clear();
        element.sendKeys(val);

    }

    public void waitUntilElementIsAbsence (String xPath, String elementValue) {

        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(By.xpath(xPath), elementValue)));

    }

    public void waitUntilElementIsPresented (String xPath, String elementValue) {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xPath), elementValue));

    }


}

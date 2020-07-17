package bigtraining.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Helper {

    private WebDriver driver;
    private WebDriverWait wait;


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
        WebElement body = driver.findElement(By.tagName("body"));

        int size;
        List<WebElement> errorPage = driver.findElements(By.xpath(errorPageXpath));

        if (errorPage != null) {
             size = errorPage.size();

            if (size == 2) {

                assertEquals(true, body.getText().contains(message));
                assertEquals(true, body.getText().contains(messageTwo));

            } else if (size == 1) {

                assertEquals(true, body.getText().contains(message));

            }

        } else  {

            assertEquals(true, body.getText().contains(message));

        }


    }

    public String getTextFromValidMessage(String elementXpath) {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return element.getText();

    }


    public void clickElement(String elementXpath) {

        WebElement element = driver.findElement(By.xpath(elementXpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }





}

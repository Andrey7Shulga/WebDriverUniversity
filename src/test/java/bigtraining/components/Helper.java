package bigtraining.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Helper {

     private WebDriver driver;
     private WebDriverWait wait;
    WebElement element;


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

        for (int i =0; i<tab.size(); i++){

            tabList.add(i,driver.switchTo().window(tab.get(i)).getTitle());
            driver.switchTo().window(tab.get(0));

            if(tabList.get(i).equals(tabName)){
                driver.switchTo().window(tab.get(i));
                return true;
            }
        }
        return false;
    }

//    public void setValue (String xpath, String val) {
//        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//        element.clear();
//        element.sendKeys(val);
//
//    }



}

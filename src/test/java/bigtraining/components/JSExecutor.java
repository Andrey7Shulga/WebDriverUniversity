package bigtraining.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSExecutor {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;
    private final Helper hp;

    public JSExecutor (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.js = (JavascriptExecutor) driver;
        hp = new Helper();
    }


    public void scrollVertical(int y) {
        js.executeScript("window.scrollTo(0," + y + ")");
    }

    public void scrollHorizontal(int x) {
        js.executeScript("window.scrollTo("+ x +",0)");
    }

    public void scrollToCoordinates(int x, int y) {
        js.executeScript("window.scrollTo(" + x + "," + y + ")");
    }


    public void scrollToSpecificElement(String elementXpath) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void scrollUntilTheBottomOfThePage() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollDynamicallyForLoadingPage_loop() {
        long initialHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();

        while(true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            hp.sleep(2000);

            long currentHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
            if (currentHeight == initialHeight) {
                break;
            }
            initialHeight = currentHeight;

        }
        System.out.println("Height is: " + initialHeight);
    }


    public void testScrollDynamic() {
        Object lastHeight = js.executeScript("return document.body.scrollHeight");

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            hp.sleep(3000);

            Object newHeight = js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
        System.out.println("Height is: " + lastHeight.toString());
    }

    public void clickOnElement (String ccsPath) {
        js.executeScript("document.querySelector('" + ccsPath + "').click();");
    }

}

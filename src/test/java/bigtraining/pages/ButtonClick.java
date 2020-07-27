package bigtraining.pages;

import bigtraining.components.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonClick {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    private Actions actions;

    private String webElementClickButton_Xpath = "//*[@id=\"button1\"]";
//    private String JavaScriptClickButton_CSS = "#button2";
    private String ActionMoveClickButton_CSS = "#button3";



    public ButtonClick(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

    }

    public void clickXpath () {
        clickElementXpath(webElementClickButton_Xpath);

    }



    public void clickElementXpath (String elementXpath) {

        element = driver.findElement(By.xpath(elementXpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    public void actionMoveAndClickElement() {

        actions = new Actions(driver);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ActionMoveClickButton_CSS)));

        actions.moveToElement(element, 50, 20)
                .click()
                .build()
                .perform();

    }


















}

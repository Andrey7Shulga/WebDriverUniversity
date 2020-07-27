package bigtraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToDoList {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    private Actions actions;

    String plusIconXpath = "//*[@id='plus-icon']";
    String addNewToDoFieldXpath = "//*[@type='text']";
    String toDoCollectionXpath = "//*[@id='container']//ul";
    String trashButtonXpath = "//*[@id='container']//ul/li//i";


    public ToDoList (WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void plusButtonFunctionality() {

        clickElementXpath(plusIconXpath);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(addNewToDoFieldXpath)));
        clickElementXpath(plusIconXpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addNewToDoFieldXpath)));


    }








    public void clickElementXpath (String elementXpath) {

        element = driver.findElement(By.xpath(elementXpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }








}

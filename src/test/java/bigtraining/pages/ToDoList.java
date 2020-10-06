package bigtraining.pages;

import bigtraining.components.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ToDoList {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions act;

    String nameToDelete = "Practice magic";
    String newName = "New age";
    int index;
    String elementDeleteButtonXpath = null;
    String elementToDeleteXpath = null;

    String containerListXpath = "//ul/li";
    String newElementFieldXpath = "//input";

    public ToDoList (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        act = new Actions(driver);
    }

    public List<String> checkContainerSizeAndGetNamesList (int size) {

        List<String> list = new ArrayList<String>();

        List<WebElement> containerList = driver.findElements(By.xpath(containerListXpath));
        assertEquals(size, containerList.size());

        for (int i = 1; i <= containerList.size(); i++ ) {

            list.add(driver.findElement(By.xpath("" + containerListXpath + "[" + i + "]" + "")).getText());

        }
        return list;

    }

    public void findNeededElementXpath (List<String> list, String nameToDelete) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(nameToDelete)) {
                index =  i + 1;
                elementToDeleteXpath = containerListXpath + "[" + index + "]";
                elementDeleteButtonXpath = elementToDeleteXpath + "/span/i";
            }
        }
    }

    public void hoverAnElementNeeded () {

        assert elementToDeleteXpath != null;
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementToDeleteXpath)));

        act.moveToElement(element, 50, 20)
                .build().perform();

    }

    public void deleteAnElementNeeded () {

        WebElement deleteButton = driver.findElement(By.xpath(elementDeleteButtonXpath));
        deleteButton.click();

    }

    public void isElementDeleted () {

        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body"), nameToDelete)));

    }

    public void typeAndSubmitNewElement () {

        WebElement newElementField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(newElementFieldXpath)));

        act.click(newElementField)
                .sendKeys(newName)
                .sendKeys(Keys.ENTER)
                .build().perform();

    }

    public void isNewElementPresent () {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul/li[3]"), newName));

    }


















}

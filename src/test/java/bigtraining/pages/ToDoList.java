package bigtraining.pages;

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

    public static final String tabName = "WebDriver | To Do List";
    public static final String nameToDelete = "Practice magic";
    public static final String newName = "New age";
    public static final String elementXpathToFindText = "//body";
    public static String elementDeleteButtonXpath = null;
    public static String elementToDeleteXpath = null;

    int index;
    public static final String containerListXpath = "//ul/li";
    String newElementFieldXpath = "//input";

    public ToDoList (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        act = new Actions(driver);
    }

    public List<String> checkContainerSizeAndGetNamesList () {
        List<String> list = new ArrayList<>();
        List<WebElement> containerList = driver.findElements(By.xpath(containerListXpath));
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

    public void typeAndSubmitNewElement () {
        WebElement newElementField =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(newElementFieldXpath)));
        act.click(newElementField)
                .sendKeys(newName)
                .sendKeys(Keys.ENTER)
                .build().perform();
    }
}

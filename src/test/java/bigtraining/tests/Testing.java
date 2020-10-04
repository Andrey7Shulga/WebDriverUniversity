package bigtraining.tests;

import bigtraining.listeners.TestListener;
import dataprovider.ContactUsDataProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)

public class Testing extends BaseTest {

    @Test
    public void testContactUsPage () {

        String tabname = "WebDriver | Contact Us";
        String validMessage = "Thank You for your Message!";

        //click to get the 'Contact Us' Page
        mn.getContactUs();

        //switch to the next tab
        hp.switchToTab(tabname);

        //type the data to the fields
        cu.typeData();

        //compare input data and actual data
        cu.validateInputData();

        cu.clickOnResetButton();

        //validate all the fields to
        cu.validateResetOption();

        //reinput data to submit
        cu.typeData();

        cu.clickOnSubmitButton();

        ///get the element message
        assertEquals(validMessage, cu.getTextFromValidMessage());

    }

    @Test(dataProvider = "SubmitToUs", dataProviderClass = ContactUsDataProvider.class)
    public void testContactUsDataProvider(String fnameValue, String lnameValue, String emailValue,
                                      String commentsValue, String message, String messageTwo) {

        String tabname = "WebDriver | Contact Us";

        driver.get(url);

        //click to get the 'Contact Us' Page
        mn.getContactUs();

        //switch to the next tab
        hp.switchToTab(tabname);

        //type data to be verified
        cu.typeDataProvider(fnameValue, lnameValue, emailValue, commentsValue);

        //click on submit button
        cu.clickOnSubmitButton();

        //messages assertion
        hp.messagePageHandling(message, messageTwo);

        }



     @Test
     public void webElementClickTest () {

         String tabname = "WebDriver | Button Clicks";
         String passText = "Congratulations!";
         String passTextXpath = "//*[@id='myModalClick']//h4";

         //click to get the 'BUTTON CLICKS' Page
         mn.buttonClicks();

         //switch to the next tab
         hp.switchToTab(tabname);

         //click the WebElement button
         bc.clickXpath();

         //assert a success window message
         assertEquals(passText, hp.getTextFromValidMessage(passTextXpath));


     }

     @Test
    public void javaScriptClickTest() {

         JavascriptExecutor js = (JavascriptExecutor) driver;

         String tabname = "WebDriver | Button Clicks";
         String passText = "It’s that Easy!! Well I think it is.....";
         String passTextXpath = "//*[@id='myModalJSClick']//h4";

         //click to get the 'BUTTON CLICKS' Page
         mn.buttonClicks();

         //switch to the next tab
         hp.switchToTab(tabname);

         js.executeScript("document.querySelector('#button2').click();");

         //assert a success window message
         assertEquals(passText, hp.getTextFromValidMessage(passTextXpath));


     }

     @Test
    public void actionMoveClickTest() {

         String tabname = "WebDriver | Button Clicks";
         String passText = "Action Move & Click";
         String passTextXpath = "//*[@id='myModalMoveClick']//h4/b";

         //click to get the 'BUTTON CLICKS' Page
         mn.buttonClicks();

         //switch to the next tab
         hp.switchToTab(tabname);

         bc.actionMoveAndClickElement();

         //assert a success window message
         assertEquals(passText, hp.getTextFromValidMessage(passTextXpath));

     }

     @Test
    public void toDoList() {

         String tabName = "WebDriver | To Do List";
         String nameToDelete = "Practice magic";
         String newName = "New age";
         int index;

         String containerListXpath = "//ul/li";
//         String elementDeleteButtonXpath = "//ul/li[1]/span/i";
         String elementDeleteButtonXpath = null;
         String elementToDeleteXpath = null;
         String newElementFieldXpath = "//input";

         List<String> containerNames = new ArrayList<String>();
         Actions act = new Actions(driver);

         mn.toDoListClick();

        //switch to the next tab
        hp.switchToTab(tabName);

        List<WebElement> containerList = driver.findElements(By.xpath(containerListXpath));
        assertEquals(3, containerList.size());

        for (int i = 1; i <= containerList.size(); i++ ) {

            containerNames.add(driver.findElement(By.xpath("" + containerListXpath + "[" + i + "]" + "")).getText());

        }

        //find an needed element index

        for (int i = 0; i < containerNames.size(); i++) {

            if (containerNames.get(i).equals(nameToDelete)) {
                index = i + 1;
                elementToDeleteXpath = containerListXpath + "[" + index + "]";
                elementDeleteButtonXpath = elementToDeleteXpath + "/span/i";
            }
        }


        //hover an element
//         WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[1]")));
         assert elementToDeleteXpath != null;
         WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementToDeleteXpath)));

         act.moveToElement(element, 50, 20)
                 .build().perform();

         //delete an element
         WebElement deleteButton = driver.findElement(By.xpath(elementDeleteButtonXpath));
         deleteButton.click();

         //wait an element for being deleted
//         wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul/li[1]"), "Go to potion class")));
//         wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementToDeleteXpath), nameToDelete)));
         wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body"), nameToDelete)));

         //check the containerList new size
         containerList = driver.findElements(By.xpath(containerListXpath));
         assertEquals(2, containerList.size());

         //type a new element name to be added to containerList
         WebElement newElementField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(newElementFieldXpath)));

         act.click(newElementField)
                 .sendKeys(newName)
                 .sendKeys(Keys.ENTER)
                 .build().perform();

         //wait an element for being deleted
         wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul/li[3]"), newName));

         //check the containerList new size
         containerList = driver.findElements(By.xpath(containerListXpath));
         assertEquals(3, containerList.size());


     }


    }

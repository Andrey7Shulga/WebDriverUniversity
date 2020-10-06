package bigtraining.tests;

import bigtraining.listeners.TestListener;
import bigtraining.pages.ButtonClick;
import dataprovider.ContactUsDataProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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

         String passText = "Congratulations!";
         String passTextXpath = "//*[@id='myModalClick']//h4";

         //click to get the 'BUTTON CLICKS' Page
         mn.buttonClicks();

         //switch to the next tab
         hp.switchToTab(ButtonClick.tabName);

         //click the WebElement button
         hp.clickElement(ButtonClick.webElementClickButton_Xpath);

         //assert a success window message
         assertEquals(passText, hp.getTextFromValidMessage(passTextXpath));

     }

     @Test
    public void javaScriptClickTest() {

         JavascriptExecutor js = (JavascriptExecutor) driver;

         String passText = "It’s that Easy!! Well I think it is.....";
         String passTextXpath = "//*[@id='myModalJSClick']//h4";

         //click to get the 'BUTTON CLICKS' Page
         mn.buttonClicks();

         //switch to the next tab
         hp.switchToTab(ButtonClick.tabName);

         js.executeScript("document.querySelector('#button2').click();");

         //assert a success window message
         assertEquals(passText, hp.getTextFromValidMessage(passTextXpath));


     }

     @Test
    public void actionMoveClickTest() {

         String passText = "Action Move & Click";
         String passTextXpath = "//*[@id='myModalMoveClick']//h4/b";

         //click to get the 'BUTTON CLICKS' Page
         mn.buttonClicks();

         //switch to the next tab
         hp.switchToTab(ButtonClick.tabName);

         //getting MoveAndClick action
         hp.actionMoveAndClickElement(ButtonClick.ActionMoveClickButton_Xpath);

         //assert a success window message
         assertEquals(passText, hp.getTextFromValidMessage(passTextXpath));

     }


    @Test
    public void toDoList() {

        String tabName = "WebDriver | To Do List";
        String nameToDelete = "Practice magic";

        mn.toDoListClick();

        //switch to the next tab
        hp.switchToTab(tabName);

        //create and check a list of elements names
        List<String> containerNames = tdl.checkContainerSizeAndGetNamesList(3);

        tdl.findNeededElementXpath(containerNames, nameToDelete);
        tdl.hoverAnElementNeeded();
        tdl.deleteAnElementNeeded();
        tdl.isElementDeleted();

        //check a list of elements names
        tdl.checkContainerSizeAndGetNamesList(2);

        tdl.typeAndSubmitNewElement();
        tdl.isNewElementPresent();

        //check a list of elements names
        tdl.checkContainerSizeAndGetNamesList(3);

    }


    }

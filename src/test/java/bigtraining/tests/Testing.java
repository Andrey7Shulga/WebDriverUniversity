package bigtraining.tests;

import bigtraining.components.Menu;
import bigtraining.listeners.TestListener;
import bigtraining.pages.ButtonClick;
import bigtraining.pages.ContactUs;
import bigtraining.pages.ToDoList;
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

        String validMessage = "Thank You for your Message!";

        //click to get the 'Contact Us' Page
        hp.clickElement(Menu.contact_usXpath);

        //switch to the next tab
        hp.switchToTab(ContactUs.tabname);

        //type the data to the fields
        cu.typeData();

        //compare input data and actual data
        cu.validateInputData();

        hp.clickElement(ContactUs.resetButtonXpath);

        //validate all the fields to
        cu.validateResetOption();

        //reinput data to submit
        cu.typeData();

        hp.clickElement(ContactUs.submitButtonXpath);

        ///get the element message
        assertEquals(validMessage, hp.getTextFromElement(ContactUs.validMessageXpath));

    }

    @Test(dataProvider = "SubmitToUs", dataProviderClass = ContactUsDataProvider.class)
    public void testContactUsDataProvider(String fnameValue, String lnameValue, String emailValue,
                                      String commentsValue, String message, String messageTwo) {

        driver.get(url);

        //click to get the 'Contact Us' Page
        hp.clickElement(Menu.contact_usXpath);

        //switch to the next tab
        hp.switchToTab(ContactUs.tabname);

        //type data to be verified
        cu.typeDataProvider(fnameValue, lnameValue, emailValue, commentsValue);

        //click on submit button
        hp.clickElement(ContactUs.submitButtonXpath);

        //messages assertion
        hp.messagePageHandling(message, messageTwo);

    }


     @Test
     public void webElementClickTest () {

         String passText = "Congratulations!";
         String passTextXpath = "//*[@id='myModalClick']//h4";

         //click to get the 'BUTTON CLICKS' Page
         hp.clickElement(Menu.button_clicks_usXpath);

         //switch to the next tab
         hp.switchToTab(ButtonClick.tabName);

         //click the WebElement button
         hp.clickElement(ButtonClick.webElementClickButton_Xpath);

         //assert a success window message
         assertEquals(passText, hp.getTextFromElement(passTextXpath));

     }

     @Test
    public void javaScriptClickTest() {

         JavascriptExecutor js = (JavascriptExecutor) driver;

         String passText = "It’s that Easy!! Well I think it is.....";
         String passTextXpath = "//*[@id='myModalJSClick']//h4";

         //click to get the 'BUTTON CLICKS' Page
         hp.clickElement(Menu.button_clicks_usXpath);

         //switch to the next tab
         hp.switchToTab(ButtonClick.tabName);

         js.executeScript("document.querySelector('#button2').click();");

         //assert a success window message
         assertEquals(passText, hp.getTextFromElement(passTextXpath));


     }

     @Test
    public void actionMoveClickTest() {

         String passText = "Action Move & Click";
         String passTextXpath = "//*[@id='myModalMoveClick']//h4/b";

         //click to get the 'BUTTON CLICKS' Page
         hp.clickElement(Menu.button_clicks_usXpath);

         //switch to the next tab
         hp.switchToTab(ButtonClick.tabName);

         //getting MoveAndClick action
         hp.actionMoveAndClickElement(ButtonClick.ActionMoveClickButton_Xpath);

         //assert a success window message
         assertEquals(passText, hp.getTextFromElement(passTextXpath));

     }


    @Test
    public void toDoList() {

        String tabName = "WebDriver | To Do List";
        String nameToDelete = "Practice magic";

        //click to get the 'TO DO LIST' Page
        hp.clickElement(Menu.toDoList_click_Xpath);

        //switch to the next tab
        hp.switchToTab(tabName);

        //create and check a list of elements names
        List<String> containerNames = tdl.checkContainerSizeAndGetNamesList(3);

        tdl.findNeededElementXpath(containerNames, nameToDelete);
        tdl.hoverAnElementNeeded();
        tdl.deleteAnElementNeeded();
        hp.waitUntilElementIsAbsence(ToDoList.elementXpathToFindText, ToDoList.nameToDelete);

        //check a list of elements names
        tdl.checkContainerSizeAndGetNamesList(2);

        tdl.typeAndSubmitNewElement();
        hp.waitUntilElementIsPresented(ToDoList.elementXpathToFindText, ToDoList.newName);

        //check a list of elements names
        tdl.checkContainerSizeAndGetNamesList(3);

    }

}

package bigtraining.tests;

import bigtraining.components.Menu;
import bigtraining.listeners.TestListener;
import bigtraining.pages.*;
import dataprovider.ContactUsDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
public class Testing extends BaseTest {

    @Test
    public void testContactUsPage () {

        //click to get the 'Contact Us' Page
        hp.openPageNeeded(Menu.contact_usXpath, ContactUs.tabname);

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
        assertEquals(ContactUs.validMessage, hp.getTextFromElement(ContactUs.validMessageXpath));

    }

    @Test(dataProvider = "SubmitToUs", dataProviderClass = ContactUsDataProvider.class)
    public void testContactUsDataProvider(String fnameValue, String lnameValue, String emailValue,
                                      String commentsValue, String message, String messageTwo) {

        driver.get(url);

        //click to get the 'Contact Us' Page
        hp.openPageNeeded(Menu.contact_usXpath, ContactUs.tabname);

        //type data to be verified
        cu.typeDataProvider(fnameValue, lnameValue, emailValue, commentsValue);

        //click on submit button
        hp.clickElement(ContactUs.submitButtonXpath);

        //messages assertion
        hp.messagePageHandling(message, messageTwo);

    }


     @Test
     public void buttonsClickTest () {

         //click to get the 'BUTTON CLICKS' Page
         hp.openPageNeeded(Menu.button_clicks_usXpath, ButtonClick.tabName);

         //getting MoveAndClick action asserting a success window message and close the popup window
         hp.actionMoveAndClickElement(ButtonClick.ActionMoveClickButton_Xpath);
         assertEquals(ButtonClick.passText, hp.getTextFromElement(ButtonClick.passTextXpath));
         hp.sleep(1000);
         hp.clickElement(ButtonClick.CloseButton);

         //click the WebElement button asserting a success window message and close the popup window
         hp.clickElement(ButtonClick.webElementClickButton_Xpath);
         assertEquals(ButtonClick.webPassText, hp.getTextFromElement(ButtonClick.webPassTextXpath));
         hp.sleep(1000);
         hp.clickElement(ButtonClick.webCloseButton);

         //javascript click asserting a success window message and close the popup window
         jsExecutor.clickOnElement("#button2");
         assertEquals(ButtonClick.jsPassText, hp.getTextFromElement(ButtonClick.jsPassTextXpath));
         hp.sleep(1000);
         hp.clickElement(ButtonClick.jsCloseButton);


     }


    @Test
    public void toDoList() {

        //click to get the 'TO DO LIST' Page
        hp.openPageNeeded(Menu.toDoList_click_Xpath, ToDoList.tabName);

        //create and check a list of elements names
        List<String> containerNames = tdl.checkContainerSizeAndGetNamesList(3);

        tdl.findNeededElementXpath(containerNames, ToDoList.nameToDelete);
        hp.hoverAnElementNeeded(ToDoList.elementToDeleteXpath);

        //delete an element
        hp.clickElement(ToDoList.elementDeleteButtonXpath);
        hp.waitUntilElementIsAbsence(ToDoList.elementXpathToFindText, ToDoList.nameToDelete);

        //check a list of elements names
        tdl.checkContainerSizeAndGetNamesList(2);

        tdl.typeAndSubmitNewElement();
        hp.waitUntilElementIsPresented(ToDoList.elementXpathToFindText, ToDoList.newName);

        //check a list of elements names
        tdl.checkContainerSizeAndGetNamesList(3);

        hp.sleep(2000);

    }

    @Test
    public void dropdownBlock () {

        //click to get the 'Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)' Page
        hp.openPageNeeded(Menu.dropChechRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

        //select the dropDown elements needed and check their presenting
        hp.selectDropDownElement(DropD_CheckB_RadioB.ddmFirstXpath, "sql");
        hp.selectDropDownElement(DropD_CheckB_RadioB.ddmSecondXpath, "junit");
        hp.selectDropDownElement(DropD_CheckB_RadioB.ddmThirdXpath, "css");

        hp.waitUntilElementIsPresented(DropD_CheckB_RadioB.ddmAreaXpath, "SQL");
        hp.waitUntilElementIsPresented(DropD_CheckB_RadioB.ddmAreaXpath, "JUnit");
        hp.waitUntilElementIsPresented(DropD_CheckB_RadioB.ddmAreaXpath, "CSS");

        hp.sleep(2000);

    }

    @Test
    public void checkboxBlock () {

        //click to get the 'Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)' Page
        hp.openPageNeeded(Menu.dropChechRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

        //get checkBoxes list
        List<WebElement> abc = hp.collectWebElementsListAndCheckSize(
                DropD_CheckB_RadioB.checkBoxesCommonXpath, 4);

        //check whether any checkbox is selected and deselect it if it is
        hp.deselectAllElementsFromList(
                abc,
                DropD_CheckB_RadioB.checkBoxesCommonXpath,
                DropD_CheckB_RadioB.checkBoxesEndXpath);

        //select elements with names 'Option 2' and 'Option 4'
        dcr.selectNeededElements(abc, "Option 2", "Option 4");

        hp.sleep(2000);

    }

    @Test
    public void radioButtonsBlock () {

        //click to get the 'Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)' Page
        hp.openPageNeeded(Menu.dropChechRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

        //get radioButtons list
        List<WebElement> abc = hp.collectWebElementsListAndCheckSize(
                DropD_CheckB_RadioB.radioButtonsCommonXpath, 5);

        //select radioButtons alternately checking if only one is selected at the same time
        dcr.activateRadioButtonsAndCheckCounting (abc);

        hp.sleep(2000);

    }

    @Test
    public void radioButtonsDisabledBlock () {

        //click to get the 'Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)' Page
         hp.openPageNeeded(Menu.dropChechRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

        //get radioButtons list
        List<WebElement> abc = hp.collectWebElementsListAndCheckSize(
                DropD_CheckB_RadioB.rbDisablebCommonXpath, 3);

        //select radioButtons alternately checking if only one is disabled
        hp.checkWebElementsListForDisabledElement(abc, 2, "cabbage");

        hp.sleep(2000);

    }

    @Test
    public void dropDowmWithDisabledElement () {

        //click to get the 'Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)' Page
        hp.openPageNeeded(Menu.dropChechRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

        //get dropDown options list
        List<WebElement> abc = hp.collectWebElementsListAndCheckSize(
                DropD_CheckB_RadioB.ddDisablebCommonXpath + "/option", 4);

        hp.checkWebElementsListForDisabledElement(abc, 3, "orange");

        hp.sleep(2000);

    }

    @Test
    public void actions () throws InterruptedException {

        hp.openPageNeeded(Menu.actions_Xpath, ActionsTest.tabName);

        //drop and down and check the result
        hp.dragAndDropTest(ActionsTest.dropFromXpath, ActionsTest.dropToXpath);
        hp.waitUntilElementIsPresented(ActionsTest.dropToXpath, "Dropped!");

        //double click on an element
        hp.doubleClickTest(ActionsTest.doubleClickXpath);
        hp.waitAttributeToHaveValue(ActionsTest.doubleClickXpath, "class", "div-double-click double");

        //hover on the left element
        hp.hoverAnElementNeeded(ActionsTest.hoverLeftXpath);
        hp.clickElement(ActionsTest.leftLinkXpath);
        hp.alertAccept();

        //hover on the center element
        hp.hoverAnElementNeeded(ActionsTest.hoverCenterXpath);
        hp.clickElement(ActionsTest.centerLinkXpath);
        hp.alertAccept();

        //hover on the right element to click the first link
        hp.hoverAnElementNeeded(ActionsTest.hoverRightXpath);
        //get links list
        List<WebElement> abc = hp.collectWebElementsListAndCheckSize(
                ActionsTest.rightLinksListXpath, 2);
        abc.get(0).click();
        hp.alertAccept();

        //hover on the right element to click the second link
        hp.hoverAnElementNeeded(ActionsTest.hoverRightXpath);
        //get links list
        abc.get(1).click();
        hp.alertAccept();

        //click and hold action
        hp.clickAndHoldTest(ActionsTest.clickAndHoldXpath);
        String text = hp.getTextFromElement(ActionsTest.clickAndHoldXpath);
        assertThat(text).contains("Well done!");

        hp.sleep(2000);

    }

    @Test
    public void closePopupsAndAlerts () throws InterruptedException {

        hp.openPageNeeded(Menu.popUpAlerts_Xpath, PopUpAlerts.tabName);

        hp.clickElement(PopUpAlerts.javaScriptAlertButton);
        hp.alertAccept();

        hp.clickElement(PopUpAlerts.modalPopupButton);
        hp.clickElement(PopUpAlerts.modalAlertClose);

        hp.clickElement(PopUpAlerts.javaScriptConfBoxButton);
        hp.alertDismiss();
        String message = hp.getTextFromElement(PopUpAlerts.javaScriptConfBoxMessage);
        assertThat(message).isEqualTo("You pressed Cancel!");

        hp.clickElement(PopUpAlerts.ajaxLoaderButton);
        hp.clickElement(PopUpAlerts.ajaxAnswerButton);
        hp.clickElement(PopUpAlerts.modalAlertClose);

        hp.sleep(2000);

    }


}

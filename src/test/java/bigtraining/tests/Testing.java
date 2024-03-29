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
        hp.openPageNeeded(Menu.contact_usXpath, ContactUs.tabName);
        //type the data to the fields
        cu.typeData();
        //compare input data and actual data
        cu.validateInputData();
        hp.clickElement(ContactUs.resetButtonXpath);
        //validate all the fields to
        cu.validateResetOption();
        //re-input data to submit
        cu.typeData();
        hp.clickElement(ContactUs.submitButtonXpath);
        //get the element message
        assertEquals(ContactUs.validMessage, hp.getTextFromElement(ContactUs.validMessageXpath));
    }

    @Test(dataProvider = "SubmitToUs", dataProviderClass = ContactUsDataProvider.class)
    public void testContactUsDataProvider(
            String fNameValue,
            String lNameValue,
            String emailValue,
            String commentsValue,
            String message,
            String messageTwo
    ) {
        //click to get the 'Contact Us' Page
        hp.openPageNeeded(Menu.contact_usXpath, ContactUs.tabName);
        //type data to be verified
        cu.typeDataProvider(fNameValue, lNameValue, emailValue, commentsValue);
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
        List<String> containerNames = tdl.checkContainerSizeAndGetNamesList();
        assertEquals(3, containerNames.size());
        tdl.findNeededElementXpath(containerNames, ToDoList.nameToDelete);
        hp.hoverAnElementNeeded(ToDoList.elementToDeleteXpath);
        //delete an element
        hp.clickElement(ToDoList.elementDeleteButtonXpath);
        hp.waitUntilElementsValueIsAbsence(ToDoList.elementXpathToFindText, ToDoList.nameToDelete);
        //check a list of elements names
        containerNames = tdl.checkContainerSizeAndGetNamesList();
        assertEquals(2, containerNames.size());
        //submit a new element
        hp.typeAndSubmitNewElement(ToDoList.newElementFieldXpath, ToDoList.newName);
        hp.waitUntilElementIsPresented(ToDoList.elementXpathToFindText, ToDoList.newName);
        //check a list of elements names
        containerNames = tdl.checkContainerSizeAndGetNamesList();
        assertEquals(3, containerNames.size());
        hp.sleep(2000);
    }

    @Test
    public void dropdownBlock () {
        //click to get the 'Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)' Page
        hp.openPageNeeded(Menu.dropCheckRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

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
        hp.openPageNeeded(Menu.dropCheckRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

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
        hp.openPageNeeded(Menu.dropCheckRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

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
         hp.openPageNeeded(Menu.dropCheckRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

        //get radioButtons list
        List<WebElement> abc = hp.collectWebElementsListAndCheckSize(
                DropD_CheckB_RadioB.rbDisablebCommonXpath, 3);

        //select radioButtons alternately checking if only one is disabled
        hp.checkWebElementsListForDisabledElement(abc, 2, "cabbage");
        hp.sleep(2000);
    }

    @Test
    public void dropDownWithDisabledElement () {
        //click to get the 'Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)' Page
        hp.openPageNeeded(Menu.dropCheckRadio_click_Xpath, DropD_CheckB_RadioB.tabName);

        //get dropDown options list
        List<WebElement> abc = hp.collectWebElementsListAndCheckSize(
                DropD_CheckB_RadioB.ddDisablebCommonXpath + "/option", 4);

        hp.checkWebElementsListForDisabledElement(abc, 3, "orange");
        hp.sleep(2000);
    }

    @Test
    public void actions () {
        hp.openPageNeeded(Menu.actions_Xpath, ActionsTest.tabName);

        //drop and down and check the result
        hp.dragAndDropTest(ActionsTest.dropFromXpath, ActionsTest.dropToXpath);
        hp.waitUntilElementIsPresented(ActionsTest.dropToXpath, "Dropped!");

        //double-click on an element
        hp.doubleClickTest(ActionsTest.doubleClickXpath);
        hp.waitAttributeToHaveValue(ActionsTest.doubleClickXpath, "class", "div-double-click double");

        //hover on the left element
        hp.hoverAnElementNeeded(ActionsTest.hoverLeftXpath);
        hp.clickElement(ActionsTest.leftLinkXpath);

        assertThat(hp.getTextFromAlert()).isEqualTo(ActionsTest.alertMessage);
        hp.alertAccept();

        //hover on the center element
        hp.hoverAnElementNeeded(ActionsTest.hoverCenterXpath);
        hp.clickElement(ActionsTest.centerLinkXpath);

        assertThat(hp.getTextFromAlert()).isEqualTo(ActionsTest.alertMessage);
        hp.alertAccept();

        //hover on the right element to click the first link
        hp.hoverAnElementNeeded(ActionsTest.hoverRightXpath);
        //get links list
        List<WebElement> abc = hp.collectWebElementsListAndCheckSize(
                ActionsTest.rightLinksListXpath, 2);
        abc.get(0).click();

        assertThat(hp.getTextFromAlert()).isEqualTo(ActionsTest.alertMessage);
        hp.alertAccept();

        //hover on the right element to click the second link
        hp.hoverAnElementNeeded(ActionsTest.hoverRightXpath);
        //get links list
        abc.get(1).click();

        assertThat(hp.getTextFromAlert()).isEqualTo(ActionsTest.alertMessage);
        hp.alertAccept();

        //click and hold action
        hp.clickAndHoldTest(ActionsTest.clickAndHoldXpath);
        String text = hp.getTextFromElement(ActionsTest.clickAndHoldXpath);
        assertThat(text).contains("Well done!");
        hp.sleep(2000);
    }

    @Test
    public void closePopupsAndAlerts () {
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

    @Test
    public void appearDisappearText() {
        hp.openPageNeeded(Menu.appearDisappearText_Xpath, AccordionTextAffects.tabName);
        ata.clickAndWait(
                AccordionTextAffects.manualTesting_Xpath,
                AccordionTextAffects.manualTesting_Text,
                1000);
        ata.clickAndWait(
                AccordionTextAffects.cucumberBDD_Xpath,
                AccordionTextAffects.cucumberBDD_Text,
                1000);
        ata.clickAndWait(
                AccordionTextAffects.automationTesting_Xpath,
                AccordionTextAffects.automationTesting_Text,
                1000);

        //wait for proper loading
        hp.waitUntilElementIsPresented(AccordionTextAffects.hiddenTextArea_Xpath, AccordionTextAffects.textForWaiting);
        ata.clickAndWait(
                AccordionTextAffects.keepClicking_Xpath,
                AccordionTextAffects.keepClicking_Text,
                1000);
    }

    @Test
    public void datePicker() {
        hp.openPageNeeded(Menu.datePicker_Xpath, DatePicker.tabName);
        hp.clickElement(DatePicker.pickButton_Xpath);
        hp.clickElement(DatePicker.datePickerSwitch_Xpath);
        dp.chooseYear();

        //get a month needed
        hp.clickElementFromList(DatePicker.monthList_Xpath, DatePicker.month);

        //get a day needed
        //collect a dayList without classes 'old day' and 'new day' and click the day needed
        hp.clickElementFromList(DatePicker.daysListFromActiveMonth_Xpath, DatePicker.day);

        //assert the day needed is chosen
        hp.clickElement(DatePicker.mainField_Xpath);
        assertThat(hp.getTextFromElement(DatePicker.dayPicked_Xpath)).isEqualTo(DatePicker.day);

        //assert the month and the year needed are chosen
        assertThat(hp.getTextFromElement(DatePicker.datePickerSwitch_Xpath))
                .contains(DatePicker.year)
                .contains(DatePicker.month);
        hp.sleep(3000);
    }


    @Test
    public void fileUpload() {
        hp.openPageNeeded(Menu.fileUpload_Xpath, FileUpload.tabName);

        //send file path to an element with type 'file'
        hp.sendKeysToElement(FileUpload.chooseButton, fu.getAbsoluteFilePath());
        hp.clickElement(FileUpload.submitButton);
        assertThat(hp.getTextFromAlert()).isEqualTo("Your file has now been uploaded!");
        hp.alertAccept();
    }

    @Test
    public void autoComplete() {
        hp.openPageNeeded(Menu.autoComplete_Xpath, AutocompleteTextfield.tabName);
        //send a letter into the input field
        hp.sendKeysToElement(AutocompleteTextfield.inputField_xPath, AutocompleteTextfield.letter);
        //choose an element and make assertions
        actf.chooseElementNeeded();
    }
}
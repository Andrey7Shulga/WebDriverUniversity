package bigtraining.tests;

import bigtraining.components.Helper;
import bigtraining.components.Menu;
import bigtraining.listeners.TestListener;
import bigtraining.pages.ButtonClick;
import bigtraining.pages.ContactUs;
import bigtraining.pages.ToDoList;
import dataprovider.ContactUsDataProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)

public class Testing extends BaseTest {

     private Helper hp;
     private Menu mn;
     private ContactUs cu;
     private ButtonClick bc;
     private ToDoList td;


    private String url = "http://webdriveruniversity.com/index.html";



    @Test
    public void testContactUsPage () {

        hp = new Helper(driver, wait);
        mn = new Menu(driver, wait);
        cu = new ContactUs(driver, wait);

        String tabname = "WebDriver | Contact Us";
        String validMessage = "Thank You for your Message!";

        driver.get(url);

        //click to get the 'Contact Us' Page
        mn.getContactUs();

        ///switch to the next tab
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

        hp = new Helper(driver, wait);
        mn = new Menu(driver, wait);
        cu = new ContactUs(driver, wait);

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

         hp = new Helper(driver, wait);
         mn = new Menu(driver, wait);
         bc = new ButtonClick(driver, wait);

         String tabname = "WebDriver | Button Clicks";
         String passText = "Congratulations!";
         String passTextXpath = "//*[@id='myModalClick']//h4";

         driver.get(url);

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

         hp = new Helper(driver, wait);
         mn = new Menu(driver, wait);
         bc = new ButtonClick(driver, wait);
         JavascriptExecutor js = (JavascriptExecutor) driver;

         String tabname = "WebDriver | Button Clicks";
         String passText = "It’s that Easy!! Well I think it is.....";
         String passTextXpath = "//*[@id='myModalJSClick']//h4";

         driver.get(url);

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

         hp = new Helper(driver, wait);
         mn = new Menu(driver, wait);
         bc = new ButtonClick(driver, wait);

         String tabname = "WebDriver | Button Clicks";
         String passText = "Action Move & Click";
         String passTextXpath = "//*[@id='myModalMoveClick']//h4/b";

         driver.get(url);

         //click to get the 'BUTTON CLICKS' Page
         mn.buttonClicks();

         //switch to the next tab
         hp.switchToTab(tabname);

         bc.actionMoveAndClickElement();

         //assert a success window message
         assertEquals(passText, hp.getTextFromValidMessage(passTextXpath));


     }

     @Test
    public void toDoListTest() {

         hp = new Helper(driver, wait);
         mn = new Menu(driver, wait);
         td = new ToDoList(driver, wait);

         String tabname = "WebDriver | To Do List";


         driver.get(url);


         mn.toDoListClick();

         //switch to the next tab
         hp.switchToTab(tabname);

         td.plusButtonFunctionality();



     }






    }

package bigtraining.tests;

import bigtraining.components.Helper;
import bigtraining.components.Menu;
import bigtraining.listeners.TestListener;
import bigtraining.pages.ContactUs;
import dataprovider.ContactUsDataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)

public class Testing extends BaseTest {

     private Helper hp;
     private Menu mn;
     private ContactUs cu;

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


    }

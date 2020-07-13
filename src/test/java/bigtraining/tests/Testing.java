package bigtraining.tests;

import bigtraining.components.Helper;
import bigtraining.components.Menu;
import bigtraining.listeners.TestListener;
import bigtraining.pages.ContactUs;
import dataprovider.ContactUsDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)

public class Testing extends BaseTest {

     private Helper hp;
     private Menu mn;
     private ContactUs cu;


    @Test
    public void testContactUsPage () {

        hp = new Helper(driver, wait);
        mn = new Menu(driver, wait);
        cu = new ContactUs(driver, wait);

        String tabname = "WebDriver | Contact Us";
        String validMessage = "Thank You for your Message!";

        String url = "http://webdriveruniversity.com/index.html";
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
    public void ContactUsDataProvider(String fnameValue, String lnameValue, String emailValue, String commentsValue, String message, String messageTwo) {

        hp = new Helper(driver, wait);
        mn = new Menu(driver, wait);
        cu = new ContactUs(driver, wait);

        String url = "http://webdriveruniversity.com/index.html";
        String tabname = "WebDriver | Contact Us";
        String validMessage = "Thank You for your Message!";

        driver.get(url);

        //click to get the 'Contact Us' Page
        mn.getContactUs();

        //switch to the next tab
        hp.switchToTab(tabname);

        //type data
        cu.typeDataProvider(fnameValue, lnameValue, emailValue, commentsValue);

        //click on submit button
        cu.clickOnSubmitButton();

        //up to two strings error
        String errorPageXpath = "//body/br";
        int size;
        List<WebElement> errorPage = driver.findElements(By.xpath(errorPageXpath));
        WebElement body = driver.findElement(By.tagName("body"));

        if (errorPage != null) {
             size = errorPage.size();

            if (size == 2) {

                assertEquals(true, body.getText().contains(message));
                assertEquals(true, body.getText().contains(messageTwo));

            } else if (size == 1) {

                assertEquals(true, body.getText().contains(message));

            }

        } else  {

            assertEquals(true, body.getText().contains(message));

        }


        }


    }

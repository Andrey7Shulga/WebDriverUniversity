package bigtraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class AutocompleteTextfield {

    private final WebDriverWait wait;

    public static final String tabName = "WebDriver | Contact Us";
    public static final String inputField_xPath = "//*[@id='myInput']";
    public static final String submitButton_xPath = "//*[@id='submit-button']";
    public static final String itemsList_xPath = "//*[@class='autocomplete-items']/div";

    public static final String letter = "L";
    public static final String itemToChoose = "Linguine";


    public AutocompleteTextfield (WebDriverWait wait) {
        this.wait = wait;
    }


    public void chooseElementNeeded () {

        //collect a list of elements value
        List<WebElement> abc =
                collectWebElementsListAndCheckSize(itemsList_xPath, 4);

        for (WebElement k : abc) {
            assertThat(k.getText()).isNotEqualTo(null);
        }

        for (int i = 1; i <= abc.size(); i++) {

            String text = getTextFromElement
                    (itemsList_xPath + "[" + i + "]" + "/strong");
            assertThat(text).isEqualTo(letter);

            String value = getTextFromAttribute(
                    itemsList_xPath + "[" + i + "]" + "/input", "value");

            if (value.equals(itemToChoose)) {

                //choose an click the element needed
                clickElement(itemsList_xPath + "[" + i + "]");
                waitUntilElementIsNotVisible(itemsList_xPath);
                bodyGetTextToCompare(value);

                //click the submit button
                clickElement(submitButton_xPath);
                assertThat(bodyGetTextToCompare(value)).isFalse();
                break;

            }

        }



    }

    public List<WebElement> collectWebElementsListAndCheckSize (String xPath, int size) {

        List<WebElement> containerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPath)));
        assertEquals(size, containerList.size());
        return containerList;

    }

    public String getTextFromElement (String elementXpath) {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return element.getText();

    }

    public String getTextFromAttribute (String xpath, String attribute) {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getAttribute(attribute);

    }

    public void clickElement(String elementXpath) {

        WebElement element =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
        element.click();

    }

    public void waitUntilElementIsNotVisible (String xpath) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));

    }

    public boolean bodyGetTextToCompare(String text) {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        return element.getText().contains(text);

    }

}

package bigtraining.pages;

import bigtraining.components.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DropD_CheckB_RadioB {

    private final WebDriverWait wait;
    private final WebDriver driver;

    public DropD_CheckB_RadioB (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public static final String tabName = "WebDriver | Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)";
    public static final String ddmFirstXpath = "//select[@id='dropdowm-menu-1']";
    public static final String ddmSecondXpath = "//select[@id='dropdowm-menu-2']";
    public static final String ddmThirdXpath = "//select[@id='dropdowm-menu-3']";
    public static final String ddmAreaXpath = "//h2[contains(text(), 'Dropdown Menu(s)')]/following-sibling::div";
    public static final String checkBoxesCommonXpath = "//label";
    public static final String checkBoxesEndXpath = "//input";
    //Radio buttons
    public static final String radioButtonsCommonXpath = "//*[@id='radio-buttons']/descendant::*[@type='radio']";
    //*[@type='radio'][ancestor::*[@id='radio-buttons']]
    //Radio buttons disabled
    public static final String rbDisablebCommonXpath = "//form[@id='radio-buttons-selected-disabled']//input";
    //DropDown disabled
    public static final String ddDisablebCommonXpath = "//select[@id='fruit-selects']";

    public void selectNeededElements (List<WebElement> abc, String opt1, String opt2) {
        int count = 0;
        for (WebElement el : abc) {
            int index = abc.indexOf(el) + 1;
            String text = el.getText();
            WebElement checkBox = new Helper(driver, wait)
                    .collectPresentedWebElement(checkBoxesCommonXpath + "[" + index + "]" + checkBoxesEndXpath);
            if (opt1.equals(text) || opt2.equals(text)) {
                if (!checkBox.isSelected()) {
                    checkBox.click();
                }
                assertTrue(checkBox.isSelected());
            }
            if (checkBox.isSelected()) {
                count += 1;
            }
        }
        assertEquals(count, 2);
    }

    public void activateRadioButtonsAndCheckCounting (List<WebElement> abc) {
        Helper hp = new Helper(driver, wait);
        WebElement radioButton, element;

        for (WebElement el1 : abc) {
            int ind = abc.indexOf(el1) + 1;
            radioButton = hp.collectClickableWebElement(radioButtonsCommonXpath + "[" + ind + "]");
            //click if is not selected
            if (!radioButton.isSelected()) {
                radioButton.click();
            }
            assertTrue(radioButton.isSelected());
            //check others elements for being not selected
            int count = 0;
            for (WebElement el2 : abc) {
                int index = abc.indexOf(el2) + 1;
                element = hp.collectClickableWebElement(radioButtonsCommonXpath + "[" + index + "]");
                if (!element.isSelected()) {
                    count++;
                }
            }
            assertEquals(abc.size() - 1, count);
        }
    }
}
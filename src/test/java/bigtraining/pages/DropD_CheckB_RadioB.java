package bigtraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class DropD_CheckB_RadioB {

    private final WebDriverWait wait;

    public DropD_CheckB_RadioB (WebDriverWait wait) {
        this.wait = wait;

    }

    public static final String tabName = "WebDriver | Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)";

    public static final String ddmFirstXpath = "//select[@id='dropdowm-menu-1']";
    public static final String ddmSecondXpath = "//select[@id='dropdowm-menu-2']";
    public static final String ddmThirdXpath = "//select[@id='dropdowm-menu-3']";
    public static final String ddmAreaXpath = "//h2[contains(text(), 'Dropdown Menu(s)')]/following-sibling::div";


//    public static final String checkBoxesCommonXpath = "//input[@type='checkbox']";
    public static final String checkBoxesCommonXpath = "//label";
    public static final String checkBoxesEndXpath = "//input";


    public static final String checkBoxOpt1Xpath = "//input[@value='option-1']";
    public static final String checkBoxOpt2Xpath = "//input[@value='option-2']";
    public static final String checkBoxOpt3Xpath = "//input[@value='option-3']";
    public static final String checkBoxOpt4Xpath = "//input[@value='option-4']";

    //Radio buttons
    public static final String radioButtonsCommonXpath = "//*[@id='radio-buttons']/descendant::*[@type='radio']";
    //*[@type='radio'][ancestor::*[@id='radio-buttons']]

    public void selectNeededElements (List<WebElement> abc, String opt1, String opt2) {

        int count = 0;

        for (int i=0; i < abc.size(); i++ ) {

            int index = i + 1;
            String text = abc.get(i).getText();
            WebElement chechBox = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(checkBoxesCommonXpath + "[" + index + "]" + checkBoxesEndXpath)));

            if (opt1.equals(text) || opt2.equals(text)) {

                if (!chechBox.isSelected()) {
                    chechBox.click();
                }

                assertTrue(chechBox.isSelected());
            }

            if (chechBox.isSelected()) {

                count += 1;
            }
        }

        assertEquals(count, 2);

    }

    public void activateRadioButtonsAndCheckCounting (List<WebElement> abc) {

        int count = 0;
        for (int i=0; i < abc.size(); i++ ) {

            int index = i + 1;
            WebElement radioButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(radioButtonsCommonXpath + "[" + index + "]")));

            if (!radioButton.isSelected()) {
                radioButton.click();
                count++;

            }
            assertTrue(radioButton.isSelected());
        }

        assertEquals(abc.size(), count);
    }






}

package bigtraining.pages;

import bigtraining.components.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccordionTextAffects {

    private final WebDriverWait wait;

    public static final String tabName = "Accordion Items";
    public static final String manualTesting_Xpath = "//button[@id='manual-testing-accordion']";
    public static final String manualTesting_Text = "Manual testing has for some";
    public static final String cucumberBDD_Xpath = "//button[@id='cucumber-accordion']";
    public static final String cucumberBDD_Text = "Cucumber (BDD) simplifies";
    public static final String automationTesting_Xpath = "//button[@id='automation-accordion']";
    public static final String automationTesting_Text = "Automation testing has been steadily grown";
    public static final String keepClicking_Xpath = "//button[@id='click-accordion']";
    public static final String keepClicking_Text = "This text has appeared after 5 seconds!";
    public static final String hiddenTextArea_Xpath = "//p[@id='hidden-text']";
    public static final String textForWaiting = "LOADING COMPLETE.";

    public AccordionTextAffects (WebDriverWait wait) {
        this.wait = wait;
    }

    public void clickAndWait (String xPath, String textToPresent, int timeout) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        element.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//body"), textToPresent));
        new Helper().sleep(timeout);
        element.click();
    }
}
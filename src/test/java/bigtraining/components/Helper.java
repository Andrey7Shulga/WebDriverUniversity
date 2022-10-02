package bigtraining.components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.*;

public class Helper {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public Helper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        actions = new Actions(driver);
    }

    public Helper() {}

    public List<WebElement> collectWebElementsList (String xPath) {
        Objects.requireNonNull(xPath);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPath)));
    }

    public WebElement collectPresentedWebElement (String xPath) {
        Objects.requireNonNull(xPath);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    public WebElement collectVisibleWebElement (String xPath) {
        Objects.requireNonNull(xPath);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    public WebElement collectClickableWebElement (String xPath) {
        Objects.requireNonNull(xPath);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    public Alert collectAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void openPageNeeded(String menuClickXpath, String switchToTabXpath) {
        //click to element on Menu Page
        clickElement(menuClickXpath);
        //switch to the next tab
        switchToTab(switchToTabXpath);
    }

    public void switchToTab(String tabName){
        List<String> tab = new ArrayList<>(driver.getWindowHandles());
        List<String> tabList = new ArrayList<>();

        for (String tabElement : tab) {
            tabList.add(driver.switchTo().window(tabElement).getTitle());
            driver.switchTo().window(tab.get(0));
            if (tabList.get(tab.indexOf(tabElement)).equals(tabName)) {
                driver.switchTo().window(tabElement);
                return;
            }
        }
    }

    public void messagePageHandling(String message, String messageTwo) {
        String errorPageXpath = "//body/br";
        List<WebElement> errorPage = driver.findElements(By.xpath(errorPageXpath));
        int size;
        if (errorPage != null) {
             size = errorPage.size();
            if (size == 2) {
                assertTrue(bodyGetTextToCompare(message));
                assertTrue(bodyGetTextToCompare(messageTwo));
            } else if (size == 1) {
                assertTrue(bodyGetTextToCompare(message));
            }
        } else  {
            assertTrue(bodyGetTextToCompare(message));
        }
    }

    public void scrollBarElementActivate(String elementXpath) {
        collectPresentedWebElement(elementXpath).sendKeys(Keys.END);
    }

    public void sendKeysToElement(String elementXpath, String text) {
        collectPresentedWebElement(elementXpath).sendKeys(text);
    }

    public void checkWebElementsListForDisabledElement(List<WebElement> abc, int size, String disabledValue) {
        List<String> list = new ArrayList<>();
        for (WebElement dd : abc) {
            if (dd.isEnabled()) {
                dd.click();
                list.add(dd.getAttribute("value"));
            }
        }
        assertThat(list.size()).isEqualTo(size);
        assertThat(list.toString()).doesNotContain(disabledValue);
    }

    public List<WebElement> collectWebElementsListAndCheckSize (String xPath, int size) {
        List<WebElement> containerList = collectWebElementsList(xPath);
        assertEquals(size, containerList.size());
        return containerList;
    }

    public void deselectAllElementsFromList (List<WebElement> abc, String startXpath, String endXpath) {
        for (WebElement el : abc) {
            int index = abc.indexOf(el) + 1;
            WebElement checkBox = collectClickableWebElement(startXpath + "[" + index + "]" + endXpath);
            if (checkBox.isSelected()) {
                checkBox.click();
                wait.until(ExpectedConditions.elementSelectionStateToBe(checkBox, false));
            }
            assertFalse(checkBox.isSelected());
        }
    }

    public void selectDropDownElement (String selectXpath, String value) {
        Select sel = new Select(collectClickableWebElement(selectXpath));
        sel.selectByValue(value);
    }

    public String getTextFromElement (String elementXpath) {
        return collectVisibleWebElement(elementXpath).getText();
    }

    public boolean bodyGetTextToCompare(String text) {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }

    public void clickElement(String elementXpath) {
        collectPresentedWebElement(elementXpath).click();
    }

    public void clickElementFromList (String elementsListXpath, String elementText) {
        List<WebElement> daysList = collectWebElementsList(elementsListXpath);
        for (WebElement myDay : daysList) {
            if (myDay.getText().equals(elementText)) {
                myDay.click();
                break;
            }
        }
    }

    /**
     * ACTIONS BLOCK - START
     */
    public void actionMoveAndClickElement(String xPath) {
        actions.moveToElement(collectPresentedWebElement(xPath), 50, 20)
                .click()
                .build()
                .perform();
    }

    public void dragAndDropTest(String dragXpath, String dropXpath) {
        actions.dragAndDrop(collectPresentedWebElement(dragXpath), collectPresentedWebElement(dropXpath))
                .pause(2000)
                .build()
                .perform();
    }

    public void doubleClickTest (String xPath) {
        actions.doubleClick(collectPresentedWebElement(xPath))
                .pause(2000)
                .build()
                .perform();
    }

    public void clickAndHoldTest (String xPath) {
        actions.clickAndHold(collectPresentedWebElement(xPath))
                .pause(2000)
                .build()
                .perform();
    }

    public void hoverAnElementNeeded (String xPath) {
        actions.moveToElement(collectPresentedWebElement(xPath))
                .build()
                .perform();
    }

    public void typeAndSubmitNewElement (String elementXPath, String newValue) {
        actions.click(collectPresentedWebElement(elementXPath))
                .sendKeys(newValue)
                .sendKeys(Keys.ENTER)
                .build().perform();
    }

    /**
     * ACTIONS BLOCK - END
     */

    public String getTextFromAttribute (String xpath, String attribute) {
        return collectPresentedWebElement(xpath).getAttribute(attribute);
    }

    public void waitAttributeToHaveValue (String xpath, String attribute, String value) {
        wait.until(ExpectedConditions.attributeContains(By.xpath(xpath), attribute, value));
    }


    public void setValue (String xpath, String val) {
        WebElement element = collectPresentedWebElement(xpath);
        element.clear();
        element.sendKeys(val);
    }

    public void waitUntilElementsValueIsAbsence (String xPath, String elementValue) {
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(By.xpath(xPath), elementValue)));
    }

    public void waitUntilElementIsPresented (String elementXpath, String elementText) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementXpath), elementText));
    }

    public void sleep (int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsNotVisible (String xpath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    /**
     * ALERTS
     */
    public void alertAccept() {
        collectAlert().accept();
    }

    public String getTextFromAlert() {
        return collectAlert().getText();
    }

    public void alertDismiss() {
        collectAlert().dismiss();
    }
    /*** END ALERTS ***/

    public void clear() {}

    public String getTagName() {
        return null;
    }

    public String getAttribute(String s) {
        return null;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return false;
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return null;
    }

    public Rectangle getRect() {
        return null;
    }

    public String getCssValue(String s) {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
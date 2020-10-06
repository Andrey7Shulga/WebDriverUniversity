package bigtraining.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu {

    WebDriver driver;
    WebDriverWait wait;

    public static final String contact_usXpath = "//a[contains(@href, 'Contact-Us')]";
    public static final String button_clicks_usXpath = "//h1[contains(text(), 'BUTTON CLICKS')]";
    public static final String toDoList_click_Xpath = "//h1[contains(text(), 'TO DO LIST')]";

    public Menu(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

    }


//    public void getContactUs () {
//
//        clickElement(contact_usXpath);
//
//    }

//    public void buttonClicks () {
//
//        clickElement(button_clicks_usXpath);
//    }

//    public void toDoListClick () {
//
//        clickElement(toDoList_click_Xpath);
//
//    }


//    public void clickElement(String elementXpath) {
//
//        WebElement element = driver.findElement(By.xpath(elementXpath));
//        wait.until(ExpectedConditions.visibilityOf(element));
//        element.click();
//
//    }


}

package bigtraining.components;

import bigtraining.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu {

    WebDriver driver;
    WebDriverWait wait;

    WebElement contact_us;
    String contact_usXpath = "//h1[contains(text(), 'CONTACT US')]";

    WebElement login_portal;
    String login_portalXpath = "//h1[contains(text(), 'LOGIN PORTAL')]";

    @FindBy (xpath = "//h1[contains(text(), 'BUTTON CLICKS')]")
    WebElement button_clicks;


    public Menu(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

    }


    public void getContactUs () {

        contact_us = driver.findElement(By.xpath(contact_usXpath));
        wait.until(ExpectedConditions.visibilityOf(contact_us));
        contact_us.click();
    }

    public void loginPortal () {

        login_portal.click();
    }

    public void buttonClicks () {

        button_clicks.click();
    }






}

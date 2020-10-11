package bigtraining.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu {

    WebDriver driver;
    WebDriverWait wait;

    public static final String contact_usXpath = "//a[contains(@href, 'Contact-Us')]";
    public static final String button_clicks_usXpath = "//h1[contains(text(), 'BUTTON CLICKS')]";
    public static final String toDoList_click_Xpath = "//h1[contains(text(), 'TO DO LIST')]";
    public static final String dropChechRadio_click_Xpath = "//h1[contains(text(), 'DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)')]";
    public static final String actions_Xpath = "//h1[contains(text(), 'ACTIONS')]";
    public static final String scrolling_Xpath = "//h1[contains(text(), 'SCROLLING AROUND')]";
    public static final String popUpAlerts_Xpath = "//h1[(text()='POPUP & ALERTS')]";
    public static final String appearDisappearText_Xpath = "//h1[(text()='ACCORDION & TEXT AFFECTS (APPEAR & DISAPPEAR)')]";



    public Menu(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

    }

}

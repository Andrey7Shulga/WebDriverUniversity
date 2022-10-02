package bigtraining.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu {

    WebDriver driver;
    WebDriverWait wait;

    private static final String aLocator = "//a[@id='{}']";

    public static final String contact_usXpath = takeLocatorNeeded("contact-us");
    public static final String button_clicks_usXpath = takeLocatorNeeded("button-clicks");
    public static final String toDoList_click_Xpath = takeLocatorNeeded("to-do-list");
    public static final String dropCheckRadio_click_Xpath = takeLocatorNeeded("dropdown-checkboxes-radiobuttons");
    public static final String actions_Xpath = takeLocatorNeeded("actions");
    public static final String scrolling_Xpath = takeLocatorNeeded("scrolling-around");
    public static final String popUpAlerts_Xpath = takeLocatorNeeded("popup-alerts");
    public static final String appearDisappearText_Xpath = "//a[@href='Accordion/index.html']";
    public static final String datePicker_Xpath = takeLocatorNeeded("datepicker");
    public static final String fileUpload_Xpath = takeLocatorNeeded("file-upload");
    public static final String autoComplete_Xpath = takeLocatorNeeded("autocomplete-textfield");

    public Menu(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private static String takeLocatorNeeded(String toChange) {
        return Menu.aLocator.replace("{}", toChange);
    }
}

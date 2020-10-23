package bigtraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private WebElement element;

    public static final String tabName = "WebDriver | Datepicker";
    public static final String year = "1974";
    public static final String month = "Oct";
    public static final String day = "19";

    public static final String mainField_Xpath = "//input";
    public static final String dateArea_Xpath = "//*[@id='datepicker']";
    public static final String pickButton_Xpath = dateArea_Xpath + "//i";
    public static final String dropDownMenu_Xpath = "//*[@style='display: block;']";
    public static final String datePickerSwitch_Xpath = dropDownMenu_Xpath + "//th[@class='datepicker-switch']";

    public static final String monthList_Xpath = dropDownMenu_Xpath + "//span[contains(@class, 'month')]";

    public static final String daysListFromActiveMonth_Xpath = "//*[@class='datepicker-days']//td[not(@class='old day' or @class='new day')]";
    public static final String dayPicked_Xpath = "//*[@class='datepicker-days']//td[@class='active day']";

    public static final String prevButton_Xpath = dropDownMenu_Xpath + "//th[@class='prev']";
    public static final String nextButton_Xpath = dropDownMenu_Xpath + "//th[@class='next']";



    public DatePicker (WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

    }


    public void chooseYear () {

        //extract from menu the current year chosen
        String currentYear = getYearFromElement();

        //get a year needed
        //parse String to int
        int int_year = Integer.parseInt(year);
        int int_currentYear = Integer.parseInt(currentYear);

        if (int_currentYear > int_year) {

            while (int_currentYear != int_year) {

                //press the 'previous' button
                clickElement(prevButton_Xpath);
                currentYear = getYearFromElement();
                int_currentYear = Integer.parseInt(currentYear);

            }

        } else if (int_currentYear < int_year) {

            while (int_currentYear != int_year) {

                //press the 'next' button
                clickElement(nextButton_Xpath);

                currentYear = getYearFromElement();
                int_currentYear = Integer.parseInt(currentYear);

            }

        }

    }

    public String getYearFromElement () {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(datePickerSwitch_Xpath))).getText();

    }

    public void clickElement (String xpath) {

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(xpath))).click();

    }




}

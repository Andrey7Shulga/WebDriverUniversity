package bigtraining.pages;

import bigtraining.components.Helper;

public class DatePicker {

    public static final String tabName = "WebDriver | Datepicker";

    public static final String mainField_Xpath = "//input";
    public static final String dateArea_Xpath = "//*[@id='datepicker']";
    public static final String pickButton_Xpath = dateArea_Xpath + "//i";
    public static final String dropDownMenu_Xpath = "//*[@style='display: block;']";
    public static final String datePickerSwitch_Xpath = dropDownMenu_Xpath + "//th[@class='datepicker-switch']";
    public static final String yearsList_Xpath = dropDownMenu_Xpath + "//span[contains(@class, 'year')]";
    public static final String monthList_Xpath = dropDownMenu_Xpath + "//span[contains(@class, 'month')]";

    public static final String weeksList_Xpath = dropDownMenu_Xpath + "//tbody/tr";

    public static final String daysList_Xpath_append = "/td[@class='day']";
    public static final String dayPicked_Xpath = "//*[@class='datepicker-days']//td[@class='active day']";

    public static final String prevButton_Xpath = dropDownMenu_Xpath + "//th[@class='prev']";
    public static final String nextButton_Xpath = dropDownMenu_Xpath + "//th[@class='next']";



}

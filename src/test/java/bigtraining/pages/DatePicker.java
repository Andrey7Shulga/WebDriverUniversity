package bigtraining.pages;

public class DatePicker {

    public static final String tabName = "WebDriver | Datepicker";
    public static final String year = "2074";
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


//    public void chooseYear () {
//
//        //extract from menu the current year chosen
//        String currentYear = hp.getTextFromElement(DatePicker.datePickerSwitch_Xpath);
//
//        //get a year needed
//        //parse String to int
//        int int_year = Integer.parseInt(year);
//        int int_currentYear = Integer.parseInt(currentYear);
//
//        if (int_currentYear > int_year) {
//
//            while (int_currentYear != int_year) {
//
//                //press the 'previous' button
//                hp.clickElement(DatePicker.prevButton_Xpath);
//                currentYear = hp.getTextFromElement(DatePicker.datePickerSwitch_Xpath);
//                int_currentYear = Integer.parseInt(currentYear);
//
//            }
//
//        } else if (int_currentYear < int_year) {
//
//            while (int_currentYear != int_year) {
//
//                //press the 'next' button
//                hp.clickElement(DatePicker.nextButton_Xpath);
//                currentYear = hp.getTextFromElement(DatePicker.datePickerSwitch_Xpath);
//                int_currentYear = Integer.parseInt(currentYear);
//
//            }
//
//        }
//
//
//
//    }


}

package dataprovider;

import org.testng.annotations.DataProvider;

public class ContactUsDataProvider {

    @DataProvider(name = "SubmitToUs")
    public static Object [][] SubmitToUs() {

        return new Object[][] {

                {"Chris", "Boil", "1@hotmail.com", "Hello, World", "Thank You for your Message!", ""},
                {"", "Boil", "1@hotmail.com", "Hello, World", "Error: all fields are required", ""},
                {"", "Boil", "1@", "Hello, World", "Error: all fields are required", "Error: Invalid email address"}








        };

    }




}

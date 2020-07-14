package dataprovider;

import org.testng.annotations.DataProvider;

public class ContactUsDataProvider {

    @DataProvider(name = "SubmitToUs")
    public static Object [][] SubmitToUs() {

        return new Object[][] {

                //all the fields valid
                {"Chris", "Boil", "1@hotmail.com", "Hello, World", "Thank You for your Message!", ""},

                //one field from four is missed
                {"", "Boil", "1@hotmail.com", "Hello, World", "Error: all fields are required", ""},
                {"Chris", "", "1@hotmail.com", "Hello, World", "Error: all fields are required", ""},
                {"Chris", "Boil", "", "Hello, World", "Error: all fields are required", ""},
                {"Chris", "Boil", "1@hotmail.com", "", "Error: all fields are required", ""},

                //invalid e-mail address
                {"Chris", "Boil", "@asz", "Hello, World", "Error: Invalid email address", ""},

                //invalid e-mail address and one of the fields (First Name, Last Name or Message) is missed
                {"", "Boil", "1@", "Hello, World", "Error: all fields are required", "Error: Invalid email address"},
                {"Chris", "", "1@", "Hello, World", "Error: all fields are required", "Error: Invalid email address"},
                {"Chris", "Boil", "1@", "", "Error: all fields are required", "Error: Invalid email address"},

                //all the fields are missed
                {"", "", "", "", "Error: all fields are required", "Error: Invalid email address"}


        };

    }




}

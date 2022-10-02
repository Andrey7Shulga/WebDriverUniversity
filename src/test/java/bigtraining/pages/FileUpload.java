package bigtraining.pages;

import java.io.File;

public class FileUpload {
    public static final String tabName = "File Upload";
    public static final String chooseButton = "//input[@type='file']";
    public static final String submitButton = "//*[@id='submit-button']";
    public static final String filePath = "src/test/resourses/111.txt";

    public String getAbsoluteFilePath () {
        return new File(filePath).getAbsolutePath();
    }
}

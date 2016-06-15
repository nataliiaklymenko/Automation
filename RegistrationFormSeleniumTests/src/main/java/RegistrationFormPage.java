import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by nako on 29/04/2016.
 */
class RegistrationFormPage extends PageFactory implements IRegistrationPage {

    private static Properties pageObjects = new Properties(System.getProperties());
    private static final String Path_OR = System.getProperty("user.dir") + "\\src\\main\\resources\\RegistrationForm.properties";
    private static final String Path_TestData = System.getProperty("user.dir") + "\\src\\main\\resources\\TestCases\\TestCases.xlsx";

    public Properties getProperties() {
        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream(Path_OR);
            pageObjects.load(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pageObjects;
    }

    public void inputValue(String object, String value) {
        inputValueIntoField(object, value);
    }

    public void click(String object) {
        clickOnElement(object);
    }
}

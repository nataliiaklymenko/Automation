import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by nako on 29/04/2016.
 */
abstract class PageFactory {

    static void inputValueIntoField(String elementPath, String valueForInput) {
        Util.waitForElement(elementPath, Util.DEFAULT_TIMEOUT).sendKeys(valueForInput);
    }

    static void clickOnElement(String element){
        try{
           // Log.info("Clicking on Webelement "+ object);
            Util.waitForElement(element, Util.DEFAULT_TIMEOUT).click();
        }catch(Exception e){
            //Log.error("Not able to click --- " + e.getMessage());
            //DriverScript.bResult = false;
        }
    }

    static Properties getProperties(String pathToPropertiesFile) {
        FileInputStream fileStream;
        Properties pageObjects = new Properties();
        try {
            fileStream = new FileInputStream(pathToPropertiesFile);
            pageObjects.load(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pageObjects;
    }
}

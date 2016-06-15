import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nako on 29/04/2016.
 */
class PageFactory {
    static void inputValueIntoField(String elementPath, String valueForInput) {
        BaseTest.getDriver().findElement(By.xpath(elementPath)).sendKeys(valueForInput);
    }

    static void clickOnElement(String element){
        try{
           // Log.info("Clicking on Webelement "+ object);
            BaseTest.getDriver().findElement(By.xpath(element)).click();
        }catch(Exception e){
            //Log.error("Not able to click --- " + e.getMessage());
            //DriverScript.bResult = false;
        }
    }
}

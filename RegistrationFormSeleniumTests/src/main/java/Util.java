import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by nako on 29/04/2016.
 */
class Util {
    public static final int DEFAULT_TIMEOUT = 4000;

    private static Logger logger = Logger.getLogger("Util");
    private static WebDriver driver = BaseTest.getDriver();
    static String baseUrl = "http://localhost:83/registrationform/";

    static void goToPage(String pageUrl) {
        driver.get(pageUrl);
    }

    static boolean verifyCurrentPageTitle(String expectedPageTitle, String actualPageTitle) {
        return (actualPageTitle.contentEquals(expectedPageTitle));
    }

    public static WebElement waitForElement(String xpath, int timeOut) {
        WebDriverWait waiting = new WebDriverWait(driver, timeOut);
       return waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void pressButton(String elementPath) {
        driver.findElement(By.xpath(elementPath)).click();
    }

    public static void closeBrowser() {
        driver.close();
    }

    public void stopDriver() {
        driver.quit();
    }

    public static String getProperty(String propertyName) {
        Properties props = new Properties();
        String propertyValue = null;
        try {
            props.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\ci.properties")));
            propertyValue = props.getProperty(propertyName);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return propertyValue;
    }
}

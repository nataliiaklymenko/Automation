import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by nako on 29/04/2016.
 */
class Util {
    public static final int DEFAULT_TIMEOUT = 4000;
    private static Logger logger = Logger.getLogger("Util");

    public static void openBrowser(String name) {
        BaseTest.browserType = BaseTest.Browsers.valueOf(name);
        BaseTest.WebDriverInit();
    }

    public static void goToPage(String pageUrl) {
        BaseTest.getDriver().get(pageUrl);
    }

    static boolean verifyCurrentPageTitle(String expectedPageTitle, String actualPageTitle) {
        return (actualPageTitle.contentEquals(expectedPageTitle));
    }

    public static WebElement waitForElement(String object) {
        WebDriverWait waiting = new WebDriverWait(BaseTest.getDriver(), DEFAULT_TIMEOUT);
        return waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BaseTest.OR.getProperty(object))));
    }

    public static WebElement waitForVisibleElement(WebElement element) {
        WebDriverWait waiting = new WebDriverWait(BaseTest.getDriver(), DEFAULT_TIMEOUT);
        return waiting.until(ExpectedConditions.visibilityOf(element));
    }

    public static void closeBrowser() {
        BaseTest.getDriver().close();
    }

    public void stopDriver() {
        BaseTest.getDriver().quit();
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

    public static Properties getProperties(String pathToPropertiesFile) {
        FileInputStream fileStream;
        Properties pageObjects = new Properties();
        try {
            fileStream = new FileInputStream(pathToPropertiesFile);
            pageObjects.load(fileStream);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return pageObjects;
    }
}

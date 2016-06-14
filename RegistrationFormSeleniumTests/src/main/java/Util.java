import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by nako on 29/04/2016.
 */
public class Util {
    private static WebDriver driver = BaseTest.getDriver();
    static String baseUrl = "http://localhost:83/registrationform/";

    public static void goToPage(String pageUrl) {
        driver.get(pageUrl);
    }

    public static boolean verifyCurrentPage(String expectedPageTitle, String actualPageTitle) {
        return (actualPageTitle.contentEquals(expectedPageTitle));
    }

    public void inputValueIntoField(String elementPath, String valueForInput) {
        driver.findElement(By.xpath(elementPath)).sendKeys(valueForInput);
    }

    public void pressButton(String elementPath) {
        driver.findElement(By.xpath(elementPath)).click();
    }

    public void closeBrowser() {
        driver.close();
    }

    public void stopDriver() {
        driver.quit();
    }
}

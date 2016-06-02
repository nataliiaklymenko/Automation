import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by nako on 29/04/2016.
 */
public class Util {
    static WebDriver driver;
    static String baseUrl = "http://localhost:8080/registrationform/";
    static String validUserId = "mngr35696";
    static String validUserPassword = "sAgUseh";

    public static WebDriver launchBrowser() {
        driver = new FirefoxDriver();
        return driver;
    }

    public void goToPage(String pageUrl) {
        driver.get(pageUrl);
    }

    public boolean verifyCurrentPage(String expectedPageTitle, String actualPageTitle) {
        return (actualPageTitle.contentEquals(expectedPageTitle));
    }

    public void inputValueIntoField(String valueForInput) {
        driver.findElement(By.name("uid")).sendKeys(valueForInput);
        driver.findElement(By.name("password")).sendKeys(validUserPassword);
    }

    public void pressButton() {
        driver.findElement(By.name("btnLogin")).click();
    }

    public void closeBrowser() {
        driver.close();
    }

    public void stopDriver() {
        driver.quit();
    }
}

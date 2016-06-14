import com.thoughtworks.selenium.DefaultSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

/**
 * Created by Argentum on 6/5/2016.
 */
public class BaseTest {
    public enum Browsers {Chrome, IE, Firefox, Safari}

    public Browsers browserType = Browsers.Safari;
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @BeforeClass
    public void Init() {
        String driverPath = System.getProperty("user.dir");
        switch (browserType) {
            case IE:
                System.setProperty("webdriver.ie.driver", driverPath + "\\src\\main\\resources\\drivers\\IEDriverServer.exe");
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                setDriver(new InternetExplorerDriver(ieCapabilities));
                break;
            case Firefox:
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                //firefoxProfile.setPreference("browser.download.folderList", 2);
                //firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
                //firefoxProfile.setPreference("browser.download.dir", "c:\\downloads");
                //firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
                setDriver(new FirefoxDriver(firefoxProfile));
                break;
            case Safari:
                SafariOptions options = new SafariOptions();
                options.setUseCleanSession(true);
                setDriver(new SafariDriver(options));
                break;
            default: // chome driver by default
                System.setProperty("webdriver.chrome.driver", "\\src\\main\\resources\\drivers\\chromedriver.exe");
                setDriver(new ChromeDriver());
                break;
        }
        driver.navigate().to(Util.baseUrl);
    }

    @AfterClass
    public void QuitDriver() {
        driver.quit();
    }
}
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created by nako on 6/5/2016.
 */
public class BaseTest {
    private enum Browsers {Chrome, IE, Firefox, Safari}

    private Browsers browserType = Browsers.Chrome;
    static WebDriver driver;

    static WebDriver getDriver() {
        return driver;
    }

    private static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @BeforeClass
    public void WebDriverInit() {
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
            case Chrome:
                System.setProperty("webdriver.chrome.driver", driverPath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
                setDriver(new ChromeDriver());
                break;
            default:
                //TODO:define default action
        }
    }

    @AfterClass
    public static void QuitDriver() {
        if (driver == null) return;
        driver.quit();
        setDriver(null);
    }

    @BeforeMethod
    public static void startCase(Method method){
        Log.startTestCase(method.getName());
    }

    @AfterMethod
    public static void endCase(Method method){
        Log.endTestCase(method.getName());
    }
}
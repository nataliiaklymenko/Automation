import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by nako on 6/5/2016.
 */
public class BaseTest {
    public static Properties OR;

    public enum Browsers {Chrome, IE, Firefox, Safari}

    public static Browsers browserType = Browsers.Chrome;
    static WebDriver driver;
    public static boolean bResult;

    static WebDriver getDriver() {
        return driver;
    }

    private static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void WebDriverInit() {
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

    public static void QuitDriver() {
        if (driver == null) return;
        driver.quit();
        setDriver(null);
    }

    public void execute_TestCase(String testCaseId, String path, String sheetName, Class actionKeywords) {
        int iTestStep;
        int iTestLastStep;
        String sActionKeyword;
        String sData;
        String sPageObject;
        String sRunMode;
        try {
            Log.startTestCase(testCaseId);
            HSSFSheet sheet = ExcelUtils.getExcelSheet(path, sheetName);
            iTestStep = ExcelUtils.getRowContains(testCaseId, Constants.Col_TestCaseID, path, sheetName);
            iTestLastStep = ExcelUtils.getTestStepsCount(path, sheetName, testCaseId, iTestStep);
            for (; iTestStep <= iTestLastStep; iTestStep++) {
                bResult = true;
                sRunMode = ExcelUtils.getCellData(sheet, iTestStep, Constants.Col_RunMode);
                if (sRunMode.equals("Yes")) {
                    sActionKeyword = ExcelUtils.getCellData(sheet, iTestStep, Constants.Col_ActionKeyword);
                    sPageObject = ExcelUtils.getCellData(sheet, iTestStep, Constants.Col_PageObject);
                    sData = ExcelUtils.getCellData(sheet, iTestStep, Constants.Col_DataSet);
                    execute_Actions(path, sheetName, sActionKeyword, sPageObject, actionKeywords, iTestStep, sData);
                }
            }
            Log.endTestCase(testCaseId);
        } catch (Exception e) {
            Log.error(e.getMessage());
            Assert.fail();
        }
    }

    private static void execute_Actions(String path, String sheetName, String sActionKeyword, String sPageObject, Class actionKeywords, int iTestcase, String sData) {
        try {
            Method[] method = actionKeywords.newInstance().getClass().getMethods();
            for (Method aMethod : method) {
                if (aMethod.getName().equals(sActionKeyword)) {
                    String Path_OR = Constants.Path_OR;
                    FileInputStream fileInputStream = new FileInputStream(Path_OR);
                    OR = new Properties(System.getProperties());
                    OR.load(fileInputStream);
                    aMethod.invoke(actionKeywords.newInstance(), sPageObject, sData);
                    if (bResult) {
                        ExcelUtils.setCellData(path, sheetName, Constants.KEYWORD_PASS, iTestcase, Constants.Col_Result);
                        break;
                    } else {
                        ExcelUtils.setCellData(path, sheetName, Constants.KEYWORD_FAIL, iTestcase, Constants.Col_Result);
                        Util.closeBrowser();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            Log.error(e.getMessage());
            Assert.fail();
        }
    }
}
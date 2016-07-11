/**
 * Created by nako on 29/04/2016.
 */
abstract class PageFactory {

    public static void openBrowser(String browser, String name) {
        Util.openBrowser(name);
    }

    public static void goToPage(String object, String url) {
        Util.goToPage(url);
    }

    public static void closeBrowser() {
        Util.closeBrowser();
    }

    public static void inputValueIntoField(String elementPath, String valueForInput) {
        Util.waitForElement(elementPath).sendKeys(valueForInput);
    }

    public static void clickOnElement(String element, String data) {
        Util.waitForElement(element).click();
    }

    static void verifyPageTitle(String expectedTitle, String actualTitle) {
        BaseTest.bResult = Util.verifyCurrentPageTitle(expectedTitle, actualTitle);
    }
}

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by nako on 29/04/2016.
 */

public class Tests {

    private WebDriver driver;
    Util init = new Util();

    @BeforeClass
    public void setUp() {
        driver = Util.launchBrowser();
    }

    @Test
    public void testSuccessfulLogin() {
        init.goToPage(Util.baseUrl);
        Assert.assertTrue(init.verifyCurrentPage(RegistrationFormPage.REGISTRATION_FORM_PAGE_TITLE, driver.getTitle()));
    }

    @AfterClass
    public void tearDrop() {
        init.closeBrowser();
    }
}

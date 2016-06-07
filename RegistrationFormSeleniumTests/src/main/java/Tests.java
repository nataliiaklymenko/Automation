import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by nako on 29/04/2016.
 */
public class Tests extends BaseTest{
    @Test
    public void testSuccessfulLogin() {
        Util.goToPage(Util.baseUrl);
        Assert.assertTrue(Util.verifyCurrentPage(RegistrationFormPage.REGISTRATION_FORM_PAGE_TITLE, driver.getTitle()));
    }
}

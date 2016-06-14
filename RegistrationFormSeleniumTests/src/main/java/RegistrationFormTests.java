import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nako on 29/04/2016.
 */
public class RegistrationFormTests extends BaseTest{
    private static Logger logger = Logger.getLogger("RegistrationFormTests");

    @Test
    public void testRegistrationFormLoading() {
        Util.goToPage(Util.baseUrl);
        Assert.assertTrue(Util.verifyCurrentPage(RegistrationFormPage.REGISTRATION_FORM_PAGE_TITLE, driver.getTitle()));
    }

    @Test(enabled = false)
    public void testRegistrationFormSave() {
       Assert.assertTrue(false);
    }

    @Test(enabled = false)
    public void testRegistrationFormReset() {
        Assert.assertTrue(false);
    }
}

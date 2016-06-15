import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

/**
 * Created by nako on 29/04/2016.
 */
public class RegistrationFormTests extends BaseTest{
    private static Logger logger = Logger.getLogger("RegistrationFormTests");
    private IRegistrationPage iRegistrationPage = new RegistrationFormPage();
    private Properties pageObjects = iRegistrationPage.getProperties();

    @Test(enabled = false)
    public void testRegistrationFormLoading() {
        Util.goToPage(Util.baseUrl);
        Assert.assertTrue(Util.verifyCurrentPageTitle(pageObjects.getProperty("title_RegistrationForm"), driver.getTitle()));
    }

    @Test
    public void testRegistrationFormSave() {
        Util.goToPage(Util.baseUrl);
        iRegistrationPage.inputValue(pageObjects.getProperty("field_FirstName"), "test first name");
        iRegistrationPage.inputValue(pageObjects.getProperty("field_LastName"), "test last name");
        iRegistrationPage.inputValue(pageObjects.getProperty("field_Email"), "ts@ts.ts");
        iRegistrationPage.inputValue(pageObjects.getProperty("field_RepeatEmail"), "ts@ts.ts");
        iRegistrationPage.click(pageObjects.getProperty("btn_JavaQuestionCategory"));
//        iRegistrationPage.click(pageObjects.getProperty("rbtn_Answer").replace("#", "-3"));//TODO: add array with questions and answers
//        iRegistrationPage.click(pageObjects.getProperty("checkbox_Agreement"));
//        iRegistrationPage.click(pageObjects.getProperty("btn_Save"));
//        Assert.assertTrue(false);
    }

    @Test(enabled = false)
    public void testRegistrationFormReset() {
        Assert.assertTrue(false);
    }
}

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

/**
 * Created by nako on 29/04/2016.
 */
public class RegistrationFormTests extends BaseTest {
    private static Logger logger = Logger.getLogger("RegistrationFormTests");
    private static final String Path_OR = System.getProperty("user.dir") + "\\src\\main\\resources\\RegistrationForm.properties";
    private Properties pageObjects = RegistrationFormPage.getProperties(Path_OR);

    @Test
    public void testRegistrationFormLoading() {
        Util.goToPage(Util.baseUrl);
        Assert.assertTrue(Util.verifyCurrentPageTitle(RegistrationFormPage.REGISTRATION_FORM_PAGE_TITLE, driver.getTitle()));
    }

    @Test
    public void testRegistrationFormSave() {
        Util.goToPage(Util.baseUrl);
        RegistrationFormPage.inputValueIntoField(RegistrationFormPage.FIRST_NAME_FIELD, "test first name");
        RegistrationFormPage.inputValueIntoField(RegistrationFormPage.LAST_NAME_FIELD, "test last name");
        RegistrationFormPage.inputValueIntoField(RegistrationFormPage.EMAIL_FIELD, "ts@ts.ts");
        RegistrationFormPage.inputValueIntoField(RegistrationFormPage.REPEAT_EMAIL_FIELD, "ts@ts.ts");
        RegistrationFormPage.clickOnElement(RegistrationFormPage.JAVA_QUESTION_CATEGORY);
//        iRegistrationPage.click(RegistrationFormPage.getProperty("rbtn_Answer").replace("#", "-3"));//TODO: add array with questions and answers
//        iRegistrationPage.click(RegistrationFormPage.getProperty("checkbox_Agreement"));
//                RegistrationFormPage.clickOnElement(RegistrationFormPage.RESET_BUTTON);
//        Assert.assertTrue(false);
    }

    @Test
    public void testRegistrationFormReset() {
        Util.goToPage(Util.baseUrl);
        RegistrationFormPage.inputValueIntoField(RegistrationFormPage.FIRST_NAME_FIELD, "test first name");
        RegistrationFormPage.inputValueIntoField(RegistrationFormPage.LAST_NAME_FIELD, "test last name");
        RegistrationFormPage.inputValueIntoField(RegistrationFormPage.EMAIL_FIELD, "ts@ts.ts");
        RegistrationFormPage.inputValueIntoField(RegistrationFormPage.REPEAT_EMAIL_FIELD, "ts@ts.ts");
        RegistrationFormPage.clickOnElement(RegistrationFormPage.JAVA_QUESTION_CATEGORY);
        RegistrationFormPage.clickOnElement(RegistrationFormPage.RESET_BUTTON);

        //Assert.assertTrue(false);
    }
}

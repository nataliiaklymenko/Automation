import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

/**
 * Created by nako on 29/04/2016.
 */
public class RegistrationFormTests extends BaseTest {
    private static Logger logger = Logger.getLogger("RegistrationFormTests");
    private static final String PATH_TEST_DATA = System.getProperty("user.dir") + "\\src\\main\\resources\\TestCases\\TestCases.xls";

    @Test
    public void testRegistrationPageLoading() {
        execute_TestCase("GFTRegistrationFormLoading_001\n",
                PATH_TEST_DATA, "GFTRegistrationForm",
                RegistrationFormPage.class);
    }

    @Test
    public void testRegistrationFormWithJavaCategorySave() {
        execute_TestCase("GFTRegistrationForm_RegisterWithJavaQuestionCategory_002",
                PATH_TEST_DATA, "GFTRegistrationForm",
                RegistrationFormPage.class);
    }
}

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Properties;


/**
 * Created by nako on 29/04/2016.
 */
class RegistrationFormPage extends PageFactory {
    private static final String Path_OR = System.getProperty("user.dir") + "\\src\\main\\resources\\RegistrationForm.properties";
    private static final String PATH_TEST_DATA = System.getProperty("user.dir") + "\\src\\main\\resources\\TestCases\\TestCases.xlsx";

    public static final String REGISTRATION_FORM_PAGE_TITLE = "Rule Financial Registration Form";
    public static final String GFT_LOGO = ".//div[@class='rf-logo']";
    public static final String FIRST_NAME_FIELD = ".//input[@name='firstName']";
    public static final String LAST_NAME_FIELD = ".//input[@name='lastName']";
    public static final String EMAIL_FIELD = ".//input[@name='email']";
    public static final String REPEAT_EMAIL_FIELD = ".//input[@name='repeatEmail']";
    public static final String JAVA_QUESTION_CATEGORY = ".//button[.='Java']";
    public static final String SQL_QUESTION_CATEGORY = ".//button[.='SQL']";
    public static final String NET_QUESTION_CATEGORY = ".//button[.='.NET']";
    public static final String AGREEMENT_CHECKBOX = ".//input[@type='checkbox']";
    public static final String AGREEMENT_TEXT = ".//label[.='I hereby agree for my personal data, included in my job application,         to be processed in line with the needs of recruitment,         in accordance with the Law on Personal Data Protection of 29 August 1997         (Law Gazette from 2002, No.101, heading 926, as amended).']\n" + "  ";
    public static final String TERMS_AND_CONDITIONS_LINK = ".//a[.='Terms and Conditions']";
    public static final String SAVE_BUTTON = ".//button[.='Save']";
    public static final String RESET_BUTTON = ".//button[.='Reset']";
    public static final String ANSWER_RADIOBUTTON = ".//span[./label[.='#']]/input[@name='answers']";

    private static Properties pageObjects = getProperties(Path_OR);

    @FindBy(how = How.XPATH, using = FIRST_NAME_FIELD)
    private WebElement firstName;
}

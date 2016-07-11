import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by nako on 29/04/2016.
 */
class RegistrationFormPage extends PageFactory {
    public static void selectAnswer(String element, String answer) {
       // WebElement answerElement = Util.waitForElement(BaseTest.OR.getProperty(element).replace("#", answer));
        WebElement answerElement = Util.waitForElement(element);
        answerElement.click();
    }

    public static void verifyCodeBlock(String element, String answer) {
        Util.waitForElement(element);
    }
}




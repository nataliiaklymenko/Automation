import java.util.Properties;

/**
 * Created by nako on 15/06/2016.
 */
public interface IRegistrationPage {
    void inputValue(String object, String value);
    Properties getProperties();
    void click(String elementForClick);
}

import org.apache.log4j.Logger;

/**
 * Created by nako on 15/06/2016.
 */
public class Log {
    private static Logger Log = Logger.getLogger(Log.class.getName());

    static void startTestCase(String testCaseName) {
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("***                 " + testCaseName + "       ***");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
    }

    static void endTestCase(String testCaseName) {
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + testCaseName + " -E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}

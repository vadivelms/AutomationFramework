package utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;

public class LoggingUtility {
//    public static Logger logger = LogManager.getLogger();

    public static void logInfo(String message) {
        File file = new File("configs/log4j.properties");
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.setConfigLocation(file.toURI());
        Logger logger = LogManager.getLogger();
        logger.info(message);

    }
    public static void logError(String message) {
        File file = new File("configs/log4j.properties");
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.setConfigLocation(file.toURI());
        Logger logger = LogManager.getLogger();
        logger.error(message);
    }
}

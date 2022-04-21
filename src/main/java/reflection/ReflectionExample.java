package reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;

public class ReflectionExample {

    private static final Logger LOGGER = LogManager.getLogger(ReflectionExample.class);

    public static void main(String[] args) {

        // Create a new logger context (just testing this method)
        LoggerContext context = (LoggerContext) LogManager.getContext(true);
        File file = new File("src/main/resources/log4j2.properties");
        context.setConfigLocation(file.toURI());

        LOGGER.info("Starting application");

    }
}

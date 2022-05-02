package reflection;

import hospital.models.staff.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {

    private static final Logger LOGGER = LogManager.getLogger(ReflectionExample.class);

    public static void main(String[] args) throws ClassNotFoundException {

        // Create a new logger context (just testing this method)
        LoggerContext context = (LoggerContext) LogManager.getContext(true);
        File file = new File("src/main/resources/log4j2.properties");
        context.setConfigLocation(file.toURI());

        LOGGER.info("Starting application");

        //Get class constructors
        Constructor[] constructor = Doctor.class.getDeclaredConstructors();

        //Get class fields
        Field[] fields = Doctor.class.getDeclaredFields();
        LOGGER.info("Fields: " + Arrays.stream(fields).toList());

        //Get all the class methods
        Method[] methods = Doctor.class.getDeclaredMethods();
        LOGGER.info("Methods: " + Arrays.stream(methods).toList());

        try {
            Doctor doc = (Doctor) constructor[0].newInstance();

            LOGGER.info("Created new doctor: " + doc.toString());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.error(e);
        }
    }
}

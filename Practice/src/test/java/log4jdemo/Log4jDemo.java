package log4jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
    private static final Logger LOGGER = LogManager.getLogger(Log4jDemo.class);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            LOGGER.debug("Running loop" + i);

        }
        calculateTax(123409,true);
        calculateTax(-3456,false);
    }

    static double calculateTax(double salary, boolean isMarried) {
        LOGGER.info("Received request for calculating tax");
        LOGGER.debug("Persons name salary" + salary + "marriage status" + isMarried);

        if (salary > 0) {
            if (salary < 35000 && isMarried) {
                LOGGER.debug("tax = " + (salary * 0.1));
                return salary * 0.1;
            }
        } else {
            LOGGER.error("Salary can not be negative");
            return 0;

        }
        return 0;
    }
}
//Logs in all programming languages follow the same conventions for level
//DEBUG -> we put very detailed info with very detailed data in debug level
//INFO -> we put general info in INFO level
//WARN -> we put possible issues in WARN level
//ERROR -> when errors occur we put in ERROR level
//FATAL -> when something went horrible WRONG we put in fatal level
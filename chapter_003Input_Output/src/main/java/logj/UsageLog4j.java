package logj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) throws ParseException {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        String name = "Pavel Chupin";
        char gender = 'М';
        boolean human = true;
        byte age = 27;
        short fingers = 20;
        int footSize = 45;
        long teeth = 28;
        double weight =  98.1;
        float growth = 183.5F;
        Date birthDate = new SimpleDateFormat("dd.MM.yyyy").parse("16.11.1994");

        LOG.debug("User info name : {}, gender : {}, human : {}, age : {}, "
                 + "fingers : {}, footSize : {}, teeth : {}, weight : {}, growth : {}, birthDate : {}",
                name, gender, human, age, fingers, footSize, teeth, weight, growth, birthDate);
    }
}
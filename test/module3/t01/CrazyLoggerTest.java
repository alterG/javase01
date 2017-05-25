package module3.t01;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by alterG on 25.05.2017.
 */
public class CrazyLoggerTest {
    private CrazyLogger logger;
    private SimpleDateFormat format;

    @Before
    public void initializeLogger() {
        logger = new CrazyLogger();
        format = new SimpleDateFormat("dd-mm-YYYY : hh-mm");
    }

    /**
     * Ignored cause logger prints results to the console
     * @throws Exception
     */
    @Ignore
    @Test
    public void findByDate() throws Exception {
        final String exampleMessage = "Test message for test.";
        logger.add(exampleMessage);
        Date today = new Date();
        final String expectedResult = format.format(today) + " - " +exampleMessage;
        logger.findByDate(today);
    }

}
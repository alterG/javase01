package module3.t01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by alterG on 20.05.2017.
 */
public class CrazyLogger {

    private StringBuilder storage;
    private SimpleDateFormat format = new SimpleDateFormat("dd-mm-YYYY : hh-mm");

    public CrazyLogger() {
        storage = new StringBuilder();
        this.add("Logger has run.");
    }

    public void add(String message) {
        Date currentDate = Calendar.getInstance().getTime();
        storage
                .append(format.format(currentDate))
                .append(" - ")
                .append(message+"\n");
    }

    public void printContent() {
        System.out.println(storage);
    }

}
